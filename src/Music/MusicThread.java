package Music;


public class MusicThread extends Thread {
    private MusicWavPlayer wav;
    private boolean flag, loop;


    public MusicThread(String Path, boolean loop) {
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

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}

