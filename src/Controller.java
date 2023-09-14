public class Controller {
    private Database db;

    public Controller(Database db) {
        this.db = db;
    }

    public void addSuperheroToDatabase(String name, String superHeroName, boolean isHuman, int creationYear, String superpower, int strength) {
        try {
            Superhero superhero = new Superhero(name, superHeroName, isHuman, creationYear, superpower, strength);
            db.addSuperhero(superhero);
            System.out.println("Superhero added to the database.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please check the provided data.");
        } catch (Exception e) {
            System.out.println("An error occurred while adding the superhero: " + e.getMessage());
        }
    }
}
