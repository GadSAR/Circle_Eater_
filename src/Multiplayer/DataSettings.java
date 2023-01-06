package Multiplayer;

import Manage.GameStateManager;

import java.io.Serial;
import java.io.Serializable;


public class DataSettings implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Short[] settings = new Short[4];

    public DataSettings(GameStateManager gameStateManager) {

        settings[0] = (short) gameStateManager.getSpeedLevel();
        settings[1] = (short) gameStateManager.getMode();
        settings[2] = (short) gameStateManager.getVecSize();
        settings[3] = (short) gameStateManager.getWidthStart();

    }
}
