package classHolder;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/** Called when user clicks Go To Start Screen in AllTimeScores.
 * @author Nderon Beqiri-modified */
public class StartScreen {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private ImageView myImageView;
    private int choice=5;
    private int bg=5;
    @FXML
    private TextField nameTextField;

    private final MusicPlayer musicPlayer = new MusicPlayer("src/classHolder/frogger.mp3");

    private final ScoreToFile highscore = new ScoreToFile();

    private final Image myImage = new Image(getClass().getResourceAsStream("UI-background2.png"));
    private final Image myImage2 = new Image(getClass().getResourceAsStream("UI-background.png"));

    private final Image myImage3 = new Image(getClass().getResourceAsStream("UI-background3.png"));


    /**Allows user to click Play Background Music and play frogger.mp3*/
    @FXML
    void onPlayAudio (ActionEvent event){
        musicPlayer.Play();
    }

    /**Called when user clicks Sky Background button*/
    public void displayImage(){
        myImageView.setImage(myImage);
        bg=1;
    }

    /**Called when user clicks Happy Background button*/
    public void displayImage2(){
        myImageView.setImage(myImage2);
        bg=0;
    }

    /**Called when user clicks Basic Level button*/
    public int basicLevel(){
        choice=0;
        System.out.println("Selected Basic Level");
        return choice;
    }

    /**Called when user clicks Advanced Level button*/
    public void advancedLevel(){
        choice=1;
        myImageView.setImage(myImage3);
        System.out.println("Selected Advanced Level");
    }

    /**If button is clicked, snake will be green*/
    public int playGreenSnake(){
        MySnake.isRed=0;
        System.out.println("Selected Green Snake");
        return MySnake.isRed;

    }

    /**If button is clicked, snake will be red*/
    public int playRedSnake(){
        MySnake.isRed=1;
        System.out.println("Selected Red Snake");
        return MySnake.isRed;
    }

    /**Returns choice*/
    public int getChoice(){
        return choice;
    }

    /**Returns background selected*/
    public int getBg(){
        return bg;
    }

    /**If button is clicked, application is closed*/
    public void exitButton(){
        Platform.exit();
    }

    /**Displays rules when clicked by going to rules.fxml screen*/
    public void rulesButton(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("rules.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**Called when user clicks Begin button*/
    public void beginGame(ActionEvent event) throws InterruptedException, IOException {
        //store final choices into variable so Play class can use them
        int finalChoice = choice;
        int finalBg = bg;

        //check if username is null or not
        //if null, initialise finalVariables to 6
        //-> go to else statement
        //-> display Error screen
        String username=nameTextField.getText();
        highscore.addNameToHighScore(username);

        //if no username has been entered go to Error screen
        if (username.length()<1){
            finalChoice =6;
            finalBg =6;
        }

        //Play class displays UI-background 1 (sky background)
        if (finalChoice == 0 && finalBg == 0) {
            Play play = new Play();
            Thread.sleep(1000);
            play.PlayBegins();

        }
        //Play class displays UI-background 2 (happy background)
        if (finalChoice == 0 && finalBg == 1) {
            Play play = new Play();
            Thread.sleep(1000);
            play.PlayBegins2();

        }
        //Play class displays UI-background 3 (advanced level)
        if(finalChoice ==1 && finalBg !=0 && finalBg != 1){
            Play play = new Play();
            Thread.sleep(1000);
            play.PlayBegins3();
        }


        //if user does not select a valid option, return to Error screen
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("errorEntry.fxml"));
            root = loader.load();

            ErrorScreen scene2Controller = loader.getController();
            scene2Controller.displayError();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
