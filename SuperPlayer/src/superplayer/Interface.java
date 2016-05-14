package superplayer;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class Interface extends JFrame
{
    MediaPlayer player = new MediaPlayer("/home/markx/Музыка/item.txt");

    Interface(String s) throws FileNotFoundException, JavaLayerException {
        super(s);
        setLayout(null);
        setSize(400, 180);
        setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        JButton pl = new JButton("Play");
        pl.setBounds(15, 120, 80, 25);
        add(pl);

        JButton pau = new JButton("Pause");
        pau.setBounds(160, 120, 80, 25);
        add(pau);

        JButton st = new JButton("Stop");
        st.setBounds(305, 120, 80, 25);
        add(st);

        pl.addActionListener(
                event -> new MediaPlayer("/home/markx/Музыка/item.txt"));
    }
    public void actionPerformed(ActionEvent event) throws FileNotFoundException, JavaLayerException {
        player.start();
    }
}
