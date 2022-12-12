package Resources;

import Manage.*;
import Music.*;
import Panels.*;
import Objects.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;

public class Resource {

    private GameStateManager gameStateManager;
    private String CHILLgameBackgroundImg, GLITCHgameBackgroundImg, UNKNOWNgameBackgroundImg,
            CHILLgoodBallImg, CHILLbadBallImg, CHILLplayer1BallImg, CHILLplayer2BallImg,
            GLITCHgoodBallImg, GLITCHbadBallImg, GLITCHplayer1BallImg, GLITCHplayer2BallImg,
            UNKNOWNgoodBallImg, UNKNOWNbadBallImg, UNKNOWNplayer1BallImg, UNKNOWNplayer2BallImg,
            menuBackgroundImg, gameOverBackgroundImg, gameSettingsBackgroundImg, howToPlayBackgroundImg, pauseImg,
            playImg, onPlayImg, howToPlayImg, onHowToPlayImg, exitImg, onExitImg, settingsImg, onSettingsImg;
    ;
    private String CHILLgoodBallPathSound, CHILLbadBallPathSound, CHILLgameBackgroundPathSound,
            GLITCHgoodBallPathSound, GLITCHbadBallPathSound, GLITCHgameBackgroundPathSound,
            UNKNOWNgoodBallPathSound, UNKNOWNbadBallPathSound, UNKNOWNgameBackgroundPathSound,
            clickButtonPathSound, onButtonPathSound, backgroundPathSound;

    public Resource(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        CHILLgameBackgroundImg = "src/Resources/pictures/original.gif";
        GLITCHgameBackgroundImg = null;
        UNKNOWNgameBackgroundImg = null;
        CHILLgoodBallImg = "src/Resources/pictures/blue.gif";
        CHILLbadBallImg = "src/Resources/pictures/red.gif";
        CHILLplayer1BallImg = "src/Resources/pictures/pause.gif";
        CHILLplayer2BallImg = null;
        GLITCHgoodBallImg = null;
        GLITCHbadBallImg = null;
        GLITCHplayer1BallImg = null;
        GLITCHplayer2BallImg = null;
        UNKNOWNgoodBallImg = null;
        UNKNOWNbadBallImg = null;
        UNKNOWNplayer1BallImg = null;
        UNKNOWNplayer2BallImg = null;
        menuBackgroundImg = "src/Resources/pictures/bgMenu.gif";
        gameOverBackgroundImg = "src/Resources/pictures/space.png";
        gameSettingsBackgroundImg = "src/Resources/pictures/space.png";
        howToPlayImg = "src/Resources/pictures/space.png";
        pauseImg = "src/Resources/pictures/pauseScreen.png";
        playImg = "src/Resources/pictures/empty.png";
        onPlayImg = null;
        howToPlayImg = null;
        onHowToPlayImg = null;
        exitImg = null;
        onExitImg = null;
        settingsImg = null;
        onSettingsImg = null;
        CHILLgoodBallPathSound = "src/Resources/Sounds/good.wav";
        CHILLbadBallPathSound = "src/Resources/Sounds/bad.wav";
        CHILLgameBackgroundPathSound = "src/Resources/Sounds/Eminem_Stan.wav";
        GLITCHgoodBallPathSound = null;
        GLITCHbadBallPathSound = null;
        GLITCHgameBackgroundPathSound = null;
        UNKNOWNgoodBallPathSound = null;
        UNKNOWNbadBallPathSound = null;
        UNKNOWNgameBackgroundPathSound = null;
        clickButtonPathSound = null;
        onButtonPathSound = null;
        backgroundPathSound = null;
    }


    public String getgameBackgroundImg() {
        if (gameStateManager.getCurrentGameMode() == GameMode.CHILL)
            return CHILLgameBackgroundImg;
        else if (gameStateManager.getCurrentGameMode() == GameMode.GLITCH)
            return GLITCHgameBackgroundImg;
        else if (gameStateManager.getCurrentGameMode() == GameMode.UNKNOWN)
            return UNKNOWNgameBackgroundImg;
        return "error";
    }

    public String getgoodBallImg() {
        if (gameStateManager.getCurrentGameMode() == GameMode.CHILL)
            return CHILLgoodBallImg;
        else if (gameStateManager.getCurrentGameMode() == GameMode.GLITCH)
            return GLITCHgoodBallImg;
        else if (gameStateManager.getCurrentGameMode() == GameMode.UNKNOWN)
            return UNKNOWNgoodBallImg;
        return "error";
    }

