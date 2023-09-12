import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
        System.out.println("Superhero added to the database.");
    }

    public ArrayList<Superhero> hentAlleSuperhelte() {
        return superheroes;
    }

    public Superhero findSuperhero(String name) {
        // Find superheroes whose name matches the search criteria
        for (Superhero hero : superheroes) {
            if (hero.getName().equalsIgnoreCase(name)) {
                return hero;
            }
        }
        // No match found
        return null;
    }

    public int getAntalSuperheroes() {
        return superheroes.size();
    }
}
