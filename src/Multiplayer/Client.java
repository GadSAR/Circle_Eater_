package Multiplayer;

import Manage.*;
import Panels.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client extends Thread {


    String serverIP;
    Socket socket;
    InputStream inputStream;
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    GameStateManager gSM;
    GamePanel game;
    Data data, receivedData;


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
        data = new Data(game);

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

            try {
                Object obj = objectInputStream.readObject();
                System.out.println("client read");
                if (obj instanceof Data) {
                    receivedData = (Data) obj;
                    game.getPlayer2().setX(data.p.x);
                    game.getPlayer2().setY(data.p.y);

                    game.setCoordinatesAndStatus(receivedData.botsCoordinatesAndStatus);
                    for(int i = 0; i < 3; i++)
                        System.out.println(Arrays.toString(receivedData.botsCoordinatesAndStatus[i]));
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            data.update(game);
            try {
                objectOutputStream.writeObject(data);
                System.out.println("client write");
                for(int i = 0; i < 3; i++)
                    System.out.println(Arrays.toString(data.botsCoordinatesAndStatus[i]));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }


}

