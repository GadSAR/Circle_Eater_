package Multiplayer;

import Manage.GameState;
import Manage.GameStateManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread {

    private int[] previousSettings;
    private String HOST = "localhost";
    static final int PORT = Server.PORT;
    Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    GameStateManager gameStateManager;


    public Client(GameStateManager gameStateManager, String ipAddress) throws Exception {
        this.gameStateManager = gameStateManager;
        int speed = gameStateManager.getSpeedLevel(), mode = gameStateManager.getMode(), vecSize = gameStateManager.getVecSize(), playersSize = gameStateManager.getWidthStart();
        previousSettings = new int[]{speed, mode, vecSize, playersSize};
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

            // read a Data Settings from the server
            DataSettings dataSettings;
            try {
                dataSettings = (DataSettings) inputStream.readObject();
                System.out.println("Received data from server: " + dataSettings.settings[0]);
                gameStateManager.setSpeedLevel(dataSettings.settings[0]);
                gameStateManager.setMode(dataSettings.settings[1]);
                gameStateManager.setVecSize(dataSettings.settings[2]);
                gameStateManager.setWidthStart(dataSettings.settings[3]);
            } catch (IOException | ClassNotFoundException e) {
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

        while(true) {

            // write a Data object to the server
            DataClient dataClient = new DataClient(gameStateManager.getGamePanel());
            try {
                outputStream.writeObject(dataClient);
                System.out.println("Sent data to server: " + dataClient.playerCoordinatesAndStatus[0] + ", " + dataClient.playerCoordinatesAndStatus[1] + ", " + dataClient.playerCoordinatesAndStatus[2] + ", " + dataClient.playerCoordinatesAndStatus[3]);
            } catch (IOException ignored) {
            }

            // read a Data object from the server
            DataServer dataServer = null;
            try {
                dataServer = (DataServer) inputStream.readObject();
                System.out.println("Received data from server: " + dataServer.playerCoordinatesAndStatus[0] + ", " + dataServer.playerCoordinatesAndStatus[1] + ", " + dataServer.playerCoordinatesAndStatus[2] + ", " + dataServer.playerCoordinatesAndStatus[3] + ", " + dataServer.moveFlag.toString());
                gameStateManager.getGamePanel().setPlayer2CoordinatesAndStatus(dataServer.playerCoordinatesAndStatus);
                gameStateManager.getGamePanel().setBallsCoordinatesAndStatus(dataServer.ballsCoordinatesAndStatus);
                gameStateManager.getGamePanel().setMoveFlag(dataServer.moveFlag);
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

    public void endClient() throws IOException, InterruptedException {
        gameStateManager.getGamePanel().getPlayer().setPlayerAlive(false);
        gameStateManager.setSpeedLevel(previousSettings[0]);
        gameStateManager.setMode(previousSettings[1]);
        gameStateManager.setVecSize(previousSettings[2]);
        gameStateManager.setWidthStart(previousSettings[3]);
        sleep(100);
        socket.close();
    }
}