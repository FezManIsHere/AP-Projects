package composition;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


public class Composition extends Applet{

    public void paint(Graphics g) {
        Phonograph phono = new Phonograph(g);

    }

}

class MusicPlayer {

    public MusicPlayer(Graphics g) {
        drawMusicPlayer(g);
    }

    public void drawMusicPlayer(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(100, 100, 0, 0);
    }
}

class Phonograph extends MusicPlayer {

    public Phonograph(Graphics g) {
        super(g);
    }

    
}

class Record {

    public Record(Graphics g) {
        drawRecord(g);
    }

    public void drawRecord(Graphics g) {

    }
}

class TuneArm {

    public TuneArm(Graphics g) {
        drawTuneArm(g);
    }

    public void drawTuneArm(Graphics g) {

    }
}

class PitchControl {

    public PitchControl(Graphics g) {
        drawPitchControl(g);
    }

    public void drawPitchControl(Graphics g) {

    }
}