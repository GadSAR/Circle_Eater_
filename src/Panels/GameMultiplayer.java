package Panels;
import Manage.*;

import javax.swing.*;
import java.awt.*;

public class GameMultiplayer extends JPanel {

    private GameStateManager gameStateManager;

    private Image bgMenu, Play, onPlay, Settings, onSettings, HowToPlay, onHowToPlay;
    private int xMiddleScreen, yMiddleScreen,
            wPlay, hPlay, xPlay, yPlay,
            wSettings, hSettings, xSettings, ySettings,
            wHowToPlay, hHowToPlay, xHowToPlay, yHowToPlay;


    public GameMultiplayer(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;

        bgMenu = (new ImageIcon(gameStateManager.getResource().getGameMenuBackgroundImg())).getImage();
        Play = (new ImageIcon(gameStateManager.getResource().getPlayButton())).getImage();
        onPlay = (new ImageIcon(gameStateManager.getResource().getOnPlayButton())).getImage();
        Settings = (new ImageIcon(gameStateManager.getResource().getSettingsButton())).getImage();
        onSettings = (new ImageIcon(gameStateManager.getResource().getOnSettingsButton())).getImage();
        HowToPlay = (new ImageIcon(gameStateManager.getResource().getHowToPlayButton())).getImage();
        onHowToPlay = (new ImageIcon(gameStateManager.getResource().getOnHowToPlayButton())).getImage();

        Toolkit tk = gameStateManager.getF().getToolkit().getDefaultToolkit();
        xMiddleScreen = tk.getScreenSize().width / 2;
        yMiddleScreen = tk.getScreenSize().height / 2;

        wPlay = 80;
        hPlay = 30;
        xPlay = xMiddleScreen - wPlay / 2;
        yPlay = yMiddleScreen - hPlay / 2 - 100;

        wSettings = 80;
        hSettings = 30;
        xSettings = xMiddleScreen - wSettings / 2;
        ySettings = yPlay + hPlay + 20;

        wHowToPlay = 80;
        hHowToPlay = 30;
        xHowToPlay = xMiddleScreen - wHowToPlay / 2;
        yHowToPlay = ySettings + hSettings + 20;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bgMenu, 0, 0, getWidth(), getHeight(), null);
        if (gameStateManager.getMouseX() > xPlay && gameStateManager.getMouseX() < xPlay + wPlay && gameStateManager.getMouseY() > yPlay && gameStateManager.getMouseY() < yPlay + hPlay)
            g.drawImage(onPlay, xPlay, yPlay, wPlay, hPlay, null);
        else g.drawImage(Play, xPlay, yPlay, wPlay, hPlay, null);
        if (gameStateManager.getMouseX() > xSettings && gameStateManager.getMouseX() < xSettings + wSettings && gameStateManager.getMouseY() > ySettings && gameStateManager.getMouseY() < ySettings + hSettings)
            g.drawImage(onSettings, xSettings, ySettings, wSettings, hSettings, null);
        else g.drawImage(Settings, xSettings, ySettings, wSettings, hSettings, null);
        if (gameStateManager.getMouseX() > xHowToPlay && gameStateManager.getMouseX() < xHowToPlay + wHowToPlay && gameStateManager.getMouseY() > yHowToPlay && gameStateManager.getMouseY() < yHowToPlay + hHowToPlay)
            g.drawImage(onHowToPlay, xHowToPlay, yHowToPlay, wHowToPlay, hHowToPlay, null);
        else g.drawImage(HowToPlay, xHowToPlay, yHowToPlay, wHowToPlay, hHowToPlay, null);

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

}
