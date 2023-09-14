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