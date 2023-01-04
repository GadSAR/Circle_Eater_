package Multiplayer;
import Panels.*;

import java.io.Serial;
import java.io.Serializable;


public class DataClient implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    char[] playerCoordinatesAndStatus;

    public DataClient() {
        playerCoordinatesAndStatus = new char[4];
    }

    public void update(GamePanel gamePanel) {

        playerCoordinatesAndStatus[0] = (char) gamePanel.getPlayer().getX();
        playerCoordinatesAndStatus[1] = (char) gamePanel.getPlayer().getY();
        playerCoordinatesAndStatus[2] = (char) gamePanel.getPlayer().getWidth();
        playerCoordinatesAndStatus[3] = (char) gamePanel.getPlayer().getAlive();
    }

}
