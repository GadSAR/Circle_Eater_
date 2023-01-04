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
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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

        while (true) {

            DataServer receivedData;

            try {
                Object obj = objectInputStream.readObject();
                System.out.println("client read");
                if (obj instanceof DataServer) {
                    receivedData = (DataServer) obj;
                    game.setBallsCoordinatesAndStatus(receivedData.ballsCoordinatesAndStatus);
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            data.update(game);

            try {
                System.out.println("Trying to write: " + (int)data.playerCoordinatesAndStatus[0]);
                objectOutputStream.writeObject(data);
                System.out.println("client write");
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

}

