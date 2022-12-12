package Music;
import Manage.*;
import Multiplayer.*;
import Music.*;
import Panels.*;
import Objects.*;
import Resources.*;

public class MusicThread extends Thread {
    private MusicWavPlayer wav;
    private boolean flag, loop;

    private GameStateManager gSM;


    public MusicThread(String Path, GameStateManager gSM, boolean loop) {
        this.gSM = gSM;
        wav = new MusicWavPlayer(Path, gSM);
        this.loop = loop;
        start();
    }


    public void run() {
        while (true) {

            if (flag) {
                wav.play();
                if (!loop)
                    flag = false;
            }

            if (gSM.getCurrentGameState() != GameState.GAME) {
                wav.stop();
            }

            try {
                Thread.sleep(0, 5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

}

