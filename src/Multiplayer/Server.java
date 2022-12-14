package Multiplayer;
import Manage.*;
import Multiplayer.*;
import Music.*;
import Panels.*;
import Objects.*;
import Resources.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    static int port = 8888;

    ServerSocket server;
    Socket socket;

    InputStream inputStream;
    OutputStream outputStream;

    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;

    GamePanel game;
    GameStateManager gSM;

    Thread t;

    public Server(GameStateManager gSM) throws IOException {
        t = new Thread(this);
        this.gSM = gSM;
        serverConnection();
        game = new GamePanel(gSM);

        t.start();
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
    }

    public void run() {

        while (true) {

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {

                Point pp = new Point(p1);
                d1 = new Data(pp, width1, color1);
                objectOutputStream.writeObject(d1);

                d2 = (Data) objectInputStream.readObject();
                p2.x = d2.p.x;
                p2.y = d2.p.y;
                width2 = d2.width;
                color2 = d2.color;

            } catch (IOException e) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    Thread.sleep(5000);
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

