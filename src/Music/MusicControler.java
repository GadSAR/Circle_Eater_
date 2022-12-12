package Music;
import Manage.*;
import Multiplayer.*;
import Music.*;
import Panels.*;
import Objects.*;
import Resources.*;

public class MusicControler {

    private GameStateManager gSM;
    private MusicThread good, bad, background;

    public MusicControler(String goodPath, String badPath, String backgroundPath, GameStateManager gSM) {
        this.gSM = gSM;
        good = new MusicThread(goodPath, gSM, false);
        bad = new MusicThread(badPath, gSM, false);
        background = new MusicThread(backgroundPath, gSM, true);
    }

    public MusicThread getGood() {
        return good;
    }

    public void setGood(MusicThread good) {
        this.good = good;
    }

    public MusicThread getBad() {
        return bad;
    }

    public void setBad(MusicThread bad) {
        this.bad = bad;
    }

    public MusicThread getBackground() {
        return background;
    }

    public void setBackground(MusicThread background) {
        this.background = background;
    }
}
