package superplayer;

import javazoom.jl.decoder.JavaLayerException;

import java.io.FileNotFoundException;

public class MainPlayer {

    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
      //new Interface("SuperPlayer");
        try {
            MediaPlayer player = new MediaPlayer("C:\\Users\\markx\\Desktop\\Projects\\IdeaProjects\\PLAYER\\SuperPlayer\\item.txt");
            player.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}