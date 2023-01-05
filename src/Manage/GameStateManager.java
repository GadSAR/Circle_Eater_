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
    private Fps fps;
    private GameMode currentGameMode;
    private Integer[] defaultsSettings = {2,0,60,30};
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
    }

    private void setGameResources() {
        currentGameMode = GameMode.CHILL;
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
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    if (currentGameState == GameState.GAME) {
                        try {
                            gamePanel.gameOver(playerType);
                        } catch (IOException | InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else if (currentGameState == GameState.GAMEOVER)
                        setCurrentGameState(GameState.MENU);
                    else if (currentGameState == GameState.SETTINGS)
                        setCurrentGameState(GameState.MENU);
                    else if (currentGameState == GameState.HOWTOPLAY)
                        setCurrentGameState(GameState.MENU);
                    else if (currentGameState == GameState.MULTIPLAYER)
                        setCurrentGameState(GameState.MENU);
                    else if (currentGameState == GameState.MENU)
                        System.exit(1);
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (currentGameState == GameState.GAME)
                        if (playerType != 2)
                            gamePanel.setMoveFlag(!gamePanel.getMoveFlag());
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (currentGameState == GameState.MENU || currentGameState == GameState.GAMEOVER)
                        setCurrentGameState(GameState.GAME);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (currentGameState == GameState.GAME) {
                        mouseX = gamePanel.getPlayer().getX() - 60;
                        mouseY = gamePanel.getPlayer().getY() + gamePanel.getPlayer().getWidth() / 2;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (currentGameState == GameState.GAME) {
                        mouseX = gamePanel.getPlayer().getX() + 60;
                        mouseY = gamePanel.getPlayer().getY() + gamePanel.getPlayer().getWidth() / 2;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (currentGameState == GameState.GAME) {
                        mouseX = gamePanel.getPlayer().getX() + gamePanel.getPlayer().getWidth() / 2;
                        mouseY = gamePanel.getPlayer().getY() - 60;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (currentGameState == GameState.GAME) {
                        mouseX = gamePanel.getPlayer().getX() + gamePanel.getPlayer().getWidth() / 2;
                        mouseY = gamePanel.getPlayer().getY() + 60;
                    }
                }

            }
        });

        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                clickSound();

                if (GameState.MENU == currentGameState) {

                    if (mouseX > gameMenu.getxPlay() && mouseX < gameMenu.getxPlay() + gameMenu.getwPlay() && mouseY > gameMenu.getyPlay() && mouseY < gameMenu.getyPlay() + gameMenu.gethPlay()) {
                        playerType = 0;
                        setCurrentGameState(GameState.GAME);
                    }
                    if (mouseX > gameMenu.getxLobby() && mouseX < gameMenu.getxLobby() + gameMenu.getwLobby() && mouseY > gameMenu.getyLobby() && mouseY < gameMenu.getyLobby() + gameMenu.gethLobby())
                        setCurrentGameState(GameState.MULTIPLAYER);
                    if (mouseX > gameMenu.getxSettings() && mouseX < gameMenu.getxSettings() + gameMenu.getwSettings() && mouseY > gameMenu.getySettings() && mouseY < gameMenu.getySettings() + gameMenu.gethSettings())
                        setCurrentGameState(GameState.SETTINGS);
                    if (mouseX > gameMenu.getxExit() && mouseX < gameMenu.getxExit() + gameMenu.getwExit() && mouseY > gameMenu.getyExit() && mouseY < gameMenu.getyExit() + gameMenu.gethExit())
                        System.exit(1);

                } else if (GameState.SETTINGS == currentGameState) {

                    if (mouseX > gameSettings.getxBack() && mouseX < gameSettings.getxBack() + gameSettings.getWBack() && mouseY > gameSettings.getyBack() && mouseY < gameSettings.getyBack() + gameSettings.gethBack())
                        setCurrentGameState(GameState.MENU);

                } else if (GameState.MULTIPLAYER == currentGameState) {

                    if (mouseX > gameMultiplayer.getxCreate() && mouseX < gameMultiplayer.getxCreate() + gameMultiplayer.getwCreate() && mouseY > gameMultiplayer.getyCreate() && mouseY < gameMultiplayer.getyCreate() + gameMultiplayer.gethCreate()) {
                        playerType = 1;
                        try {
                            newServer();
                        } catch (IOException | InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if (mouseX > gameMultiplayer.getxJoin() && mouseX < gameMultiplayer.getxJoin() + gameMultiplayer.getwJoin() && mouseY > gameMultiplayer.getyJoin() && mouseY < gameMultiplayer.getyJoin() + gameMultiplayer.gethJoin()) {
                        playerType = 2;
                        try {
                            newClient(gameMultiplayer.getJoinIpAddress().getText());
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if (mouseX > gameMultiplayer.getxBack() && mouseX < gameMultiplayer.getxBack() + gameMultiplayer.getWBack() && mouseY > gameMultiplayer.getyBack() && mouseY < gameMultiplayer.getyBack() + gameMultiplayer.gethBack()) {
                        setCurrentGameState(GameState.MENU);
                    }
                } else if (GameState.GAMEOVER == currentGameState) {

                    if (mouseX > gameOver.getxReplay() && mouseX < gameOver.getxReplay() + gameOver.getwReplay() && mouseY > gameOver.getyReplay() && mouseY < gameOver.getyReplay() + gameOver.gethReplay()) {
                        if(playerType == 1) {
                            try {
                                newServer();
                            } catch (IOException | InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        else if(playerType == 2) {
                            try {
                                newClient(gameMultiplayer.getJoinIpAddress().getText());
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        else
                            setCurrentGameState(GameState.GAME);
                    }
                    if (mouseX > gameOver.getxMenu() && mouseX < gameOver.getxMenu() + gameOver.getwMenu() && mouseY > gameOver.getyMenu() && mouseY < gameOver.getyMenu() + gameOver.gethMenu())
                        setCurrentGameState(GameState.MENU);
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

    private void setMusicController() {
        musicController = new MusicController(this, resource.getgoodBallPathSound(), resource.getbadBallPathSound(), resource.getgameBackgroundPathSound(), resource.getClickButtonPathSound(), resource.getBackgroundPathSound());
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
        fps = new Fps(this);
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
            }
            else if (previousGameState == GameState.MULTIPLAYER)
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

    public void clickSound(){
        musicController.getClick().setFlag(true);
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(GameState currentGameState) {
        previousGameState = this.currentGameState;
        changePanel(currentGameState);
        this.currentGameState = currentGameState;
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

    public MusicController getMusicController() {
        return musicController;
    }

    public void setMusicController(MusicController musicController) {
        this.musicController = musicController;
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

    public GameMultiplayer getGameMultiplayer() {
        return gameMultiplayer;
    }

    public void setGameMultiplayer(GameMultiplayer gameMultiplayer) {
        this.gameMultiplayer = gameMultiplayer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
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

    public char getPlayerType() {
        return playerType;
    }

    public void setPlayerType(char playerType) {
        this.playerType = playerType;
    }

    public Integer[] getSettings() {
        return defaultsSettings;
    }

    public void setSettings(Integer[] settings) {
        this.defaultsSettings = settings;
    }

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        this.speedLevel = speedLevel;
    }

    public Image getCursor() {
        return cursor;
    }

    public void setCursor(Image cursor) {
        this.cursor = cursor;
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

    public void setMode(int mode) {
        this.mode = mode;
        switch (mode){
            case 0:
                currentGameMode = GameMode.CHILL;
                break;
            case 1:
                currentGameMode = GameMode.GLITCH;
                break;
            case 2:
                currentGameMode = GameMode.UNKNOWN;
                break;
        }
        changedMode = true;
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

    public void restoreSettings(){
        setSpeedLevel(defaultsSettings[0]);
        setMode(defaultsSettings[1]);
        setVecSize(defaultsSettings[2]);
        setWidthStart(defaultsSettings[3]);
    }
}