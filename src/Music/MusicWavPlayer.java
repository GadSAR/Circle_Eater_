package Music;
import Manage.*;

import javax.sound.sampled.*;
import java.io.File;

public class MusicWavPlayer {
    private String filename;
    GameStateManager gSM;
    SourceDataLine auLine = null;


    public MusicWavPlayer(String wavFile, GameStateManager gSM) {
        wavFile = wavFile.replaceAll("%20", " "); //sometimes the URL encoded representation will be showed as "%20"
        filename = wavFile;
        this.gSM = gSM;
    }

    public void play() {
        File soundFile = new File(filename);
        if (!soundFile.exists()) {
            System.err.println("Wave file not found: " + filename);
            return;
        }

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            auLine = (SourceDataLine) AudioSystem.getLine(info);
            auLine.open(format);
            auLine.start();
            int nBytesRead = 0;
            // 128kB
            int EXTERNAL_BUFFER_SIZE = 128 * 1024;
            byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
            while (nBytesRead != -1 && gSM.getCurrentGameState() == GameState.GAME) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    auLine.write(abData, 0, nBytesRead);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            auLine.drain();
            auLine.close();
        }
    }

    public void stop() {
        if (auLine != null)
            auLine.stop();
    }
}