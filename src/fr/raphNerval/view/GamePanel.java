package fr.raphNerval.view;

import fr.raphNerval.controller.GameController;
import fr.raphNerval.controller.PlantCard;
import fr.raphNerval.controller.Shovel;
import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.Entity;
import fr.raphNerval.model.enemy.*;
import fr.raphNerval.model.field.Box;
import fr.raphNerval.model.projectile.Bullet;
import fr.raphNerval.model.projectile.FreezePea;
import fr.raphNerval.model.projectile.Pea;
import fr.raphNerval.model.projectile.Sun;
import fr.raphNerval.model.tower.*;
import fr.raphNerval.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class GamePanel extends JPanel implements Serializable {

    //*****ATTRIBUTS*****//
    private Image backgroundImage;
    public static String pathBG = "/images/BG.png";
    private Image imgScore;
    private Box[][] tray;
    private Timer gameTimer;
    private ActionListener gameUpdater;
    private Wave wave;
    private Random random;
    private long lastTime; // nouvelle variable pour stocker le temps de la dernière mise à jour
    public static JLabel moneyLabel;
    private Player player;
    private GameWindow.PlantType plantType = GameWindow.PlantType.None;
    private TowersCount towersCount;
    private EnemiesCount enemiesCount;


    //*****CONSTRUCTEUR*****//
    public GamePanel(TowersCount towersCount, EnemiesCount enemiesCount) {
        setSize(1000, 752);
        setLayout(null);
        this.enemiesCount = enemiesCount;
        this.towersCount = towersCount;
        backgroundImage = new ImageIcon(getClass().getResource(pathBG)).getImage();
        lastTime = System.nanoTime();


        //ajoute le score d'argent
        moneyLabel = new JLabel("" +200);
        moneyLabel.setBounds(50, 80, 100, 30);
        add(moneyLabel);
        player = new Player(moneyLabel, 200);

        lastTime = System.nanoTime(); // initialiser le temps de la dernière mise à jour
        imgScore = new ImageIcon(getClass().getResource("/images/score.jpg")).getImage() ;


        tray = new Box[5][10]; // Changed to a 2D array
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Box box = new Box();
                box.setLocation(44 + j * 100, 109 + i * 120);
                tray[i][j] = box;
                box.setActionListener(new GameController(this, j, i,player));
                add(box);
            }
        }


        int xPosition = 35;
        if(towersCount.isSunFlowerAvailable()) {
            xPosition += 65;
            addCard("/images/cards/card_sunflower.png", xPosition, 8, GameWindow.PlantType.Sunflower);
        }
        if(towersCount.isPeashooterAvailable()){
            xPosition+=65;
            addCard("/images/cards/card_peashooter.png",xPosition, 8,GameWindow.PlantType.Peashooter );
        }
        if(towersCount.isWalnutAvailable()){
            xPosition+=65;
            addCard("/images/cards/card_walnut.png",xPosition, 8,GameWindow.PlantType.Walnut );
        }
        if(towersCount.isFreezePeashooterAvailable()){
            xPosition+=65;
            addCard("/images/cards/card_freezepeashooter.png",xPosition, 8,GameWindow.PlantType.FreezePeashooter );
        }

        //ajout de la pelle
        Shovel shovel = new Shovel();
        shovel.setLocation(565, 0);
        shovel.setActionListener((ActionEvent e) -> {
            plantType = GameWindow.PlantType.Shovel;
           // System.out.println("pelle");
        });
        add(shovel);

        //bouton pause
        JButton pauseButton = new JButton(new ImageIcon(getClass().getResource("/images/buttons/menuButton.jpg")));
        pauseButton.setBounds(855, 4, 139, 33);
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseGame();
            }
        });
        add(pauseButton);

        //ajoute les entités
        random = new Random();
        int line = random.nextInt(6);
        int choose=random.nextInt(3);
        wave=new Wave(Wave.nbEnemies,enemiesCount);

       ActionListener spawner_time= event -> {
        int y=random.nextInt(5);
        tray[y][tray[y].length-1].spawn( wave);

           if(towersCount.isFreezePeashooterAvailable() && towersCount.isPeashooterAvailable()
                   && towersCount.isWalnutAvailable() && towersCount.isSunFlowerAvailable()) {
             //  System.out.println("vague infini");
               if(choose==0 && enemiesCount.isMasstifZombie()){
                   Zombie enemy=new MastifZombie(50, 1000);
                   wave.add_enemy(enemy);
               }else if(choose == 1 && enemiesCount.isConeZombie()){
                   Zombie enemy=new ConeZombie(50, 200);
                   wave.add_enemy(enemy);
               }else {
                   Zombie enemy=new NormalZombie(25, 100);
                   wave.add_enemy(enemy);
               }
           }
    };
   
    Timer timer_2 = new Timer(3000, spawner_time);
    timer_2.start(); 


    gameUpdater = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            long now = System.nanoTime();
            double delta = (now - lastTime) / 1e9;
            lastTime = now;
            if(Box.getNb_InZone()==3){
                Box.setNb_InZone(0);
                gameTimer.stop();
                GameWindow.gameWindow.switchPanel(new EndGame("/images/gameover.jpg"));
            }
            if(wave.wave.size() == 0 && !Box.leftZombie(tray)){
                gameTimer.start();
                GameWindow.gameWindow.switchPanel(new EndGame("/images/victory.jpg"));
            }
            update(delta);
            revalidate();
            repaint();
        }};

        int updateInterval = 100;
        gameTimer = new Timer(updateInterval, gameUpdater);
        gameTimer.start();

    }


    //*****ACCESSEURS*****//
    public GameWindow.PlantType getPlantType() {
        return plantType;
    }
    public Player getPlayer(){return player;}

    public void setPlantType(GameWindow.PlantType plantType) {
        this.plantType = plantType;
    }


    //*****METHODES******//

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, null);
        g.drawImage(imgScore,10,70,null);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                Box box = tray[i][j];
                for (Entity p : box.getEntities()) {
                    if (p != null) {
                        if (p instanceof Peashooter) {
                            g.drawImage(((Peashooter) p).getImg(), 60 + j * 100, 129 + i * 120, null);
                            ((Peashooter) p).setPos(new RealCoordinates(box.getX(), box.getY()));
                            if (((Plant) p).getBullet() != null) {
                                Bullet b = ((Plant) p).getBullet();
                                //System.out.println(((Plant)p).getBullet().getPos());
                                g.drawImage(((Pea) b).getImage(), (int) ((Plant) p).getBullet().getPos().x(), (int) ((Plant) p).getBullet().getPos().y(), 50, 50, null);
                            }

                        } else if (p instanceof FreezePeashooter) {
                            ((FreezePeashooter) p).setPos(new RealCoordinates(box.getX(), box.getY()));
                            g.drawImage(((FreezePeashooter) p).getImg(), 60 + j * 100, 129 + i * 120, null);
                            if (((Plant) p).getBullet() != null) {
                                Bullet b = ((Plant) p).getBullet();
                                //System.out.println(((Plant)p).getBullet().getPos());
                                g.drawImage(((FreezePea) b).getImage(), (int) ((Plant) p).getBullet().getPos().x(), (int) ((Plant) p).getBullet().getPos().y(), 50, 50, null);
                            }
                        } else if (p instanceof SunFlower) {
                            ((SunFlower) p).setPos(new RealCoordinates(box.getX(), box.getY()));
                            g.drawImage(((SunFlower) p).getImg(), 60 + j * 100, 129 + i * 120, null);
                            if (((Plant) p).getBullet() != null) {
                                Bullet b = ((Plant) p).getBullet();
                                if (((Sun) b).isShow()) {
                                    g.drawImage(((Sun) b).getImage(), (int) ((Plant) p).getBullet().getPos().x(), (int) ((Plant) p).getBullet().getPos().y(), 50, 50, null);
                                }
                            }
                        } else if (p instanceof Walnut) {
                            ((Walnut) p).setPos(new RealCoordinates(box.getX(), box.getY()));
                            g.drawImage(((Walnut) p).getImg(), 60 + j * 100, 129 + i * 120, null);
                        }
                        if (p instanceof Zombie) {
                            // Dessine l'entité à la bordure gauche de la boîte
                            Zombie l = (Zombie) p;
                            int entityX = (int) l.getPos().x();
                            int entityY = (int) l.getPos().y();
                            // System.out.println(l.getPos()+" "+"X"+" "+(((int)l.getPos().y()/100)-1)+" "+(((int)l.getPos().x()/100)));
                            // Dessine l'entité
                            if (l instanceof NormalZombie) {
                                g.drawImage(((NormalZombie) l).getModel(), entityX, entityY, 100, 100, null);
                            } else if (l instanceof ConeZombie) {
                                g.drawImage(((ConeZombie) l).getModel(), entityX, entityY, 100, 100, null);
                            } else if (l instanceof MastifZombie) {
                                g.drawImage(((MastifZombie) l).getModel(), entityX, entityY, 100, 100, null);
                            }
                        }
                    }
                }
            }
        }
    }
    

    private void pauseGame() {
        gameTimer.stop();
        Object[] options = {"Sauvegarder", "Menu", "Reprendre"}; // Affiche une boîte de dialogue avec trois boutons
        int choice = JOptionPane.showOptionDialog(this,"","", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                break;
            case 1:
                if (GameWindow.gameWindow != null) {
                    MenuPanel menuPanel = new MenuPanel();
                    GameWindow.gameWindow.switchPanel(menuPanel);
                }
                break;
            case 2:
                gameTimer.start();
                break;
        }
    }

    private void update(double delta) {
        Box.movedZombie_All(tray,wave);
        Box.all_Plant_shoot(tray);
        Box.all_Plant_shoot_move(tray,wave,player);
    }

    private void addCard(String imagePath, int x, int y, GameWindow.PlantType plant) {
        PlantCard card = new PlantCard(imagePath);
        card.setLocation(x, y);
        card.setActionListener((ActionEvent e) -> {
            plantType = plant;
        });
        add(card);
    }



}
