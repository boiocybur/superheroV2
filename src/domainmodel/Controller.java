package domainmodel;

import datasource.Database;
import datasource.Superhero;

import java.util.ArrayList;

public class Controller {
    private final Database db;

    public Controller(Database db) {
        this.db = db;
    }


    public void addSuperheroToDatabase(String name, String superHeroName, boolean isHuman, int creationYear, String superpower, int strength) {
      db.addSuperhero(name, superHeroName, isHuman, creationYear, superpower, strength);
    }
}