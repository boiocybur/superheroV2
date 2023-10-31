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
        try {
            Superhero superhero = new Superhero(name, superHeroName, isHuman, creationYear, superpower, strength);
            db.addSuperhero(superhero);
            System.out.println("datasource.Superhero added to the database.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. No numbers or special characters in names");
        } catch (Exception e) {
            System.out.println("An error occurred while adding the superhero: ");
        }
    }
}