package fr.raphNerval.view;

import fr.raphNerval.controller.GameController;
import fr.raphNerval.controller.PlantCard;
import fr.raphNerval.model.Entity;
import fr.raphNerval.model.tower.FreezePeashooter;
import fr.raphNerval.model.tower.Peashooter;
import fr.raphNerval.model.tower.SunFlower;
import fr.raphNerval.model.field.Box;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel implements MouseMotionListener {


    //*****ATTRIBUTS*****//
    private Image backgroundImage;
    private Box[] tray;
    private GameWindow.PlantType plantType = GameWindow.PlantType.None;
    private int mouseX, mouseY;

    //*****CONSTRUCTEUR*****//
    public GamePanel() {
        setSize(1000, 752);
        setLayout(null);
        addMouseMotionListener(this);

        backgroundImage = new ImageIcon(getClass().getResource("/images/BG.png")).getImage();

        tray = new Box[50];
        for(int i = 0;i<50;i++){
            Box box = new Box();
            box.setLocation(44 + (i % 10) * 100, 109 + (i / 10) * 120);
            this.tray[i] = box;
            box.setActionListener(new GameController(this,(i%9),(i/9)));
            add(box);
        }


        PlantCard cardSunFlower = new PlantCard("/images/card_sunflower.png");
        cardSunFlower.setLocation(100,8);
        cardSunFlower.setActionListener((ActionEvent e)->{
            plantType = GameWindow.PlantType.Sunflower;
            System.out.println("sunflower");
        });
        add(cardSunFlower);

        PlantCard cardFreezePeaShooter = new PlantCard("/images/card_freezepeashooter.png");
        cardFreezePeaShooter.setLocation(230,8);
        cardFreezePeaShooter.setActionListener((ActionEvent e)->{
            plantType = GameWindow.PlantType.FreezePeashooter;
            System.out.println("freezepeashooter");
        });
        add(cardFreezePeaShooter);

        PlantCard cardPeaShooter = new PlantCard("/images/card_peashooter.png");
        cardPeaShooter.setLocation(165,8);
        cardPeaShooter.setActionListener((ActionEvent e)->{
            plantType = GameWindow.PlantType.Peashooter;
            System.out.println("peashooter");
        });
        add(cardPeaShooter);

        //ajoute les entités

        Entity sunFlower = new SunFlower(this,0,0);
        Entity peaShooter = new Peashooter(this,0,0);
        Entity freezePeaShooter = new FreezePeashooter(this,0,0);
        tray[0].addEntity(sunFlower);
        tray[10].addEntity(peaShooter);
        tray[20].addEntity(freezePeaShooter);

        repaint();

    }
    //*****ACCESSEURS*****//
    public GameWindow.PlantType getPlantType() {return plantType;}
    public Box[] getTray() {return tray;}
    public void setPlantType(GameWindow.PlantType plantType) {this.plantType = plantType;}

    //*****METHODES******//
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);

        for (int i = 0; i < 50; i++) {
            Box box = tray[i];
            if (box.getEntity() != null) {
                Entity p = box.getEntity();
                if (p instanceof Peashooter) {
                    g.drawImage(((Peashooter) p).getImg(), 60 + (i % 10) * 100, 129 + (i / 10) * 120, null);
                } else if (p instanceof FreezePeashooter) {
                    g.drawImage(((FreezePeashooter) p).getImg(), 60 + (i % 10) * 100, 129 + (i / 10) * 120, null);
                } else if (p instanceof SunFlower) {
                    g.drawImage(((SunFlower) p).getImg(), 60 + (i % 10) * 100, 129 + (i / 10) * 120, null);
                }
            }
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void printConsoleBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Box box = tray[i * 10 + j];
                if (box.getEntity() == null) {
                    System.out.print(".");
                } else {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
