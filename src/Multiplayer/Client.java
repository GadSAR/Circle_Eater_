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

    GamePanel game;
    BallPlayer player;
    BallBot vec;
    GameStateManager gSM;

    Thread t;


    public Client(GameStateManager gSM) throws IOException, ClassNotFoundException {
        t = new Thread(this);
        this.gSM = gSM;
        connectToServer(Server.port);
        game = new GamePanel(gSM);

        Object obj = objectInputStream.readObject();
        if (obj instanceof GameState) {
            GameState command = (GameState) obj;
            if (command == GameState.GAME) {
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

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {

                objectOutputStream.writeObject(game.getVec());
                Class vecType = game.getVec().getClass();
                Object obj = objectInputStream.readObject();
                if(vecType.isInstance(obj))
                    obj = (vecType) obj;
                    game.setVec(obj);

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

