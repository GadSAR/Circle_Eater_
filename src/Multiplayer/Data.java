package Multiplayer;
import Objects.*;
import Panels.*;

import java.io.Serial;
import java.io.Serializable;


public class Data implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    char[][] coordinatesAndStatus;

    public Data(GamePanel game) {
        char vecSize = game.getVecSize();
        coordinatesAndStatus = new char[vecSize + 1][4];
    }

    public void update(GamePanel game) {

        BallBot[] tempBots = game.getVec();
        BallPlayer tempPlayer = game.getPlayer();

        coordinatesAndStatus[0][0] = (char) tempPlayer.getX();
        coordinatesAndStatus[0][1] = (char) tempPlayer.getY();
        coordinatesAndStatus[0][2] = (char) tempPlayer.getWidth();
        coordinatesAndStatus[0][3] = (char) tempPlayer.getAlive();

        for (int i = 1; i < coordinatesAndStatus.length; i++) {
            coordinatesAndStatus[i][0] = (char) tempBots[i - 1].getX();
            coordinatesAndStatus[i][1] = (char) tempBots[i - 1].getY();
            coordinatesAndStatus[i][2] = (char) tempBots[i - 1].getWidth();
            coordinatesAndStatus[i][3] = (char) tempBots[i - 1].getAlive();
        }
    }


    public char[][] getCoordinatesAndStatus() {
        return coordinatesAndStatus;
    }

    public void setCoordinatesAndStatus(char[][] coordinatesAndStatus) {
        this.coordinatesAndStatus = coordinatesAndStatus;
    }

}
