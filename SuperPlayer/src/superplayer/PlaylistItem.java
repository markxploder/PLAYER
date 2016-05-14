package superplayer;


import java.io.File;
import java.util.Formatter;

public class PlaylistItem {

    private String title = "";
    private String artist = "";
    private String album = "";
    private int trackLength = 260;
    private byte rating = 0;
    private int bitrate = 0;
    private String trackPath = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getTrackLength() {
        return trackLength;
    }

    public String getTrackLengthString() {

        int h, m, s;
        h = this.getTrackLength() / 3600;
        m = (this.getTrackLength() % 3600 / 60);
        s = (this.getTrackLength() % 60);

        Formatter f = new Formatter();
        f.format("%02d",h);
        f.format("%02d",m);
        f.format("%02d",s);
        String getTrackLengthString = f.toString();
        f.close();
        return getTrackLengthString;
    }

    public void setTrackLength(short trackLength) {
        this.trackLength = trackLength;
    }

    public void setTrackLength(String trackLength) {

        String len[] = trackLength.split(":");
        int h = 0, m = 0, s = 0;

        try {
            if (len.length == 3) {
                h = Integer.parseInt(len[0]);
                m = Integer.parseInt(len[1]);
                s = Integer.parseInt(len[2]);
            } else if (len.length == 2) {
                m = Integer.parseInt(len[0]);
                s = Integer.parseInt(len[1]);
            } else if (len.length == 1) {
                s = Integer.parseInt(len[0]);
            }

            if (s > 59) {
                s = s % 60;
                m += (s / 60);
            }
            if (m > 59) {
                m = m % 3600;
                h += (m / 3600);
            }

            this.trackLength = h * 3600 + m * 60 + s;
        } catch (Exception e) {

        }

    }

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        if (rating > 5)
            this.rating = 5;
        else if (rating < 0)
            this.rating = 0;
        else
            this.rating = rating;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public String getTrackPath() {
        return trackPath;
    }

    public void setTrackPath(String trackPath) {
        File file = new File(trackPath);
        if (file.exists() && file.isFile()) {
            this.trackPath = trackPath;
        }
        else System.out.println("Шляпа");
    }
}
