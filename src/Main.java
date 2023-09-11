import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database(); // Opret en database

        while (true) {
            // Vis menu
            System.out.println("Menu:");
            System.out.println("1. Opret en ny superhelt");
            System.out.println("2. Afslut programmet");
            System.out.print("Vælg en handling: ");

            int valg = scanner.nextInt();
            scanner.nextLine(); // Fjern newline efter nextInt()

            switch (valg) {
                case 1:
                    // Opret en ny superhelt og tilføj den til databasen
                    System.out.print("Indtast navn på superhelt: ");
                    String navn = scanner.nextLine();
                    System.out.print("Indtast superheltnavn: ");
                    String superheltnavn = scanner.nextLine();
                    System.out.print("Er superhelten menneskelig (ja/nej): ");
                    boolean erMenneskelig = scanner.nextLine().equalsIgnoreCase("ja");
                    System.out.print("Indtast skabelsesår: ");
                    int skabelsesaar = scanner.nextInt();
                    System.out.print("Indtast styrke: ");
                    String styrke = scanner.nextLine();

                    Superhero superhero = new Superhero(navn, superheltnavn, erMenneskelig, skabelsesaar, styrke);
                    database.addSuperhero(superhero);
                    break;
                case 2:
                    // Afslut programmet
                    System.out.println("Afslutter programmet.");
                    System.exit(0);
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }
}