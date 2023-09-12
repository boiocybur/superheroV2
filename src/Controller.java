import java.util.ArrayList;

public class Controller {
    private Database db;

    public Controller(Database db) {
        this.db = db;
    }

    public void tilfoejPerson(String name, String superHeroName, boolean isHuman, int creationYear, String superpower, int strength) {
        db.addSuperhero(new Superhero(name, superHeroName, isHuman, creationYear, superpower, strength));
    }

    public ArrayList<Superhero> hentPersoner() {
        return db.hentAlleSuperhelte();
    }

    public void visPersoner() {
        // Display superheroes
        ArrayList<Superhero> superheroes = hentPersoner();
        if (superheroes.isEmpty()) {
            System.out.println("Der er ingen superhelte i databasen.");
        } else {
            System.out.println("Superhelte i database:");
            for (Superhero p : superheroes) {
                System.out.println("Navn: " + p.getName());
                // Print other superhero information as needed
                System.out.println("----------------------");
            }
        }
    }
}
