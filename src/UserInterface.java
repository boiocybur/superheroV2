import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final Database database;
    private final Controller controller;

    public UserInterface(Scanner scanner, Database database, Controller controller) {
        this.scanner = scanner;
        this.database = database;
        this.controller = controller;
    }

    public void start() {
        while (true) {
            // Vis menu
            System.out.println("""
                    Welcome to Superhero database.
                    1. Create hero
                    2. Show heroes
                    3. Find heroes
                    4. Edit heroes
                    5. Delete heroes
                    9. Exit
                    """);

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Removes newline after nextInt()

                switch (choice) {
                    case 1 -> {
                        // create a new superhero and add to database
                        System.out.print("Real name of superhero: ");
                        String name = scanner.nextLine();
                        System.out.print("Alias of superhero: ");
                        String superHeroName = scanner.nextLine();
                        boolean isHuman = false;
                        boolean validInput = false;

                        while (!validInput) {
                            System.out.print("Is hero human? (ja/nej): ");
                            String isHumanInput = scanner.nextLine().trim().toLowerCase();

                            if (isHumanInput.equals("ja")) {
                                isHuman = true;
                                break;
                            } else if (isHumanInput.equals("nej")) {
                                isHuman = false;
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter 'ja' or 'nej'.");
                            }
                        }
                        System.out.print("Creation year: ");
                        int creationYear = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Chosen superpower: ");
                        String superpower = scanner.nextLine();
                        System.out.println("Overall strength [0-100]: ");
                        int strength = scanner.nextInt();

                        if (!isValidName(name)) {
                            System.out.println("Invalid input. No numbers or special characters in names.");
                            continue;
                        }
                        controller.addSuperheroToDatabase(name, superHeroName, isHuman, creationYear, superpower, strength);
                    }
                    case 2 -> {
                        if (database.getNumberOfSuperheroes() == 0) {
                            System.out.println("There is no superheroes in the database.");
                        } else {
                            ArrayList<Superhero> heroes = database.getAllSuperheroes();
                            System.out.println("Superheroes in the database:");
                            for (Superhero hero : heroes) {
                                database.printHeroDetails(hero);
                            }
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter search criteria (superhero name or real name): ");
                        String searchCriteria = scanner.nextLine();

                        ArrayList<Superhero> searchResult = database.searchSuperhero(searchCriteria);

                        if (searchResult.isEmpty()) {
                            System.out.println("No superheroes matching the search criteria found.");
                        } else {
                            System.out.println("Superheroes found:");
                            for (Superhero superhero : searchResult) {
                                database.printHeroDetails(superhero);

                            }

                        }
                    }
                    case 4 -> {
                        System.out.println("Enter a part of the name or superhero name of the superhero you wish to edit: ");
                        String partialSearchCriteria = scanner.nextLine();

                        ArrayList<Superhero> matchingSuperheroes = new ArrayList<>();

                        // Search for superheroes with a partial match in either name or superhero name
                        for (Superhero hero : database.getAllSuperheroes()) {
                            if (hero.getName().toLowerCase().contains(partialSearchCriteria.toLowerCase()) ||
                                    hero.getSuperHeroName().toLowerCase().contains(partialSearchCriteria.toLowerCase())) {
                                matchingSuperheroes.add(hero);
                            }
                        }

                        if (matchingSuperheroes.isEmpty()) {
                            System.out.println("No superheroes found matching the search criteria.");
                        } else {
                            System.out.println("Matching superheroes:");

                            for (int i = 0; i < matchingSuperheroes.size(); i++) {
                                Superhero hero = matchingSuperheroes.get(i);
                                System.out.println(i + 1 + ". " + hero.getName() + " (" + hero.getSuperHeroName() + ")");
                            }

                            System.out.print("Enter the number of the superhero you wish to edit: ");
                            int selection = scanner.nextInt();

                            if (selection >= 1 && selection <= matchingSuperheroes.size()) {
                                Superhero superheroToEdit = matchingSuperheroes.get(selection - 1);

                                System.out.println("Current details of the superhero:");
                                database.printHeroDetails(superheroToEdit);
                                scanner.nextLine();

                                System.out.print("Enter the new name (press Enter to keep the current name): ");
                                String newName = scanner.nextLine();
                                if (!newName.isEmpty()) {
                                    superheroToEdit.setName(newName);
                                }

                                System.out.print("Enter the new alias (press Enter to keep the current alias): ");
                                String newAlias = scanner.nextLine();
                                if (!newAlias.isEmpty()) {
                                    superheroToEdit.setSuperHeroName(newAlias);
                                }

                                System.out.print("Is the superhero human? (ja/nej) (press Enter to keep the current value): ");
                                String newIsHumanInput = scanner.nextLine().trim().toLowerCase();
                                if (!newIsHumanInput.isEmpty()) {
                                    boolean newIsHuman = newIsHumanInput.equals("ja");
                                    superheroToEdit.setIsHuman(newIsHuman);
                                }

                                System.out.print("Enter the new creation year (press Enter to keep the current year): ");
                                String newCreationYearInput = scanner.nextLine();
                                if (!newCreationYearInput.isEmpty()) {
                                    int newCreationYear = Integer.parseInt(newCreationYearInput);
                                    superheroToEdit.setCreationYear(newCreationYear);
                                }

                                System.out.print("Enter the new superpower (press Enter to keep the current superpower): ");
                                String newSuperpower = scanner.nextLine();
                                if (!newSuperpower.isEmpty()) {
                                    superheroToEdit.setSuperpower(newSuperpower);
                                }

                                System.out.print("Enter the new strength [0-100] (press Enter to keep the current strength): ");
                                String newStrengthInput = scanner.nextLine();
                                if (!newStrengthInput.isEmpty()) {
                                    int newStrength = Integer.parseInt(newStrengthInput);
                                    superheroToEdit.setStrength(newStrength);
                                }

                                database.editSuperhero(partialSearchCriteria, superheroToEdit);
                            } else {
                                System.out.println("Invalid selection. Please choose a superhero from the list.");
                            }
                        }
                    }
                    case 5 -> {
                        System.out.println("Enter the name of the superhero you wish to remove: ");
                        String removeSuperheroName = scanner.nextLine().trim().toLowerCase(); // Convert input to lowercase

                        // Call the removeSuperhero method to remove the superhero by name
                        database.removeSuperhero(removeSuperheroName);

                        // Check if any superheroes were removed
                        if (!database.getAllSuperheroes().stream().anyMatch(superhero ->
                                superhero.getSuperHeroName().trim().equalsIgnoreCase(removeSuperheroName))) {
                            System.out.println("Superhero(s) removed successfully.");
                        } else {
                            System.out.println("Superhero not found in the database.");
                        }
                    }
                    case 9 -> {
                        // exit program
                        System.out.println("Exiting program.");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }catch(InputMismatchException ime){
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
                continue; // Continue the loop to allow the user to enter valid input
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
    // Check if the name contains only letters, spaces, and hyphens
    private boolean isValidName(String name) {
        return name.matches("^[a-zA-Z\\s-]*$");
    }

}
