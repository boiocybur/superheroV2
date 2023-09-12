import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database(); // creates a database

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
                    break;
                }
                case 2 -> {
                    if (database.getAntalSuperheroes() == 0) {
                        System.out.println("Der er ingen superhelte i databasen.");
                    } else {
                        ArrayList<Superhero> heroes = database.hentAlleSuperhelte();
                        System.out.println("Superhelte i databasen:");
                        for (Superhero hero : heroes) {
                            System.out.println("Navn: " + hero.getName());
                            System.out.println("Superheltnavn: " + hero.getSuperHeroName());
                            System.out.println("Er menneskelig: " + (hero.isHuman() ? "Ja" : "Nej"));
                            System.out.println("Skabelsesår: " + hero.getCreationYear());
                            System.out.println("Superpower: " + hero.getSuperpower());
                            System.out.println("Styrke: " + hero.getStrength());
                            System.out.println("----------------------");
                        }
                    }
                    break;
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