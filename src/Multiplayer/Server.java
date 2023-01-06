package Multiplayer;

import Manage.GameState;
import Manage.GameStateManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    final static int PORT = 8888;
    Socket socket;
    ObjectOutputStream outputStream;
    ObjectInputStream inputStream;


    GameStateManager gameStateManager;

    public Server(GameStateManager gameStateManager) throws InterruptedException {
        this.gameStateManager = gameStateManager;
        serverConnection();
    }

    private void serverConnection() throws InterruptedException {

        try {
            // create a server socket
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {

                // wait for a client to connect
                socket = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // get the input and output streams
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

            // write a Data Settings to the client
            DataSettings dataSettings = new DataSettings(gameStateManager);
            try {
                outputStream.writeObject(dataSettings);
                System.out.println("Sent data to client: " + dataSettings.settings[0]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            gameStateManager.setCurrentGameState(GameState.GAME);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sleep(1000);
    }

    @Override
    public void run() {

        while (true) {

            // write a Data object to the client
            DataServer dataServer = new DataServer(gameStateManager.getGamePanel());
            try {
                outputStream.writeObject(dataServer);
                System.out.println("Sent data to client: " + dataServer.playerCoordinatesAndStatus[0] + ", " + dataServer.playerCoordinatesAndStatus[1] + ", " + dataServer.playerCoordinatesAndStatus[2] + ", " + dataServer.playerCoordinatesAndStatus[3] + ", " + dataServer.moveFlag.toString());
            } catch (IOException ignored) {
            }

            // read a Data object from the client
            DataClient dataClient;
            try {
                dataClient = (DataClient) inputStream.readObject();
                System.out.println("Received data from client: " + dataClient.playerCoordinatesAndStatus[0] + ", " + dataClient.playerCoordinatesAndStatus[1] + ", " + dataClient.playerCoordinatesAndStatus[2] + ", " + dataClient.playerCoordinatesAndStatus[3]);
                gameStateManager.getGamePanel().setPlayer2CoordinatesAndStatus(dataClient.playerCoordinatesAndStatus);
                gameStateManager.getGamePanel().setBallsStatus(dataClient.ballsStatus);
            } catch (IOException | ClassNotFoundException | InterruptedException ignored) {
            }

            // sleep
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void endServer() throws IOException, InterruptedException {
        sleep(100);
        socket.close();
    }
}