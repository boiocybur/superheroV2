import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database(); // creates a database
        Controller controller = new Controller(database);  //Passes database to Controller

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
                    database.addSuperhero(superhero);
                    System.out.println("Superhero added to the database.");
                }
                case 2 -> {
                    if (database.getAntalSuperheroes() == 0) {
                        System.out.println("There is no superheroes in the database.");
                    } else {
                        ArrayList<Superhero> heroes = database.getAllSuperheroes();
                        System.out.println("Superheroes in the database:");
                        for (Superhero hero : heroes) {
                            System.out.println("Name: " + hero.getName());
                            System.out.println("Superhero name: " + hero.getSuperHeroName());
                            System.out.println("Is a human: " + (hero.isHuman() ? "Yes" : "No"));
                            System.out.println("Creation year: " + hero.getCreationYear());
                            System.out.println("Superpower: " + hero.getSuperpower());
                            System.out.println("Strength: " + hero.getStrength());
                            System.out.println("----------------------");
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
                            System.out.println("Name: " + superhero.getName());
                            System.out.println("Superhero name: " + superhero.getSuperHeroName());
                            System.out.println("Is a human: " + (superhero.isHuman() ? "Yes" : "No"));
                            System.out.println("Creation year: " + superhero.getCreationYear());
                            System.out.println("Superpower: " + superhero.getSuperpower());
                            System.out.println("Strength: " + superhero.getStrength());
                            System.out.println("----------------------");
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