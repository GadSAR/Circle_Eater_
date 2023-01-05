package Multiplayer;

import Panels.*;

import java.io.Serial;
import java.io.Serializable;


public class DataServer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Integer[] playerCoordinatesAndStatus = new Integer[4];
    Integer[][] ballsCoordinatesAndStatus;
    Boolean moveFlag;

    public DataServer(GamePanel gamePanel) {

        ballsCoordinatesAndStatus = new Integer[gamePanel.getGameStateManager().getVecSize()][6];

        moveFlag = gamePanel.getMoveFlag();

        playerCoordinatesAndStatus[0] = gamePanel.getPlayer().getX();
        playerCoordinatesAndStatus[1] = gamePanel.getPlayer().getY();
        playerCoordinatesAndStatus[2] = gamePanel.getPlayer().getWidth();
        playerCoordinatesAndStatus[3] = gamePanel.getPlayer().getAlive();

        for (int i = 0; i < ballsCoordinatesAndStatus.length; i++) {
            ballsCoordinatesAndStatus[i][0] = gamePanel.getVec()[i].getX();
            ballsCoordinatesAndStatus[i][1] = gamePanel.getVec()[i].getY();
            ballsCoordinatesAndStatus[i][2] = gamePanel.getVec()[i].getWidth();
            ballsCoordinatesAndStatus[i][3] = gamePanel.getVec()[i].getAlive();
            ballsCoordinatesAndStatus[i][4] = gamePanel.getVec()[i].getDirX();
            ballsCoordinatesAndStatus[i][5] = gamePanel.getVec()[i].getDirY();
        }
    }

}
