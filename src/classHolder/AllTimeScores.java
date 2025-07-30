package classHolder;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

/**First class called by main, initial screen showing displayscores.fxml file.
 * Displays updated all time score list each time program is run.
 * Contains button that allows to go to start screen.
 * Contains button that allows to exit.
 * @author Nderon Beqiri */
public class AllTimeScores implements Initializable {


    private Parent root;
    private Stage stage;
    private Scene scene;


    @FXML
    /**Text area will display file contents*/
    private TextArea textArea;

    /**User can exit by clicking button*/
    @FXML
    void exitButton(MouseEvent event) {
        Platform.exit();
    }

    /**Returns textArea*/
    public TextArea getTextArea(){
        return textArea;
    }

    /**User can reset by clicking button*/
    public void resetButton(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**Append names and scores stored in file to textarea*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //read file AllTimeScores
            Scanner s = new Scanner(new File("AllTimeScores.txt")).useDelimiter("\\s+");
            while (s.hasNext()) {
                //if integer variable, 2 new lines
                if (s.hasNextInt()) { // check if next token is an int
                    textArea.appendText(s.nextInt() + " "+"\n"+"\n"); // display the found integer

                } else {
                    //if string variable, one new line
                    textArea.appendText(s.next() + " "+"\n"); // else read the next token
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }
}