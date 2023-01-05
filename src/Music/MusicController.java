package Music;
import Manage.*;

public class MusicController {

    private MusicThread good, bad, game, click, onbutton, background;

    public MusicController(GameStateManager gameStateManager, String goodPath, String badPath, String gamePath, String clickPath, String backgroundPath) {
        good = new MusicThread(goodPath, gameStateManager, false);
        bad = new MusicThread(badPath, gameStateManager, false);
        game = new MusicThread(gamePath, gameStateManager, true);
        click = new MusicThread(clickPath, gameStateManager, false);
        background = new MusicThread(backgroundPath, gameStateManager, true);

    }

    public MusicThread getClick() {
        return click;
    }

    public void setClick(MusicThread click) {
        this.click = click;
    }

    public MusicThread getOnbutton() {
        return onbutton;
    }

    public void setOnbutton(MusicThread onbutton) {
        this.onbutton = onbutton;
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
