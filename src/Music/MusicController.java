package Music;


public class MusicController {

    private MusicThread good, bad, game, click, background;

    public MusicController(String goodPath, String badPath, String gamePath, String clickPath, String backgroundPath) {
        good = new MusicThread(goodPath, false);
        bad = new MusicThread(badPath, false);
        game = new MusicThread(gamePath, true);
        click = new MusicThread(clickPath, false);
        background = new MusicThread(backgroundPath, true);

    }

    public MusicThread getClick() {
        return click;
    }

    public MusicThread getBackground() {
        return background;
    }

    public MusicThread getGood() {
        return good;
    }

    public MusicThread getBad() {
        return bad;
    }

    public MusicThread getGame() {
        return game;
    }

}
