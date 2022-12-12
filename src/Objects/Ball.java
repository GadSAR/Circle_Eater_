package Objects;
import Manage.*;
import Music.*;
import Panels.*;
import Objects.*;
import Resources.*;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;

public abstract class Ball extends Thread implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int x, y, radius, diameter;
    private boolean alive;
    private Image ballImage;
    private GamePanel panel;

    public Ball(int x, int y, int radius, int diameter, boolean alive, Image ballImage, GamePanel panel) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.diameter = diameter;
        this.alive = alive;
        this.ballImage = ballImage;
        this.panel = panel;
    }

    public Ball() {

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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public boolean alive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Image getBallImage() {
        return ballImage;
    }

    public void setBallImage(Image ballImage) {
        this.ballImage = ballImage;
    }

    public GamePanel getPanel() {
        return panel;
    }

    public void setPanel(GamePanel panel) {
        this.panel = panel;
    }
}
