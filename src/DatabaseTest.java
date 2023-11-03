import static org.junit.jupiter.api.Assertions.*;

import datasource.Database;
import datasource.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class DatabaseTest {
    private Database database;

    @BeforeEach
    void setUp() {
        database = new Database();
    }

    @AfterEach
    void tearDown() {
        database = null;
    }

    @Test
    void testAddSuperhero() {
        Superhero validSuperhero = new Superhero("Bruce Wayne", "Batman", true, 1939, "Intelligence", 90);

        // Test adding a valid superhero
        assertDoesNotThrow(() -> database.addSuperhero("Bruce Wayne", "Batman", true, 1939, "Intelligence", 90));

        // Test adding a superhero with invalid data
        Superhero invalidSuperhero = new Superhero("", "", true, -1, "", -1);
        assertThrows(IllegalArgumentException.class, () -> database.addSuperhero("Bruce Wayne", "Batman", true, 1939, "Intelligence", 90));
    }

    @Test
    void testSearchSuperhero() {
        Superhero superhero1 = new Superhero("Bruce Wayne", "Batman", true, 1939, "Intelligence", 90);
        Superhero superhero2 = new Superhero("Clark Kent", "Superman", true, 1938, "Flight", 95);


        //database.addSuperhero(superhero1);

        database.addSuperhero("Bruce Wayne", "Batman", true, 1939, "Money", 3);
        database.addSuperhero("Clark Kent", "Superman", true, 1938, "Flight", 95);

        // Test searching for an existing superhero
        ArrayList<Superhero> searchResult1 = database.searchSuperhero("Batman");
        assertEquals(1, searchResult1.size());
        assertEquals(superhero1, searchResult1.get(0));

        // Test searching for a non-existing superhero
        ArrayList<Superhero> searchResult2 = database.searchSuperhero("Flash");
        assertTrue(searchResult2.isEmpty());

        // Test searching for multiple superheroes
        ArrayList<Superhero> searchResult3 = database.searchSuperhero("man");
        assertEquals(2, searchResult3.size());
    }

    @Test
    void testEditSuperhero() {
        Superhero superhero1 = new Superhero("Bruce Wayne", "Batman", true, 1939, "Intelligence", 90);
        Superhero updatedSuperhero = new Superhero("Diana Prince", "Wonder Woman", false, 1941, "Super strength", 88);

                database.addSuperhero("Bruce Wayne", "Batman", true, 1939, "Intelligence", 90);

        // Test editing an existing superhero
        database.editSuperhero("Batman", updatedSuperhero);
        Superhero editedSuperhero = database.getAllSuperheroes().get(0);
        assertEquals(updatedSuperhero, editedSuperhero);

        // Test editing a non-existing superhero
        database.editSuperhero("Flash", updatedSuperhero);
        assertEquals(1, database.getNumberOfSuperheroes());
    }

    @Test
    void testRemoveSuperhero() {
        Superhero superhero1 = new Superhero("Bruce Wayne", "Batman", true, 1939, "Intelligence", 90);
        Superhero superhero2 = new Superhero("Clark Kent", "Superman", true, 1938, "Flight", 95);

        database.addSuperhero("Bruce Wayne", "Batman", true, 1939, "Intelligence", 90);
        database.addSuperhero("Clark Kent", "Superman", true, 1938, "Flight", 95);

        // Test removing an existing superhero
        database.removeSuperhero("Batman");
        assertEquals(1, database.getNumberOfSuperheroes());

        // Test removing a non-existing superhero
        database.removeSuperhero("Flash");
        assertEquals(1, database.getNumberOfSuperheroes());
    }
}