    public String getbadBallImg() {
        if (gameStateManager.getCurrentGameMode() == GameMode.CHILL)
            return CHILLbadBallImg;
        else if (gameStateManager.getCurrentGameMode() == GameMode.GLITCH)
            return GLITCHbadBallImg;
        else if (gameStateManager.getCurrentGameMode() == GameMode.UNKNOWN)
            return UNKNOWNbadBallImg;
        return "error";
    }

    public String getplayer1BallImg() {
        if (gameStateManager.getCurrentGameMode() == GameMode.CHILL)
            return CHILLplayer1BallImg;
        else if (gameStateManager.getCurrentGameMode() == GameMode.GLITCH)
            return GLITCHplayer1BallImg;
        else if (gameStateManager.getCurrentGameMode() == GameMode.UNKNOWN)
            return UNKNOWNplayer1BallImg;
        return "error";
    }

    public String getplayer2BallImg() {
        if (gameStateManager.getCurrentGameMode() == GameMode.CHILL)
            return CHILLplayer2BallImg;
        else if (gameStateManager.getCurrentGameMode() == GameMode.GLITCH)
            return GLITCHplayer2BallImg;
        else if (gameStateManager.getCurrentGameMode() == GameMode.UNKNOWN)
            return UNKNOWNplayer2BallImg;
        return "error";
    }

    public String getgameBackgroundPathSound() {
        if (gameStateManager.getCurrentGameMode() == GameMode.CHILL)
            return CHILLgameBackgroundPathSound;
        else if (gameStateManager.getCurrentGameMode() == GameMode.GLITCH)
            return GLITCHgameBackgroundPathSound;
        else if (gameStateManager.getCurrentGameMode() == GameMode.UNKNOWN)
            return UNKNOWNgameBackgroundPathSound;
        return "error";
    }

    public String getgoodBallPathSound() {
        if (gameStateManager.getCurrentGameMode() == GameMode.CHILL)
            return CHILLgoodBallPathSound;
        else if (gameStateManager.getCurrentGameMode() == GameMode.GLITCH)
            return GLITCHgoodBallPathSound;
        else if (gameStateManager.getCurrentGameMode() == GameMode.UNKNOWN)
            return UNKNOWNgoodBallPathSound;
        return "error";
    }

    public String getbadBallPathSound() {
        if (gameStateManager.getCurrentGameMode() == GameMode.CHILL)
            return CHILLbadBallPathSound;
        else if (gameStateManager.getCurrentGameMode() == GameMode.GLITCH)
            return GLITCHbadBallPathSound;
        else if (gameStateManager.getCurrentGameMode() == GameMode.UNKNOWN)
            return UNKNOWNbadBallPathSound;
        return "error";
    }

    public String getCHILLgameBackgroundImg() {
        return CHILLgameBackgroundImg;
    }

    public void setCHILLgameBackgroundImg(String CHILLgameBackgroundImg) {
        this.CHILLgameBackgroundImg = CHILLgameBackgroundImg;
    }

    public String getGLITCHgameBackgroundImg() {
        return GLITCHgameBackgroundImg;
    }

    public void setGLITCHgameBackgroundImg(String GLITCHgameBackgroundImg) {
        this.GLITCHgameBackgroundImg = GLITCHgameBackgroundImg;
    }

    public String getUNKNOWNgameBackgroundImg() {
        return UNKNOWNgameBackgroundImg;
    }

    public void setUNKNOWNgameBackgroundImg(String UNKNOWNgameBackgroundImg) {
        this.UNKNOWNgameBackgroundImg = UNKNOWNgameBackgroundImg;
    }

    public String getCHILLgoodBallImg() {
        return CHILLgoodBallImg;
    }

    public void setCHILLgoodBallImg(String CHILLgoodBallImg) {
        this.CHILLgoodBallImg = CHILLgoodBallImg;
    }

    public String getCHILLbadBallImg() {
        return CHILLbadBallImg;
    }

    public void setCHILLbadBallImg(String CHILLbadBallImg) {
        this.CHILLbadBallImg = CHILLbadBallImg;
    }

    public String getCHILLplayer1BallImg() {
        return CHILLplayer1BallImg;
    }

