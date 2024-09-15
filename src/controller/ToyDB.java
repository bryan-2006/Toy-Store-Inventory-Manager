package controller;

import java.io.*;
import java.util.*;

import model.Animal;
import model.BoardGame;
import model.Figure;
import model.Puzzle;
import model.Toy;

/**
 * This class handles the database of all the toys.
 * @author Bryan, John
 * @version 03-010-2024
 */
public class ToyDB {
	/**
	 * ArrayList of Toys in the database
	 */
	private final ArrayList<Toy> dataBase = new ArrayList<>();
	/**
	 * Relative path to database text file as a String
	 */
    private final String DB_FILE_PATH = "res/toys.txt";
    
    /**
     * The constructor for the ToyDB class
     */
    public ToyDB() {
    	
    }
    
    /**
     * Method to get the database
     * @return
     */
    public ArrayList<Toy> getDataBase(){
    	return dataBase;
    }
    
    /**
     * This method loads the information from the text file.
     */
	public void load() {
        try {
            // Create a FileReader object
            FileReader fileReader = new FileReader(DB_FILE_PATH);

            // Wrap FileReader in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Read each line of the text file until the end
            while ((line = bufferedReader.readLine()) != null) {
                // Process each line as needed
                parseLine(line);
            }
            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            // Handle IOException (e.g., file not found, unable to read)
            e.printStackTrace();
        }
    }

	/**
	 * This method finds the toy based on the serial number.
	 * @param serialNumber is the serial number of the toy.
	 * @return the toy ArrayList
	 */
    public ArrayList<Toy> filterBySN(String serialNumber) {
        ArrayList<Toy> searchResults = new ArrayList<>();
        for (Toy toy: dataBase)
            if (toy.getSerialNumber().equals(serialNumber))
                searchResults.add(toy);
        return searchResults;
    }

    /**
     * This method finds the toy based on its name.
     * @param name is the name of the toy.
     * @return the toy attributes.
     */
    public ArrayList<Toy> filterByName(String name) {
        ArrayList<Toy> searchResults = new ArrayList<>();
        for (Toy toy: dataBase)
            if (toy.getName().toLowerCase().contains(name.toLowerCase()))
                searchResults.add(toy);
        return searchResults;
    }

    /**
     * This method finds the toy based on its type.
     * @param type is the type of the toy.
     * @return the toy attributes.
     */
    public ArrayList<Toy> filterByType(String type) {
        ArrayList<Toy> searchResults = new ArrayList<>();
        
        switch (type.toLowerCase()) {
        case "figure":
            for (Toy toy: dataBase)
                if (toy instanceof Figure)
                    searchResults.add(toy);
            break;
        case "animal":
            for (Toy toy: dataBase)
                if (toy instanceof Animal)
                    searchResults.add(toy);
            break;
        case "puzzle":
            for (Toy toy: dataBase)
                if (toy instanceof Puzzle)
                    searchResults.add(toy);
            break;
        case "boardgame":
            for (Toy toy: dataBase)
                if (toy instanceof BoardGame)
                    searchResults.add(toy);
            break;
        }
            
 
        return searchResults;
    }

    /**
     * This method handles the purchasing option.
     * @param toy is the toy the user wants to purchase.
     * @throws RuntimeException throws an exception when the available count is 0.
     */
    public void purchaseToy(Toy toy) throws RuntimeException {
        int availableCount = toy.getAvailableCount();
        if (availableCount > 0)
            toy.setAvailableCount(availableCount - 1);
        else
            throw new RuntimeException();
    }

    /**
     * Method to add the toy to the database
     * @param toy is the toy the user wants to add
     */
    public void addEntry(Toy toy) {
        this.dataBase.add(toy);
    }
    
    /**
     * This is the method that removes the toy from the database
     * @param toy is the toy the user wants to remove
     */
    public void removeEntry(Toy toy) {
        this.dataBase.remove(toy);
    }
    
