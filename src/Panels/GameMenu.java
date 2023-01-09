package Panels;

import Manage.*;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends JPanel {

    private GameStateManager gameStateManager;

    private Image bgMenu, Play, onPlay, Lobby, onLobby, Settings, onSettings, HowToPlay, onHowToPlay, Exit, onExit;
    private int wPlay, hPlay, xPlay, yPlay,
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

        gameStateManager.getF().getToolkit();
        Toolkit tk = Toolkit.getDefaultToolkit();

        int xMiddleScreen = tk.getScreenSize().width / 2;
        int yMiddleScreen = tk.getScreenSize().height / 2;

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
        if (gameStateManager.mouseIn(xPlay, wPlay, yPlay, hPlay)) {
            g.drawImage(onPlay, xPlay, yPlay, wPlay, hPlay, null);
        } else g.drawImage(Play, xPlay, yPlay, wPlay, hPlay, null);
        if (gameStateManager.mouseIn(xLobby, wLobby, yLobby, hLobby)) {
            g.drawImage(onLobby, xLobby, yLobby, wLobby, hLobby, null);
        } else g.drawImage(Lobby, xLobby, yLobby, wLobby, hLobby, null);
        if (gameStateManager.mouseIn(xSettings, wSettings, ySettings, hSettings)) {
            g.drawImage(onSettings, xSettings, ySettings, wSettings, hSettings, null);
        } else g.drawImage(Settings, xSettings, ySettings, wSettings, hSettings, null);
        if (gameStateManager.mouseIn(xHowToPlay, wHowToPlay, yHowToPlay, hHowToPlay)) {
            g.drawImage(onHowToPlay, xHowToPlay, yHowToPlay, wHowToPlay, hHowToPlay, null);
        } else g.drawImage(HowToPlay, xHowToPlay, yHowToPlay, wHowToPlay, hHowToPlay, null);
        if (gameStateManager.mouseIn(xExit, wExit, yExit, hExit)) {
            g.drawImage(onExit, xExit, yExit, wExit, hExit, null);
        } else g.drawImage(Exit, xExit, yExit, wExit, hExit, null);

        gameStateManager.drawCursor(g);

    }

    public int getwPlay() {
        return wPlay;
    }

    public int gethPlay() {
        return hPlay;
    }

    public int getxPlay() {
        return xPlay;
    }

    public int getyPlay() {
        return yPlay;
    }

    public int getwSettings() {
        return wSettings;
    }

    public int gethSettings() {
        return hSettings;
    }

    public int getxSettings() {
        return xSettings;
    }

    public int getySettings() {
        return ySettings;
    }

    public int getwHowToPlay() {
        return wHowToPlay;
    }

    public int gethHowToPlay() {
        return hHowToPlay;
    }

    public int getxHowToPlay() {
        return xHowToPlay;
    }

    public int getyHowToPlay() {
        return yHowToPlay;
    }

    public int getwExit() {
        return wExit;
    }

    public int gethExit() {
        return hExit;
    }

    public int getxExit() {
        return xExit;
    }

    public int getyExit() {
        return yExit;
    }

    public int getwLobby() {
        return wLobby;
    }

    public int gethLobby() {
        return hLobby;
    }

    public int getxLobby() {
        return xLobby;
    }

    public int getyLobby() {
        return yLobby;
    }

}
