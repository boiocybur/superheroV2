import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class DatabaseTest {
    private Database database;

    @BeforeEach
    void setUp() {
        // Initialize new database before each test
        database = new Database();
    }

    @AfterEach
    void tearDown() {
        database = null;
    }

    @Test
    void testAddSuperhero() {
        Superhero superhero = new Superhero("Bruce Wayne", "Batman", true, 1939, "Intelligence", 90);

        // Test adding a valid superhero
        assertDoesNotThrow(() -> database.addSuperhero(superhero));

        // Test adding a superhero with invalid data
        Superhero invalidSuperhero = new Superhero("", "", true, -1, "", -1);
        assertThrows(IllegalArgumentException.class, () -> database.addSuperhero(invalidSuperhero));
    }

    @Test
    void testEmptySuperheroList() {
        // Create a new database
        Database database = new Database();

        // Perform a search for a non-existent hero
        ArrayList<Superhero> searchResult = database.searchSuperhero("Flash");

        // Verify that the search result is an empty list
        assertTrue(searchResult.isEmpty());
    }

    @Test
    void testSearchSingleSuperhero() {

        Database database = new Database();

        // Add Iron Man to the database
        Superhero superhero1 = new Superhero("Tony Stark", "Iron Man", true, 1939, "Intelligence", 90);
        database.addSuperhero(superhero1);

        // Search for Iron Man
        ArrayList<Superhero> searchResult = database.searchSuperhero("Iron Man");
        assertEquals(1, searchResult.size());
        assertEquals(superhero1, searchResult.get(0));
    }

    @Test
    void testSearchMultipleSuperheroes() {
        Database database = new Database();

        // Add Batman, Superman, and Wonder Woman to the database
        Superhero superhero1 = new Superhero("Clark Kent", "Ultraman", false, 1938, "Flight", 95);
        Superhero superhero2 = new Superhero("Diana Prince", "Ultra Girl", false, 1941, "Super strength", 88);

        database.addSuperhero(superhero1);
        database.addSuperhero(superhero2);

        // Search for multiple superheroes
        ArrayList<Superhero> searchResult = database.searchSuperhero("tra");
        assertEquals(2, searchResult.size());

        assertTrue(searchResult.contains(superhero1));
        assertTrue(searchResult.contains(superhero2));
    }

    @Test
    void testRemoveSuperhero() {
        Database database = new Database();

        Superhero superhero1 = new Superhero("Hank Pym", "Ant man", true, 1969, "Size Change suit", 66);
        database.addSuperhero(superhero1);

        // Remove superhero1 directly
        database.removeSuperhero(superhero1.getSuperHeroName());

        assertFalse(database.getAllSuperheroes().contains(superhero1));
    }
}