    /**
     * This is the method that saves the current database.
     */  
    public void save() {
        try {
            // Create a FileReader object
            FileWriter fileWriter = new FileWriter(DB_FILE_PATH);

            // Wrap FileReader in BufferedReader for efficient reading
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Toy toy: dataBase) {
                bufferedWriter.write(toy.toDb() + "\n");
            }

            // Close the BufferedReader
            bufferedWriter.close();
        } catch (IOException e) {
            // Handle IOException (e.g., file not found, unable to read)
            e.printStackTrace();
        }
    }

    /**
     * This method splits the categories into parts and adds it as an entry.
     * @param line is the line from the database.
     */
    private void parseLine(String line) {
        String[] parts = line.split(";");
        String serialNumber = parts[0];
        String name = parts[1];
        String brand = parts[2];
        double price = Double.parseDouble(parts[3]);
        int availableCount = Integer.parseInt(parts[4]);
        int minAgeAppropriate = Integer.parseInt(parts[5]);
        
        String category = findCategoryBySerial(serialNumber);
        switch (category) {
            case "Figure":
                char classification = parts[6].charAt(0);
                addEntry(new Figure(category, serialNumber, name, brand, price, availableCount, minAgeAppropriate, classification));
                break;
            case "Animal":
                String material = parts[6];
                char size = parts[7].charAt(0);
                addEntry(new Animal(category, serialNumber, name, brand, price, availableCount, minAgeAppropriate, material, size));
                break;
            case "Puzzle":
                char puzzleType = parts[6].charAt(0);
                addEntry(new Puzzle(category, serialNumber, name, brand, price, availableCount, minAgeAppropriate, puzzleType));
                break;
            case "BoardGame":
                String[] players = parts[6].split("-");
                int minPlayer = Integer.parseInt(players[0]);
                int maxPlayer = Integer.parseInt(players[1]);
                String[] designers = parts[7].split(",");
                addEntry(new BoardGame(category, serialNumber, name, brand, price, availableCount, minAgeAppropriate, minPlayer, maxPlayer, designers));
                break;
        }
    }
    
    /**
     * This method finds the category of the game depending on the first number of the serial number.
     * @param serialNumber is the serial number of the toy.
     * @return the category of the toy.
     */
	public String findCategoryBySerial(String serialNumber) {
		if (serialNumber.startsWith("0") || serialNumber.startsWith("1"))
			return "Figure";
		else if (serialNumber.startsWith("2") || serialNumber.startsWith("3"))
			return "Animal";
		else if (serialNumber.startsWith("4") || serialNumber.startsWith("5") || serialNumber.startsWith("6"))
			return "Puzzle";
		else
			return "BoardGame";
	}
	
    /**
     * This method finds the toy based on its minimum age requirement.
     * @param minimum age requirement to play with the toy.
     * @return the toy ArrayList.
     */
	public ArrayList<Toy> filterByAge(String age) {
		ArrayList<Toy> searchResults = new ArrayList<>();
        int ageInt = Integer.parseInt(age);
		for (Toy toy: dataBase) {
			if (toy.getMinAgeAppropriate() >= ageInt)
				searchResults.add(toy);
		}
        return searchResults;
	}

	/**
	 * This method finds the toy based on the price.
	 * @param price of the toy.
	 * @return the toys that have the price or higher ArrayList
	 */
	public ArrayList<Toy> filterByPriceRange(double[] price) {
		final int INDEXOFLOWESTPRICE = 0;
		final int INDEXOHIGHESTPRICE = 1;

		ArrayList<Toy> searchResults = new ArrayList<>();
		double lowerPrice = price[INDEXOFLOWESTPRICE];
		double higherPrice = price[INDEXOHIGHESTPRICE];

		for (Toy toy: dataBase) {
			if (toy.getPrice() >= lowerPrice && toy.getPrice() <= higherPrice)
				searchResults.add(toy);
		}
		
        return searchResults;
	}
}



