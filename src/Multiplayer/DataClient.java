package Multiplayer;
import Panels.*;

import java.io.Serial;
import java.io.Serializable;


public class DataClient implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Integer[] playerCoordinatesAndStatus = new Integer[4];
    Integer[] ballsStatus;


    public DataClient(GamePanel gamePanel) {

        ballsStatus = new Integer[gamePanel.getGameStateManager().getVecSize()];

        playerCoordinatesAndStatus[0] = gamePanel.getPlayer().getX();
        playerCoordinatesAndStatus[1] = gamePanel.getPlayer().getY();
        playerCoordinatesAndStatus[2] = gamePanel.getPlayer().getWidth();
        playerCoordinatesAndStatus[3] = gamePanel.getPlayer().getAlive();

        for (int i = 0; i < ballsStatus.length; i++) {
            ballsStatus[i] = gamePanel.getVec()[i].getAlive();
        }
    }

}
