package Manage;
import Music.*;
import Panels.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class GameStateManager {

    private GameState currentGameState, previousGameState;
    private JFrame f;
    private MusicControler musicControler;
    private Fps fps;
    private GameMode currentGameMode;
    private Resource resource;
    private int mouseX, mouseY;

    private boolean changedPanel = true, changedMode = true;
    private GameMultiplayer gameMultiplayer;
    private GamePanel gamePanel;
    private GameMenu gameMenu;
    private GameHowToPlay gameHowToPlay;
    private GameOver gameOver;
    private GameSettings gameSettings;


    public GameStateManager() {

        setGameResources();
        setStartGameStates();
        setFrame();
        setFps();
        setMusicControler();
        setListeners();
    }

    private void setGameResources() {
        currentGameMode = GameMode.CHILL;
        resource = new Resource(this);
    }

    private void setStartGameStates() {
        currentGameState = GameState.MENU;
        previousGameState = null;
    }

    private void setListeners() {
        f.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (currentGameState == GameState.PLAY)
                        setCurrentGameState(GameState.MENU);
                    else if (currentGameState == GameState.GAMEOVER)
                        setCurrentGameState(GameState.MENU);
                    else if (currentGameState == GameState.SETTINGS)
                        setCurrentGameState(GameState.MENU);
                    else if (currentGameState == GameState.HOWTOPLAY)
                        setCurrentGameState(GameState.MENU);
                    else if (currentGameState == GameState.MENU)
                        System.exit(1);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (currentGameState == GameState.PLAY)
                        gamePanel.pause();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (currentGameState == GameState.MENU || currentGameState == GameState.GAMEOVER)
                        setCurrentGameState(GameState.PLAY);
                }
            }
        });

        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                if (GameState.MENU == currentGameState) {
                    if (mouseX > gameMenu.getxPlay() && mouseX < gameMenu.getxPlay() + gameMenu.getwPlay() && mouseY > gameMenu.getyPlay() && mouseY < gameMenu.getyPlay() + gameMenu.gethPlay())
                        setCurrentGameState(GameState.PLAY);
                    if (mouseX > gameMenu.getxHowToPlay() && mouseX < gameMenu.getxHowToPlay() + gameMenu.getwHowToPlay() && mouseY > gameMenu.getyHowToPlay() && mouseY < gameMenu.getyHowToPlay() + gameMenu.gethHowToPlay())
                        setCurrentGameState(GameState.HOWTOPLAY);
                    if (mouseX > gameMenu.getxSettings() && mouseX < gameMenu.getxSettings() + gameMenu.getwSettings() && mouseY > gameMenu.getySettings() && mouseY < gameMenu.getySettings() + gameMenu.gethSettings())
                        setCurrentGameState(GameState.SETTINGS);
                    if (mouseX > gameMenu.getxExit() && mouseX < gameMenu.getxExit() + gameMenu.getwExit() && mouseY > gameMenu.getyExit() && mouseY < gameMenu.getyExit() + gameMenu.gethExit())
                        System.exit(1);
                }
            }
        });

        f.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
    }

    private void setMusicControler() {
        musicControler = new MusicControler(resource.getgoodBallPathSound(), resource.getbadBallPathSound(), resource.getgameBackgroundPathSound(), this);
    }

    private void setFrame() {
        f = new JFrame("Circle Eater by Gad");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setUndecorated(true);
        hideMouseCursor();

    }

    public void setFps() {
        fps = new Fps(this);
        fps.start();
    }

    public void changePanel() {
        switch (currentGameState) {
            case MENU: {
                setMenuPanel();
                break;
            }
            case PLAY: {
                setGamePanel();
                break;
            }
            case HOWTOPLAY: {
                setHowToPlayPanel();
                break;
            }
            case GAMEOVER: {
                setGameOverPanel();
                break;
            }
            case SETTINGS: {
                setSettingsPanel();
                break;
            }
        }
    }

    private void setMenuPanel() {
        if (previousGameState != null) {
            if (previousGameState == GameState.PLAY)
                f.remove(gamePanel);
            else if (previousGameState == GameState.GAMEOVER)
                f.remove(gameOver);
            else if (previousGameState == GameState.SETTINGS)
                f.remove(gameSettings);
            else if (previousGameState == GameState.HOWTOPLAY)
                f.remove(gameHowToPlay);
        }
        gameMenu = new GameMenu(this);
        setNewPanel(gameMenu);
    }

    private void setGamePanel() {
        removeGamePreviousPanels();
        gamePanel = new GamePanel(this);
        setNewPanel(gamePanel);
    }

    public void removeGamePreviousPanels() {
        if (previousGameState != null) {
            if (previousGameState == GameState.MENU)
                f.remove(gameMenu);
            else if (previousGameState == GameState.GAMEOVER)
                f.remove(gameOver);
        }
    }

    private void setHowToPlayPanel() {
        f.remove(gameMenu);
        gameHowToPlay = new GameHowToPlay(this);
        setNewPanel(gameHowToPlay);
    }

    private void setGameOverPanel() {
        f.remove(gamePanel);
        gameOver = new GameOver(this);
        setNewPanel(gameOver);
    }

    private void setSettingsPanel() {
        f.remove(gameMenu);
        gameSettings = new GameSettings(this);
        setNewPanel(gameSettings);
    }

    public void setNewPanel(JPanel p) {
        p.setVisible(true);
        p.setFocusable(true);
        f.add(p);
        f.setVisible(true);
        f.setFocusable(true);
    }

    public void hideMouseCursor() {
        //Transparent 16 x 16 pixel cursor image.
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        // Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        // Set the blank cursor to the JPanel.
        f.setCursor(blankCursor);
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(GameState currentGameState) {
        previousGameState = this.currentGameState;
        this.currentGameState = currentGameState;
        this.changedPanel = true;
    }


    public GameMode getCurrentGameMode() {
        return currentGameMode;
    }

    public void setCurrentGameMode(GameMode currentGameMode) {
        this.currentGameMode = currentGameMode;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public MusicControler getMusicControler() {
        return musicControler;
    }

    public void setMusicControler(MusicControler musicControler) {
        this.musicControler = musicControler;
    }

    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    public boolean isChangedPanel() {
        return changedPanel;
    }

    public void setChangedPanel(boolean changedPanel) {
        this.changedPanel = changedPanel;
    }

    public boolean isChangedMode() {
        return changedMode;
    }

    public void setChangedMode(boolean changedMode) {
        this.changedMode = changedMode;
    }

    public GameState getPreviousGameState() {
        return previousGameState;
    }

    public void setPreviousGameState(GameState previousGameState) {
        this.previousGameState = previousGameState;
    }

    public JFrame getF() {
        return f;
    }

    public void setF(JFrame f) {
        this.f = f;
    }

    public Fps getFps() {
        return fps;
    }

    public void setFps(Fps fps) {
        this.fps = fps;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public void setGameMenu(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
    }

    public GameHowToPlay getGameHowToPlay() {
        return gameHowToPlay;
    }

    public void setGameHowToPlay(GameHowToPlay gameHowToPlay) {
        this.gameHowToPlay = gameHowToPlay;
    }

    public GameOver getGameOver() {
        return gameOver;
    }

    public void setGameOver(GameOver gameOver) {
        this.gameOver = gameOver;
    }

    public GameSettings getGameSettings() {
        return gameSettings;
    }

    public void setGameSettings(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

}