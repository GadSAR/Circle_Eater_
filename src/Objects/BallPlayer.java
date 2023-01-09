package Objects;

import Manage.*;
import Panels.*;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class BallPlayer extends Thread {

    private GamePanel panel;
    private int x, y, width;
    private Boolean alive;
    private long startTime;
    private double delay;
    private Image playerImage, player2Image;


    public BallPlayer(GamePanel panel) {
        this(panel, 0, 0);
    }

    public BallPlayer(GamePanel panel, int x, int y) {
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.width = panel.getGameStateManager().getWidthStart();
        delay = (double) 1000 / (30 * panel.getGameStateManager().getSpeedLevel());
        alive = true;
        playerImage = new ImageIcon(panel.getGameStateManager().getResource().getplayer1BallImg()).getImage();
        player2Image = new ImageIcon(panel.getGameStateManager().getResource().getplayer2BallImg()).getImage();
        startTime = System.currentTimeMillis();
        start();
    }

    public void run() {
        while (true) {
            checkpause();
            update();
            try {
                checkWin();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(0, 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (panel.getGameStateManager().getCurrentGameState() != GameState.GAME)
                break;
        }
    }

    private void checkWin() throws IOException, InterruptedException {
            int counter = 0;
            for (int i = 0; i < panel.getVec().length; i++) {
                counter += panel.getVec()[i].getAlive();
            }
            if(counter == 0){
                if (panel.getGameStateManager().getPlayerType() == 0){
                    if (isPlayerAlive())
                        panel.gameOver(0);}
                else {
                    if(panel.getPlayer().width > panel.getPlayer2().width)
                        panel.gameOver(panel.getGameStateManager().getPlayerType());
                    else
                        panel.gameOver(-1);
                }
            }
    }

    private void checkpause() {
        synchronized (this) {
            if (!panel.getMoveFlag())
                try {
                    wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
        }
    }

    private void update() {
        if (System.currentTimeMillis() - startTime >= delay) {

            double dx = panel.getGameStateManager().getMouseX() - panel.getPlayer().getX() - (double) panel.getPlayer().getWidth() / 2 + 7.5;
            double dy = panel.getGameStateManager().getMouseY() - panel.getPlayer().getY() - (double) panel.getPlayer().getWidth() / 2 + 7.5;

            if (dx * dx + dy * dy > (double) panel.getPlayer().width / 2) {    //minimum to move
                double angle = Math.atan2(dy, dx);
                panel.getPlayer().x += (int) (5 * Math.cos(angle));
                panel.getPlayer().y += (int) (5 * Math.sin(angle));
                if (panel.getPlayer().x < -panel.getPlayer().width / 2)
                    panel.getPlayer().x = -panel.getPlayer().width / 2;
                if (panel.getPlayer().x + panel.getPlayer().width / 2 > panel.getWidth())
                    panel.getPlayer().x = panel.getWidth() - panel.getPlayer().width / 2;
                if (panel.getPlayer().y < -panel.getPlayer().width / 2)
                    panel.getPlayer().y = -panel.getPlayer().width / 2;
                if (panel.getPlayer().y + panel.getPlayer().width / 2 > panel.getHeight())
                    panel.getPlayer().y = panel.getHeight() - panel.getPlayer().width / 2;

            }
            startTime = System.currentTimeMillis();
        }

    }

    public void drawPlayer(Graphics g) {
        g.drawImage(playerImage, x, y, width, width, null);
    }

    public void drawPlayer2(Graphics g) {
        g.drawImage(player2Image, x, y, width, width, null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getAlive() {
        return alive ? 1 : 0;
    }

    public void setAlive(int alive) {
        this.alive = alive == 1;
    }

    public boolean isPlayerAlive() {
        return alive;
    }

    public void setPlayerAlive(boolean alive) {
        this.alive = alive;
    }
}
