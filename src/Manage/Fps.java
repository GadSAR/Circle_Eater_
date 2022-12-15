package Manage;

public class Fps extends Thread {
    GameStateManager gSM;
    long startTime;
    double delay;

    public Fps(GameStateManager gSM) {
        this.gSM = gSM;
        startTime = System.currentTimeMillis();
        delay = 1000/60;       //60fps
    }

    public void update() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime >= delay) {
            if(gSM.isChangedPanel()){
                gSM.changePanel();
                gSM.setChangedPanel(false);
            }
            if(gSM.isChangedMode()){
                gSM.setMusicControler(gSM.getMusicControler());
                gSM.setChangedMode(false);
            }
            if(gSM.getCurrentGameState() == GameState.PLAY) gSM.getGamePanel().repaint();
            if(gSM.getCurrentGameState() == GameState.MENU ) gSM.getGameMenu().repaint();
            if(gSM.getCurrentGameState() == GameState.SETTINGS ) gSM.getGameSettings().repaint();
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
                Thread.sleep(2);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
