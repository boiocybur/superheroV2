package datasource;

import java.util.ArrayList;

public class Database {
    private final ArrayList<Superhero> superheroes = new ArrayList<>();

    public void addSuperhero(Superhero superhero) throws IllegalArgumentException {
        if (isValidSuperhero(superhero)) {
            superheroes.add(superhero);
        } else {
            throw new IllegalArgumentException("Invalid superhero data.");
        }
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
                if (superhero.getName().contains(searchCriteria) || superhero.getSuperHeroName().contains(searchCriteria)) {
                    searchResult.add(superhero);
                }
            }
        }

        return searchResult;
    }

    /*public void printHeroDetails(Superhero hero) {
        System.out.println("----------------------");
        System.out.println("Name: " + hero.getName());
        System.out.println("datasource.Superhero name: " + hero.getSuperHeroName());
        System.out.println("Is a human: " + (hero.isHuman() ? "Yes" : "No"));
        System.out.println("Creation year: " + hero.getCreationYear());
        System.out.println("Superpower: " + hero.getSuperpower());
        System.out.println("Strength: " + hero.getStrength());
        System.out.println("----------------------");
    }*/
    public void printHeroDetails(Superhero hero){
        for(Superhero superhero : superheroes){
            hero.getName();
            hero.getSuperHeroName();
            hero.isHuman();
            hero.getCreationYear();
            hero.getSuperpower();
            hero.getStrength();
        }
    }

    public boolean isValidSuperhero(Superhero superhero) {
        return superhero != null &&
                superhero.getName() != null && !superhero.getName().isEmpty() &&
                superhero.getSuperHeroName() != null && !superhero.getSuperHeroName().isEmpty() &&
                superhero.getSuperpower() != null && !superhero.getSuperpower().isEmpty() &&
                superhero.getCreationYear() >= 0 &&
                superhero.getStrength() >= 0 && superhero.getStrength() <= 100;
    }

    public void editSuperhero(String nameToEdit, Superhero superheroToEdit) {
        boolean superheroFound = false;

        for (int i = 0; i < superheroes.size(); i++) {
            Superhero superhero = superheroes.get(i);
            if (superhero.getName().toLowerCase().contains(nameToEdit.toLowerCase())) {
                // Find superhero with a name containing the search criteria and update
                superheroes.set(i, superheroToEdit);
                System.out.println("datasource.Superhero updated successfully.");

                // Print the updated details
                System.out.println("Updated details of the superhero:");
                printHeroDetails(superheroToEdit);

                superheroFound = true;
            }
        }

        if (!superheroFound) {
            // If no matching superhero is found in the database
            System.out.println("datasource.Superhero not found.");
        }
    }

    public void removeSuperhero(String superheroName) {
        ArrayList<Superhero> superheroesToRemove = new ArrayList<>();
        for (Superhero superheroInDatabase : superheroes) {
            if (superheroInDatabase.getSuperHeroName().trim().equalsIgnoreCase(superheroName)) {
                superheroesToRemove.add(superheroInDatabase);
            }
        }
        superheroes.removeAll(superheroesToRemove);
    }

}

