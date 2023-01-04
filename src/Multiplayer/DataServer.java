package Multiplayer;
import Objects.*;
import Panels.*;

import java.io.Serial;
import java.io.Serializable;


public class DataServer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    char[] playerCoordinatesAndStatus;
    char[][] ballsCoordinatesAndStatus;
    boolean moveFlag;

    public DataServer(GamePanel game) {
        char vecSize = game.getVecSize();
        playerCoordinatesAndStatus = new char[4];
        ballsCoordinatesAndStatus = new char[vecSize][6];
    }

    public void update(GamePanel game) {

        moveFlag = game.getMoveFlag();

        playerCoordinatesAndStatus[0] = (char) game.getPlayer().getX();
        playerCoordinatesAndStatus[1] = (char) game.getPlayer().getY();
        playerCoordinatesAndStatus[2] = (char) game.getPlayer().getWidth();
        playerCoordinatesAndStatus[3] = (char) game.getPlayer().getAlive();

        for (int i = 1; i < ballsCoordinatesAndStatus.length; i++) {
            ballsCoordinatesAndStatus[i][0] = (char) game.getVec()[i - 1].getX();
            ballsCoordinatesAndStatus[i][1] = (char) game.getVec()[i - 1].getY();
            ballsCoordinatesAndStatus[i][2] = (char) game.getVec()[i - 1].getWidth();
            ballsCoordinatesAndStatus[i][3] = (char) game.getVec()[i - 1].getAlive();
            ballsCoordinatesAndStatus[i][3] = (char) game.getVec()[i - 1].getDirX();
            ballsCoordinatesAndStatus[i][3] = (char) game.getVec()[i - 1].getDirY();
        }
    }

}
