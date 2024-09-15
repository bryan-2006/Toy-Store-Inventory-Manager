package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * This main class initializes the JavaFx application and extends Application
 * @author Bryan, John
 * @version 03-31-2024
 */
public class Main extends Application {
	
	/**
	 * Constructor for Main
	 */
	public Main() {
		
	}
	
	/**
	 * This method loads the FMXL file with the root and scene 
	 * @param primaryStage is what is being shown
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			Scene scene = new Scene(root,500,500);
			scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The main method that starts the java application
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
