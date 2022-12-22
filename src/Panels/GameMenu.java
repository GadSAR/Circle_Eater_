package Panels;

import Manage.*;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends JPanel {

    private GameStateManager gameStateManager;

    private Image bgMenu, Play, onPlay, Lobby, onLobby, Settings, onSettings, HowToPlay, onHowToPlay, Exit, onExit;
    private int xMiddleScreen, yMiddleScreen,
            wPlay, hPlay, xPlay, yPlay,
            wLobby, hLobby, xLobby, yLobby,
            wSettings, hSettings, xSettings, ySettings,
            wHowToPlay, hHowToPlay, xHowToPlay, yHowToPlay,
            wExit, hExit, xExit, yExit;


    public GameMenu(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;

        bgMenu = (new ImageIcon(gameStateManager.getResource().getGameMenuBackgroundImg())).getImage();
        Play = (new ImageIcon(gameStateManager.getResource().getPlayButton())).getImage();
        onPlay = (new ImageIcon(gameStateManager.getResource().getOnPlayButton())).getImage();
        Lobby = (new ImageIcon(gameStateManager.getResource().getLobbyButton())).getImage();
        onLobby = (new ImageIcon(gameStateManager.getResource().getOnLobbyButton())).getImage();
        Settings = (new ImageIcon(gameStateManager.getResource().getSettingsButton())).getImage();
        onSettings = (new ImageIcon(gameStateManager.getResource().getOnSettingsButton())).getImage();
        HowToPlay = (new ImageIcon(gameStateManager.getResource().getHowToPlayButton())).getImage();
        onHowToPlay = (new ImageIcon(gameStateManager.getResource().getOnHowToPlayButton())).getImage();
        Exit = (new ImageIcon(gameStateManager.getResource().getExitButton())).getImage();
        onExit = (new ImageIcon(gameStateManager.getResource().getOnExitButton())).getImage();

        Toolkit tk = gameStateManager.getF().getToolkit().getDefaultToolkit();
        xMiddleScreen = tk.getScreenSize().width / 2;
        yMiddleScreen = tk.getScreenSize().height / 2;

        wPlay = 240;
        hPlay = 120;
        xPlay = xMiddleScreen - wPlay - 50;
        yPlay = yMiddleScreen - hPlay / 2 - 100;

        wLobby = 240;
        hLobby = 120;
        xLobby = xMiddleScreen + 50;
        yLobby = yPlay;

        wSettings = 180;
        hSettings = 90;
        xSettings = xMiddleScreen - wSettings - 20;
        ySettings = yLobby + hLobby + 20;

        wHowToPlay = 180;
        hHowToPlay = 90;
        xHowToPlay = xMiddleScreen + 20;
        yHowToPlay = ySettings;

        wExit = 160;
        hExit = 80;
        xExit = xMiddleScreen - wExit / 2;
        yExit = yHowToPlay + hHowToPlay + 20;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bgMenu, 0, 0, getWidth(), getHeight(), null);
        if (gameStateManager.getMouseX() > xPlay && gameStateManager.getMouseX() < xPlay + wPlay && gameStateManager.getMouseY() > yPlay && gameStateManager.getMouseY() < yPlay + hPlay)
            g.drawImage(onPlay, xPlay, yPlay, wPlay, hPlay, null);
        else g.drawImage(Play, xPlay, yPlay, wPlay, hPlay, null);
        if (gameStateManager.getMouseX() > xLobby && gameStateManager.getMouseX() < xLobby + wLobby && gameStateManager.getMouseY() > yLobby && gameStateManager.getMouseY() < yLobby + hLobby)
            g.drawImage(onLobby, xLobby, yLobby, wLobby, hLobby, null);
        else g.drawImage(Lobby, xLobby, yLobby, wLobby, hLobby, null);
        if (gameStateManager.getMouseX() > xSettings && gameStateManager.getMouseX() < xSettings + wSettings && gameStateManager.getMouseY() > ySettings && gameStateManager.getMouseY() < ySettings + hSettings)
            g.drawImage(onSettings, xSettings, ySettings, wSettings, hSettings, null);
        else g.drawImage(Settings, xSettings, ySettings, wSettings, hSettings, null);
        if (gameStateManager.getMouseX() > xHowToPlay && gameStateManager.getMouseX() < xHowToPlay + wHowToPlay && gameStateManager.getMouseY() > yHowToPlay && gameStateManager.getMouseY() < yHowToPlay + hHowToPlay)
            g.drawImage(onHowToPlay, xHowToPlay, yHowToPlay, wHowToPlay, hHowToPlay, null);
        else g.drawImage(HowToPlay, xHowToPlay, yHowToPlay, wHowToPlay, hHowToPlay, null);
        if (gameStateManager.getMouseX() > xExit && gameStateManager.getMouseX() < xExit + wExit && gameStateManager.getMouseY() > yExit && gameStateManager.getMouseY() < yExit + hExit)
            g.drawImage(onExit, xExit, yExit, wExit, hExit, null);
        else g.drawImage(Exit, xExit, yExit, wExit, hExit, null);

        gameStateManager.drawCursor(g);

    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public void setGameStateManager(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public Image getBgMenu() {
        return bgMenu;
    }

    public void setBgMenu(Image bgMenu) {
        this.bgMenu = bgMenu;
    }

    public Image getPlay() {
        return Play;
    }

    public void setPlay(Image play) {
        Play = play;
    }

    public Image getOnPlay() {
        return onPlay;
    }

    public void setOnPlay(Image onPlay) {
        this.onPlay = onPlay;
    }

    public Image getSettings() {
        return Settings;
    }

    public void setSettings(Image settings) {
        Settings = settings;
    }

    public Image getOnSettings() {
        return onSettings;
    }

    public void setOnSettings(Image onSettings) {
        this.onSettings = onSettings;
    }

    public Image getHowToPlay() {
        return HowToPlay;
    }

    public void setHowToPlay(Image howToPlay) {
        HowToPlay = howToPlay;
    }

    public Image getOnHowToPlay() {
        return onHowToPlay;
    }

    public void setOnHowToPlay(Image onHowToPlay) {
        this.onHowToPlay = onHowToPlay;
    }

    public Image getExit() {
        return Exit;
    }

    public void setExit(Image exit) {
        Exit = exit;
    }

    public Image getOnExit() {
        return onExit;
    }

    public void setOnExit(Image onExit) {
        this.onExit = onExit;
    }

    public int getxMiddleScreen() {
        return xMiddleScreen;
    }

    public void setxMiddleScreen(int xMiddleScreen) {
        this.xMiddleScreen = xMiddleScreen;
    }

    public int getyMiddleScreen() {
        return yMiddleScreen;
    }

    public void setyMiddleScreen(int yMiddleScreen) {
        this.yMiddleScreen = yMiddleScreen;
    }

    public int getwPlay() {
        return wPlay;
    }

    public void setwPlay(int wPlay) {
        this.wPlay = wPlay;
    }

    public int gethPlay() {
        return hPlay;
    }

    public void sethPlay(int hPlay) {
        this.hPlay = hPlay;
    }

    public int getxPlay() {
        return xPlay;
    }

    public void setxPlay(int xPlay) {
        this.xPlay = xPlay;
    }

    public int getyPlay() {
        return yPlay;
    }

    public void setyPlay(int yPlay) {
        this.yPlay = yPlay;
    }

    public int getwSettings() {
        return wSettings;
    }

    public void setwSettings(int wSettings) {
        this.wSettings = wSettings;
    }

    public int gethSettings() {
        return hSettings;
    }

    public void sethSettings(int hSettings) {
        this.hSettings = hSettings;
    }

    public int getxSettings() {
        return xSettings;
    }

    public void setxSettings(int xSettings) {
        this.xSettings = xSettings;
    }

    public int getySettings() {
        return ySettings;
    }

    public void setySettings(int ySettings) {
        this.ySettings = ySettings;
    }

    public int getwHowToPlay() {
        return wHowToPlay;
    }

    public void setwHowToPlay(int wHowToPlay) {
        this.wHowToPlay = wHowToPlay;
    }

    public int gethHowToPlay() {
        return hHowToPlay;
    }

    public void sethHowToPlay(int hHowToPlay) {
        this.hHowToPlay = hHowToPlay;
    }

    public int getxHowToPlay() {
        return xHowToPlay;
    }

    public void setxHowToPlay(int xHowToPlay) {
        this.xHowToPlay = xHowToPlay;
    }

    public int getyHowToPlay() {
        return yHowToPlay;
    }

    public void setyHowToPlay(int yHowToPlay) {
        this.yHowToPlay = yHowToPlay;
    }

    public int getwExit() {
        return wExit;
    }

    public void setwExit(int wExit) {
        this.wExit = wExit;
    }

    public int gethExit() {
        return hExit;
    }

    public void sethExit(int hExit) {
        this.hExit = hExit;
    }

    public int getxExit() {
        return xExit;
    }

    public void setxExit(int xExit) {
        this.xExit = xExit;
    }

    public int getyExit() {
        return yExit;
    }

    public void setyExit(int yExit) {
        this.yExit = yExit;
    }

    public Image getLobby() {
        return Lobby;
    }

    public void setLobby(Image lobby) {
        Lobby = lobby;
    }

    public Image getOnLobby() {
        return onLobby;
    }

    public void setOnLobby(Image onLobby) {
        this.onLobby = onLobby;
    }

    public int getwLobby() {
        return wLobby;
    }

    public void setwLobby(int wLobby) {
        this.wLobby = wLobby;
    }

    public int gethLobby() {
        return hLobby;
    }

    public void sethLobby(int hLobby) {
        this.hLobby = hLobby;
    }

    public int getxLobby() {
        return xLobby;
    }

    public void setxLobby(int xLobby) {
        this.xLobby = xLobby;
    }

    public int getyLobby() {
        return yLobby;
    }

    public void setyLobby(int yLobby) {
        this.yLobby = yLobby;
    }
}
