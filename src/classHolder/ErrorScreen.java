
package classHolder;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
/** Called when user input in Start Screen is wrong.
 * Displays errorEntry.fxml file.
 * Tells the user what they have entered is wrong.
 * Contains reset button for going back to StartScreen.
 * Contains exit button.
 * @author Nderon Beqiri */


public class ErrorScreen {

    @FXML
    private Label nameLabel;

    private Stage stage;

    private Scene scene;

    private Parent root;


    /**Returns nameLabel*/
    public Label getNameLabel(){
        return nameLabel;
    }

    /**Displays error message if user input in StartScreen is wrong*/
    public void displayError() {
        nameLabel.setText("You didn't select a valid option");
    }
    /**Button that allows user to exit program*/
    public void exitButton() {
        Platform.exit();

    }
    /**Button that allows user to go back to StartScreen*/
    public void resetButton(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}

