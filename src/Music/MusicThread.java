package Music;
import Manage.*;

public class MusicThread extends Thread {
    private MusicWavPlayer wav;
    private boolean flag, loop;

    private GameStateManager gameStateManager;


    public MusicThread(String Path, GameStateManager gameStateManager, boolean loop) {
        this.gameStateManager = gameStateManager;
        wav = new MusicWavPlayer(Path);
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

            try {
                Thread.sleep(0, 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopWav(){
        flag = false;
        wav.stop();
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

