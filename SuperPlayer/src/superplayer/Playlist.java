package superplayer;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.util.ArrayList;

public class Playlist
{
    PlaylistItem[] playlist;
    //ArrayList<PlaylistItem> playlist = new ArrayList();
    public static int playlistLength;

    Playlist () {

    }

    Playlist (String playlistPath)
    {
        this.read(playlistPath);
    }

    public void read(String playlistPath) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            File f = new File(playlistPath);
            if (f.exists() && f.isFile()) {
                fr = new FileReader(playlistPath);
                br = new BufferedReader(fr);
                String s = null;
                int count = 0;

                while ((s = br.readLine()) != null)
                    count++;
                playlistLength = (short) count / 7;

                br.close();

                fr = new FileReader(playlistPath);
                br = new BufferedReader(fr);

                playlist = new PlaylistItem[count];
                
                s = "";
                for (int trackNumber = 0; trackNumber < count/7; trackNumber++) {
                    playlist[trackNumber] = new PlaylistItem();
                    playlist[trackNumber].setTitle(br.readLine());
                    playlist[trackNumber].setArtist(br.readLine());
                    playlist[trackNumber].setAlbum(br.readLine());
                    playlist[trackNumber].setTrackLength(br.readLine());
                    playlist[trackNumber].setRating(Byte.parseByte(br.readLine()));
                    playlist[trackNumber].setBitrate(Integer.parseInt(br.readLine()));
                    playlist[trackNumber].setTrackPath(br.readLine());

                    //System.out.println(this.getPlaylistItemInfo(trackNumber));
                }

                br.close();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPlaylistItemInfo(int trackNumber) {
        return playlist[trackNumber].getTitle() + " - " +
                playlist[trackNumber].getArtist() + " - " +
                playlist[trackNumber].getAlbum() + " - " +
                playlist[trackNumber].getTrackLength() + " - " +
                playlist[trackNumber].getRating() + " - " +
                playlist[trackNumber].getBitrate() + " - " +
                playlist[trackNumber].getTrackPath();
    }

    public void shuffle() {
        int track1 = 0, track2 = 0;
        for (int i = 0; i < playlistLength; i++) {
            track1 = (int) (Math.random()*playlistLength);
            track2 = (int) (Math.random()*playlistLength);

            PlaylistItem temp = new PlaylistItem();
            temp.setTitle(playlist[track1].getTitle());
            temp.setArtist(playlist[track1].getArtist());
            temp.setAlbum(playlist[track1].getAlbum());
            temp.setTrackLength(playlist[track1].getTrackLengthString());
            temp.setRating(playlist[track1].getRating());
            temp.setBitrate(playlist[track1].getBitrate());
            temp.setTrackPath(playlist[track1].getTrackPath());

            playlist[track1].setTitle(playlist[track2].getTitle());
            playlist[track1].setArtist(playlist[track2].getArtist());
            playlist[track1].setAlbum(playlist[track2].getAlbum());
            playlist[track1].setTrackLength(playlist[track2].getTrackLengthString());
            playlist[track1].setRating(playlist[track2].getRating());
            playlist[track1].setBitrate(playlist[track2].getBitrate());
            playlist[track1].setTrackPath(playlist[track2].getTrackPath());

            playlist[track2].setTitle(temp.getTitle());
            playlist[track2].setArtist(temp.getArtist());
            playlist[track2].setAlbum(temp.getAlbum());
            playlist[track2].setTrackLength(temp.getTrackLengthString());
            playlist[track2].setRating(temp.getRating());
            playlist[track2].setBitrate(temp.getBitrate());
            playlist[track2].setTrackPath(temp.getTrackPath());
        }
    }
}