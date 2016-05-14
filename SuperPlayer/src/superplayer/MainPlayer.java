package superplayer;

import javazoom.jl.decoder.JavaLayerException;

import java.io.FileNotFoundException;

public class MainPlayer {

    public static void main(String[] args) throws FileNotFoundException, JavaLayerException {
      //new Interface("SuperPlayer");
        try {
            MediaPlayer player = new MediaPlayer("/home/markx/Музыка/item.txt");
            player.start();

            MediaPlayer player1 = new MediaPlayer("/home/markx/Музыка/item.txt");
            Thread.sleep(1000);
            player1.changeTrackNumber(1);
            player1.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}