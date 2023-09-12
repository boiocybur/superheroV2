import java.util.Arrays;

public class Database {
    private Superhero[] superhero;
    private int antalSuperheroes;

    public Database() {
        this.superhero = new Superhero[5]; // Start with space for 5 superheroes
        this.antalSuperheroes = 0;
    }

    public void addSuperhero(Superhero superhero) {
        if (antalSuperheroes < this.superhero.length) {
            this.superhero[antalSuperheroes++] = superhero;
            System.out.println("Superhelten er tilføjet til databasen.");
        } else {
            System.out.println("Databasen er fuld. Kan ikke tilføje flere superhelte.");
            System.exit(0);
        }
    }

    public Superhero[] hentAlleSuperhelte() {
        return Arrays.copyOf(superhero, antalSuperheroes);
    }

    public Superhero findSuperhero(String navn) {
        for (int i = 0; i < antalSuperheroes; i++) {
            if (superhero[i].getName().equalsIgnoreCase(navn)) {
                return superhero[i];
            }
        }
        return null; // Return null if superhero is not found
    }
}
