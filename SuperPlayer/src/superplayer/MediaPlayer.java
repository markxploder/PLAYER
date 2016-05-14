package superplayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;

public class MediaPlayer extends Thread {
    private int currentTrackNumber = 0;
    byte playerState; // 0 - stopped, 1 - playing, 2 - paused
    Player zoomPlayer;
    Playlist playlist = new Playlist("/home/markx/Музыка/item.txt");

    public MediaPlayer(String playlistPath) {
        playlist = new Playlist(playlistPath);
    }

    void changeTrackNumber(int trackNumber) {
        if (trackNumber < 0)
            if (this.currentTrackNumber > 0)
                this.currentTrackNumber--;
            else
                this.currentTrackNumber = Playlist.playlistLength - 1;
        else if (trackNumber == 0)
            if (this.currentTrackNumber < Playlist.playlistLength - 2)
                this.currentTrackNumber++;
            else
                this.currentTrackNumber = 0;
        else if ((trackNumber < Playlist.playlistLength - 1) && (trackNumber >= 0))
            this.currentTrackNumber = trackNumber;
    }

    void play() throws FileNotFoundException, JavaLayerException {
        FileInputStream mp3Path = new FileInputStream(this.playlist.playlist[this.currentTrackNumber].getTrackPath());
        zoomPlayer = new Player(mp3Path);
        if (this.playerState == 0)
            zoomPlayer.play();
    }


    void stopPlaying() {

    }

    @Override
    public void run() {
        try {
            this.play();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }


}
