package fr.raphNerval.view;


import javax.swing.*;

public class GameWindow extends JFrame {

    public enum PlantType{
        None,
        Sunflower,
        Peashooter,
        FreezePeashooter,
        Shovel,
        Walnut
    }

    //*****ATTRIBUTS*****//
    public static JPanel currentPanel;
    public static GameWindow gameWindow;

    //*****CONSTRUCTEUR*****//
    public GameWindow() {
        setSize(1000,752);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        showMenuPanel();

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //*****METHODES******//
    private void showMenuPanel() {
        MenuPanel menuPanel = new MenuPanel();
        setCurrentPanel(menuPanel);
    }

    public void switchPanel(JPanel panel) {
        setContentPane(panel);
        revalidate();
        repaint();
    }

    private void setCurrentPanel(JPanel panel) {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        currentPanel = panel;
        setContentPane(currentPanel);

        revalidate();
        repaint();
    }
    public static void main(String[] args) {
        gameWindow = new GameWindow();

}}

