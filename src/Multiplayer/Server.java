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
    Data data, receivedData;

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
        System.out.println("server write");
    }

    public void run() {

        while (true) {

            data.update(game);

            try {
                objectOutputStream.writeObject(data);
                System.out.println("server write");
                for(int i = 0; i < 3; i++)
                    System.out.println(Arrays.toString(data.botsCoordinatesAndStatus[i]));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                Object obj = objectInputStream.readObject();
                System.out.println("server read");
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

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
