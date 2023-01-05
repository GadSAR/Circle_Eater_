package Multiplayer;

import Panels.*;

import java.io.Serial;
import java.io.Serializable;


public class DataServer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Integer[] playerCoordinatesAndStatus = new Integer[4];
    Integer[][] ballsCoordinatesAndStatus = new Integer[60][6];
    Boolean moveFlag;

        public DataServer(GamePanel game) {

        moveFlag = game.getMoveFlag();

        playerCoordinatesAndStatus[0] = game.getPlayer().getX();
        playerCoordinatesAndStatus[1] = game.getPlayer().getY();
        playerCoordinatesAndStatus[2] = game.getPlayer().getWidth();
        playerCoordinatesAndStatus[3] = game.getPlayer().getAlive();

        for (int i = 0; i < ballsCoordinatesAndStatus.length; i++) {
            ballsCoordinatesAndStatus[i][0] = game.getVec()[i].getX();
            ballsCoordinatesAndStatus[i][1] = game.getVec()[i].getY();
            ballsCoordinatesAndStatus[i][2] = game.getVec()[i].getWidth();
            ballsCoordinatesAndStatus[i][3] = game.getVec()[i].getAlive();
            ballsCoordinatesAndStatus[i][4] = game.getVec()[i].getDirX();
            ballsCoordinatesAndStatus[i][5] = game.getVec()[i].getDirY();
        }
    }

}
