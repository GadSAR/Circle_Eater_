package Panels;
import Manage.*;
import Multiplayer.*;
import Music.*;
import Panels.*;
import Objects.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends JPanel {

    private GameStateManager gameStateManager;

    private Image bgMenu, Play, onPlay, HowToPlay, onHowToPlay, Exit, onExit;
    private int xMiddleScreen, yMiddleScreen,
            wPlay, hPlay, xPlay, yPlay,
            wHowToPlay, hHowToPlay, xHowToPlay, yHowToPlay,
            wExit, hExit, xExit, yExit;


    public GameMenu(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        bgMenu = (new ImageIcon(gameStateManager.getResource().getMenuBackgroundImg())).getImage();
        Play = (new ImageIcon(gameStateManager.getResource().getPlayImg())).getImage();

        xMiddleScreen = gameStateManager.getF().getWidth() / 2;
        yMiddleScreen = gameStateManager.getF().getHeight() / 2;

        wPlay = 80;
        hPlay = 30;
        xPlay = xMiddleScreen - wPlay / 2;
        yPlay = yMiddleScreen - hPlay / 2;

        wHowToPlay = 80;
        hHowToPlay = 30;
        xHowToPlay = xMiddleScreen - wHowToPlay / 2;
        yHowToPlay = yMiddleScreen - hHowToPlay / 2;

        wExit = 80;
        hExit = 30;
        xExit = xMiddleScreen - wExit / 2;
        yExit = yMiddleScreen - hExit / 2;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bgMenu, 0, 0, getWidth(), getHeight(), null);
        if(gameStateManager.getMouseX() > xPlay && gameStateManager.getMouseX() < xPlay + wPlay && gameStateManager.getMouseY() > yPlay && gameStateManager.getMouseY() < yPlay + hPlay)
            g.drawImage(onPlay, xPlay, yPlay, wPlay, hPlay, null);
        else g.drawImage(Play, xPlay, yPlay, wPlay, hPlay, null);
        if(gameStateManager.getMouseX() > xHowToPlay && gameStateManager.getMouseX() < xHowToPlay + wHowToPlay && gameStateManager.getMouseY() > yHowToPlay && gameStateManager.getMouseY() < yHowToPlay + hHowToPlay)
            g.drawImage(onHowToPlay, xHowToPlay, yHowToPlay, wHowToPlay, hHowToPlay, null);
        else g.drawImage(HowToPlay, xHowToPlay, yHowToPlay, wHowToPlay, hHowToPlay, null);
        if(gameStateManager.getMouseX() > xExit && gameStateManager.getMouseX() < xExit + wExit && gameStateManager.getMouseY() > yExit && gameStateManager.getMouseY() < yExit + hExit)
            g.drawImage(onExit, xExit, yExit, wExit, hExit, null);
        else g.drawImage(Exit, xExit, yExit, wExit, hExit, null);

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
}
