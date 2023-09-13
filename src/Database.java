import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
        System.out.println("Superhero added to the database.");
    }

    public ArrayList<Superhero> findAllSuperheroes() {
        return superheroes;
    }

    public int getAntalSuperheroes() {
        return superheroes.size();
    }

    public ArrayList<Superhero> findHeroes() {
        return findAllSuperheroes();
    }

    public ArrayList<Superhero> getAllSuperheroes() {
        // Display superheroes
        ArrayList<Superhero> superheroes = findHeroes();
        if (superheroes.isEmpty()) {
            System.out.println("There is no superhero in the database.");
        } else {
            System.out.println("Superheroes in database:");
            for (Superhero hero : superheroes) {
                System.out.println("Name: " + hero.getName());
                System.out.println("Superhero name: " + hero.getSuperHeroName());
                System.out.println("Is a human: " + (hero.isHuman() ? "Yes" : "No"));
                System.out.println("Creation year: " + hero.getCreationYear());
                System.out.println("Superpower: " + hero.getSuperpower());
                System.out.println("Strength: " + hero.getStrength());
                System.out.println("----------------------");
            }
        }
        return superheroes;
    }

    public ArrayList<Superhero> searchSuperhero(String searchCriteria) {
        ArrayList<Superhero> searchResult = new ArrayList<>();

        for (Superhero superhero : superheroes) {
            if (superhero.getName().equalsIgnoreCase(searchCriteria) || superhero.getSuperHeroName().equalsIgnoreCase(searchCriteria)) {
                searchResult.add(superhero);
            }
        }

        return searchResult; // Return the list of matching superheroes
    }
}

