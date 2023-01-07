package Resources;

import Manage.*;

public class Resource {

    private GameStateManager gameStateManager;
    private String CHILLgameBackgroundImg, GLITCHgameBackgroundImg, UNKNOWNgameBackgroundImg,
            CHILLgoodBallImg, CHILLbadBallImg, CHILLplayer1BallImg, CHILLplayer2BallImg,
            GLITCHgoodBallImg, GLITCHbadBallImg, GLITCHplayer1BallImg, GLITCHplayer2BallImg,
            UNKNOWNgoodBallImg, UNKNOWNbadBallImg, UNKNOWNplayer1BallImg, UNKNOWNplayer2BallImg,
            gameMenuBackgroundImg, gameOverBackgroundImg, gameSettingsBackgroundImg, gameHowToPlayBackgroundImg, pauseImg,
            cursorImg, cursorLuImg, cursorUImg, cursorRuImg, cursorLImg, cursorCImg, cursorRImg, cursorLdImg, cursorDImg, cursorRdImg,
            playButton, onPlayButton, howToPlayButton, onHowToPlayButton, exitButton, onExitButton, settingsButton, onSettingsButton,
            lobbyButton, onLobbyButton, creatButton, onCreatButton, joinButton, onJoinButton, backButton, onBackButton,
            replayButton, onReplayButton, menuButton, onMenuButton, gameOverLost, gameOverWon, plusButton, minusButton;

    private String CHILLgoodBallPathSound, CHILLbadBallPathSound, CHILLgameBackgroundPathSound,
            GLITCHgoodBallPathSound, GLITCHbadBallPathSound, GLITCHgameBackgroundPathSound,
            UNKNOWNgoodBallPathSound, UNKNOWNbadBallPathSound, UNKNOWNgameBackgroundPathSound,
            clickButtonPathSound, backgroundPathSound;

