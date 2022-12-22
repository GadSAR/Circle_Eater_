package Panels;
import Manage.*;
import Multiplayer.*;
import Music.*;
import Panels.*;
import Objects.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;

public class GameHowToPlay extends JPanel {

    GameStateManager gameStateManager;
    private Image img;

    public GameHowToPlay(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        this.img = (new ImageIcon(gameStateManager.getResource().getGameHowToPlayBackgroundImg())).getImage();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(img,0,0,getWidth(),getHeight(),null);

        gameStateManager.drawCursor(g);

    }

}
