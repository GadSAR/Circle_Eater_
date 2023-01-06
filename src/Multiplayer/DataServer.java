package Multiplayer;

import Panels.*;

import java.io.Serial;
import java.io.Serializable;


public class DataServer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Short[] playerCoordinatesAndStatus = new Short[4];
    Short[][] ballsCoordinatesAndStatus;
    Boolean moveFlag;

    public DataServer(GamePanel gamePanel) {

        ballsCoordinatesAndStatus = new Short[gamePanel.getGameStateManager().getVecSize()][6];

        moveFlag = gamePanel.getMoveFlag();

        playerCoordinatesAndStatus[0] = (short) gamePanel.getPlayer().getX();
        playerCoordinatesAndStatus[1] = (short) gamePanel.getPlayer().getY();
        playerCoordinatesAndStatus[2] = (short) gamePanel.getPlayer().getWidth();
        playerCoordinatesAndStatus[3] = (short) gamePanel.getPlayer().getAlive();

        for (int i = 0; i < ballsCoordinatesAndStatus.length; i++) {
            ballsCoordinatesAndStatus[i][0] = (short) gamePanel.getVec()[i].getX();
            ballsCoordinatesAndStatus[i][1] = (short) gamePanel.getVec()[i].getY();
            ballsCoordinatesAndStatus[i][2] = (short) gamePanel.getVec()[i].getWidth();
            ballsCoordinatesAndStatus[i][3] = (short) gamePanel.getVec()[i].getAlive();
            ballsCoordinatesAndStatus[i][4] = (short) gamePanel.getVec()[i].getDirX();
            ballsCoordinatesAndStatus[i][5] = (short) gamePanel.getVec()[i].getDirY();
        }
    }

}
