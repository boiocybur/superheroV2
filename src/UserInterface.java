import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Database database;
    private Controller controller;

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
                    9. Exit
                    """);


            int choice = scanner.nextInt();
            scanner.nextLine(); // Removes newline after nextInt()

            switch (choice) {
                case 1 -> {
                    // create a new superhero and add to database
                    System.out.print("Real name of superhero: ");
                    String name = scanner.nextLine();
                    System.out.print("Alias of superhero: ");
                    String superHeroName = scanner.nextLine();
                    System.out.print("Is hero human? (ja/nej): ");
                    boolean isHuman = scanner.nextLine().equalsIgnoreCase("ja");
                    System.out.print("Creation year: ");
                    int creationYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Chosen superpower: ");
                    String superpower = scanner.nextLine();
                    System.out.println("Overall strength [0-100]: ");
                    int strength = scanner.nextInt();
                    Superhero superhero = new Superhero(name, superHeroName, isHuman, creationYear, superpower, strength);
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

                            System.out.print("Enter the new name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter the new alias: ");
                            String newAlias = scanner.nextLine();
                            System.out.print("Enter the new racial status: ");
                            boolean newIsHuman = scanner.nextLine().equalsIgnoreCase("ja");
                            System.out.print("Enter the new creation year: ");
                            int newCreationYear = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter the new superpower: ");
                            String newSuperpower = scanner.nextLine();
                            System.out.print("Enter the new strength [0-100]: ");
                            int newStrength = scanner.nextInt();

                            superheroToEdit.setName(newName);
                            superheroToEdit.setSuperHeroName(newAlias);
                            superheroToEdit.setIsHuman(newIsHuman);
                            superheroToEdit.setCreationYear(newCreationYear);
                            superheroToEdit.setSuperpower(newSuperpower);
                            superheroToEdit.setStrength(newStrength);

                            database.editSuperhero(partialSearchCriteria, superheroToEdit);
                        } else {
                            System.out.println("Invalid selection. Please choose a superhero from the list.");
                        }
                    }
            }

                case 9 -> {
                    // exit program
                    System.out.println("Exiting program.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}