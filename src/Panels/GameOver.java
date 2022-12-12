package Panels;
import Manage.*;
import Multiplayer.*;
import Music.*;
import Panels.*;
import Objects.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {

    GameStateManager gameStateManager;
    private Image img;

    public GameOver(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        this.img = (new ImageIcon(gameStateManager.getResource().getGameOverBackgroundImg())).getImage();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(img,0,0,getWidth(),getHeight(),null);
    }

}
