package Panels;

import Manage.*;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {

    private GameStateManager gameStateManager;

    private Image bgOver, Replay, onReplay, Menu, onMenu, gameOverWon, gameOverLose;
    private int wReplay, hReplay, xReplay, yReplay,
            wMenu, hMenu, xMenu, yMenu,
            wGameOver, hGameOver, xGameOver, yGameOver;


    public GameOver(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;

        bgOver = (new ImageIcon(gameStateManager.getResource().getGameOverBackgroundImg())).getImage();
        Replay = (new ImageIcon(gameStateManager.getResource().getReplayButton())).getImage();
        onReplay = (new ImageIcon(gameStateManager.getResource().getOnReplayButton())).getImage();
        Menu = (new ImageIcon(gameStateManager.getResource().getMenuButton())).getImage();
        onMenu = (new ImageIcon(gameStateManager.getResource().getOnMenuButton())).getImage();
        gameOverWon = (new ImageIcon(gameStateManager.getResource().getGameOverWon())).getImage();
        gameOverLose = (new ImageIcon(gameStateManager.getResource().getGameOverLost())).getImage();

        gameStateManager.getF().getToolkit();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xMiddleScreen = tk.getScreenSize().width / 2;
        int yMiddleScreen = tk.getScreenSize().height / 2;

        wGameOver = 380;
        hGameOver = 190;
        xGameOver = xMiddleScreen - wGameOver / 2;
        yGameOver = yMiddleScreen - hGameOver / 2 - 150;

        wReplay = 180;
        hReplay = 90;
        xReplay = xMiddleScreen - wReplay / 2;
        yReplay = yMiddleScreen - hReplay / 2;

        wMenu = 140;
        hMenu = 70;
        xMenu = xMiddleScreen - wMenu / 2;
        yMenu = yReplay + hMenu + 35;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bgOver, 0, 0, getWidth(), getHeight(), null);
        if (gameStateManager.getPlayerType() == gameStateManager.getLastPlayerWon()) {
            g.drawImage(gameOverWon, xGameOver, yGameOver, wGameOver, hGameOver, null);
        } else
            g.drawImage(gameOverLose, xGameOver, yGameOver, wGameOver, hGameOver, null);
        if (gameStateManager.mouseIn(xReplay, wReplay, yReplay, hReplay)) {
            g.drawImage(onReplay, xReplay, yReplay, wReplay, hReplay, null);
        } else g.drawImage(Replay, xReplay, yReplay, wReplay, hReplay, null);
        if (gameStateManager.mouseIn(xMenu, wMenu, yMenu, hMenu)) {
            g.drawImage(onMenu, xMenu, yMenu, wMenu, hMenu, null);
        } else g.drawImage(Menu, xMenu, yMenu, wMenu, hMenu, null);

        gameStateManager.drawCursor(g);

    }

    public int getwReplay() {
        return wReplay;
    }

    public int gethReplay() {
        return hReplay;
    }

    public int getxReplay() {
        return xReplay;
    }

    public int getyReplay() {
        return yReplay;
    }

    public int getwMenu() {
        return wMenu;
    }

    public int gethMenu() {
        return hMenu;
    }

    public int getxMenu() {
        return xMenu;
    }

    public int getyMenu() {
        return yMenu;
    }

}
