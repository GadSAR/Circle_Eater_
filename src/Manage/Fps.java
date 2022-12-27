package Manage;

public class Fps extends Thread {
    GameStateManager gSM;
    long startTime;
    double delay;

    public Fps(GameStateManager gSM) {
        this.gSM = gSM;
        startTime = System.currentTimeMillis();
        delay = (double)1000/60;       //60fps
    }

    public void update() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime >= delay) {
            if(gSM.isChangedMode()){
                gSM.setMusicController(gSM.getMusicController());
                gSM.setChangedMode(false);
            }
            if(gSM.getCurrentGameState() == GameState.GAME) gSM.getGamePanel().repaint();
            if(gSM.getCurrentGameState() == GameState.MENU ) gSM.getGameMenu().repaint();
            if(gSM.getCurrentGameState() == GameState.SETTINGS ) gSM.getGameSettings().repaint();
            if(gSM.getCurrentGameState() == GameState.MULTIPLAYER ) gSM.getGameMultiplayer().repaint();
            if(gSM.getCurrentGameState() == GameState.GAMEOVER ) gSM.getGameOver().repaint();
            if(gSM.getCurrentGameState() == GameState.HOWTOPLAY ) gSM.getGameHowToPlay().repaint();
            startTime = System.currentTimeMillis();
        }
    }

    @Override
    public void run() {
        while(true) {
            update();

            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e) {
                 throw new RuntimeException(e);
            }
        }
    }
}
