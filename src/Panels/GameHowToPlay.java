package Panels;

import Manage.*;

import javax.swing.*;
import java.awt.*;

public class GameHowToPlay extends JPanel {

    GameStateManager gameStateManager;
    private Image img, back, onBack;
    private int wBack, hBack, xBack, yBack;

    public GameHowToPlay(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        this.img = (new ImageIcon(gameStateManager.getResource().getGameHowToPlayBackgroundImg())).getImage();
        this.back = (new ImageIcon(gameStateManager.getResource().getBackButton())).getImage();
        this.onBack = (new ImageIcon(gameStateManager.getResource().getOnBackButton())).getImage();

        gameStateManager.getF().getToolkit();
        Toolkit tk = Toolkit.getDefaultToolkit();

        wBack = 90;
        hBack = 45;
        xBack = 10;
        yBack = tk.getScreenSize().height - hBack - 10;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);

        if (gameStateManager.mouseIn(xBack, wBack, yBack, hBack))
            g.drawImage(onBack, xBack, yBack, wBack, hBack, null);
        else
            g.drawImage(back, xBack, yBack, wBack, hBack, null);


        gameStateManager.drawCursor(g);

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
}
