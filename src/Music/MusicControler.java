package Music;
import Manage.*;

public class MusicControler {

    private GameStateManager gSM;
    private MusicThread good, bad, game, mouseOn, mousePressed,background;

    public MusicControler(String goodPath, String badPath, String gamePath, GameStateManager gSM) {
        this.gSM = gSM;
        good = new MusicThread(goodPath, gSM, false);
        bad = new MusicThread(badPath, gSM, false);
        game = new MusicThread(gamePath, gSM, true);
        /*mouseOn = new MusicThread(backgroundPath, gSM, false);
        mousePressed =  new MusicThread(backgroundPath, gSM, false);
        background = new MusicThread(backgroundPath, gSM, true);*/

    }

    public GameStateManager getgSM() {
        return gSM;
    }

    public void setgSM(GameStateManager gSM) {
        this.gSM = gSM;
    }

    public MusicThread getMouseOn() {
        return mouseOn;
    }

    public void setMouseOn(MusicThread mouseOn) {
        this.mouseOn = mouseOn;
    }

    public MusicThread getMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(MusicThread mousePressed) {
        this.mousePressed = mousePressed;
    }

    public MusicThread getBackground() {
        return background;
    }

    public void setBackground(MusicThread background) {
        this.background = background;
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

    public MusicThread getGame() {
        return game;
    }

    public void setGame(MusicThread game) {
        this.game = game;
    }
}
