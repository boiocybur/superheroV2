package datasource;

import file.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Database {
    private Filehandler file = new Filehandler();
    private ArrayList<Superhero> superheroes = new ArrayList<>();
    NameComparator nameComparator = new NameComparator();
    SuperheroNameComparator superheroNameComparator = new SuperheroNameComparator();
    file.isHumanComparator isHumanComparator = new isHumanComparator();
    CreationYearComparator creationYearComparator = new CreationYearComparator();
    StrengthComparator strengthComparator = new StrengthComparator();

    public void addSuperhero(String name, String superHeroName, boolean isHuman, int creationYear, String superpower, int strength) throws IllegalArgumentException {
        if (!isValidInput(name, superHeroName, creationYear, superpower, strength)) {
            throw new IllegalArgumentException("Invalid input. Please check the superhero details.");
        }

        Superhero superhero = new Superhero(name, superHeroName, isHuman, creationYear, superpower, strength);
        superheroes.add(superhero);
        System.out.println("Superhero added to the database.");
    }

    private boolean isValidInput(String name, String superHeroName, int creationYear, String superpower, int strength) {
        return name != null && !name.isEmpty() &&
                superHeroName != null && !superHeroName.isEmpty() &&
                superpower != null && !superpower.isEmpty() &&
                creationYear >= 0 &&
                strength >= 0 && strength <= 100;
    }

    public ArrayList<Superhero> getAllSuperheroes() {
        return superheroes;
    }

    public int getNumberOfSuperheroes() {
        return superheroes.size();
    }

    public ArrayList<Superhero> searchSuperhero(String searchCriteria) {
        ArrayList<Superhero> searchResult = new ArrayList<>();

        if (searchCriteria != null) {  // Add error handling for null input
            for (Superhero superhero : superheroes) {
                if (superhero.getName().toLowerCase().contains(searchCriteria) || superhero.getSuperheroName().toLowerCase().contains(searchCriteria)) {
                    searchResult.add(superhero);
                }
            }
        }

        return searchResult;
    }

    public void loadList(){
        ArrayList<Superhero> heroes = superheroes;

        for (Superhero hero : heroes) {
            printHeroDetails(hero);
        }

    }
    public void printHeroDetails(Superhero hero){
        System.out.println("Name: " + hero.getName());
        System.out.println("Superhero name: " + hero.getSuperheroName());
        System.out.println("Is a human: " + (hero.isHuman() ? "Yes" : "No"));
        System.out.println("Creation year: " + hero.getCreationYear());
        System.out.println("Superpower: " + hero.getSuperpower());
        System.out.println("Strength: " + hero.getStrength());
        System.out.println("----------------------");
        }
    public void editSuperhero(String nameToEdit, Superhero superheroToEdit) {
        boolean superheroFound = false;

        for (int i = 0; i < superheroes.size(); i++) {
            Superhero superhero = superheroes.get(i);
            if (superhero.getName().toLowerCase().contains(nameToEdit.toLowerCase())) {
                // Find superhero with a name containing the search criteria and update
                superheroes.set(i, superheroToEdit);
                System.out.println("Superhero updated successfully.");

                // Print the updated details
                System.out.println("Updated details of the superhero:");
                printHeroDetails(superheroToEdit);

                superheroFound = true;
            }
        }

        if (!superheroFound) {
            // If no matching superhero is found in the database
            System.out.println("Superhero not found.");
        }
    }

    public void removeSuperhero(String superheroName) {
        ArrayList<Superhero> superheroesToRemove = new ArrayList<>();
        for (Superhero superheroInDatabase : superheroes) {
            if (superheroInDatabase.getSuperheroName().trim().equalsIgnoreCase(superheroName)) {
                superheroesToRemove.add(superheroInDatabase);
            }
        }
        superheroes.removeAll(superheroesToRemove);
    }
    public void save(){
        file.save(superheroes);

    }
    public void load() throws IOException {
     file.load();
        superheroes.addAll(file.getHerofiles());
    }
    public void sortByOneAttribute(int primaryAttribute){
        Comparator<Superhero> primaryComparator = getPrimaryComparatorBasedOnAttribute(primaryAttribute);
        Collections.sort(superheroes, primaryComparator);
    }
    public void sortByTwoAttributes(int primaryAttribute, int secondaryAttribute) {
        Comparator<Superhero> primaryComparator = getPrimaryComparatorBasedOnAttribute(primaryAttribute);
        Comparator<Superhero> secondaryComparator = getSecondaryComparatorBasedOnAttribute(secondaryAttribute);
        Collections.sort(superheroes, primaryComparator.thenComparing(secondaryComparator));
    }
    private Comparator<Superhero> getPrimaryComparatorBasedOnAttribute(int attribute) {
        return switch (attribute) {
            case 1 -> nameComparator;
            case 2 -> superheroNameComparator;
            case 3 -> isHumanComparator;
            case 4 -> creationYearComparator;
            case 5 -> strengthComparator;
            default -> throw new IllegalArgumentException("Invalid attribute for sorting: " + attribute);
        };
    }
    private Comparator<Superhero> getSecondaryComparatorBasedOnAttribute(int attribute) {
        return switch (attribute) {
            case 1 -> nameComparator;
            case 2 -> superheroNameComparator;
            case 3 -> isHumanComparator;
            case 4 -> creationYearComparator;
            case 5 -> strengthComparator;
            default -> throw new IllegalArgumentException("Invalid attribute for sorting: " + attribute);
        };
    }
}

