package fr.raphNerval.model.enemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Wave {
    public  Map<Integer ,Zombie> wave=new HashMap<>();
    public Wave(int nb_enemie){
        Random random = new Random();
        for (int a=0;a<=nb_enemie;a++){
            int choose = random.nextInt(3);
            if(choose==0){

                Zombie enemy=new NormalZombie(25, 100);
                this.add_enemy(enemy);
            }else if(choose == 1){
                Zombie enemy=new ConeZombie(50, 100);
                this.add_enemy(enemy);

            }else {
                Zombie enemy=new MastifZombie(50, 100);
                this.add_enemy(enemy);
            }

        }
    }
    public void add_enemy(Zombie e){
        wave.put(e.getId_enemy(),e);
    }
    public void remove_enemy(Zombie e){
        Zombie enemy=wave.remove(e);
        enemy.is_death();
    }



    public void check(){
        for (int cle : wave.keySet()) {
            Zombie valeur = wave.get(cle);
            System.out.println(valeur.isSpawned());
        }
    }


}

