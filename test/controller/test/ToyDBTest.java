package controller.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import controller.ToyDB;
import model.*;

/**
 * This class contains JUnit tests for the ToyDB class.
 * @author Bryan, John
 * @version 03-31-2024
 */
class ToyDBTest {
	/**
	 * The ToyDB object that is used for tests 
	 */
    private ToyDB toyDB;
    
	/**
	 * Constructor for ToyDBTest
	 */
	public ToyDBTest() {
		
	}
    
    /**
     * This method initializes the toyDB object before each of the test case
     */
    @BeforeEach
    void setUp() {
        toyDB = new ToyDB();
        // Add sample data to the toy database for testing
        toyDB.addEntry(new Figure("Figure", "0123456789", "Action Figure", "Brand1", 10.99, 5, 3, 'A'));
        toyDB.addEntry(new Animal("Animal", "2345678901", "Stuffed Animal", "Brand2", 15.99, 8, 5, "Cotton", 'M'));
        // Add more sample data if needed
    }

    /**
     * Tests the filtering by serial number method
     */
    @Test
    void testFilterBySN() {
        // Test filtering by serial number
        assertEquals(1, toyDB.filterBySN("0123456789").size());
        assertEquals(0, toyDB.filterBySN("9876543210").size()); // Serial number not found
    }

    /**
     * Tests the filtering by name method
     */
    @Test
    void testFilterByName() {
        // Test filtering by name
        assertEquals(1, toyDB.filterByName("Action").size());
        assertEquals(1, toyDB.filterByName("animal").size()); // Case-insensitive search
        assertEquals(0, toyDB.filterByName("Board").size()); // No toys with "Board" in name
    }

    /**
     * Tests the filter by type method
     */
    @Test
    void testFilterByType() {
        // Test filtering by type
        assertEquals(1, toyDB.filterByType("figure").size());
        assertEquals(1, toyDB.filterByType("animal").size());
        assertEquals(0, toyDB.filterByType("puzzle").size()); // No puzzles in sample data
    }

}