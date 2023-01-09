package Panels;

import Manage.*;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GameMultiplayer extends JPanel {

    private GameStateManager gameStateManager;

    private Image bgMultiplayer, Create, onCreate, Join, onJoin, Back, onBack;
    private int wCreate, hCreate, xCreate, yCreate,
            wText, hText, xText, yText,
            wJoin, hJoin, xJoin, yJoin,
            wBack, hBack, xBack, yBack;
    private JTextField joinIpAddress;


    public GameMultiplayer(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;

        bgMultiplayer = (new ImageIcon(gameStateManager.getResource().getGameMenuBackgroundImg())).getImage();
        Create = (new ImageIcon(gameStateManager.getResource().getCreatButton())).getImage();
        onCreate = (new ImageIcon(gameStateManager.getResource().getOnCreatButton())).getImage();
        Join = (new ImageIcon(gameStateManager.getResource().getJoinButton())).getImage();
        onJoin = (new ImageIcon(gameStateManager.getResource().getOnJoinButton())).getImage();
        Back = (new ImageIcon(gameStateManager.getResource().getBackButton())).getImage();
        onBack = (new ImageIcon(gameStateManager.getResource().getOnBackButton())).getImage();

        gameStateManager.getF().getToolkit();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xMiddleScreen = tk.getScreenSize().width / 2;
        int yMiddleScreen = tk.getScreenSize().height / 2;

        String myIpAddress;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            myIpAddress = inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            // If the local host could not be resolved, set the IP address to "unknown"
            myIpAddress = "unknown";
        }
        JTextField myIpAddress1 = new JTextField(myIpAddress);

        wCreate = 240;
        hCreate = 120;
        xCreate = xMiddleScreen - wCreate / 2;
        yCreate = yMiddleScreen - hCreate / 2 - 100;

        wJoin = 180;
        hJoin = 90;
        xJoin = xMiddleScreen + 20;
        yJoin = yCreate + hCreate + 20;

        joinIpAddress = new JTextField("Type lobby Ip Address...", 30);
        wText = 200;
        hText = hJoin - 50;
        xText = xJoin - 220;
        yText = yJoin + 25;

        wBack = 160;
        hBack = 80;
        xBack = xMiddleScreen - wBack / 2;
        yBack = yJoin + hJoin + 20;

        Font font = new Font("Arial", Font.BOLD, 15);
        setLayout(null);
        joinIpAddress.setFont(font);
        joinIpAddress.setBounds(xText, yText, wText, hText);
        add(joinIpAddress);

        myIpAddress1.setFont(font);
        myIpAddress1.setBounds(0, 0, 130, 25);
        myIpAddress1.setEditable(false);
        add(myIpAddress1);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bgMultiplayer, 0, 0, getWidth(), getHeight(), null);

        if (gameStateManager.mouseIn(xCreate, wCreate, yCreate, hCreate)) {
            g.drawImage(onCreate, xCreate, yCreate, wCreate, hCreate, null);
        } else g.drawImage(Create, xCreate, yCreate, wCreate, hCreate, null);

        if (gameStateManager.mouseIn(xJoin, wJoin, yJoin, hJoin)) {
            g.drawImage(onJoin, xJoin, yJoin, wJoin, hJoin, null);
        } else g.drawImage(Join, xJoin, yJoin, wJoin, hJoin, null);

        if (gameStateManager.getMouseX() > xText - 40 && gameStateManager.getMouseX() < xText + wText + 40 && gameStateManager.getMouseY() > yText - 40 && gameStateManager.getMouseY() < yText + hText + 40) {            // If the mouse is within the bounds of the text field and the text is "Type lobby Ip Address...", clear the text
            if (joinIpAddress.getText().equals("Type lobby Ip Address..."))
                joinIpAddress.setText("");
        } else if (joinIpAddress.getText().isEmpty()) {
            // If the mouse is not within the bounds of the text field and the text is empty, set the text to "Type lobby Ip Address..."
            joinIpAddress.setText("Type lobby Ip Address...");
        }

        if (gameStateManager.mouseIn(xBack,wBack,yBack,hBack)) {
            g.drawImage(onBack, xBack, yBack, wBack, hBack, null);
        } else g.drawImage(Back, xBack, yBack, wBack, hBack, null);

        gameStateManager.drawCursor(g);

    }


    public JTextField getJoinIpAddress() {
        return joinIpAddress;
    }

    public int getwCreate() {
        return wCreate;
    }

    public int gethCreate() {
        return hCreate;
    }

    public int getxCreate() {
        return xCreate;
    }

    public int getyCreate() {
        return yCreate;
    }

    public int getwJoin() {
        return wJoin;
    }

    public int gethJoin() {
        return hJoin;
    }

    public int getxJoin() {
        return xJoin;
    }

    public int getyJoin() {
        return yJoin;
    }

    public int getwBack() {
        return wBack;
    }

    public int gethBack() {
        return hBack;
    }

    public int getxBack() {
        return xBack;
    }

    public int getyBack() {
        return yBack;
    }

}
