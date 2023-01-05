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
    DataServer dataServer;


    public Server(GameStateManager gSM) throws IOException {

        this.gSM = gSM;
        this.gSM.setCurrentGameState(GameState.GAME);

        serverConnection();

        game = this.gSM.getGamePanel();
        dataServer = new DataServer(game);

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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

        read();
        write();

    }

    private void write() {

        Thread thread = new Thread(() -> {

            while (true) {

                dataServer.update(game);

                try {
                    System.out.println("server Trying to write: " + (int) dataServer.playerCoordinatesAndStatus[0]);
                    objectOutputStream.writeObject(dataServer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        thread.start();

    }

    private void read() {

        Thread thread = new Thread(() -> {

            while (true) {

                try {
                    Object obj = objectInputStream.readObject();
                    if (obj instanceof DataClient receivedData) {
                        System.out.println("server Trying to read: " + (int) receivedData.playerCoordinatesAndStatus[0]);
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
        });
        thread.start();
    }
}
