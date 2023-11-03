package datasource;

import java.util.ArrayList;

public class Database {
    private final ArrayList<Superhero> superheroes = new ArrayList<>();


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
                if (superhero.getName().toLowerCase().contains(searchCriteria) || superhero.getSuperHeroName().toLowerCase().contains(searchCriteria)) {
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
        System.out.println("Superhero name: " + hero.getSuperHeroName());
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

