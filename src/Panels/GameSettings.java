package Panels;

import Manage.*;

import javax.swing.*;
import java.awt.*;

public class GameSettings extends JPanel {

    private GameStateManager gameStateManager;

    private Image bgSettings, restoreSettings, Plus, Minus, save, onSave;
    private int xMiddleScreen, yMiddleScreen,
            wRestore, hRestore, xRestore, yRestore,
            wText, hText, xText, yText1, yText2, yText3, yText4,
            wPlusMinus, hPlusMinus, xPlus, xMinus,
            wBack, hBack, xBack, yBack;
    private JTextField Speed, Mode, BallsQuantity, PlayersSize;


    public GameSettings(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;

        bgSettings = (new ImageIcon(gameStateManager.getResource().getGameMenuBackgroundImg())).getImage();
        restoreSettings = (new ImageIcon(gameStateManager.getResource().getCreatButton())).getImage();
        Plus = (new ImageIcon(gameStateManager.getResource().getPlusButton())).getImage();
        Minus = (new ImageIcon(gameStateManager.getResource().getMinusButton())).getImage();
        save = (new ImageIcon(gameStateManager.getResource().getBackButton())).getImage();
        onSave = (new ImageIcon(gameStateManager.getResource().getOnBackButton())).getImage();

        gameStateManager.getF().getToolkit();
        Toolkit tk = Toolkit.getDefaultToolkit();
        xMiddleScreen = tk.getScreenSize().width / 2;
        yMiddleScreen = tk.getScreenSize().height / 2;

        wRestore = 80;
        hRestore = 40;
        xRestore = xMiddleScreen - wRestore / 2;;
        yRestore = yMiddleScreen - hRestore / 2 - 180;

        wText = 120;
        hText = 40;
        xText =  xMiddleScreen - wText / 2;
        yText1 = yRestore + hRestore + 30;
        yText2 = yText1 + hText + 25;
        yText3 = yText2 + hText + 25;
        yText4 = yText3 + hText + 25;

        wBack = 160;
        hBack = 80;
        xBack = xMiddleScreen - wBack / 2;
        yBack = yText4 + hText + 30;

        wPlusMinus = 40;
        hPlusMinus = 40;
        xPlus = xBack + wBack + 20;
        xMinus = xBack - wPlusMinus - 20;


        Font font = new Font("Arial", Font.BOLD, 25);
        Speed = new JTextField(String.valueOf(gameStateManager.getSpeedLevel()));
        Mode = new JTextField(String.valueOf(gameStateManager.getMode()));
        BallsQuantity = new JTextField(String.valueOf(gameStateManager.getVecSize()));
        PlayersSize = new JTextField(String.valueOf(gameStateManager.getWidthStart()));
        setLayout(null);
        Speed.setFont(font);
        Speed.setBounds(xText, yText1, wText, hText);
        Speed.setHorizontalAlignment(JTextField.CENTER);
        Speed.setEditable(false);
        add(Speed);
        Mode.setFont(font);
        Mode.setBounds(xText, yText2, wText, hText);
        Mode.setHorizontalAlignment(JTextField.CENTER);
        Mode.setEditable(false);
        add(Mode);
        BallsQuantity.setFont(font);
        BallsQuantity.setBounds(xText, yText3, wText, hText);
        BallsQuantity.setHorizontalAlignment(JTextField.CENTER);
        BallsQuantity.setEditable(false);
        add(BallsQuantity);
        PlayersSize.setFont(font);
        PlayersSize.setBounds(xText, yText4, wText, hText);
        PlayersSize.setHorizontalAlignment(JTextField.CENTER);
        PlayersSize.setEditable(false);
        add(PlayersSize);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bgSettings, 0, 0, getWidth(), getHeight(), null);

        g.drawImage(restoreSettings, xRestore, yRestore, wRestore, hRestore, null);
        g.drawImage(Plus, xPlus, yText1, wPlusMinus, hPlusMinus, null);
        g.drawImage(Plus, xPlus, yText2, wPlusMinus, hPlusMinus, null);
        g.drawImage(Plus, xPlus, yText3, wPlusMinus, hPlusMinus, null);
        g.drawImage(Plus, xPlus, yText4, wPlusMinus, hPlusMinus, null);
        g.drawImage(Minus, xMinus, yText1, wPlusMinus, hPlusMinus, null);
        g.drawImage(Minus, xMinus, yText2, wPlusMinus, hPlusMinus, null);
        g.drawImage(Minus, xMinus, yText3, wPlusMinus, hPlusMinus, null);
        g.drawImage(Minus, xMinus, yText4, wPlusMinus, hPlusMinus, null);

        if (gameStateManager.getMouseX() > xBack && gameStateManager.getMouseX() < xBack + wBack && gameStateManager.getMouseY() > yBack && gameStateManager.getMouseY() < yBack + hBack) {
            g.drawImage(onSave, xBack, yBack, wBack, hBack, null);
        } else g.drawImage(save, xBack, yBack, wBack, hBack, null);

