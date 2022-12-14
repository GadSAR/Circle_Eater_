package Panels;
import Manage.*;
import Music.*;
import Objects.*;

import java.awt.*;
import java.util.Random;

import javax.swing.*;


public class GamePanel extends JPanel
{
	private GameStateManager gameStateManager;
	
	private BallPlayer player ;
	private BallPlayer player2 ;
	private BallBot[] vec;
	
	private boolean moveFlag = false;


	private MusicThread mt;
	private Image backgroundImg, pauseImg;
	private Image[][] imgsCursor = new Image[3][3];
	
	
	public GamePanel(GameStateManager gameStateManager)
	{
		setGameStateManager(gameStateManager);
		setScreenImgs();
		setPlayers();
		setBallsGame();
		setCursors();
		setMusic();
	}

	private void setMusic() { gameStateManager.getMusicControler().getGame().setFlag(true); }

	public void setScreenImgs()
	{
		backgroundImg = (new ImageIcon(gameStateManager.getResource().getgameBackgroundImg())).getImage();
		pauseImg = (new ImageIcon(gameStateManager.getResource().getPauseImg())).getImage();
	}

	public void setPlayers()
	{
		///if(playerNum == 1)
		player = new BallPlayer(this);
		player2 = new BallPlayer(this, 100,100);
	}

	public void setBallsGame()
	{
		vec = new BallBot[60];

		for(int i=0 ; i<vec.length; i++)
		{
			int w = (int)(Math.random()*50)+12;

			ImageIcon img1 = new ImageIcon(gameStateManager.getResource().getgoodBallImg());
			ImageIcon img2 = new ImageIcon(gameStateManager.getResource().getbadBallImg());

			Image ballsImage = w < player.getWidth() ? img1.getImage() : img2.getImage();

			Random rnd = new Random();

			vec[i]= new BallBot(rnd.nextInt(1400), rnd.nextInt(800), w, ballsImage, this);
		}
	}

	public void setCursors()
	{
		imgsCursor[0][0] = (new ImageIcon("src/Resources/pictures/lu.png")).getImage();
		imgsCursor[0][1] = (new ImageIcon("src/Resources/pictures/u.png")).getImage();
		imgsCursor[0][2] = (new ImageIcon("src/Resources/pictures/ru.png")).getImage();
		imgsCursor[1][0] = (new ImageIcon("src/Resources/pictures/l.png")).getImage();
		imgsCursor[1][1] = (new ImageIcon("src/Resources/pictures/c.png")).getImage();
		imgsCursor[1][2] = (new ImageIcon("src/Resources/pictures/r.png")).getImage();
		imgsCursor[2][0] = (new ImageIcon("src/Resources/pictures/ld.png")).getImage();
		imgsCursor[2][1] = (new ImageIcon("src/Resources/pictures/d.png")).getImage();
		imgsCursor[2][2] = (new ImageIcon("src/Resources/pictures/rd.png")).getImage();
	}

	public void pause() {
		if(!moveFlag)
		{
			for (int i = 0; i < vec.length; i++)
			{
				synchronized(vec[i])
				{
					vec[i].notify();
				}
			}
			synchronized(player)
			{
				player.notify();
			}
		}
		moveFlag = !moveFlag;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(backgroundImg,0,0,getWidth(),getHeight(),null);
		
		for(int i=0 ; i<vec.length; i++)
			if (vec[i].isAlive())
				vec[i].drawBall(g);


		drawCursor(g);

		if(!moveFlag) {
			g.drawImage(pauseImg, 0, 0, getWidth(), getHeight(), null);
		}

		player.drawPlayer(g);
	}

	public void drawCursor(Graphics g)
	{
		if(gameStateManager.getMouseX() < player.getX() + player.getWidth()/2 - 16 && gameStateManager.getMouseY() < player.getY() + player.getWidth()/2 - 16) g.drawImage(imgsCursor[0][0],gameStateManager.getMouseX(),gameStateManager.getMouseY(),16,16,null);
		else if(gameStateManager.getMouseX() < player.getX() + player.getWidth()/2 - 16 && gameStateManager.getMouseY() > player.getY() + player.getWidth()/2 + 16) g.drawImage(imgsCursor[2][0],gameStateManager.getMouseX(),gameStateManager.getMouseY(),16,16,null);
		else if(gameStateManager.getMouseX() > player.getX() + player.getWidth()/2 + 16 && gameStateManager.getMouseY() < player.getY() + player.getWidth()/2 - 16) g.drawImage(imgsCursor[0][2],gameStateManager.getMouseX(),gameStateManager.getMouseY(),16,16,null);
		else if(gameStateManager.getMouseX() > player.getX() + player.getWidth()/2 + 16 && gameStateManager.getMouseY() > player.getY() + player.getWidth()/2 + 16) g.drawImage(imgsCursor[2][2],gameStateManager.getMouseX(),gameStateManager.getMouseY(),16,16,null);
		else if(gameStateManager.getMouseX() < player.getX() + player.getWidth()/2 - 16 && gameStateManager.getMouseY() > player.getY() + player.getWidth()/2 - 16 && gameStateManager.getMouseY() < player.getY() + player.getWidth()/2 + 16) g.drawImage(imgsCursor[1][0],gameStateManager.getMouseX(),gameStateManager.getMouseY(),16,16,null);
		else if(gameStateManager.getMouseX() > player.getX() + player.getWidth()/2 + 16 && gameStateManager.getMouseY() > player.getY() + player.getWidth()/2 - 16 && gameStateManager.getMouseY() < player.getY() + player.getWidth()/2 + 16) g.drawImage(imgsCursor[1][2],gameStateManager.getMouseX(),gameStateManager.getMouseY(),16,16,null);
		else if(gameStateManager.getMouseY() < player.getY() + player.getWidth()/2 - 16 && gameStateManager.getMouseX() > player.getX() + player.getWidth()/2 - 16 && gameStateManager.getMouseX() < player.getX() + player.getWidth()/2 + 16) g.drawImage(imgsCursor[0][1],gameStateManager.getMouseX(),gameStateManager.getMouseY(),16,16,null);
		else if(gameStateManager.getMouseY() > player.getY() + player.getWidth()/2 + 16 && gameStateManager.getMouseX() > player.getX() + player.getWidth()/2 - 16 && gameStateManager.getMouseX() < player.getX() + player.getWidth()/2 + 16) g.drawImage(imgsCursor[2][1],gameStateManager.getMouseX(),gameStateManager.getMouseY(),16,16,null);
		else g.drawImage(imgsCursor[1][1],gameStateManager.getMouseX(),gameStateManager.getMouseY(),16,16,null);
	}

	public GameStateManager getGameStateManager() {
		return gameStateManager;
	}
	public void setGameStateManager(GameStateManager gameStateManager){
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
}
