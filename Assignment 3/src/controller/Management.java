package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import model.Animal;
import model.BoardGame;
import model.Figure;
import model.Puzzle;
import model.Toy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import exceptions.PlayerAmountException;
import exceptions.PriceException;

/**
 * This class handles the database of all the toys.
 * @author Bryan, John
 * @version 03-031-2024
 */
public class Management {
	/**
	 * This field represents the toy database.
	 */
    private ToyDB toyDB;
    

    /**
     * Label on "Add Toy" to show any messages that was in console in the previous version without GUI
     */
    @FXML
    private Label addToyConsole;

    
    /**
     * The buy button in "Home"
     */
    @FXML
    private Button buyBtn;

    /**
     * Clear button in "Home"
     */
    @FXML
    private Button clearBtn;

    /**
     * Toggle group for the radio buttons in "Home"
     */
    @FXML
    private ToggleGroup findWith;

    /**
     * The ListView in "Home"
     */
    @FXML
    private ListView<Toy> list;
    
    /**
     * The ListView in "Remove Toy"
     */
    @FXML
    private ListView<Toy> removeList;
    
    /**
     * The remove button in "Remove Toy"
     */
    @FXML
    private Button removeBtn;	

    /**
     * The TextField that takes name input in "Home"
     */
    @FXML
    private TextField nameField;
    
    /**
     * The TextField that takes in SN for "Remove Toy" 
     */
    @FXML
    private TextField removeNumberField;

    /**
     * The Label coinciding with the name TextField in "Home" 
     */
    @FXML
    private Label nameLbl;

    /**
     * The Name radio button in "Home"
     */
    @FXML
    private RadioButton nameRadio;

    /**
     * The search button in "Home"
     */
    @FXML
    private Button searchBtn;

    /**
     * The serial number field in "Home"
     */
    @FXML
    private TextField snField;

    /**
     * The Label coinciding with the serial number TextField in "Home" 
     */
    @FXML
    private Label snLbl;

    /**
     * The Serial Number radio button in "Home"
     */
    @FXML
    private RadioButton snRadio;

    /**
     * Takes in the input for type of Toy in "Home"
     */
    @FXML
    private TextField typeField;

    /**
     * The Label coinciding with the type TextField in "Home" 
     */
    @FXML
    private Label typeLbl;
    
    /**
     * Takes in the input for the minimum appropriate age to play with Toy in "Add Toy"
     */
    @FXML
    private TextField ageNewToy;

    /**
     * Takes in the input for the available count of the Toys in "Add Toy"
     */
    @FXML
    private TextField availableNewToy;

    /**
     * Takes in the input for the brand for the Toy in "Add Toy"
     */    
    @FXML
    private TextField brandNewToy;

    /**
     * Takes in the input for the classification for the Toy in "Add Toy" if Toy is a Figure
     */
    @FXML
    private TextField classification;

    /**
     * Takes in the input for the designers for the Toy in "Add Toy" if Toy is a BoardGame
     */
    @FXML
    private TextField design;

    /**
     * Takes in the input for the material for the Toy in "Add Toy" if Toy is a Animal
     */
    @FXML
    private TextField material;

    /**
     * Takes in the input for the max # of people for the Toy in "Add Toy" if Toy is a BoardGame
     */
    @FXML
    private TextField max;

    /**
     * Takes in the input for the min # of people for the Toy in "Add Toy" if Toy is a BoardGame
     */
    @FXML
    private TextField min;

    /**
     * Takes in the name for the Toy in "Add Toy"
     */   
    @FXML
    private TextField nameNewToy;
    
    /**
     * Takes in the price for the Toy in "Add Toy"
     */   
    @FXML
    private TextField priceNewToy;

    /**
     * The save button in "Add Toy"
     */   
    @FXML
    private Button saveBtn;

    /**
     * Takes in the size for the Toy in "Add Toy" if Toy is an Animal
     */     
    @FXML
    private TextField size;
    
    /**
     * Takes in the serial number for the Toy in "Add Toy"
     */   
    @FXML
    private TextField snNewToy;

    /**
     * Takes in the input for the type of Puzzle for the Toy in "Add Toy" if Toy is a Puzzle
     */
    @FXML
    private TextField type;