        gameStateManager.drawCursor(g);

    }

    public void restoreDefaultSettings() {
        gameStateManager.restoreSettings();
        Speed.setText(String.valueOf(gameStateManager.getSpeedLevel()));
        Mode.setText(String.valueOf(gameStateManager.getMode()));
        BallsQuantity.setText(String.valueOf(gameStateManager.getVecSize()));
        PlayersSize.setText(String.valueOf(gameStateManager.getWidthStart()));
    }

    public void increaseSpeed() {
        int temp = gameStateManager.getSpeedLevel();
        if (temp < 5) {
            gameStateManager.setSpeedLevel(temp + 1);
            Speed.setText(String.valueOf(gameStateManager.getSpeedLevel()));
        }
    }

    public void increaseMode() {
        int temp = gameStateManager.getMode();
        if (temp < 2) {
            gameStateManager.setMode(temp + 1);
            Mode.setText(String.valueOf(gameStateManager.getMode()));
        }
    }

    public void increaseVecSize() {
        int temp = gameStateManager.getVecSize();
        if (temp < 100) {
            gameStateManager.setVecSize(temp + 1);
            BallsQuantity.setText(String.valueOf(gameStateManager.getVecSize()));
        }
    }

    public void increaseWidthStart() {
        int temp = gameStateManager.getWidthStart();
        if (temp < 100) {
            gameStateManager.setWidthStart(temp + 1);
            PlayersSize.setText(String.valueOf(gameStateManager.getWidthStart()));
        }
    }

    public void decreaseSpeed() {
        int temp = gameStateManager.getSpeedLevel();
        if (temp > 1) {
            gameStateManager.setSpeedLevel(temp - 1);
            Speed.setText(String.valueOf(gameStateManager.getSpeedLevel()));
        }
    }

    public void decreaseMode() {
        int temp = gameStateManager.getMode();
        if (temp > 0) {
            gameStateManager.setMode(temp - 1);
            Mode.setText(String.valueOf(gameStateManager.getMode()));
        }
    }

    public void decreaseVecSize() {
        int temp = gameStateManager.getVecSize();
        if (temp > 1) {
            gameStateManager.setVecSize(temp - 1);
            BallsQuantity.setText(String.valueOf(gameStateManager.getVecSize()));
        }
    }

    public void decreaseWidthStart() {
        int temp = gameStateManager.getWidthStart();
        if (temp > 0) {
            gameStateManager.setWidthStart(temp - 1);
            PlayersSize.setText(String.valueOf(gameStateManager.getWidthStart()));
        }
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

    public int getyText1() {
        return yText1;
    }

    public void setyText1(int yText1) {
        this.yText1 = yText1;
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

    public Image getMinus() {
        return Minus;
    }

    public void setMinus(Image minus) {
        Minus = minus;
    }

    public Image getSave() {
        return save;
    }

    public void setSave(Image save) {
        this.save = save;
    }

    public Image getOnSave() {
        return onSave;
    }

    public void setOnSave(Image onSave) {
        this.onSave = onSave;
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

    public int getwPlusMinus() {
        return wPlusMinus;
    }

    public void setwPlusMinus(int wPlusMinus) {
        this.wPlusMinus = wPlusMinus;
    }

    public int gethPlusMinus() {
        return hPlusMinus;
    }

    public void sethPlusMinus(int hPlusMinus) {
        this.hPlusMinus = hPlusMinus;
    }

    public int getxPlus() {
        return xPlus;
    }

    public void setxPlus(int xPlus) {
        this.xPlus = xPlus;
    }

    public int getwBack() {
        return wBack;
    }

    public void setwBack(int wBack) {
        this.wBack = wBack;
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

    public int getyText2() {
        return yText2;
    }

    public void setyText2(int yText2) {
        this.yText2 = yText2;
    }

    public int getyText3() {
        return yText3;
    }

    public void setyText3(int yText3) {
        this.yText3 = yText3;
    }

    public int getyText4() {
        return yText4;
    }

    public void setyText4(int yText4) {
        this.yText4 = yText4;
    }

    public int getxMinus() {
        return xMinus;
    }

    public void setxMinus(int xMinus) {
        this.xMinus = xMinus;
    }

    public JTextField getSpeed() {
        return Speed;
    }

    public void setSpeed(JTextField speed) {
        Speed = speed;
    }

    public JTextField getMode() {
        return Mode;
    }

    public void setMode(JTextField mode) {
        Mode = mode;
    }

    public JTextField getBallsQuantity() {
        return BallsQuantity;
    }

    public void setBallsQuantity(JTextField ballsQuantity) {
        BallsQuantity = ballsQuantity;
    }

    public JTextField getPlayersSize() {
        return PlayersSize;
    }

    public void setPlayersSize(JTextField playersSize) {
        PlayersSize = playersSize;
    }

    public Image getRestoreSettings() {
        return restoreSettings;
    }

    public void setRestoreSettings(Image restoreSettings) {
        this.restoreSettings = restoreSettings;
    }

    public int getwRestore() {
        return wRestore;
    }

    public void setwRestore(int wRestore) {
        this.wRestore = wRestore;
    }

    public int gethRestore() {
        return hRestore;
    }

    public void sethRestore(int hRestore) {
        this.hRestore = hRestore;
    }

    public int getxRestore() {
        return xRestore;
    }

    public void setxRestore(int xRestore) {
        this.xRestore = xRestore;
    }

    public int getyRestore() {
        return yRestore;
    }

    public void setyRestore(int yRestore) {
        this.yRestore = yRestore;
    }

}