    public void setCHILLplayer1BallImg(String CHILLplayer1BallImg) {
        this.CHILLplayer1BallImg = CHILLplayer1BallImg;
    }

    public String getCHILLplayer2BallImg() {
        return CHILLplayer2BallImg;
    }

    public void setCHILLplayer2BallImg(String CHILLplayer2BallImg) {
        this.CHILLplayer2BallImg = CHILLplayer2BallImg;
    }

    public String getGLITCHgoodBallImg() {
        return GLITCHgoodBallImg;
    }

    public void setGLITCHgoodBallImg(String GLITCHgoodBallImg) {
        this.GLITCHgoodBallImg = GLITCHgoodBallImg;
    }

    public String getGLITCHbadBallImg() {
        return GLITCHbadBallImg;
    }

    public void setGLITCHbadBallImg(String GLITCHbadBallImg) {
        this.GLITCHbadBallImg = GLITCHbadBallImg;
    }

    public String getGLITCHplayer1BallImg() {
        return GLITCHplayer1BallImg;
    }

    public void setGLITCHplayer1BallImg(String GLITCHplayer1BallImg) {
        this.GLITCHplayer1BallImg = GLITCHplayer1BallImg;
    }

    public String getGLITCHplayer2BallImg() {
        return GLITCHplayer2BallImg;
    }

    public void setGLITCHplayer2BallImg(String GLITCHplayer2BallImg) {
        this.GLITCHplayer2BallImg = GLITCHplayer2BallImg;
    }

    public String getUNKNOWNgoodBallImg() {
        return UNKNOWNgoodBallImg;
    }

    public void setUNKNOWNgoodBallImg(String UNKNOWNgoodBallImg) {
        this.UNKNOWNgoodBallImg = UNKNOWNgoodBallImg;
    }

    public String getUNKNOWNbadBallImg() {
        return UNKNOWNbadBallImg;
    }

    public void setUNKNOWNbadBallImg(String UNKNOWNbadBallImg) {
        this.UNKNOWNbadBallImg = UNKNOWNbadBallImg;
    }

    public String getUNKNOWNplayer1BallImg() {
        return UNKNOWNplayer1BallImg;
    }

    public void setUNKNOWNplayer1BallImg(String UNKNOWNplayer1BallImg) {
        this.UNKNOWNplayer1BallImg = UNKNOWNplayer1BallImg;
    }

    public String getUNKNOWNplayer2BallImg() {
        return UNKNOWNplayer2BallImg;
    }

    public void setUNKNOWNplayer2BallImg(String UNKNOWNplayer2BallImg) {
        this.UNKNOWNplayer2BallImg = UNKNOWNplayer2BallImg;
    }

    public String getMenuBackgroundImg() {
        return menuBackgroundImg;
    }

    public void setMenuBackgroundImg(String menuBackgroundImg) {
        this.menuBackgroundImg = menuBackgroundImg;
    }

    public String getGameOverBackgroundImg() {
        return gameOverBackgroundImg;
    }

    public void setGameOverBackgroundImg(String gameOverBackgroundImg) {
        this.gameOverBackgroundImg = gameOverBackgroundImg;
    }

    public String getGameSettingsBackgroundImg() {
        return gameSettingsBackgroundImg;
    }

    public void setGameSettingsBackgroundImg(String gameSettingsBackgroundImg) {
        this.gameSettingsBackgroundImg = gameSettingsBackgroundImg;
    }

    public String getHowToPlayBackgroundImg() {
        return howToPlayBackgroundImg;
    }

    public void setHowToPlayBackgroundImg(String howToPlayBackgroundImg) {
        this.howToPlayBackgroundImg = howToPlayBackgroundImg;
    }

    public String getPauseImg() {
        return pauseImg;
    }

    public void setPauseImg(String pauseImg) {
        this.pauseImg = pauseImg;
    }

    public String getPlayImg() {
        return playImg;
    }

    public void setPlayImg(String playImg) {
        this.playImg = playImg;
    }

    public String getOnPlayImg() {
        return onPlayImg;
    }

    public void setOnPlayImg(String onPlayImg) {
        this.onPlayImg = onPlayImg;
    }

    public String getHowToPlayImg() {
        return howToPlayImg;
    }

