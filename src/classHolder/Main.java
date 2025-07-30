package classHolder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


/** First class called when program is run
 * @author Nderon Beqiri */
public class Main extends Application {

    /**Creation of stage, showing displayScores.fxml file*/
    @Override
    public void start(Stage stage) throws IOException {
        Image icon = new Image(getClass().getResourceAsStream("snake-logo.png"));
        Parent root = FXMLLoader.load(getClass().getResource("displayScores.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //set icon of Start screen to snake logo
        stage.getIcons().add(icon);
        //Set title of Start screen to Snakee Yipee
        stage.setTitle("Snakee Yipee");
        stage.show();
    }


    /**First method executed in program, loading up stage*/
    public static void main(String[] args) {
        launch(args);
    }
}
