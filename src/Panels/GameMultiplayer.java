package Panels;

import Manage.*;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GameMultiplayer extends JPanel {

    private GameStateManager gameStateManager;

    private Image bgMultiplayer, Create, onCreate, Join, onJoin, Back, onBack;
    private int xMiddleScreen, yMiddleScreen,
            wCreate, hCreate, xCreate, yCreate,
            wText, hText, xText, yText,
            wJoin, hJoin, xJoin, yJoin,
            WBack, hBack, xBack, yBack;
    private JTextField joinIpAdress, MyIpAddress;
    private String myIpAddress;


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
        xMiddleScreen = tk.getScreenSize().width / 2;
        yMiddleScreen = tk.getScreenSize().height / 2;

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            myIpAddress = inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            // If the local host could not be resolved, set the IP address to "unknown"
            myIpAddress = "unknown";
        }
        MyIpAddress = new JTextField(myIpAddress);

        wCreate = 240;
        hCreate = 120;
        xCreate = xMiddleScreen - wCreate / 2;
        yCreate = yMiddleScreen - hCreate / 2 - 100;

        wJoin = 180;
        hJoin = 90;
        xJoin = xMiddleScreen + 20;
        yJoin = yCreate + hCreate + 20;

        joinIpAdress = new JTextField("Type lobby Ip Address...", 30);
        wText = 200;
        hText = hJoin - 50;
        xText = xJoin - 220;
        yText = yJoin + 25;

        WBack = 160;
        hBack = 80;
        xBack = xMiddleScreen - WBack / 2;
        yBack = yJoin + hJoin + 20;

        Font font = new Font("Arial", Font.BOLD, 15);
        setLayout(null);
        //joinIpAdress.setOpaque(true);
        //joinIpAdress.setForeground(Color.black);
        joinIpAdress.setFont(font);
        joinIpAdress.setBounds(xText, yText, wText, hText);
        add(joinIpAdress);

        MyIpAddress.setFont(font);
        MyIpAddress.setBounds(0, 0, 130, 25);
        MyIpAddress.setEditable(false);
        add(MyIpAddress);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bgMultiplayer, 0, 0, getWidth(), getHeight(), null);

        if (gameStateManager.getMouseX() > xCreate && gameStateManager.getMouseX() < xCreate + wCreate && gameStateManager.getMouseY() > yCreate && gameStateManager.getMouseY() < yCreate + hCreate)
            g.drawImage(onCreate, xCreate, yCreate, wCreate, hCreate, null);
        else g.drawImage(Create, xCreate, yCreate, wCreate, hCreate, null);

        if (gameStateManager.getMouseX() > xJoin && gameStateManager.getMouseX() < xJoin + wJoin && gameStateManager.getMouseY() > yJoin && gameStateManager.getMouseY() < yJoin + hJoin)
            g.drawImage(onJoin, xJoin, yJoin, wJoin, hJoin, null);
        else g.drawImage(Join, xJoin, yJoin, wJoin, hJoin, null);

        if (gameStateManager.getMouseX() > xText - 10 && gameStateManager.getMouseX() < xText + wText + 10 && gameStateManager.getMouseY() > yText - 10 && gameStateManager.getMouseY() < yText + hText + 10) {
            // If the mouse is within the bounds of the text field and the text is "Type lobby Ip Address...", clear the text
            if (joinIpAdress.getText().equals("Type lobby Ip Address..."))
                joinIpAdress.setText("");
        } else if (joinIpAdress.getText().isEmpty()) {
            // If the mouse is not within the bounds of the text field and the text is empty, set the text to "Type lobby Ip Address..."
            joinIpAdress.setText("Type lobby Ip Address...");

        }

        if (gameStateManager.getMouseX() > xBack && gameStateManager.getMouseX() < xBack + WBack && gameStateManager.getMouseY() > yBack && gameStateManager.getMouseY() < yBack + hBack)
            g.drawImage(onBack, xBack, yBack, WBack, hBack, null);
        else g.drawImage(Back, xBack, yBack, WBack, hBack, null);

        gameStateManager.drawCursor(g);

    }


    public JTextField getJoinIpAdress() {
        return joinIpAdress;
    }

    public void setJoinIpAdress(JTextField joinIpAdress) {
        this.joinIpAdress = joinIpAdress;
    }

    public int getwText() {
        return wText;
    }

    public void setwText(int wText) {
        this.wText = wText;
    }

    public int gethText() {
        return hText;
    }

    public void sethText(int hText) {
        this.hText = hText;
    }

    public int getxText() {
        return xText;
    }

    public void setxText(int xText) {
        this.xText = xText;
    }

    public int getyText() {
        return yText;
    }

    public void setyText(int yText) {
        this.yText = yText;
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public void setGameStateManager(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public Image getBgMultiplayer() {
        return bgMultiplayer;
    }

    public void setBgMultiplayer(Image bgMultiplayer) {
        this.bgMultiplayer = bgMultiplayer;
    }

    public Image getCreate() {
        return Create;
    }

    public void setCreate(Image create) {
        Create = create;
    }

    public Image getOnCreate() {
        return onCreate;
    }

    public void setOnCreate(Image onCreate) {
        this.onCreate = onCreate;
    }

    public Image getJoin() {
        return Join;
    }

    public void setJoin(Image join) {
        Join = join;
    }

    public Image getOnJoin() {
        return onJoin;
    }

    public void setOnJoin(Image onJoin) {
        this.onJoin = onJoin;
    }

    public Image getBack() {
        return Back;
    }

    public void setBack(Image back) {
        Back = back;
    }

    public Image getOnBack() {
        return onBack;
    }

    public void setOnBack(Image onBack) {
        this.onBack = onBack;
    }

    public int getxMiddleScreen() {
        return xMiddleScreen;
    }

    public void setxMiddleScreen(int xMiddleScreen) {
        this.xMiddleScreen = xMiddleScreen;
    }

    public int getyMiddleScreen() {
        return yMiddleScreen;
    }

    public void setyMiddleScreen(int yMiddleScreen) {
        this.yMiddleScreen = yMiddleScreen;
    }

    public int getwCreate() {
        return wCreate;
    }

    public void setwCreate(int wCreate) {
        this.wCreate = wCreate;
    }

    public int gethCreate() {
        return hCreate;
    }

    public void sethCreate(int hCreate) {
        this.hCreate = hCreate;
    }

    public int getxCreate() {
        return xCreate;
    }

    public void setxCreate(int xCreate) {
        this.xCreate = xCreate;
    }

    public int getyCreate() {
        return yCreate;
    }

    public void setyCreate(int yCreate) {
        this.yCreate = yCreate;
    }

    public int getwJoin() {
        return wJoin;
    }

    public void setwJoin(int wJoin) {
        this.wJoin = wJoin;
    }

    public int gethJoin() {
        return hJoin;
    }

    public void sethJoin(int hJoin) {
        this.hJoin = hJoin;
    }

    public int getxJoin() {
        return xJoin;
    }

    public void setxJoin(int xJoin) {
        this.xJoin = xJoin;
    }

    public int getyJoin() {
        return yJoin;
    }

    public void setyJoin(int yJoin) {
        this.yJoin = yJoin;
    }

    public int getWBack() {
        return WBack;
    }

    public void setWBack(int WBack) {
        this.WBack = WBack;
    }

    public int gethBack() {
        return hBack;
    }

    public void sethBack(int hBack) {
        this.hBack = hBack;
    }

    public int getxBack() {
        return xBack;
    }

    public void setxBack(int xBack) {
        this.xBack = xBack;
    }

    public int getyBack() {
        return yBack;
    }

    public void setyBack(int yBack) {
        this.yBack = yBack;
    }

}
