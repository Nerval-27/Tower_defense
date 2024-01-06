package fr.raphNerval.view;

import fr.raphNerval.Player.player;
import fr.raphNerval.controller.GameController;
import fr.raphNerval.controller.PlantCard;
import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.Entity;
import fr.raphNerval.model.Projectile.projectile;
import fr.raphNerval.model.Projectile.simple_bullet;
import fr.raphNerval.model.Projectile.stop_bullet;
import fr.raphNerval.model.enemy.Mastiff;
import fr.raphNerval.model.enemy.Wave;
import fr.raphNerval.model.enemy.Zombie;
import fr.raphNerval.model.enemy.clacker;
import fr.raphNerval.model.tower.FreezePeashooter;
import fr.raphNerval.model.tower.Peashooter;
import fr.raphNerval.model.tower.Plant;
import fr.raphNerval.model.tower.SunFlower;
import fr.raphNerval.model.field.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class GamePanel extends JPanel implements MouseMotionListener {

    //*****ATTRIBUTS*****//
    private Image backgroundImage;
    private Box[][] tray;
    private Timer gameTimer;
    private ActionListener gameUpdater;
     private Wave wave;
    private Random random;
    private long lastTime; // nouvelle variable pour stocker le temps de la dernière mise à jour



    public player getPlayer() {
        return player;
    }
    private player player;
    private GameWindow.PlantType plantType = GameWindow.PlantType.None;
    private int mouseX, mouseY;

    //*****CONSTRUCTEUR*****//
    /**
     * 
     */
    public GamePanel() {
        setSize(1000, 752);
        setLayout(null);
        addMouseMotionListener(this);


        backgroundImage = new ImageIcon(getClass().getResource("/images/BG.png")).getImage();
        lastTime = System.nanoTime(); // initialiser le temps de la dernière mise à jour


        tray = new Box[5][10]; // Changed to a 2D array
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Box box = new Box();
                box.setLocation(44 + j * 100, 109 + i * 120);
                tray[i][j] = box;
                box.setActionListener(new GameController(this, j, i));
                add(box);
            }
        }

        player=new player();

        PlantCard cardSunFlower = new PlantCard("/images/card_sunflower.png");
        cardSunFlower.setLocation(100, 8);
        cardSunFlower.setActionListener((ActionEvent e) -> {
            plantType = GameWindow.PlantType.Sunflower;
            //System.out.println("sunflower");
        });
        add(cardSunFlower);

        PlantCard cardFreezePeaShooter = new PlantCard("/images/card_freezepeashooter.png");
        cardFreezePeaShooter.setLocation(230, 8);
        cardFreezePeaShooter.setActionListener((ActionEvent e) -> {
            plantType = GameWindow.PlantType.FreezePeashooter;
            //System.out.println("freezepeashooter");
        });
        add(cardFreezePeaShooter);

        PlantCard cardPeaShooter = new PlantCard("/images/card_peashooter.png");
        cardPeaShooter.setLocation(165, 8);
        cardPeaShooter.setActionListener((ActionEvent e) -> {
            plantType = GameWindow.PlantType.Peashooter;
            //System.out.println("peashooter");
        });
        add(cardPeaShooter);

        //ajoute les entités

        random = new Random();
        int line = random.nextInt(6);
        wave=new Wave(4);
       /*  Timer timer = new Timer(1000, new ActionListener() {
            // Position horizontale de l'image
           @Override
           public void actionPerformed(ActionEvent e) {
               // Mettre à jour la position de l'image
               int y=random.nextInt(5);
               tray[y][tray[y].length-1].spawn( wave);
               Box.movedZombie_All(tray);
               Box.all_Plant_shoot(tray);
               Box.all_Plant_shoot_move(tray,player);
               //Box.PlantO(boxs);
               // Redessiner l'interface utilisateur
               revalidate();
               repaint();
           }
       });
       // Démarrer le minuteur
       timer.start();*/




       gameUpdater = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            long now = System.nanoTime();
            double delta = (now - lastTime) / 1e9; // convertir en secondes
            lastTime = now;

            // Mettre à jour la logique du jeu avec delta
            update(delta);

            // Redessiner l'interface utilisateur
            revalidate();
            repaint();
        }
    };

    int updateInterval = 100; // par exemple, une mise à jour toutes les 16 millisecondes
    gameTimer = new Timer(updateInterval, gameUpdater);
    gameTimer.start();
       }



       private void update(double delta) {
              int y=random.nextInt(5);
               tray[y][tray[y].length-1].spawn( wave);
               Box.movedZombie_All(tray);
               Box.all_Plant_shoot(tray);
               Box.all_Plant_shoot_move(tray,player);
       }

    //*****ACCESSEURS*****//
    public GameWindow.PlantType getPlantType() {
        return plantType;
    }

    public Box[][] getTray() {
        return tray;
    }

    public void setPlantType(GameWindow.PlantType plantType) {
        this.plantType = plantType;
    }

    //*****METHODES******//
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Box box = tray[i][j];
                for(Entity p:box.getEntities()){
                     if (p != null) {
                         if (p instanceof Peashooter) {
                        g.drawImage(((Peashooter) p).getImg(), 60 + j * 100, 129 + i * 120, null);
                        ((Peashooter) p).setPos(new RealCoordinates(box.getX(),box.getY()));
                        if(((Plant)p).getBullet()!=null){
                             projectile b=((Plant)p).getBullet();
                            //System.out.println(((Plant)p).getBullet().getPos());
                            g.drawImage(((simple_bullet)b).getImage(),(int)((Plant)p).getBullet().getPos().x(),(int)((Plant)p).getBullet().getPos().y(),50,50,null);
                        }

                    } else if (p instanceof FreezePeashooter) {
                          (( FreezePeashooter) p).setPos(new RealCoordinates(box.getX(),box.getY()));
                        g.drawImage(((FreezePeashooter) p).getImg(), 60 + j * 100, 129 + i * 120, null);
                         if(((Plant)p).getBullet()!=null){
                            projectile b=((Plant)p).getBullet();
                            //System.out.println(((Plant)p).getBullet().getPos());
                            g.drawImage(((stop_bullet)b).getImage(),(int)((Plant)p).getBullet().getPos().x(),(int)((Plant)p).getBullet().getPos().y(),50,50,null);
                        }
                    } else if (p instanceof SunFlower) {
                             ((SunFlower) p).setPos(new RealCoordinates(box.getX(),box.getY()));
                        g.drawImage(((SunFlower) p).getImg(), 60 + j * 100, 129 + i * 120, null);
                         if(((Plant)p).getBullet()!=null){
                            projectile b=((Plant)p).getBullet();
                            //System.out.println(((Plant)p).getBullet().getPos());
                            g.drawImage(((simple_bullet)b).getImage(),(int)((Plant)p).getBullet().getPos().x(),(int)((Plant)p).getBullet().getPos().y(),50,50,null);
                        }
                    }
                }
                    if (p instanceof Zombie ) {
                // Dessine l'entité à la bordure gauche de la boîte
                Zombie l=(Zombie)p;
                int entityX =(int)l.getPos().x();
                int entityY =(int)l.getPos().y();
            // System.out.println(l.getPos()+" "+"X"+" "+(((int)l.getPos().y()/100)-1)+" "+(((int)l.getPos().x()/100)));
                // Dessine l'entité
                if(l instanceof clacker){
                   g.drawImage(((clacker)l).getModel(), entityX, entityY,100,100, null);
                 }else if(l instanceof Mastiff){
                      g.drawImage(((Mastiff)l).getModel(), entityX, entityY, 100,100,null);
                }
        }
            }}}}

    @Override
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    /*public void printConsoleBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Box box = tray[i][j];
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
    }*/
}
