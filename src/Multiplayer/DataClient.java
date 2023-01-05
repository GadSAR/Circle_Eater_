package Multiplayer;
import Panels.*;

import java.io.Serial;
import java.io.Serializable;


public class DataClient implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Integer[] playerCoordinatesAndStatus = new Integer[4];;


    public DataClient(GamePanel gamePanel) {

        playerCoordinatesAndStatus[0] = gamePanel.getPlayer().getX();
        playerCoordinatesAndStatus[1] = gamePanel.getPlayer().getY();
        playerCoordinatesAndStatus[2] = gamePanel.getPlayer().getWidth();
        playerCoordinatesAndStatus[3] = gamePanel.getPlayer().getAlive();

    }

}