    /**
     * The Type radio button in "Home"
     */
    @FXML
    private RadioButton typeRadio;
    
    /**
     * For one of the handle search methods where the integer number represents what type of search method is used. 
     */
    private int snNameOrType = 0;

    /**
     * ArrayList of Toy for the Home ListView
     */
    private ArrayList<Toy> toys = new ArrayList<>();
    
    /**
     * Logger that creates a log for when the program is booted, when a toy is added, removed, etc. (might not show up on Eclipse but its there if u open project in file explorer)
     */
    private final static Logger LOGR = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    
    /**
     * The constructor for the Management class
     * @throws IOException If log file cannot be done
     * @throws SecurityException Specified detail message and cause
     */
    public Management() throws SecurityException, IOException {
        toyDB = new ToyDB();
        toyDB.load();
        
        LogManager.getLogManager().reset();
		
		FileHandler fh = new FileHandler("myLog.log");
		fh.setLevel(Level.ALL);
		LOGR.setLevel(Level.ALL);
		
		LOGR.addHandler(fh);
		fh.setFormatter(new SimpleFormatter()); //changes from xml file (looks like html src) to
												//similair to txt and console output
		
		LOGR.info("Program booted.");
		
	}
    
    /**
     * This method clears all the fields
     * @param event is the action event
     */
    @FXML
    void clear(ActionEvent event) {
    	snField.setText("");
    	nameField.setText("");
    	typeField.setText("");
    	findWith.selectToggle(null);
    	list.getItems().removeAll(FXCollections.observableArrayList(
    			toys));
    	    	
    	radioClick(event); //passes in clear button event but thats ok since the else if red statements wont run, only turns black
    }

    /**
     * This method changes the colour of the label button to red, depending on which radio button is clicked
     * @param event is the radio button that is clicked
     */
    @FXML
    void radioClick(ActionEvent event) {
    	//learned to change color: https://stackoverflow.com/questions/61052676/how-to-change-color-of-text-in-javafx-label
    	nameLbl.setTextFill(Color.color(0, 0, 0));
    	snLbl.setTextFill(Color.color(0, 0, 0));
    	typeLbl.setTextFill(Color.color(0, 0, 0));
    	
    	// TO CREATE PLACEHOLDERS: https://stackoverflow.com/questions/23363222/how-to-set-placeholder-in-javafx
    	
    	snField.setPromptText("");
    	nameField.setPromptText("");
    	typeField.setPromptText("");
    	
    	if (event.getSource().toString().contains("Name")) {
			nameLbl.setTextFill(Color.color(1, 0, 0));
			snNameOrType = 2;
	    	nameField.setPromptText("Enter name here");
    	} else if (event.getSource().toString().contains("Number")) {
			snLbl.setTextFill(Color.color(1, 0, 0));
			snNameOrType = 1;
			snField.setPromptText("Enter SN here");
    	} else if (event.getSource().toString().contains("Type")) {
			typeLbl.setTextFill(Color.color(1, 0, 0));
			snNameOrType = 3;
	    	typeField.setPromptText("Enter type here");

    	}
    }

    /**
     * This method searches for the toy
     * @param event is the toy that is being searched
     */
    @FXML
    void search(ActionEvent event) {
    	ObservableList<Toy> listView = FXCollections.observableArrayList(
    			handleSearchReturnToys(snNameOrType));
    	
    	list.getItems().addAll(listView);
    }
	
    /**
     * This method searches for the toy based on the searchCriteria and returns it
     * @param searchCriteria is the criteria used to search the toy
     * @return the toy
     */
	private ArrayList<Toy> handleSearchReturnToys(int searchCriteria) {
        
        switch (searchCriteria) {
            case 1:
                toys = toyDB.filterBySN(snField.getText());
                break;
            case 2:
                toys = toyDB.filterByName(nameField.getText());
                break;
            case 3:
                toys = toyDB.filterByType(typeField.getText());
                break;
            case 4:
            	toys = toyDB.filterBySN(removeNumberField.getText());
        };
        
        return toys;
    }    

