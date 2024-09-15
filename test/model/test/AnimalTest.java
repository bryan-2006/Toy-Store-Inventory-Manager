package model.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.Animal;

/**
 * This class contains JUnit tests for the Animal class.
 * It tests the constructors, getters, and setters of the Animal class.
 * 
 * @author Bryan, John
 * @version 03-010-2024
 */
class AnimalTest {
	
	/**
	 * Constructor for AnimalTest
	 */
	public AnimalTest() {
		
	}
	
	/**
	 * Test for the Animal constructor.
	 * It checks if the constructor initializes the object with the correct values.
	 */
	@Test
	public void testAnimalConstructor() {
        Animal animal = new Animal("Animal", "2123451239", "Mecha", "Hasbro", 39.99, 18, 8, "Plastic", 'M');
        assertEquals("2123451239", animal.getSerialNumber());
        assertEquals("Mecha", animal.getName());
        assertEquals("Hasbro", animal.getBrand());
        assertEquals(39.99, animal.getPrice(), 0.001);
        assertEquals(18, animal.getAvailableCount());
        assertEquals(8, animal.getMinAgeAppropriate());
        assertEquals("Plastic", animal.getMaterial());
        assertEquals('M', animal.getSize());
	}
	
	/**
	 * Test for inherited getters and setters of the Animal class.
	 * It checks if the getters and setters inherited from the superclass work correctly.
	 */
    @Test
    public void testInheritedGettersAndSetters() {
        Animal animal = new Animal("Animal", "2123456789", "Elly", "Fisher Toys", 23.99, 10, 4, "Wool", 'S');

        assertEquals("2123456789", animal.getSerialNumber());
        assertEquals("Elly", animal.getName());
        assertEquals("Fisher Toys", animal.getBrand());
        assertEquals(23.99, animal.getPrice(), 0.001);
        assertEquals(10, animal.getAvailableCount());
        assertEquals(4, animal.getMinAgeAppropriate());
    }

    /**
     * Test for specific getters of the Animal class.
     * It checks if the specific getters for material and size work correctly.
     */
    @Test
    public void testAnimalGetters() {
        Animal animal = new Animal("Animal", "2123456789", "Elly", "Fisher Toys", 23.99, 10, 4, "Plastic", 'L');
        assertEquals("Plastic", animal.getMaterial());
        assertEquals('L', animal.getSize());
    }
    
    /**
     * Test for specific setters of the Animal class.
     * It checks if the specific setters for material and size work correctly.
     */
    @Test
    public void testAnimalSetters() {
        Animal animal = new Animal("Animal", "2123456789", "Elly", "Fisher Toys", 23.99, 10, 4, "Wool", 'S');
        
        animal.setMaterial("SoftFabric");
        animal.setSize('L');

        assertEquals("SoftFabric", animal.getMaterial());
        assertEquals('L', animal.getSize());
    }
}