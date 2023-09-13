public class Controller {
    private Database db;

    public Controller(Database db) {
        this.db = db;
    }


    public void addHero(String name, String superHeroName, boolean isHuman, int creationYear, String superpower, int strength) {
        db.addSuperhero(new Superhero(name, superHeroName, isHuman, creationYear, superpower, strength));
    }
}