    public void setHowToPlayImg(String howToPlayImg) {
        this.howToPlayImg = howToPlayImg;
    }

    public String getOnHowToPlayImg() {
        return onHowToPlayImg;
    }

    public void setOnHowToPlayImg(String onHowToPlayImg) {
        this.onHowToPlayImg = onHowToPlayImg;
    }

    public String getExitImg() {
        return exitImg;
    }

    public void setExitImg(String exitImg) {
        this.exitImg = exitImg;
    }

    public String getOnExitImg() {
        return onExitImg;
    }

    public void setOnExitImg(String onExitImg) {
        this.onExitImg = onExitImg;
    }

    public String getSettingsImg() {
        return settingsImg;
    }

    public void setSettingsImg(String settingsImg) {
        this.settingsImg = settingsImg;
    }

    public String getOnSettingsImg() {
        return onSettingsImg;
    }

    public void setOnSettingsImg(String onSettingsImg) {
        this.onSettingsImg = onSettingsImg;
    }

    public String getCHILLgoodBallPathSound() {
        return CHILLgoodBallPathSound;
    }

    public void setCHILLgoodBallPathSound(String CHILLgoodBallPathSound) {
        this.CHILLgoodBallPathSound = CHILLgoodBallPathSound;
    }

    public String getCHILLbadBallPathSound() {
        return CHILLbadBallPathSound;
    }

    public void setCHILLbadBallPathSound(String CHILLbadBallPathSound) {
        this.CHILLbadBallPathSound = CHILLbadBallPathSound;
    }

    public String getCHILLgameBackgroundPathSound() {
        return CHILLgameBackgroundPathSound;
    }

    public void setCHILLgameBackgroundPathSound(String CHILLgameBackgroundPathSound) {
        this.CHILLgameBackgroundPathSound = CHILLgameBackgroundPathSound;
    }

    public String getGLITCHgoodBallPathSound() {
        return GLITCHgoodBallPathSound;
    }

    public void setGLITCHgoodBallPathSound(String GLITCHgoodBallPathSound) {
        this.GLITCHgoodBallPathSound = GLITCHgoodBallPathSound;
    }

    public String getGLITCHbadBallPathSound() {
        return GLITCHbadBallPathSound;
    }

    public void setGLITCHbadBallPathSound(String GLITCHbadBallPathSound) {
        this.GLITCHbadBallPathSound = GLITCHbadBallPathSound;
    }

    public String getGLITCHgameBackgroundPathSound() {
        return GLITCHgameBackgroundPathSound;
    }

    public void setGLITCHgameBackgroundPathSound(String GLITCHgameBackgroundPathSound) {
        this.GLITCHgameBackgroundPathSound = GLITCHgameBackgroundPathSound;
    }

    public String getUNKNOWNgoodBallPathSound() {
        return UNKNOWNgoodBallPathSound;
    }

    public void setUNKNOWNgoodBallPathSound(String UNKNOWNgoodBallPathSound) {
        this.UNKNOWNgoodBallPathSound = UNKNOWNgoodBallPathSound;
    }

    public String getUNKNOWNbadBallPathSound() {
        return UNKNOWNbadBallPathSound;
    }

    public void setUNKNOWNbadBallPathSound(String UNKNOWNbadBallPathSound) {
        this.UNKNOWNbadBallPathSound = UNKNOWNbadBallPathSound;
    }

    public String getUNKNOWNgameBackgroundPathSound() {
        return UNKNOWNgameBackgroundPathSound;
    }

    public void setUNKNOWNgameBackgroundPathSound(String UNKNOWNgameBackgroundPathSound) {
        this.UNKNOWNgameBackgroundPathSound = UNKNOWNgameBackgroundPathSound;
    }

    public String getClickButtonPathSound() {
        return clickButtonPathSound;
    }

    public void setClickButtonPathSound(String clickButtonPathSound) {
        this.clickButtonPathSound = clickButtonPathSound;
    }

    public String getOnButtonPathSound() {
        return onButtonPathSound;
    }

    public void setOnButtonPathSound(String onButtonPathSound) {
        this.onButtonPathSound = onButtonPathSound;
    }

    public String getBackgroundPathSound() {
        return backgroundPathSound;
    }

    public void setBackgroundPathSound(String backgroundPathSound) {
        this.backgroundPathSound = backgroundPathSound;
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public void setGameStateManager(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

}
