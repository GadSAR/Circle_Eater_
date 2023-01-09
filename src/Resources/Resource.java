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
        GLITCHbadBallImg = "src/Resources/pictures/red.gif";
        GLITCHplayer1BallImg = "src/Resources/pictures/ball.png";
        GLITCHplayer2BallImg = "src/Resources/pictures/enemy.png";
        UNKNOWNgoodBallImg = "src/Resources/pictures/greenUnknown.png";
        UNKNOWNbadBallImg = "src/Resources/pictures/redUnknown.png";
        UNKNOWNplayer1BallImg = "src/Resources/pictures/playerUnknown.gif";
        UNKNOWNplayer2BallImg = "src/Resources/pictures/enemy.png";
        gameMenuBackgroundImg = "src/Resources/pictures/bgMenu.gif";
        gameOverBackgroundImg = "src/Resources/pictures/bgMenu.gif";
        gameSettingsBackgroundImg = "src/Resources/pictures/bgMenu.gif";
        gameHowToPlayBackgroundImg = "src/Resources/pictures/bgHTP.gif";
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
        GLITCHgoodBallPathSound = "src/Resources/Sounds/goodGlitch.wav";
        GLITCHbadBallPathSound = "src/Resources/Sounds/badGlitch.wav";
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

    public String getGameMenuBackgroundImg() {
        return gameMenuBackgroundImg;
    }

    public String getGameHowToPlayBackgroundImg() {
        return gameHowToPlayBackgroundImg;
    }

    public String getPauseImg() {
        return pauseImg;
    }

    public String getCursorLuImg() {
        return cursorLuImg;
    }

    public String getCursorUImg() {
        return cursorUImg;
    }

    public String getCursorRuImg() {
        return cursorRuImg;
    }

    public String getCursorLImg() {
        return cursorLImg;
    }

    public String getCursorCImg() {
        return cursorCImg;
    }

    public String getCursorRImg() {
        return cursorRImg;
    }

    public String getCursorLdImg() {
        return cursorLdImg;
    }

    public String getCursorDImg() {
        return cursorDImg;
    }

    public String getCursorRdImg() {
        return cursorRdImg;
    }

    public String getPlayButton() {
        return playButton;
    }

    public String getOnPlayButton() {
        return onPlayButton;
    }

    public String getHowToPlayButton() {
        return howToPlayButton;
    }

    public String getOnHowToPlayButton() {
        return onHowToPlayButton;
    }

    public String getExitButton() {
        return exitButton;
    }

    public String getOnExitButton() {
        return onExitButton;
    }

    public String getSettingsButton() {
        return settingsButton;
    }

    public String getOnSettingsButton() {
        return onSettingsButton;
    }

    public String getReplayButton() {
        return replayButton;
    }

    public String getOnReplayButton() {
        return onReplayButton;
    }

    public String getMenuButton() {
        return menuButton;
    }

    public String getOnMenuButton() {
        return onMenuButton;
    }

    public String getClickButtonPathSound() {
        return clickButtonPathSound;
    }

    public String getBackgroundPathSound() {
        return backgroundPathSound;
    }

    public String getCursorImg() {
        return cursorImg;
    }

    public String getLobbyButton() {
        return lobbyButton;
    }

    public String getOnLobbyButton() {
        return onLobbyButton;
    }

    public String getCreatButton() {
        return creatButton;
    }

    public String getOnCreatButton() {
        return onCreatButton;
    }

    public String getJoinButton() {
        return joinButton;
    }

    public String getOnJoinButton() {
        return onJoinButton;
    }

    public String getBackButton() {
        return backButton;
    }

    public String getOnBackButton() {
        return onBackButton;
    }

    public String getGameOverLost() {
        return gameOverLost;
    }

    public String getGameOverWon() {
        return gameOverWon;
    }

    public String getPlusButton() {
        return plusButton;
    }

    public String getMinusButton() {
        return minusButton;
    }

    public String getGameOverBackgroundImg() {
        return gameOverBackgroundImg;
    }

    public String getGameSettingsBackgroundImg() {
        return gameSettingsBackgroundImg;
    }
}
