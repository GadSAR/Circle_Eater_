package Manage;

import Multiplayer.Client;
import Multiplayer.Server;
import Music.*;
import Panels.*;
import Resources.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameStateManager {

    private GameState currentGameState, previousGameState;
    private JFrame f;
    private MusicController musicController;
    private GameMode currentGameMode;
    private Integer[] defaultsSettings = {2, 0, 60, 30};
    private int speedLevel = defaultsSettings[0], mode = defaultsSettings[1], vecSize = defaultsSettings[2], widthStart = defaultsSettings[3];
    private Resource resource;
    private int mouseX, mouseY;
    private Image cursor;

    private boolean changedMode = true;
    private char playerType = 0;
    private int lastPlayerWon;

    private GameMultiplayer gameMultiplayer;
    private Client client;
    private Server server;
    private GamePanel gamePanel;
    private GameMenu gameMenu;
    private GameHowToPlay gameHowToPlay;
    private GameOver gameOver;
    private GameSettings gameSettings;


    public GameStateManager() {

        setGameResources();
        setFrame();
        setStartGameStates();
        setFps();
        setMusicController();
        setListeners();
        musicController.getBackground().setFlag(true);
    }

    private void setGameResources() {
        setMode(mode);
        resource = new Resource(this);
        cursor = (new ImageIcon(resource.getCursorImg())).getImage();
    }

    private void setStartGameStates() {
        setCurrentGameState(GameState.MENU);
    }

    private void setListeners() {
        f.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE:
                        if (currentGameState == GameState.GAME) {
                            try {
                                gamePanel.gameOver(-1);
                            } catch (IOException | InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        } else if (currentGameState == GameState.GAMEOVER)
                            setCurrentGameState(GameState.MENU);
                        else if (currentGameState == GameState.SETTINGS)
                            setCurrentGameState(GameState.MENU);
                        else if (currentGameState == GameState.HOWTOPLAY)
                            setCurrentGameState(GameState.MENU);
                        else if (currentGameState == GameState.MULTIPLAYER)
                            setCurrentGameState(GameState.MENU);
                        else if (currentGameState == GameState.MENU)
                            System.exit(1);
                        break;
                    case KeyEvent.VK_SPACE:
                        if (currentGameState == GameState.GAME)
                            if (playerType != 2)
                                gamePanel.setMoveFlag(!gamePanel.getMoveFlag());
                        break;
                    case KeyEvent.VK_ENTER:
                        if (currentGameState == GameState.MENU || currentGameState == GameState.GAMEOVER)
                            setCurrentGameState(GameState.GAME);
                        break;
                    case KeyEvent.VK_LEFT:
                        if (currentGameState == GameState.GAME) {
                            mouseX = gamePanel.getPlayer().getX() - 60;
                            mouseY = gamePanel.getPlayer().getY() + gamePanel.getPlayer().getWidth() / 2;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (currentGameState == GameState.GAME) {
                            mouseX = gamePanel.getPlayer().getX() + 60;
                            mouseY = gamePanel.getPlayer().getY() + gamePanel.getPlayer().getWidth() / 2;
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (currentGameState == GameState.GAME) {
                            mouseX = gamePanel.getPlayer().getX() + gamePanel.getPlayer().getWidth() / 2;
                            mouseY = gamePanel.getPlayer().getY() - 60;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (currentGameState == GameState.GAME) {
                            mouseX = gamePanel.getPlayer().getX() + gamePanel.getPlayer().getWidth() / 2;
                            mouseY = gamePanel.getPlayer().getY() + 60;
                        }
                        break;
                }
            }
        });

        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                clickSound();

                switch (currentGameState) {
                    case MENU:
                        if (mouseIn(gameMenu.getxPlay(), gameMenu.getwPlay(), gameMenu.getyPlay(), gameMenu.gethPlay())) {
                            playerType = 0;
                            setCurrentGameState(GameState.GAME);
                        } else if (mouseIn(gameMenu.getxLobby(), gameMenu.getwLobby(), gameMenu.getyLobby(), gameMenu.gethLobby()))
                            setCurrentGameState(GameState.MULTIPLAYER);
                        else if (mouseIn(gameMenu.getxSettings(), gameMenu.getwSettings(), gameMenu.getySettings(), gameMenu.gethSettings()))
                            setCurrentGameState(GameState.SETTINGS);
                        else if (mouseIn(gameMenu.getxHowToPlay(), gameMenu.getwHowToPlay(), gameMenu.getyHowToPlay(), gameMenu.gethHowToPlay()))
                            setCurrentGameState(GameState.HOWTOPLAY);
                        else if (mouseIn(gameMenu.getxExit(), gameMenu.getwExit(), gameMenu.getyExit(), gameMenu.gethExit()))
                            System.exit(1);
                        break;
                    case SETTINGS:
                        if (mouseIn(gameSettings.getxRestore(), gameSettings.getwRestore(), gameSettings.getyRestore(), gameSettings.gethRestore()))
                            gameSettings.restoreDefaultSettings();
                        else if (mouseIn(gameSettings.getxPlus(), gameSettings.getwPlusMinus(), gameSettings.getyText1(), gameSettings.gethPlusMinus()))
                            gameSettings.increaseSpeed();
                        else if (mouseIn(gameSettings.getxMinus(), gameSettings.getwPlusMinus(), gameSettings.getyText1(), gameSettings.gethPlusMinus()))
                            gameSettings.decreaseSpeed();
                        else if (mouseIn(gameSettings.getxPlus(), gameSettings.getwPlusMinus(), gameSettings.getyText2(), gameSettings.gethPlusMinus()))
                            gameSettings.increaseMode();
                        else if (mouseIn(gameSettings.getxMinus(), gameSettings.getwPlusMinus(), gameSettings.getyText2(), gameSettings.gethPlusMinus()))
                            gameSettings.decreaseMode();
                        else if (mouseIn(gameSettings.getxPlus(), gameSettings.getwPlusMinus(), gameSettings.getyText3(), gameSettings.gethPlusMinus()))
                            gameSettings.increaseVecSize();
                        else if (mouseIn(gameSettings.getxMinus(), gameSettings.getwPlusMinus(), gameSettings.getyText3(), gameSettings.gethPlusMinus()))
                            gameSettings.decreaseVecSize();
                        else if (mouseIn(gameSettings.getxPlus(), gameSettings.getwPlusMinus(), gameSettings.getyText4(), gameSettings.gethPlusMinus()))
                            gameSettings.increaseWidthStart();
                        else if (mouseIn(gameSettings.getxMinus(), gameSettings.getwPlusMinus(), gameSettings.getyText4(), gameSettings.gethPlusMinus()))
                            gameSettings.decreaseWidthStart();
                        else if (mouseIn(gameSettings.getxBack(), gameSettings.getwBack(), gameSettings.getyBack(), gameSettings.gethBack()))
                            setCurrentGameState(GameState.MENU);
                        break;
                    case MULTIPLAYER:
                        if (mouseIn(gameMultiplayer.getxCreate(), gameMultiplayer.getwCreate(), gameMultiplayer.getyCreate(), gameMultiplayer.gethCreate())) {
                            playerType = 1;
                            try {
                                newServer();
                            } catch (IOException | InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        } else if (mouseIn(gameMultiplayer.getxJoin(), gameMultiplayer.getwJoin(), gameMultiplayer.getyJoin(), gameMultiplayer.gethJoin())) {
                            playerType = 2;
                            try {
                                newClient(gameMultiplayer.getJoinIpAddress().getText());
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        } else if (mouseIn(gameMultiplayer.getxBack(), gameMultiplayer.getwBack(), gameMultiplayer.getyBack(), gameMultiplayer.gethBack()))
                            setCurrentGameState(GameState.MENU);
                        break;
                    case GAMEOVER:
                        if (mouseIn(gameOver.getxReplay(), gameOver.getwReplay(), gameOver.getyReplay(), gameOver.gethReplay())) {
                            if (playerType == 0)
                                setCurrentGameState(GameState.GAME);
                            else if (playerType == 1) {
                                try {
                                    newServer();
                                } catch (IOException | InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } else if (playerType == 2) {
                                try {
                                    newClient(gameMultiplayer.getJoinIpAddress().getText());
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                        if (mouseIn(gameOver.getxMenu(), gameOver.getwMenu(), gameOver.getyMenu(), gameOver.gethMenu()))
                            setCurrentGameState(GameState.MENU);
                        break;
                    case HOWTOPLAY:
                        if (mouseIn(gameHowToPlay.getxBack(), gameHowToPlay.getwBack(), gameHowToPlay.getyBack(), gameHowToPlay.gethBack()))
                            setCurrentGameState(GameState.MENU);
                        break;
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

    public boolean mouseIn(int x, int w, int y, int h) {
        return (mouseX > x && mouseX < x + w && mouseY > y && mouseY < y + h);
    }

    public void drawCursor(Graphics g) {
        g.drawImage(cursor, mouseX - 10, mouseY, 30, 30, null);
    }

    private void newServer() throws IOException, InterruptedException {
        server = new Server(this);
        server.start();
    }

    private void newClient(String ipAddress) throws Exception {
        client = new Client(this, ipAddress);
        client.start();
    }

    public void setMusicController() {
        musicController = new MusicController(resource.getgoodBallPathSound(), resource.getbadBallPathSound(), resource.getgameBackgroundPathSound(), resource.getClickButtonPathSound(), resource.getBackgroundPathSound());
        musicController.getBackground().setFlag(true);
    }

    private void setFrame() {
        f = new JFrame("Circle Eater by Gad");
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setUndecorated(true);
        hideMouseCursor();

    }

    public void setFps() {
        Fps fps = new Fps(this);
        fps.start();
    }

    public void changePanel(GameState state) {
        switch (state) {
            case MENU: {
                setMenuPanel();
                break;
            }
            case GAME: {
                setGamePanel();
                break;
            }
            case MULTIPLAYER: {
                setMultiplayerPanel();
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

    private void setMultiplayerPanel() {
        f.remove(gameMenu);
        gameMultiplayer = new GameMultiplayer(this);
        setNewPanel(gameMultiplayer);
    }

    private void setMenuPanel() {
        if (previousGameState != null) {
            if (previousGameState == GameState.GAME) {
                musicController.getBackground().setFlag(true);
                f.remove(gamePanel);
            } else if (previousGameState == GameState.MULTIPLAYER)
                f.remove(gameMultiplayer);
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
        gamePanel = new GamePanel(this, playerType);
        setNewPanel(gamePanel);
    }

    public void removeGamePreviousPanels() {
        musicController.getBackground().stopWav();
        if (previousGameState != null) {
            if (previousGameState == GameState.MENU)
                f.remove(gameMenu);
            else if (previousGameState == GameState.GAMEOVER)
                f.remove(gameOver);
            else if (previousGameState == GameState.MULTIPLAYER)
                f.remove(gameMultiplayer);
        }
    }

    private void setHowToPlayPanel() {
        f.remove(gameMenu);
        gameHowToPlay = new GameHowToPlay(this);
        setNewPanel(gameHowToPlay);
    }

    private void setGameOverPanel() {
        musicController.getBackground().setFlag(true);
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

    public void setMode(int mode) {
        this.mode = mode;
        switch (mode) {
            case 0:
                currentGameMode = GameMode.UNKNOWN;
                break;
            case 1:
                currentGameMode = GameMode.CHILL;
                break;
            case 2:
                currentGameMode = GameMode.GLITCH;
                break;
        }
        changedMode = true;
    }

    public void restoreSettings() {
        setSpeedLevel(defaultsSettings[0]);
        setMode(defaultsSettings[1]);
        setVecSize(defaultsSettings[2]);
        setWidthStart(defaultsSettings[3]);
    }

    public void setCurrentGameState(GameState currentGameState) {
        previousGameState = this.currentGameState;
        changePanel(currentGameState);
        this.currentGameState = currentGameState;
    }

    public void clickSound() {
        musicController.getClick().setFlag(true);
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public GameMode getCurrentGameMode() {
        return currentGameMode;
    }

    public Resource getResource() {
        return resource;
    }

    public MusicController getMusicController() {
        return musicController;
    }

    public void setMusicController(MusicController musicController) {
        this.musicController = musicController;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public boolean isChangedMode() {
        return changedMode;
    }

    public void setChangedMode(boolean changedMode) {
        this.changedMode = changedMode;
    }

    public JFrame getF() {
        return f;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public GameMultiplayer getGameMultiplayer() {
        return gameMultiplayer;
    }

    public Client getClient() {
        return client;
    }

    public Server getServer() {
        return server;
    }

    public GameHowToPlay getGameHowToPlay() {
        return gameHowToPlay;
    }

    public GameOver getGameOver() {
        return gameOver;
    }

    public GameSettings getGameSettings() {
        return gameSettings;
    }

    public char getPlayerType() {
        return playerType;
    }

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        this.speedLevel = speedLevel;
    }

    public void setLastPlayerWon(int playerNum) {
        lastPlayerWon = playerNum;
    }

    public int getLastPlayerWon() {
        return lastPlayerWon;
    }

    public int getMode() {
        return mode;
    }

    public int getVecSize() {
        return vecSize;
    }

    public void setVecSize(int vecSize) {
        this.vecSize = vecSize;
    }

    public int getWidthStart() {
        return widthStart;
    }

    public void setWidthStart(int widthStart) {
        this.widthStart = widthStart;
    }


}