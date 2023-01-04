package Panels;

import Manage.*;

import javax.swing.*;
import java.awt.*;

public class GameSettings extends JPanel {

    private GameStateManager gameStateManager;

    private Image bgSettings, Plus, onPlus, Minus, onMinus, Empty, onEmpty;
    private int xMiddleScreen, yMiddleScreen,
            wCreate, hCreate, xCreate, yCreate,
            wText, hText, xText, yText,
            wJoin, hJoin, xJoin, yJoin,
            WBack, hBack, xBack, yBack;


    public GameSettings(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;

        bgSettings = (new ImageIcon(gameStateManager.getResource().getGameMenuBackgroundImg())).getImage();
        Plus = (new ImageIcon(gameStateManager.getResource().getCreatButton())).getImage();
        onPlus = (new ImageIcon(gameStateManager.getResource().getOnCreatButton())).getImage();
        Minus = (new ImageIcon(gameStateManager.getResource().getJoinButton())).getImage();
        onMinus = (new ImageIcon(gameStateManager.getResource().getOnJoinButton())).getImage();
        Empty = (new ImageIcon(gameStateManager.getResource().getBackButton())).getImage();
        onEmpty = (new ImageIcon(gameStateManager.getResource().getOnBackButton())).getImage();

        gameStateManager.getF().getToolkit();
        Toolkit tk = Toolkit.getDefaultToolkit();
        xMiddleScreen = tk.getScreenSize().width / 2;
        yMiddleScreen = tk.getScreenSize().height / 2;

        wCreate = 240;
        hCreate = 120;
        xCreate = xMiddleScreen - wCreate / 2;
        yCreate = yMiddleScreen - hCreate / 2 - 100;

        wJoin = 180;
        hJoin = 90;
        xJoin = xMiddleScreen + 20;
        yJoin = yCreate + hCreate + 20;

        wText = 200;
        hText = hJoin - 50;
        xText = xJoin - 220;
        yText = yJoin + 25;

        WBack = 160;
        hBack = 80;
        xBack = xMiddleScreen - WBack / 2;
        yBack = yJoin + hJoin + 20;

        Font font = new Font("Arial", Font.BOLD, 15);
        setLayout(null);
        //joinIpAdress.setOpaque(true);
        //joinIpAdress.setForeground(Color.black);
        /*joinIpAdress.setFont(font);
        joinIpAdress.setBounds(xText, yText, wText, hText);
        add(joinIpAdress);

        MyIpAddress.setFont(font);
        MyIpAddress.setBounds(0, 0, 130, 25);
        MyIpAddress.setEditable(false);
        add(MyIpAddress);*/

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bgSettings, 0, 0, getWidth(), getHeight(), null);

        if (gameStateManager.getMouseX() > xCreate && gameStateManager.getMouseX() < xCreate + wCreate && gameStateManager.getMouseY() > yCreate && gameStateManager.getMouseY() < yCreate + hCreate)
            g.drawImage(onPlus, xCreate, yCreate, wCreate, hCreate, null);
        else g.drawImage(Plus, xCreate, yCreate, wCreate, hCreate, null);

        if (gameStateManager.getMouseX() > xJoin && gameStateManager.getMouseX() < xJoin + wJoin && gameStateManager.getMouseY() > yJoin && gameStateManager.getMouseY() < yJoin + hJoin)
            g.drawImage(onMinus, xJoin, yJoin, wJoin, hJoin, null);
        else g.drawImage(Minus, xJoin, yJoin, wJoin, hJoin, null);

        if (gameStateManager.getMouseX() > xBack && gameStateManager.getMouseX() < xBack + WBack && gameStateManager.getMouseY() > yBack && gameStateManager.getMouseY() < yBack + hBack)
            g.drawImage(onEmpty, xBack, yBack, WBack, hBack, null);
        else g.drawImage(Empty, xBack, yBack, WBack, hBack, null);

        gameStateManager.drawCursor(g);

    }


    public int getwText() {
        return wText;
    }

    public void setwText(int wText) {
        this.wText = wText;
    }

    public int gethText() {
        return hText;
    }

    public void sethText(int hText) {
        this.hText = hText;
    }

    public int getxText() {
        return xText;
    }

    public void setxText(int xText) {
        this.xText = xText;
    }

    public int getyText() {
        return yText;
    }

    public void setyText(int yText) {
        this.yText = yText;
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public void setGameStateManager(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public Image getBgSettings() {
        return bgSettings;
    }

    public void setBgSettings(Image bgSettings) {
        this.bgSettings = bgSettings;
    }

    public Image getPlus() {
        return Plus;
    }

    public void setPlus(Image plus) {
        Plus = plus;
    }

    public Image getOnPlus() {
        return onPlus;
    }

    public void setOnPlus(Image onPlus) {
        this.onPlus = onPlus;
    }

    public Image getMinus() {
        return Minus;
    }

    public void setMinus(Image minus) {
        Minus = minus;
    }

    public Image getOnMinus() {
        return onMinus;
    }

    public void setOnMinus(Image onMinus) {
        this.onMinus = onMinus;
    }

    public Image getEmpty() {
        return Empty;
    }

    public void setEmpty(Image empty) {
        Empty = empty;
    }

    public Image getOnEmpty() {
        return onEmpty;
    }

    public void setOnEmpty(Image onEmpty) {
        this.onEmpty = onEmpty;
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

    public int getwCreate() {
        return wCreate;
    }

    public void setwCreate(int wCreate) {
        this.wCreate = wCreate;
    }

    public int gethCreate() {
        return hCreate;
    }

    public void sethCreate(int hCreate) {
        this.hCreate = hCreate;
    }

    public int getxCreate() {
        return xCreate;
    }

    public void setxCreate(int xCreate) {
        this.xCreate = xCreate;
    }

    public int getyCreate() {
        return yCreate;
    }

    public void setyCreate(int yCreate) {
        this.yCreate = yCreate;
    }

    public int getwJoin() {
        return wJoin;
    }

    public void setwJoin(int wJoin) {
        this.wJoin = wJoin;
    }

    public int gethJoin() {
        return hJoin;
    }

    public void sethJoin(int hJoin) {
        this.hJoin = hJoin;
    }

    public int getxJoin() {
        return xJoin;
    }

    public void setxJoin(int xJoin) {
        this.xJoin = xJoin;
    }

    public int getyJoin() {
        return yJoin;
    }

    public void setyJoin(int yJoin) {
        this.yJoin = yJoin;
    }

    public int getWBack() {
        return WBack;
    }

    public void setWBack(int WBack) {
        this.WBack = WBack;
    }

    public int gethBack() {
        return hBack;
    }

    public void sethBack(int hBack) {
        this.hBack = hBack;
    }

    public int getxBack() {
        return xBack;
    }

    public void setxBack(int xBack) {
        this.xBack = xBack;
    }

    public int getyBack() {
        return yBack;
    }

    public void setyBack(int yBack) {
        this.yBack = yBack;
    }

}
