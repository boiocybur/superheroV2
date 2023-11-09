package domainmodel;

import datasource.Database;
import datasource.Superhero;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private final Database db;

    public Controller(Database db) {
        this.db = db;
    }


    public void addSuperheroToDatabase(String name, String superHeroName, boolean isHuman, int creationYear, String superpower, int strength) {
      db.addSuperhero(name, superHeroName, isHuman, creationYear, superpower, strength);
    }

    public int getNumberOfSuperheroes() {
        return db.getNumberOfSuperheroes();
    }

    public ArrayList<Superhero> getAllSuperheroes() {
        return db.getAllSuperheroes();
    }

    public ArrayList<Superhero> searchSuperhero(String searchResult) {
        return db.searchSuperhero(searchResult);
    }


    public void removeSuperhero(String removeSuperheroName) {
        db.removeSuperhero(removeSuperheroName);
    }

    public void editSuperhero(String partialSearchCriteria, Superhero superheroToEdit) {
        db.editSuperhero(partialSearchCriteria, superheroToEdit);
    }
    public void printHeroDetails(datasource.Superhero hero){
        this.db.printHeroDetails(hero);
    }
    public void load() throws IOException {
        db.load();
    }
    public void loadList(){
        db.loadList();
    }
    public void save(){
        db.save();
    }
    public void sortByTwoAttributes(int primary, int secondary) {
        db.sortByTwoAttributes(primary, secondary);
    }
    public void sortByOneAttribute(int primary) {
        db.sortByOneAttribute(primary);
    }

}