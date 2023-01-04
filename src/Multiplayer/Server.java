package Multiplayer;

import Manage.*;
import Panels.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

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
    DataServer data;
    DataClient receivedData;

    public Server(GameStateManager gSM) throws IOException {
        this.gSM = gSM;
        serverConnection();
        this.gSM.setCurrentGameState(GameState.GAME);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.game = this.gSM.getGamePanel();
        this.data = new DataServer(game);

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
        System.out.println("server write");
    }

    public void run() {

        while (true) {

            data.update(game);
            DataClient receivedData = null;

            try {
                objectOutputStream.writeObject(data);
                System.out.println("server write");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                Object obj = objectInputStream.readObject();
                System.out.println("server read");
                if (obj instanceof DataClient) {
                    receivedData = (DataClient) obj;
                    System.out.println("Trying to read: " + (int) receivedData.playerCoordinatesAndStatus[0]);
                    game.setPlayer2CoordinatesAndStatus(receivedData.playerCoordinatesAndStatus);
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
