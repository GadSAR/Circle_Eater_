package Panels;

import Manage.*;
import Music.*;
import Objects.*;

import java.awt.*;
import java.util.Random;

import javax.swing.*;


public class GamePanel extends JPanel {
    private GameStateManager gameStateManager;

    private BallPlayer player;
    private BallPlayer player2;
    private BallBot[] vec;
    private char vecSize = 60;

    private boolean moveFlag = false;


    private MusicThread mt;
    private Image backgroundImg, pauseImg;
    private Image[][] imgsCursor = new Image[3][3];

    public GamePanel(GameStateManager gameStateManager, int index) {
        setGameStateManager(gameStateManager);
        setScreenImgs();
        setPlayers(index);
        setBallsGame();
        setCursors();
        setMusic();
    }

    private void setMusic() {
        gameStateManager.getMusicControler().getGame().setFlag(true);
    }

    public void setScreenImgs() {
        backgroundImg = (new ImageIcon(gameStateManager.getResource().getgameBackgroundImg())).getImage();
        pauseImg = (new ImageIcon(gameStateManager.getResource().getPauseImg())).getImage();
    }

    public void setPlayers(int index) {
        if (index == 0) {
            player = new BallPlayer(this);
            player2 = null;
        } else if (index == 1) {
            player = new BallPlayer(this);
            player2 = new BallPlayer(this, 100, 100);
        } else if (index == 2) {
            player = new BallPlayer(this, 100, 100);
            player2 = new BallPlayer(this);
        }
    }

    public void setBallsGame() {
        vec = new BallBot[vecSize];

        Random rnd = new Random();
        int space = 30;

        for (int i = 0; i < vec.length; i++) {

            int w = rnd.nextInt(50) + 12;

            ImageIcon img1 = new ImageIcon(gameStateManager.getResource().getgoodBallImg());
            ImageIcon img2 = new ImageIcon(gameStateManager.getResource().getbadBallImg());

            Image ballsImage = w < player.getWidth() ? img1.getImage() : img2.getImage();

            int x = rnd.nextInt(gameStateManager.getF().getWidth() - w);
            int y = rnd.nextInt(gameStateManager.getF().getHeight() - w);

            if(player2 != null)
            {
                while((((x < player.getX() + player.getWidth() + space) || (x < player.getX() - space)) && ((y < player.getY() + player.getWidth() + space) || (y < player.getY() - space))) || (((x < player2.getX() + player.getWidth() + space) || (x < player2.getY() - space)) && ((y < player2.getY() + player.getWidth() + space) || (y < player2.getY() - space)))){
                    x = rnd.nextInt(gameStateManager.getF().getWidth() - w);
                    y = rnd.nextInt(gameStateManager.getF().getHeight() - w);
                }
            }
            else
            {
                while(((x < player.getX() + player.getWidth() + space) || (x < player.getX() - space)) && ((y < player.getY() + player.getWidth() + space) || (y < player.getY() - space)))
                {
                    x = rnd.nextInt(gameStateManager.getF().getWidth() - w);
                    y = rnd.nextInt(gameStateManager.getF().getHeight() - w);
                }

            }


            vec[i] = new BallBot(x, rnd.nextInt(gameStateManager.getF().getHeight() - w), w, ballsImage, this);
        }
    }

    public void setCursors() {
        imgsCursor[0][0] = (new ImageIcon(gameStateManager.getResource().getCursorLuImg())).getImage();
        imgsCursor[0][1] = (new ImageIcon(gameStateManager.getResource().getCursorUImg())).getImage();
        imgsCursor[0][2] = (new ImageIcon(gameStateManager.getResource().getCursorRuImg())).getImage();
        imgsCursor[1][0] = (new ImageIcon(gameStateManager.getResource().getCursorLImg())).getImage();
        imgsCursor[1][1] = (new ImageIcon(gameStateManager.getResource().getCursorCImg())).getImage();
        imgsCursor[1][2] = (new ImageIcon(gameStateManager.getResource().getCursorRImg())).getImage();
        imgsCursor[2][0] = (new ImageIcon(gameStateManager.getResource().getCursorLdImg())).getImage();
        imgsCursor[2][1] = (new ImageIcon(gameStateManager.getResource().getCursorDImg())).getImage();
        imgsCursor[2][2] = (new ImageIcon(gameStateManager.getResource().getCursorRdImg())).getImage();
    }

