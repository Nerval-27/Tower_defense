package fr.raphNerval.model.enemy;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import fr.raphNerval.geometrie.IntCoordinates;
import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.Entity;
import fr.raphNerval.model.field.Box;

public class Wave {
     public  Map<Integer ,Zombie> wave=new HashMap<>();
     public Wave(int nb_enemie){
          Random random = new Random();
        for (int a=0;a<=nb_enemie;a++){
             int choose = random.nextInt(2);
             if(choose==0){

                Zombie enemy=new clacker(10, 100);
                this.add_enemy(enemy);
             }else{
                 Zombie enemy=new Mastiff(50, 100);
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
