package Objects;
import Manage.*;
import Panels.*;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;

import javax.swing.*;

public class BallPlayer extends Thread implements Serializable
{
	@Serial
	private static final long serialVersionUID = 1L;
	
	private GamePanel panel;
	private int x, y, width;
	private Boolean alive;
	private long startTime;
	private double delay = 1000/60;
	private double dx, dy, angle;
	private double degrees = 0;
	private Image ballImage;


	public BallPlayer(GamePanel panel) { this(panel,0,0); }
	
	public BallPlayer(GamePanel panel, int x, int y)
	{
		this.panel = panel;
		this.x = x;
		this.y = y;
		this.width = 30;
		alive = true;
		ballImage = new ImageIcon(panel.getGameStateManager().getResource().getplayer1BallImg()).getImage();
		startTime = System.currentTimeMillis();
		start();
	}
		
	public void run()
	{		
		while(true)
		{
			checkpause();
			update();

			try {
			   	Thread.sleep(0, 50);
		   	   }catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			if(panel.getGameStateManager().getCurrentGameState() != GameState.GAME)
				break;
		}
	}
	
	private void checkpause()
	{
		synchronized(this)
		{	
		if(!panel.getMoveFlag())
			try {
				wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}		
	}

	private void update()
	{
		if(System.currentTimeMillis() - startTime >= delay) {

			dx = panel.getGameStateManager().getMouseX() - panel.getPlayer().getX() - panel.getPlayer().getWidth() / 2 + 7.5;
			dy = panel.getGameStateManager().getMouseY() - panel.getPlayer().getY() - panel.getPlayer().getWidth() / 2 + 7.5;

			if (dx * dx + dy * dy > panel.getPlayer().width / 2) {    //minimum to move
				angle = Math.atan2(dy, dx);
				panel.getPlayer().x += (int) (5 * Math.cos(angle));
				panel.getPlayer().y += (int) (5 * Math.sin(angle));
			}
			degrees = degrees == 360 ? 4 : degrees + 4;    //for rotation animation
			startTime = System.currentTimeMillis();
		}

	}

	public void drawPlayer(Graphics g)
	{
		g.drawImage(ballImage, x,y, width, width,null);
	}
	
	public void drawAnimatedPlayer(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		Point p = new Point(x+ width /2,y+ width /2);
		g2.rotate(Math.toRadians(degrees),p.x,p.y);
		g2.drawImage(ballImage,x,y, width, width, null);
	}
	
	public GamePanel getPanel() {
		return panel;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
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
		return alive? 1:0;
	}

	public void setAlive(char alive) {
		this.alive = alive == 1? true : false;
	}

	public boolean isPlayerAlive() {
		return alive;
	}

	public void setPlayerAlive(boolean alive) {
		this.alive = alive;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getDegrees() {
		return degrees;
	}

	public void setDegrees(double degrees) {
		this.degrees = degrees;
	}

	public Image getBallImage() {
		return ballImage;
	}

	public void setBallImage(Image ballImage) {
		this.ballImage = ballImage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
