package Music;
import Manage.*;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicWavPlayer {
    private String filename;
    GameStateManager gSM;
    private final int EXTERNAL_BUFFER_SIZE = 128 * 1024; // 128kB
    SourceDataLine auline = null;


    public MusicWavPlayer(String wavfile, GameStateManager gSM) {
        wavfile = wavfile.replaceAll("%20", " "); //sometimes the URL encoded representation will be write as "%20"
        filename = wavfile;
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
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
            auline.start();
            int nBytesRead = 0;
            byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
            while (nBytesRead != -1 && gSM.getCurrentGameState() == GameState.PLAY) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    auline.write(abData, 0, nBytesRead);
            }

        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
            return;
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            auline.drain();
            auline.close();
        }
    }

    public void stop() {
        if (auline != null)
            auline.stop();
    }
}