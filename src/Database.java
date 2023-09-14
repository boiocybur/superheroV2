import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes = new ArrayList<>();

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

    public void displayAllSuperheroes() {
        ArrayList<Superhero> superheroes = getAllSuperheroes();
        if (superheroes.isEmpty()) {
            System.out.println("There are no superheroes in the database.");
        } else {
            System.out.println("Superheroes in database:");
            for (Superhero hero : superheroes) {
                printHeroDetails(hero);
                System.out.println("----------------------");
            }
        }
    }

    public void printHeroDetails(Superhero hero) {
        System.out.println("Name: " + hero.getName());
        System.out.println("Superhero name: " + hero.getSuperHeroName());
        System.out.println("Is a human: " + (hero.isHuman() ? "Yes" : "No"));
        System.out.println("Creation year: " + hero.getCreationYear());
        System.out.println("Superpower: " + hero.getSuperpower());
        System.out.println("Strength: " + hero.getStrength());
    }

    private boolean isValidSuperhero(Superhero superhero) {
        return superhero != null &&
                superhero.getName() != null && !superhero.getName().isEmpty() &&
                superhero.getSuperHeroName() != null && !superhero.getSuperHeroName().isEmpty() &&
                superhero.getSuperpower() != null && !superhero.getSuperpower().isEmpty() &&
                superhero.getCreationYear() >= 0 &&
                superhero.getStrength() >= 0;
    }
}
