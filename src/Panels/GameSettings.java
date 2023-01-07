package Panels;

import Manage.*;

import javax.swing.*;
import java.awt.*;

public class GameSettings extends JPanel {

    private GameStateManager gameStateManager;

    private Image bgSettings, restoreSettings, Plus, Minus, save, onSave;
    private int wRestore, hRestore, xRestore, yRestore,
            yText1, yText2, yText3, yText4,
            wPlusMinus, hPlusMinus, xPlus, xMinus,
            wBack, hBack, xBack, yBack;
    private JTextField Speed, Mode, BallsQuantity, PlayersSize;


    public GameSettings(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;

        bgSettings = (new ImageIcon(gameStateManager.getResource().getGameSettingsBackgroundImg())).getImage();
        restoreSettings = (new ImageIcon(gameStateManager.getResource().getCreatButton())).getImage();
        Plus = (new ImageIcon(gameStateManager.getResource().getPlusButton())).getImage();
        Minus = (new ImageIcon(gameStateManager.getResource().getMinusButton())).getImage();
        save = (new ImageIcon(gameStateManager.getResource().getBackButton())).getImage();
        onSave = (new ImageIcon(gameStateManager.getResource().getOnBackButton())).getImage();

        gameStateManager.getF().getToolkit();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xMiddleScreen = tk.getScreenSize().width / 2;
        int yMiddleScreen = tk.getScreenSize().height / 2;

        wRestore = 80;
        hRestore = 40;
        xRestore = xMiddleScreen - wRestore / 2;;
        yRestore = yMiddleScreen - hRestore / 2 - 180;

        int wText = 120;
        int hText = 40;
        int xText =  xMiddleScreen - wText / 2;
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

    public int getyText1() {
        return yText1;
    }

    public int getwPlusMinus() {
        return wPlusMinus;
    }

    public int gethPlusMinus() {
        return hPlusMinus;
    }

    public int getxPlus() {
        return xPlus;
    }

    public int getwBack() {
        return wBack;
    }

    public int gethBack() {
        return hBack;
    }

    public int getxBack() {
        return xBack;
    }

    public int getyBack() {
        return yBack;
    }

    public int getyText2() {
        return yText2;
    }

    public int getyText3() {
        return yText3;
    }

    public int getyText4() {
        return yText4;
    }

    public int getxMinus() {
        return xMinus;
    }

    public int getwRestore() {
        return wRestore;
    }

    public int gethRestore() {
        return hRestore;
    }

    public int getxRestore() {
        return xRestore;
    }

    public int getyRestore() {
        return yRestore;
    }

}
