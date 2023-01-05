package Multiplayer;

import Manage.GameStateManager;

import java.io.Serial;
import java.io.Serializable;


public class DataSettings implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Integer[] settings = new Integer[4];

    public DataSettings(GameStateManager gameStateManager) {

        settings[0] = gameStateManager.getSpeedLevel();
        settings[1] = gameStateManager.getMode();
        settings[2] = gameStateManager.getVecSize();
        settings[3] = gameStateManager.getWidthStart();

    }
}
