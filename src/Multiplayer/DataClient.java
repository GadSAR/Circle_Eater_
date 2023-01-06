package Multiplayer;
import Panels.*;

import java.io.Serial;
import java.io.Serializable;


public class DataClient implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Short[] playerCoordinatesAndStatus = new Short[4];
    Short[] ballsStatus;


    public DataClient(GamePanel gamePanel) {

        ballsStatus = new Short[gamePanel.getGameStateManager().getVecSize()];

        playerCoordinatesAndStatus[0] = (short) gamePanel.getPlayer().getX();
        playerCoordinatesAndStatus[1] = (short) gamePanel.getPlayer().getY();
        playerCoordinatesAndStatus[2] = (short) gamePanel.getPlayer().getWidth();
        playerCoordinatesAndStatus[3] = (short) gamePanel.getPlayer().getAlive();

        for (int i = 0; i < ballsStatus.length; i++) {
            ballsStatus[i] = (short) gamePanel.getVec()[i].getAlive();
        }
    }

}
