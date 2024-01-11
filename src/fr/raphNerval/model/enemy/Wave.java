package fr.raphNerval.model.enemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Wave {

    //*****ATTRIBUTS*****//
    public static int nbEnemies  = 10;
    public  Map<Integer ,Zombie> wave=new HashMap<>();
    private EnemiesCount enemiesCount;

    //*****CONSTRUCTEUR*****//
    public Wave( int nbEnemies,EnemiesCount enemiesCount){
        this.enemiesCount = enemiesCount;
        Random random = new Random();
        for (int a=0;a<=nbEnemies;a++){
            int choose = random.nextInt(3);
            if(choose==0 && enemiesCount.isMasstifZombie()){
                Zombie enemy=new MastifZombie(100, 100);
                this.add_enemy(enemy);
            }else if(choose == 1 && enemiesCount.isConeZombie()){
                Zombie enemy=new ConeZombie(50, 100);
                this.add_enemy(enemy);

            }else {
                Zombie enemy=new NormalZombie(25, 100);
                this.add_enemy(enemy);
            }

        }
    }


    //*****METHODES******//

    public void add_enemy(Zombie e){
        wave.put(e.getId_enemy(),e);
    }
    public void remove_enemy(Zombie e){
        wave.remove(e.getId_enemy());
    }

    public void check(){
        for (int cle : wave.keySet()) {
            Zombie valeur = wave.get(cle);
            System.out.println(valeur.isSpawned());
        }
    }


}

