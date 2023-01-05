package Multiplayer;

import Manage.GameState;
import Manage.GameStateManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread {
    private String HOST = "localhost";
    static final int PORT = Server.PORT;
    Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    GameStateManager gameStateManager;

    public Client(GameStateManager gameStateManager, String ipAddress) throws Exception {
        this.gameStateManager = gameStateManager;
        HOST = ipAddress;
        clientConnection();
    }

    private void clientConnection() throws Exception {

        try {
            // create a client socket
            socket = new Socket(HOST, PORT);

            // get the input and output streams
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());

            gameStateManager.setCurrentGameState(GameState.GAME);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sleep(1000);
    }

    @Override
    public void run() {

        while(true) {

            // write a Data object to the server
            DataClient dataClient = new DataClient(gameStateManager.getGamePanel());
            try {
                outputStream.writeObject(dataClient);
                System.out.println("Sent data to server: " + dataClient.playerCoordinatesAndStatus[0] + ", " + dataClient.playerCoordinatesAndStatus[1] + ", " + dataClient.playerCoordinatesAndStatus[2] + ", " + dataClient.playerCoordinatesAndStatus[3]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // read a Data object from the server
            DataServer dataServer = null;
            try {
                dataServer = (DataServer) inputStream.readObject();
                System.out.println("Received data from server: " + dataServer.playerCoordinatesAndStatus[0] + ", " + dataServer.playerCoordinatesAndStatus[1] + ", " + dataServer.playerCoordinatesAndStatus[2] + ", " + dataServer.playerCoordinatesAndStatus[3] + ", " + dataServer.moveFlag.toString());
            gameStateManager.getGamePanel().setPlayer2CoordinatesAndStatus(dataServer.playerCoordinatesAndStatus);
            gameStateManager.getGamePanel().setBallsCoordinatesAndStatus(dataServer.ballsCoordinatesAndStatus);
            gameStateManager.getGamePanel().setMoveFlag(dataServer.moveFlag);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            // sleep
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}