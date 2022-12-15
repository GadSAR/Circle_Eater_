package Multiplayer;

import Manage.*;
import Multiplayer.*;
import Music.*;
import Objects.*;
import Panels.*;
import Resources.*;


public class Data {

    GamePanel game;

    BallPlayer tempPlayer;
    BallBot[] tempVec;
    char vecSize;
    char[][] cordinatesAndStatus;

    public Data(GamePanel game) {
        this.game = game;
        vecSize = game.getVecSize();
        cordinatesAndStatus = new char[vecSize + 1][3];
    }

    public void update() {
        tempPlayer = game.getPlayer();
        tempVec = game.getVec();
        cordinatesAndStatus[0][0] = (char) tempPlayer.getX();
        cordinatesAndStatus[0][1] = (char) tempPlayer.getY();
        cordinatesAndStatus[0][2] = (char) tempPlayer.getAlive();

        for (int i = 1; i < cordinatesAndStatus.length; i++) {
            cordinatesAndStatus[i][0] = (char) tempVec[i - 1].getX();
            cordinatesAndStatus[i][1] = (char) tempVec[i - 1].getY();
            cordinatesAndStatus[i][2] = (char) tempVec[i - 1].getAlive();
        }
    }


    public GamePanel getGame() {
        return game;
    }

    public void setGame(GamePanel game) {
        this.game = game;
    }

    public BallPlayer getTempPlayer() {
        return tempPlayer;
    }

    public void setTempPlayer(BallPlayer tempPlayer) {
        this.tempPlayer = tempPlayer;
    }

    public BallBot[] getTempVec() {
        return tempVec;
    }

    public void setTempVec(BallBot[] tempVec) {
        this.tempVec = tempVec;
    }

    public char getVecSize() {
        return vecSize;
    }

    public void setVecSize(char vecSize) {
        this.vecSize = vecSize;
    }

    public char[][] getCordinatesAndStatus() {
        return cordinatesAndStatus;
    }

    public void setCordinatesAndStatus(char[][] cordinatesAndStatus) {
        this.cordinatesAndStatus = cordinatesAndStatus;
    }

}
