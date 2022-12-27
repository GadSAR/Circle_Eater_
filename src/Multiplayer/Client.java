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
    Data data, recivedData;


    public Client(GameStateManager gSM, String serverIP) throws IOException, ClassNotFoundException {
        this.gSM = gSM;
        this.serverIP = serverIP;
        connectToServer(Server.port);
        gSM.setCurrentGameState(GameState.GAME);
        game = gSM.getGamePanel();
        data = new Data(game);

        Object obj = objectInputStream.readObject();
        if (obj instanceof String) {
            String command = (String) obj;
            if (command.equals("start")) {
                start();
            }
        }
    }

    public void connectToServer(int port) throws IOException {
        socket = new Socket(serverIP, port);

        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();

        objectInputStream = new ObjectInputStream(inputStream);
        objectOutputStream = new ObjectOutputStream(outputStream);
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
                System.out.println("client write");

                Object obj = objectInputStream.readObject();
                System.out.println("client read");
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