    /**
     * This method validates the users inputs and saves it into the database when the save button is clicked
     * @param event is the action event
     */
	@FXML
	void save(ActionEvent event) {
		addToyConsole.setText("");
	    boolean pass = false;

	    String sn = snNewToy.getText();

	    ArrayList<Toy> database = toyDB.getDataBase();
	    for (Toy toy : database) {
	        if (toy.getSerialNumber().equals(sn)) {
	            addToyConsole.setText("The serial number is already existing!");
	            pass = true;
	        }
	    }

	    if (sn.length() != 10) {
	        addToyConsole.setText("The Serial Number MUST be 10 digits! ");
	        pass = true;

	    } else if (!sn.matches("[0-9]+")) {
	        addToyConsole.setText("The Serial should only contain digits! ");
	        pass = true;
	    }

	    String category = findCategoryBySerial(sn);

	    String name = nameNewToy.getText();

	    String brand = brandNewToy.getText();

	    // VALIDATION FOR PRICE
	    String priceStr = priceNewToy.getText();
	    double price = 0;

	    try {
	        price = Double.parseDouble(priceStr);
	        if (!validPrice(price)) {
	            throw new PriceException(price);
	        }

	    } catch (NumberFormatException e) {
	        addToyConsole.setText("Invalid input! Please enter a valid number for the price.");
	        pass = true;

	    } catch (PriceException e) {
	        addToyConsole.setText(e.getMessage());
	        pass = true;
	    }

	    // VALIDATION FOR COUNT
	    String availableCountStr = availableNewToy.getText();

	    int availableCount = 0;
	    try {
	        availableCount = Integer.parseInt(availableCountStr);
	    } catch (NumberFormatException e) {
	        addToyConsole.setText("Invalid input! Please enter a valid number for available counts.");
	        pass = true;
	    }

	    // VALIDATION FOR AGE
	    String ageStr = ageNewToy.getText();
	    int minAgeAppropriate = 0;

	    try {
	        minAgeAppropriate = Integer.parseInt(ageStr);
	    } catch (NumberFormatException e) {
	        addToyConsole.setText("Invalid input! Please enter a valid number for the appropriate age.");
	        pass = true;
	    }

	    if (pass) {
	        // If any validation failed, stop processing
	        return;
	    }

	    char firstDigit;
	    try {
	        firstDigit = sn.charAt(0);
	    } catch (StringIndexOutOfBoundsException e) {
	        addToyConsole.setText("Invalid Serial Number format.");
	        pass = true;
	        return;
	    }

	    if (category.equals("Figure")) {
	        if (firstDigit != '0' && firstDigit != '1') {
	            addToyConsole.setText("Invalid Serial Number for the toy category. ");
	            pass = true;
	        } else {
	            char classify;
	            try {
	                classify = classification.getText().charAt(0);
	            } catch (StringIndexOutOfBoundsException e) {
	                addToyConsole.setText("Invalid Classification format.");
	                pass = true;
	                return;
	            }
	            toyDB.addEntry(new Figure(category, sn, name, brand, price, availableCount, minAgeAppropriate, classify));
	        }
	    } else if (category.equals("Animal")) {
	        String material = this.material.getText();
	        if (firstDigit != '2' && firstDigit != '3') {
	            addToyConsole.setText("Invalid Serial Number for the toy category. ");
	            pass = true;
	        } else {
	            char size;
	            try {
	                size = this.size.getText().charAt(0);
	            } catch (StringIndexOutOfBoundsException e) {
	                addToyConsole.setText("Invalid Size format.");
	                pass = true;
	                return;
	            }
	            toyDB.addEntry(new Animal(category, sn, name, brand, price, availableCount, minAgeAppropriate, material, size));
	        }
	    } else if (category.equals("Puzzle")) {
	        if (firstDigit != '4' && firstDigit != '5' && firstDigit != '6') {
	            addToyConsole.setText("Invalid Serial Number for the toy category. ");
	            pass = true;
	        } else {
	            char puzzleType;
	            try {
	                puzzleType = this.type.getText().charAt(0);
	            } catch (StringIndexOutOfBoundsException e) {
	                addToyConsole.setText("Invalid Puzzle Type format.");
	                pass = true;
	                return;
	            }
	            toyDB.addEntry(new Puzzle(category, sn, name, brand, price, availableCount, minAgeAppropriate, puzzleType));
	        }
	    } else if (category.equals("BoardGame")) {
	        String minPlayersStr = min.getText();
	        String maxPlayersStr = max.getText();
	        int minPlayers = 0;
	        int maxPlayers = 0;
	        try {
	            minPlayers = Integer.parseInt(minPlayersStr);
	        } catch (NumberFormatException e) {
	            addToyConsole.setText("Invalid input! Please enter a valid number for the minimum number of players.");
	            pass = true;
	        }

	        try {
	            maxPlayers = Integer.parseInt(maxPlayersStr);
	        } catch (NumberFormatException e) {
	            addToyConsole.setText("Invalid input! Please enter a valid number for the maximum number of players.");
	            pass = true;
	        }

	        try {
	            if (!validPlayerAmount(maxPlayers, minPlayers)) {
	                throw new PlayerAmountException(maxPlayers, minPlayers);
	            }
	        } catch (PlayerAmountException e) {
	            addToyConsole.setText(e.getMessage());
	            pass = true;
	        }

	        if (firstDigit != '7' && firstDigit != '8' && firstDigit != '9') {
	            addToyConsole.setText("Invalid Serial Number for the toy category. ");
	            pass = true;
	        } else {
	            String[] designers;
	            try {
	                designers = design.getText().split(",");
	            } catch (StringIndexOutOfBoundsException e) {
	                addToyConsole.setText("Invalid Designers format.");
	                pass = true;
	                return;
	            }
	            toyDB.addEntry(new BoardGame(category, sn, name, brand, price, availableCount, minAgeAppropriate, minPlayers, maxPlayers, designers));
	        }
	    }

	    if (!pass) {
	        toyDB.save();
	        LOGR.info("New Toy Added.");
	    }
	}
	
