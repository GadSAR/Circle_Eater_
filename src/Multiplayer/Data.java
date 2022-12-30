package Multiplayer;
import Objects.*;
import Panels.*;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;


public class Data implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Point p;
    Integer[][] botsCoordinatesAndStatus;

    public Data(GamePanel game) {
        char vecSize = game.getVecSize();
        p = new Point();
        botsCoordinatesAndStatus = new Integer[vecSize + 1][4];
    }

    public void update(GamePanel game) {

        BallBot[] tempBots = game.getVec();
        BallPlayer tempPlayer = game.getPlayer();

        p.x = tempPlayer.getX(); p.y = tempPlayer.getY();

        botsCoordinatesAndStatus[0][0] = tempPlayer.getX();
        botsCoordinatesAndStatus[0][1] = tempPlayer.getY();
        botsCoordinatesAndStatus[0][2] = tempPlayer.getWidth();
        botsCoordinatesAndStatus[0][3] = tempPlayer.getAlive();

        for (int i = 1; i < botsCoordinatesAndStatus.length; i++) {
            botsCoordinatesAndStatus[i][0] = tempBots[i - 1].getX();
            botsCoordinatesAndStatus[i][1] = tempBots[i - 1].getY();
            botsCoordinatesAndStatus[i][2] = tempBots[i - 1].getWidth();
            botsCoordinatesAndStatus[i][3] = tempBots[i - 1].getAlive();
        }
    }


    public Integer[][] getBotsCoordinatesAndStatus() {
        return botsCoordinatesAndStatus;
    }

    public void setBotsCoordinatesAndStatus(Integer[][] botsCoordinatesAndStatus) {
        this.botsCoordinatesAndStatus = botsCoordinatesAndStatus;
    }

}
