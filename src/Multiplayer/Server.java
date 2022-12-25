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

public class Server extends Thread {

    static int port = 8888;

    ServerSocket server;
    Socket socket;

    InputStream inputStream;
    OutputStream outputStream;

    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    GameStateManager gSM;
    GamePanel game;
    Data data, recivedData;

    public Server(GameStateManager gSM) throws IOException {
        this.gSM = gSM;
        serverConnection();
        this.gSM.setCurrentGameState(GameState.GAME);
        this.game = this.gSM.getGamePanel();
        this.data = new Data(game);

        start();
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
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                objectOutputStream.writeObject(data);
                System.out.println("server write");

                Object obj = objectInputStream.readObject();
                System.out.println("server read");

                if (obj instanceof Data) {
                    recivedData = (Data)obj;
                    game.setCordinatesAndStatus(recivedData.cordinatesAndStatus);
                }

            } catch (IOException e) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    sleep(5000);
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
