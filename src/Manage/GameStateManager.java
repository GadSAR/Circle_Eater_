package Manage;
import Manage.*;
import Multiplayer.*;
import Music.*;
import Objects.*;
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
    private GamePanel gP;
    private GameMenu gM;
    private GameHowToPlay gH;
    private GameOver gO;
    private GameSettings gS;


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
                    if (currentGameState == GameState.GAME)
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
                    if (currentGameState == GameState.GAME)
                        gP.pause();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (currentGameState == GameState.MENU || currentGameState == GameState.GAMEOVER)
                        setCurrentGameState(GameState.GAME);
                }
            }
        });

        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                if (GameState.MENU == currentGameState) {
                    if (mouseX > gM.getxPlay() && mouseX < gM.getxPlay() + gM.getwPlay() && mouseY > gM.getyPlay() && mouseY < gM.getyPlay() + gM.gethPlay())
                        setCurrentGameState(GameState.GAME);
                    if (mouseX > gM.getxHowToPlay() && mouseX < gM.getxHowToPlay() + gM.getwHowToPlay() && mouseY > gM.getyHowToPlay() && mouseY < gM.getyHowToPlay() + gM.gethHowToPlay())
                        setCurrentGameState(GameState.HOWTOPLAY);
                    if (mouseX > gM.getxSettings() && mouseX < gM.getxSettings() + gM.getwSettings() && mouseY > gM.getySettings() && mouseY < gM.getySettings() + gM.gethSettings())
                        setCurrentGameState(GameState.SETTINGS);
                    if (mouseX > gM.getxExit() && mouseX < gM.getxExit() + gM.getwExit() && mouseY > gM.getyExit() && mouseY < gM.getyExit() + gM.gethExit())
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
            case GAME: {
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
            if (previousGameState == GameState.GAME)
                f.remove(gP);
            else if (previousGameState == GameState.GAMEOVER)
                f.remove(gO);
            else if (previousGameState == GameState.SETTINGS)
                f.remove(gS);
            else if (previousGameState == GameState.HOWTOPLAY)
                f.remove(gH);
        }
        gM = new GameMenu(this);
        setNewPanel(gM);
    }

    private void setGamePanel() {
        if (previousGameState != null) {
            if (previousGameState == GameState.MENU)
                f.remove(gM);
            else if (previousGameState == GameState.GAMEOVER)
                f.remove(gO);
        }
        gP = new GamePanel(this);
        setNewPanel(gP);
    }

    private void setHowToPlayPanel() {
        f.remove(gM);
        gH = new GameHowToPlay(this);
        setNewPanel(gH);
    }

    private void setGameOverPanel() {
        f.remove(gP);
        gO = new GameOver(this);
        setNewPanel(gO);
    }

    private void setSettingsPanel() {
        f.remove(gM);
        gS = new GameSettings(this);
        setNewPanel(gS);
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

    public GamePanel getgP() {
        return gP;
    }

    public void setgP(GamePanel gP) {
        this.gP = gP;
    }

    public GameMenu getgM() {
        return gM;
    }

    public void setgM(GameMenu gM) {
        this.gM = gM;
    }

    public GameHowToPlay getgH() {
        return gH;
    }

    public void setgH(GameHowToPlay gH) {
        this.gH = gH;
    }

    public GameOver getgO() {
        return gO;
    }

    public void setgO(GameOver gO) {
        this.gO = gO;
    }

    public GameSettings getgS() {
        return gS;
    }

    public void setgS(GameSettings gS) {
        this.gS = gS;
    }

}