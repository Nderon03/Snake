package classHolder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/** Stores username and score to file.
 * @author Nderon Beqiri */
public class ScoreToFile {
    private static String username;

    /**Appends final score achieved to file*/
    public void addToHighScore(int score) throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            try {
                //append score to file
                fw = new FileWriter("AllTimeScores.txt", true);
                bw = new BufferedWriter(fw);
                pw = new PrintWriter(bw);
                pw.println(score);
                pw.flush();
                //add new line before each entry for clarity
                bw.write("\n");
            } finally {
                try {
                    pw.close();
                    bw.close();
                    fw.close();
                } catch (IOException io) {
                }
            }
        } finally {

        }
    }

    /**Appends name entered in Start screen to file*/
    public void addNameToHighScore(String name) throws IOException {
        username=name;
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            try {
                //append username to file
                fw = new FileWriter("AllTimeScores.txt", true);
                bw = new BufferedWriter(fw);
                pw = new PrintWriter(bw);
                pw.println(name);
                pw.flush();
            } finally {
                try {
                    pw.close();
                    bw.close();
                    fw.close();
                } catch (IOException io) {
                }
            }
        } finally {

        }
    }

    /**Allows other classes to access username entered in Start screen*/
    public String getUsername(){
        return username;
    }


}