	/**
	 * This method validates the price
	 * @param price is the price inputed by the user
	 * @return true or false depending if the price is valid
	 * @throws PriceException if the PriceException error occurs
	 */
	private boolean validPrice(double price) throws PriceException {
	    // Check price not negative
	    if (price < 0) {
	        throw new PriceException(price);
	    }
	     
	    return true;
	}
	
	/**
	 * This method validates the player amount
	 * @param max is the maximum players inputed by the user
	 * @param min is the minimum players inputed by the user
	 * @return true or false depending if the player amount is valid
	 * @throws PlayerAmountException if the PlayerAmountException error occurs
	 */
	private boolean validPlayerAmount(int max, int min) throws PlayerAmountException{
	    if (max < min) {
	        throw new PlayerAmountException(max, min);
	    }
	     
	    return true;
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
	 * This method removes the toy from the database
	 * @param event is the toy that the user inputed
	 */
	@FXML
    void remove(ActionEvent event) {
    	String serialNumber = removeNumberField.getText();
        ArrayList<Toy> toRemove = handleSearchRemove("SN", serialNumber);
        Toy toyToRemove = toRemove.get(0);
        toyDB.removeEntry(toyToRemove);
        toyDB.save();
        
    	ObservableList<Toy> listView = FXCollections.observableArrayList(
    			toRemove);
    	
    	removeList.getItems().addAll(listView);
    	LOGR.severe(toyToRemove.getName() + " removed from database.");
    }
    
	/**
     * This method searches for the toy based on the searchTerm
     * @param searchCriteria is the criteria of what is being searched
     * @param searchTerm is the term of the criteria that is being searched
     * @return the toy that is being searched
     */
	private ArrayList<Toy> handleSearchRemove(String searchCriteria, String searchTerm) {
        ArrayList<Toy> toys = new ArrayList<>();
        switch (searchCriteria) {
            case "SN":
                toys = toyDB.filterBySN(searchTerm);
                break;
            case "name":
                toys = toyDB.filterByName(searchTerm);
                break;
            case "type":
                toys = toyDB.filterByType(searchTerm);
                break;
            case "age":
                toys = toyDB.filterByAge(searchTerm);
                break;
        };
        return toys;
    }

	/**
	 * This method buys the toy
	 * @param event is the toy being bought
	 */
    @FXML
    void buy(ActionEvent event) {
    	Toy selected = list.getSelectionModel().getSelectedItem();
    	toyDB.purchaseToy(selected);
    	
    	LOGR.info(selected.getName() + " bought.");
    	
        }
	

}
