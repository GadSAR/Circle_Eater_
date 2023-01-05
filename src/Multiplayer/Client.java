package Multiplayer;

import Manage.*;
import Panels.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Thread {

    String serverIP;
    Socket socket;
    InputStream inputStream;
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    GameStateManager gSM;
    GamePanel game;
    DataClient data;


    public Client(GameStateManager gSM, String serverIP) throws IOException, ClassNotFoundException {

        this.gSM = gSM;
        this.serverIP = serverIP;

        connectToServer(Server.port);

        gSM.setCurrentGameState(GameState.GAME);

        game = gSM.getGamePanel();
        data = new DataClient();

        Object obj = objectInputStream.readObject();
        System.out.println("client received");
        if (obj instanceof String command) {
            if (command.equals("start")) {
                start();
            }
        }
    }

    public void connectToServer(int port) throws IOException {
        socket = new Socket(serverIP, port);

        inputStream = socket.getInputStream();
        objectInputStream = new ObjectInputStream(inputStream);

        outputStream = socket.getOutputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);
    }

    public void run() {

        read();
        write();

    }

    private void write() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    data.update(game);

                    try {
                        System.out.println("client Trying to write: " + (int) data.playerCoordinatesAndStatus[0]);
                        objectOutputStream.writeObject(data);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
        thread.start();
    }

    private void read() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    try {
                        Object obj = objectInputStream.readObject();
                        if (obj instanceof DataServer receivedData) {
                            System.out.println("client Trying to read: " + (int) receivedData.playerCoordinatesAndStatus[0]);
                            game.setPlayer2CoordinatesAndStatus(receivedData.playerCoordinatesAndStatus);
                            game.setBallsCoordinatesAndStatus(receivedData.ballsCoordinatesAndStatus);
                            game.setMoveFlag(receivedData.moveFlag);
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
        });
        thread.start();
    }

}

