package Multiplayer;

import Manage.*;
import Multiplayer.*;
import Music.*;
import Panels.*;
import Objects.*;
import Resources.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Runnable {

    Socket socket;
    InputStream inputStream;
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    GameStateManager gSM;
    GamePanel game;
    Data data;

    Thread t;


    public Client(GameStateManager gSM) throws IOException, ClassNotFoundException {
        t = new Thread(this);
        this.gSM = gSM;
        connectToServer(Server.port);
        gSM.setCurrentGameState(GameState.GAME);
        data = new Data(game);

        Object obj = objectInputStream.readObject();
        if (obj instanceof String) {
            String command = (String) obj;
            if (command.equals("start")) {
                t.start();
            }
        }
    }

    public void connectToServer(int port) throws IOException {
        socket = new Socket("localhost", port);

        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();

        objectInputStream = new ObjectInputStream(inputStream);
        objectOutputStream = new ObjectOutputStream(outputStream);
    }

    public void run() {

        while (true) {
            data.update();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                objectOutputStream.writeObject(data.cordinatesAndStatus);

                Object obj = objectInputStream.readObject();
                if (obj instanceof char[][]) {
                    game.setCordinatesAndStatus((char[][]) obj);
                }

            } catch (IOException e) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.exit(0);
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

