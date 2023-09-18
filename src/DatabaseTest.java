import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class DatabaseTest {
    private Database database;

    @BeforeEach
    void setUp() {
        // Initialize the database before each test
        database = new Database();
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
    void testGetAllSuperheroes() {
        // Test getting all superheroes (initially empty)
        ArrayList<Superhero> superheroes = database.getAllSuperheroes();
        assertEquals(0, superheroes.size());

        // Add a superhero and test getting all superheroes again
        Superhero superhero = new Superhero("Clark Kent", "Superman", true, 1938, "Flight", 95);
        database.addSuperhero(superhero);

        superheroes = database.getAllSuperheroes();
        assertEquals(1, superheroes.size());
        assertEquals(superhero, superheroes.get(0));
    }

    @Test
    void testGetNumberOfSuperheroes() {
        // Test getting the number of superheroes (initially 0)
        assertEquals(0, database.getNumberOfSuperheroes());

        // Add a superhero and test again
        Superhero superhero = new Superhero("Diana Prince", "Wonder Woman", true, 1941, "Super strength", 88);
        database.addSuperhero(superhero);

        assertEquals(1, database.getNumberOfSuperheroes());
    }

    @Test
    void testSearchSuperhero() {
        // Test searching for superheroes (initially empty)
        ArrayList<Superhero> searchResult = database.searchSuperhero("Batman");
        assertTrue(searchResult.isEmpty());

        // Add some superheroes and test searching
        Superhero superhero1 = new Superhero("Bruce Wayne", "Batman", true, 1939, "Intelligence", 90);
        Superhero superhero2 = new Superhero("Clark Kent", "Superman", true, 1938, "Flight", 95);
        Superhero superhero3 = new Superhero("Diana Prince", "Wonder Woman", true, 1941, "Super strength", 88);

        database.addSuperhero(superhero1);
        database.addSuperhero(superhero2);
        database.addSuperhero(superhero3);

        // Search for Batman
        searchResult = database.searchSuperhero("Batman");
        assertEquals(1, searchResult.size());
        assertEquals(superhero1, searchResult.get(0));

        // Search for Superman
        searchResult = database.searchSuperhero("Superman");
        assertEquals(1, searchResult.size());
        assertEquals(superhero2, searchResult.get(0));

        // Search for a superhero that doesn't exist
        searchResult = database.searchSuperhero("Flash");
        assertTrue(searchResult.isEmpty());
    }

    @Test
    void testIsValidSuperhero() {
        // Test a valid superhero
        Superhero validSuperhero = new Superhero("Peter Parker", "Spider-Man", true, 1962, "Web-slinging", 80);
        assertTrue(database.isValidSuperhero(validSuperhero));

        // Test an invalid superhero with missing name
        Superhero invalidSuperhero1 = new Superhero("", "Invisible Woman", true, 1961, "Invisibility", 75);
        assertFalse(database.isValidSuperhero(invalidSuperhero1));

        // Test an invalid superhero with negative creation year
        Superhero invalidSuperhero2 = new Superhero("Bruce Banner", "Hulk", true, -1962, "Super strength", 95);
        assertFalse(database.isValidSuperhero(invalidSuperhero2));

        // Test an invalid superhero with empty superpower
        Superhero invalidSuperhero3 = new Superhero("Natasha Romanoff", "Black Widow", false, 1964, "", 85);
        assertFalse(database.isValidSuperhero(invalidSuperhero3));

        // Test an invalid superhero with strength out of range
        Superhero invalidSuperhero4 = new Superhero("Tony Stark", "Iron Man", true, 1963, "Technology", 110);
        assertFalse(database.isValidSuperhero(invalidSuperhero4));
    }

    @Test
    void testEditSuperhero() {
        // Add a superhero to the database
        Superhero originalSuperhero = new Superhero("Steve Rogers", "Captain America", true, 1941, "Super soldier serum", 55);
        database.addSuperhero(originalSuperhero);

        // Edit the superhero's name
        Superhero editedSuperhero = new Superhero("Sam Wilson", "The Falcon", true, 1941, "Tech Falcon", 40);
        database.editSuperhero("Steve Rogers", editedSuperhero);

        // Check if the superhero was updated
        ArrayList<Superhero> superheroes = database.getAllSuperheroes();
        assertEquals(1, superheroes.size()); // Check that there is one superhero in the database
        assertEquals(editedSuperhero, superheroes.get(0)); // Check if the edited superhero is in the database

        // Check that the database remains unchanged
        superheroes = database.getAllSuperheroes();
        assertEquals(1, superheroes.size()); // The database should still have one superhero
        assertEquals(editedSuperhero, superheroes.get(0)); // The edited superhero should remain in the database
    }

}