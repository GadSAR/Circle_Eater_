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
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    static int port = 8888;

    ServerSocket server;
    Socket socket;

    InputStream inputStream;
    OutputStream outputStream;

    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    GameStateManager gSM;
    GamePanel game;
    Data data;

    Thread t;

    public Server(GameStateManager gSM) throws IOException {
        t = new Thread(this);
        this.gSM = gSM;
        serverConnection();
        game = new GamePanel(gSM, 1);
        gSM.removeGamePreviousPanels();
        gSM.setGamePanel(game);
        gSM.setNewPanel(game);
        data = new Data(game);

        t.start();
    }

    public void serverConnection() throws IOException {
        server = new ServerSocket(port);
        socket = server.accept();

        outputStream = socket.getOutputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);

        inputStream = socket.getInputStream();
        objectInputStream = new ObjectInputStream(inputStream);

        String s = "start";
        objectOutputStream.writeObject(s);
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