    public Resource(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        CHILLgameBackgroundImg = "src/Resources/pictures/original.gif";
        GLITCHgameBackgroundImg = "src/Resources/pictures/gameGlitch.gif";
        UNKNOWNgameBackgroundImg = "src/Resources/pictures/backgroundUnknown.gif";
        CHILLgoodBallImg = "src/Resources/pictures/blue.gif";
        CHILLbadBallImg = "src/Resources/pictures/red.gif";
        CHILLplayer1BallImg = "src/Resources/pictures/pause.gif";
        CHILLplayer2BallImg = "src/Resources/pictures/enemy.png";
        GLITCHgoodBallImg = "src/Resources/pictures/power.png";
        GLITCHbadBallImg = "src/Resources/pictures/red.png";
        GLITCHplayer1BallImg = "src/Resources/pictures/ball.png";
        GLITCHplayer2BallImg = "src/Resources/pictures/enemy.png";
        UNKNOWNgoodBallImg = "src/Resources/pictures/greenUnknown.png";
        UNKNOWNbadBallImg = "src/Resources/pictures/redUnknown.png";
        UNKNOWNplayer1BallImg = "src/Resources/pictures/playerUnknown.gif";
        UNKNOWNplayer2BallImg = "src/Resources/pictures/enemy.png";
        gameMenuBackgroundImg = "src/Resources/pictures/bgMenu.gif";
        gameOverBackgroundImg = "src/Resources/pictures/space.png";
        gameSettingsBackgroundImg = "src/Resources/pictures/original.gif";
        gameHowToPlayBackgroundImg = "src/Resources/pictures/original.gif";
        pauseImg = "src/Resources/pictures/pauseScreen.png";

        cursorImg = "src/Resources/pictures/cursor.gif";
        cursorLuImg = "src/Resources/pictures/lu.png";
        cursorUImg = "src/Resources/pictures/u.png";
        cursorRuImg = "src/Resources/pictures/ru.png";
        cursorLImg = "src/Resources/pictures/l.png";
        cursorCImg = "src/Resources/pictures/c.png";
        cursorRImg = "src/Resources/pictures/r.png";
        cursorLdImg = "src/Resources/pictures/ld.png";
        cursorDImg = "src/Resources/pictures/d.png";
        cursorRdImg = "src/Resources/pictures/rd.png";

        playButton = "src/Resources/pictures/playButton.png";
        onPlayButton = "src/Resources/pictures/onplayButton.png";
        howToPlayButton = "src/Resources/pictures/howtoplayButton.png";
        onHowToPlayButton = "src/Resources/pictures/onhowtoplayButton.png";
        exitButton = "src/Resources/pictures/exitButton.png";
        onExitButton = "src/Resources/pictures/onexitButton.png";
        settingsButton = "src/Resources/pictures/settingsButton.png";
        onSettingsButton = "src/Resources/pictures/onsettingsButton.png";
        lobbyButton = "src/Resources/pictures/lobbyButton.png";
        onLobbyButton = "src/Resources/pictures/onlobbyButton.png";
        creatButton = "src/Resources/pictures/creatButton.png";
        onCreatButton = "src/Resources/pictures/oncreatButton.png";
        joinButton = "src/Resources/pictures/joinButton.png";
        onJoinButton = "src/Resources/pictures/onjoinButton.png";
        backButton = "src/Resources/pictures/backButton.png";
        onBackButton = "src/Resources/pictures/onbackButton.png";
        replayButton = "src/Resources/pictures/replayButton.png";
        onReplayButton = "src/Resources/pictures/onreplayButton.png";
        menuButton = "src/Resources/pictures/menuButton.png";
        onMenuButton = "src/Resources/pictures/onmenuButton.png";
        gameOverLost = "src/Resources/pictures/gameOverLost.png";
        gameOverWon = "src/Resources/pictures/gameOverWon.png";
        plusButton = "src/Resources/pictures/plus.png";
        minusButton = "src/Resources/pictures/minus.png";

        CHILLgoodBallPathSound = "src/Resources/Sounds/good.wav";
        CHILLbadBallPathSound = "src/Resources/Sounds/bad.wav";
        CHILLgameBackgroundPathSound = "src/Resources/Sounds/Eminem_Stan.wav";
        GLITCHgoodBallPathSound = "src/Resources/Sounds/goodGlitch.wav";;
        GLITCHbadBallPathSound = "src/Resources/Sounds/badGlitch.wav";;
        GLITCHgameBackgroundPathSound = "src/Resources/Sounds/groove.wav";
        UNKNOWNgoodBallPathSound = "src/Resources/Sounds/goodUnknown.wav";
        UNKNOWNbadBallPathSound = "src/Resources/Sounds/badUnknown.wav";
        UNKNOWNgameBackgroundPathSound = "src/Resources/Sounds/musicUnknown.wav";

        clickButtonPathSound = "src/Resources/Sounds/click.wav";
        backgroundPathSound = "src/Resources/Sounds/background.wav";

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

    public String getGameMenuBackgroundImg() {
        return gameMenuBackgroundImg;
    }

    public void setGameMenuBackgroundImg(String gameMenuBackgroundImg) {
        this.gameMenuBackgroundImg = gameMenuBackgroundImg;
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

    public String getGameHowToPlayBackgroundImg() {
        return gameHowToPlayBackgroundImg;
    }

    public void setGameHowToPlayBackgroundImg(String gameHowToPlayBackgroundImg) {
        this.gameHowToPlayBackgroundImg = gameHowToPlayBackgroundImg;
    }

    public String getPauseImg() {
        return pauseImg;
    }

    public void setPauseImg(String pauseImg) {
        this.pauseImg = pauseImg;
    }

    public String getCursorLuImg() {
        return cursorLuImg;
    }

    public void setCursorLuImg(String cursorLuImg) {
        this.cursorLuImg = cursorLuImg;
    }

    public String getCursorUImg() {
        return cursorUImg;
    }

    public void setCursorUImg(String cursorUImg) {
        this.cursorUImg = cursorUImg;
    }

    public String getCursorRuImg() {
        return cursorRuImg;
    }

    public void setCursorRuImg(String cursorRuImg) {
        this.cursorRuImg = cursorRuImg;
    }

    public String getCursorLImg() {
        return cursorLImg;
    }

    public void setCursorLImg(String cursorLImg) {
        this.cursorLImg = cursorLImg;
    }

    public String getCursorCImg() {
        return cursorCImg;
    }

    public void setCursorCImg(String cursorCImg) {
        this.cursorCImg = cursorCImg;
    }

    public String getCursorRImg() {
        return cursorRImg;
    }

    public void setCursorRImg(String cursorRImg) {
        this.cursorRImg = cursorRImg;
    }

    public String getCursorLdImg() {
        return cursorLdImg;
    }

    public void setCursorLdImg(String cursorLdImg) {
        this.cursorLdImg = cursorLdImg;
    }

    public String getCursorDImg() {
        return cursorDImg;
    }

    public void setCursorDImg(String cursorDImg) {
        this.cursorDImg = cursorDImg;
    }

    public String getCursorRdImg() {
        return cursorRdImg;
    }

    public void setCursorRdImg(String cursorRdImg) {
        this.cursorRdImg = cursorRdImg;
    }

    public String getPlayButton() {
        return playButton;
    }

    public void setPlayButton(String playButton) {
        this.playButton = playButton;
    }

    public String getOnPlayButton() {
        return onPlayButton;
    }

    public void setOnPlayButton(String onPlayButton) {
        this.onPlayButton = onPlayButton;
    }

    public String getHowToPlayButton() {
        return howToPlayButton;
    }

    public void setHowToPlayButton(String howToPlayButton) {
        this.howToPlayButton = howToPlayButton;
    }

    public String getOnHowToPlayButton() {
        return onHowToPlayButton;
    }

    public void setOnHowToPlayButton(String onHowToPlayButton) {
        this.onHowToPlayButton = onHowToPlayButton;
    }

    public String getExitButton() {
        return exitButton;
    }

    public void setExitButton(String exitButton) {
        this.exitButton = exitButton;
    }

    public String getOnExitButton() {
        return onExitButton;
    }

    public void setOnExitButton(String onExitButton) {
        this.onExitButton = onExitButton;
    }

    public String getSettingsButton() {
        return settingsButton;
    }

    public void setSettingsButton(String settingsButton) {
        this.settingsButton = settingsButton;
    }

    public String getOnSettingsButton() {
        return onSettingsButton;
    }

    public void setOnSettingsButton(String onSettingsButton) {
        this.onSettingsButton = onSettingsButton;
    }

    public String getReplayButton() {
        return replayButton;
    }

    public void setReplayButton(String replayButton) {
        this.replayButton = replayButton;
    }

    public String getOnReplayButton() {
        return onReplayButton;
    }

    public void setOnReplayButton(String onReplayButton) {
        this.onReplayButton = onReplayButton;
    }

    public String getMenuButton() {
        return menuButton;
    }

    public void setMenuButton(String menuButton) {
        this.menuButton = menuButton;
    }

    public String getOnMenuButton() {
        return onMenuButton;
    }

    public void setOnMenuButton(String onMenuButton) {
        this.onMenuButton = onMenuButton;
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

    public String getCursorImg() {
        return cursorImg;
    }

    public void setCursorImg(String cursorImg) {
        this.cursorImg = cursorImg;
    }

    public String getLobbyButton() {
        return lobbyButton;
    }

    public void setLobbyButton(String lobbyButton) {
        this.lobbyButton = lobbyButton;
    }

    public String getOnLobbyButton() {
        return onLobbyButton;
    }

    public void setOnLobbyButton(String onLobbyButton) {
        this.onLobbyButton = onLobbyButton;
    }

    public String getCreatButton() {
        return creatButton;
    }

    public void setCreatButton(String creatButton) {
        this.creatButton = creatButton;
    }

    public String getOnCreatButton() {
        return onCreatButton;
    }

    public void setOnCreatButton(String onCreatButton) {
        this.onCreatButton = onCreatButton;
    }

    public String getJoinButton() {
        return joinButton;
    }

    public void setJoinButton(String joinButton) {
        this.joinButton = joinButton;
    }

    public String getOnJoinButton() {
        return onJoinButton;
    }

    public void setOnJoinButton(String onJoinButton) {
        this.onJoinButton = onJoinButton;
    }

    public String getBackButton() {
        return backButton;
    }

    public void setBackButton(String backButton) {
        this.backButton = backButton;
    }

    public String getOnBackButton() {
        return onBackButton;
    }

    public void setOnBackButton(String onBackButton) {
        this.onBackButton = onBackButton;
    }

    public String getGameOverLost() {
        return gameOverLost;
    }

    public void setGameOverLost(String gameOverLost) {
        this.gameOverLost = gameOverLost;
    }

    public String getGameOverWon() {
        return gameOverWon;
    }

    public void setGameOverWon(String gameOverWon) {
        this.gameOverWon = gameOverWon;
    }

    public String getPlusButton() {
        return plusButton;
    }

    public void setPlusButton(String plusButton) {
        this.plusButton = plusButton;
    }

    public String getMinusButton() {
        return minusButton;
    }

    public void setMinusButton(String minusButton) {
        this.minusButton = minusButton;
    }
}
