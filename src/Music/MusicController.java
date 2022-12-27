package Music;
import Manage.*;

public class MusicController {

    private GameStateManager gameStateManager;
    private MusicThread good, bad, game, mouseOn, mousePressed,background;

    public MusicController(String goodPath, String badPath, String gamePath, GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        good = new MusicThread(goodPath, gameStateManager, false);
        bad = new MusicThread(badPath, gameStateManager, false);
        game = new MusicThread(gamePath, gameStateManager, true);
        /*mouseOn = new MusicThread(backgroundPath, gSM, false);
        mousePressed =  new MusicThread(backgroundPath, gSM, false);
        background = new MusicThread(backgroundPath, gSM, true);*/

    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public void setGameStateManager(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
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
