package Panels;

import Manage.*;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {

    private GameStateManager gameStateManager;

    private Image bgOver, Replay, onReplay, Menu, onMenu, gameOverWon, gameOverLose;
    private int xMiddleScreen, yMiddleScreen,
            wReplay, hReplay, xReplay, yReplay,
            wMenu, hMenu, xMenu, yMenu,
            wGameOver, hGameOver, xGameOver, yGameOver;


    public GameOver(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;

        bgOver = (new ImageIcon(gameStateManager.getResource().getGameMenuBackgroundImg())).getImage();
        Replay = (new ImageIcon(gameStateManager.getResource().getReplayButton())).getImage();
        onReplay = (new ImageIcon(gameStateManager.getResource().getOnReplayButton())).getImage();
        Menu = (new ImageIcon(gameStateManager.getResource().getMenuButton())).getImage();
        onMenu = (new ImageIcon(gameStateManager.getResource().getOnMenuButton())).getImage();
        gameOverWon = (new ImageIcon(gameStateManager.getResource().getGameOverWon())).getImage();
        gameOverLose = (new ImageIcon(gameStateManager.getResource().getGameOverLost())).getImage();

        gameStateManager.getF().getToolkit();
        Toolkit tk = Toolkit.getDefaultToolkit();
        xMiddleScreen = tk.getScreenSize().width / 2;
        yMiddleScreen = tk.getScreenSize().height / 2;

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
        if (gameStateManager.getPlayerType() == gameStateManager.getLastPlayerWon())
            g.drawImage(gameOverWon, xGameOver, yGameOver, wGameOver, hGameOver, null);
        else
            g.drawImage(gameOverLose, xGameOver, yGameOver, wGameOver, hGameOver, null);
        if (gameStateManager.getMouseX() > xReplay && gameStateManager.getMouseX() < xReplay + wReplay && gameStateManager.getMouseY() > yReplay && gameStateManager.getMouseY() < yReplay + hReplay)
            g.drawImage(onReplay, xReplay, yReplay, wReplay, hReplay, null);
        else g.drawImage(Replay, xReplay, yReplay, wReplay, hReplay, null);
        if (gameStateManager.getMouseX() > xMenu && gameStateManager.getMouseX() < xMenu + wMenu && gameStateManager.getMouseY() > yMenu && gameStateManager.getMouseY() < yMenu + hMenu)
            g.drawImage(onMenu, xMenu, yMenu, wMenu, hMenu, null);
        else g.drawImage(Menu, xMenu, yMenu, wMenu, hMenu, null);

        gameStateManager.drawCursor(g);

    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public void setGameStateManager(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public Image getBgOver() {
        return bgOver;
    }

    public void setBgOver(Image bgOver) {
        this.bgOver = bgOver;
    }

    public Image getReplay() {
        return Replay;
    }

    public void setReplay(Image replay) {
        Replay = replay;
    }

    public Image getOnReplay() {
        return onReplay;
    }

    public void setOnReplay(Image onReplay) {
        this.onReplay = onReplay;
    }

    public Image getMenu() {
        return Menu;
    }

    public void setMenu(Image menu) {
        Menu = menu;
    }

    public Image getOnMenu() {
        return onMenu;
    }

    public void setOnMenu(Image onMenu) {
        this.onMenu = onMenu;
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

    public int getwReplay() {
        return wReplay;
    }

    public void setwReplay(int wReplay) {
        this.wReplay = wReplay;
    }

    public int gethReplay() {
        return hReplay;
    }

    public void sethReplay(int hReplay) {
        this.hReplay = hReplay;
    }

    public int getxReplay() {
        return xReplay;
    }

    public void setxReplay(int xReplay) {
        this.xReplay = xReplay;
    }

    public int getyReplay() {
        return yReplay;
    }

    public void setyReplay(int yReplay) {
        this.yReplay = yReplay;
    }

    public int getwMenu() {
        return wMenu;
    }

    public void setwMenu(int wMenu) {
        this.wMenu = wMenu;
    }

    public int gethMenu() {
        return hMenu;
    }

    public void sethMenu(int hMenu) {
        this.hMenu = hMenu;
    }

    public int getxMenu() {
        return xMenu;
    }

    public void setxMenu(int xMenu) {
        this.xMenu = xMenu;
    }

    public int getyMenu() {
        return yMenu;
    }

    public void setyMenu(int yMenu) {
        this.yMenu = yMenu;
    }

}
