import datasource.Database;
import datasource.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        assertDoesNotThrow(() -> database.addSuperhero("Bruce Wayne", "Batman", true, 1939, "Intelligence", 90));
        assertEquals(1, database.getNumberOfSuperheroes());
    }

    @Test
    void testAddSuperheroWithInvalidData() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> database.addSuperhero("", "", true, -1, "", -1));
        assertEquals("Invalid input. Please check the superhero details.", exception.getMessage());
    }

    @Test
    void testSearchSuperheroNotFound() {
        assertTrue(database.searchSuperhero("Batman").isEmpty());
    }
}
