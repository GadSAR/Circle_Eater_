package Panels;
import Manage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameSettings extends JPanel {

    GameStateManager gameStateManager;
    private Image settingsBackgroundImg;

    public GameSettings(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        this.settingsBackgroundImg = (new ImageIcon(gameStateManager.getResource().getGameSettingsBackgroundImg())).getImage();
        setListeners();
    }

    public void setListeners()
    {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    //System.exit(1);
                    gameStateManager.setCurrentGameState(GameState.GAME);
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(1);
                }
            }
        });
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(settingsBackgroundImg,0,0,getWidth(),getHeight(),null);

        gameStateManager.drawCursor(g);

    }

}
