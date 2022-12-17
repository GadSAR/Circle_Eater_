package Objects;
import Manage.*;
import Panels.*;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;


public class BallBot extends Thread implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private GamePanel panel;
    private int x, y, width;
    long startTime;
    double delay = 1000 / 120;
    private boolean alive;
    private int dirX, dirY;
    private Random random = new Random();
    private Image ballImage;
    private ImageIcon goodBall, badBall;

    private int preventionDistance;


    public BallBot(int x, int y, int width, Image ballsImage, GamePanel p) {
        this.x = x;
        this.y = y;
        this.width = width;
        startTime = System.currentTimeMillis();
        dirX = random.nextBoolean() ? 1 : -1;
        dirY = random.nextBoolean() ? 1 : -1;
        preventionDistance = 0;
        this.ballImage = ballsImage;
        this.panel = p;
        goodBall = new ImageIcon(panel.getGameStateManager().getResource().getgoodBallImg());
        badBall = new ImageIcon(panel.getGameStateManager().getResource().getbadBallImg());
        start();
    }

    public void run() {
        while (true) {
            checkpause();
            update();
            if (interaction())
                break;

            try {
                Thread.sleep(0, 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (panel.getGameStateManager().getCurrentGameState() != GameState.GAME)
                break;
        }
    }

    private void soundEffect(boolean bol) {
        if (bol)
            panel.getGameStateManager().getMusicControler().getGood().setFlag(true);
        else
            panel.getGameStateManager().getMusicControler().getBad().setFlag(true);
    }

    private boolean interaction() {

        int x1 = panel.getPlayer().getX();
        int y1 = panel.getPlayer().getY();
        int cx1 = x1 + panel.getPlayer().getWidth() / 2;
        int cy1 = y1 + panel.getPlayer().getWidth() / 2;

        ballImage = width < panel.getPlayer().getWidth() ? goodBall.getImage() : badBall.getImage();


        if (distance(x + width / 2 - cx1, y + width / 2 - cy1) < width / 2 + panel.getPlayer().getWidth() / 2) {

            if (panel.getPlayer().getWidth() > width) {
                panel.getPlayer().setWidth(panel.getPlayer().getWidth() + 1);        ///increase size
                soundEffect(true);
                return true;
            }

            if (panel.getPlayer().getWidth() <= width) {
                if (panel.getPlayer().getWidth() < 25) {
                    panel.getGameStateManager().setCurrentGameState(GameState.GAMEOVER);
                    panel.getGameStateManager().setChangedPanel(true);
                    //System.exit(1);
                }
                panel.getPlayer().setWidth(panel.getPlayer().getWidth() - 8);        ///decrease size
                soundEffect(false);
                return true;
            }
            alive = false;
        }
        return false;
    }

    public void update() {
        if (System.currentTimeMillis() - startTime >= delay) {
            hitWall();
            preventionDistance();
            x += dirX;
            y += dirY;
            startTime = System.currentTimeMillis();
        }
    }

    private void hitWall() {
        int h = panel.getHeight();
        int w = panel.getWidth();

        if (x + width >= w)
            dirX = -1;
        else if (x <= 0)
            dirX = 1;
        else if (y + width >= h)
            dirY = -1;
        else if (y <= 0)
            dirY = 1;

    }

    private void preventionDistance() {
        if (preventionDistance <= 0) {
            for (int i = 0; i < panel.getVec().length; i++) {
                if (panel.getVec()[i] != this && panel.getVec()[i].isAlive()) {
                    double d = distance(x, y, panel.getVec()[i].x, panel.getVec()[i].y);
                    if (d <= width / 2 + panel.getVec()[i].width / 2) {
                        int temp = (width / 2 + panel.getVec()[i].width / 2) - (int) d;
                        if (temp > preventionDistance) {
                            dirX *= -1;
                            dirY *= -1;
                            preventionDistance = temp;
                        }
                    }
                }
            }
        } else {
            preventionDistance--;
        }

    }

    public void checkpause() {
        synchronized (this) {
            if (!panel.getMoveFlag())
                try {
                    wait();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        }
    }

    public void drawBall(Graphics g) {
        g.drawImage(ballImage, x, y, width, width, null);
    }

    public double distance(int a, int b) {
        return Math.sqrt(Math.pow(a, 2.0) + Math.pow(b, 2.0));
    }

    public double distance(int x1, int y1, int x2, int y2) {
        return distance(x1 - x2, y1 - y2);
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
        return alive ? 1:0;
    }

    public void setAlive(char alive) {
        this.alive = alive == 1? true : false;
    }

    public boolean isBotAlive() {
        return alive;
    }

    public void setBotAlive(Boolean alive) {
        this.alive = alive;
    }



    public int getDirX() {
        return dirX;
    }

    public void setDirX(int dirX) {
        this.dirX = dirX;
    }

    public int getDirY() {
        return dirY;
    }

    public void setDirY(int dirY) {
        this.dirY = dirY;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Image getBallImage() {
        return ballImage;
    }

    public void setBallImage(Image ballImage) {
        this.ballImage = ballImage;
    }

    public ImageIcon getGoodBall() {
        return goodBall;
    }

    public void setGoodBall(ImageIcon goodBall) {
        this.goodBall = goodBall;
    }

    public ImageIcon getBadBall() {
        return badBall;
    }

    public void setBadBall(ImageIcon badBall) {
        this.badBall = badBall;
    }

    public GamePanel getPanel() {
        return panel;
    }

    public void setPanel(GamePanel panel) {
        this.panel = panel;
    }

    public int getPreventionDistance() {
        return preventionDistance;
    }

    public void setPreventionDistance(int preventionDistance) {
        this.preventionDistance = preventionDistance;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