    public void pause() {
        if (!moveFlag) {
            for (int i = 0; i < vec.length; i++) {
                synchronized (vec[i]) {
                    vec[i].notify();
                }
            }
            synchronized (player) {
                player.notify();
            }
        }
        moveFlag = !moveFlag;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), null);

        for (int i = 0; i < vec.length; i++)
            if (vec[i].isAlive())
                vec[i].drawBall(g);

        if (!moveFlag) {
            g.drawImage(pauseImg, 0, 0, getWidth(), getHeight(), null);
        }

        drawCursor(g);
        player.drawPlayer(g);
        if(player2 != null) player2.drawPlayer2(g);
    }

    public void drawCursor(Graphics g) {
        if (gameStateManager.getMouseX() < player.getX() + player.getWidth() / 2 - 16 && gameStateManager.getMouseY() < player.getY() + player.getWidth() / 2 - 16)
            g.drawImage(imgsCursor[0][0], gameStateManager.getMouseX(), gameStateManager.getMouseY(), 16, 16, null);
        else if (gameStateManager.getMouseX() < player.getX() + player.getWidth() / 2 - 16 && gameStateManager.getMouseY() > player.getY() + player.getWidth() / 2 + 16)
            g.drawImage(imgsCursor[2][0], gameStateManager.getMouseX(), gameStateManager.getMouseY(), 16, 16, null);
        else if (gameStateManager.getMouseX() > player.getX() + player.getWidth() / 2 + 16 && gameStateManager.getMouseY() < player.getY() + player.getWidth() / 2 - 16)
            g.drawImage(imgsCursor[0][2], gameStateManager.getMouseX(), gameStateManager.getMouseY(), 16, 16, null);
        else if (gameStateManager.getMouseX() > player.getX() + player.getWidth() / 2 + 16 && gameStateManager.getMouseY() > player.getY() + player.getWidth() / 2 + 16)
            g.drawImage(imgsCursor[2][2], gameStateManager.getMouseX(), gameStateManager.getMouseY(), 16, 16, null);
        else if (gameStateManager.getMouseX() < player.getX() + player.getWidth() / 2 - 16 && gameStateManager.getMouseY() > player.getY() + player.getWidth() / 2 - 16 && gameStateManager.getMouseY() < player.getY() + player.getWidth() / 2 + 16)
            g.drawImage(imgsCursor[1][0], gameStateManager.getMouseX(), gameStateManager.getMouseY(), 16, 16, null);
        else if (gameStateManager.getMouseX() > player.getX() + player.getWidth() / 2 + 16 && gameStateManager.getMouseY() > player.getY() + player.getWidth() / 2 - 16 && gameStateManager.getMouseY() < player.getY() + player.getWidth() / 2 + 16)
            g.drawImage(imgsCursor[1][2], gameStateManager.getMouseX(), gameStateManager.getMouseY(), 16, 16, null);
        else if (gameStateManager.getMouseY() < player.getY() + player.getWidth() / 2 - 16 && gameStateManager.getMouseX() > player.getX() + player.getWidth() / 2 - 16 && gameStateManager.getMouseX() < player.getX() + player.getWidth() / 2 + 16)
            g.drawImage(imgsCursor[0][1], gameStateManager.getMouseX(), gameStateManager.getMouseY(), 16, 16, null);
        else if (gameStateManager.getMouseY() > player.getY() + player.getWidth() / 2 + 16 && gameStateManager.getMouseX() > player.getX() + player.getWidth() / 2 - 16 && gameStateManager.getMouseX() < player.getX() + player.getWidth() / 2 + 16)
            g.drawImage(imgsCursor[2][1], gameStateManager.getMouseX(), gameStateManager.getMouseY(), 16, 16, null);
        else g.drawImage(imgsCursor[1][1], gameStateManager.getMouseX(), gameStateManager.getMouseY(), 16, 16, null);
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public void setGameStateManager(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public BallPlayer getPlayer() {
        return player;
    }

    public void setPlayer(BallPlayer player) {
        this.player = player;
    }

    public BallPlayer getPlayer2() {
        return player2;
    }

    public void setPlayer2(BallPlayer player2) {
        this.player2 = player2;
    }

    public BallBot[] getVec() {
        return vec;
    }

    public void setVec(BallBot[] vec) {
        this.vec = vec;
    }

    public char getVecSize() {
        return vecSize;
    }

    public boolean getMoveFlag() {
        return moveFlag;
    }

    public void setMoveFlag(boolean moveFlag) {
        this.moveFlag = moveFlag;
    }

    public Image getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(Image backgroundImg) {
        this.backgroundImg = backgroundImg;
    }


    public void setImgsCursor(Image[][] imgsCursor) {
        this.imgsCursor = imgsCursor;
    }

    public void end() {
        moveFlag = false;
    }

    public void setCordinatesAndStatus(char[][] cordinatesAndStatus) {
        player.setX(cordinatesAndStatus[0][0]);
        player.setY(cordinatesAndStatus[0][1]);
        player.setWidth(cordinatesAndStatus[0][2]);
        player.setAlive(cordinatesAndStatus[0][3]);

        for(int i = 1; i < cordinatesAndStatus.length; i++){
            vec[i-1].setX(cordinatesAndStatus[i][0]);
            vec[i-1].setY(cordinatesAndStatus[i][1]);
            vec[i-1].setWidth(cordinatesAndStatus[i][2]);
            vec[i-1].setAlive(cordinatesAndStatus[i][3]);
        }
    }
}
