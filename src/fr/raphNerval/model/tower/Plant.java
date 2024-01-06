package fr.raphNerval.model.tower;

import fr.raphNerval.Player.player;
import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.Entity;
import fr.raphNerval.model.Projectile.projectile;
import fr.raphNerval.model.Projectile.simple_bullet;
import fr.raphNerval.model.Projectile.stop_bullet;
import fr.raphNerval.model.enemy.Zombie;
import fr.raphNerval.model.field.Box;
import fr.raphNerval.view.GamePanel;
import java.util.ArrayList;

public class Plant extends  Entity {

    //*****ATTRIBUTS*****//
    private GamePanel gamePanel;
    protected int x,y;
    protected int damage;
    private boolean shoot=false;
    private RealCoordinates pos;
    public projectile getBullet() {
        return bullet;
    }

    public void setBullet(projectile bullet) {
        this.bullet = bullet;
    }

    private projectile bullet=null;

    //*****CONSTRUCTEUR*****//
    public Plant(GamePanel gamePanel, int x, int y) {
        super(200, 0);
        this.gamePanel = gamePanel;
        this.x = x;
        this.y = y;
    }

    //*****ACCESSEURS*****//

    public RealCoordinates getPos() {
        return pos;
    }

    public void setPos(RealCoordinates pos) {
        this.pos = pos;
    }
  


    //*****METHODES******//
    public void receivedDamage(int damage){
        if(this.health-damage>=0){
        this.health-=damage;
    }
    }
     public ArrayList<Zombie> InFrontOf(Box [][] box){
        ArrayList <Zombie> zombies = new ArrayList<Zombie>();
        int line=(((int)this.getPos().y()/100)-1);
        int column=(((int)this.getPos().x()/100));
        System.out.println(line+" "+column+" "+getPos()+" Pos "+" "+line+" "+column);
        for(int a=column;a<box[line].length;a++){
            for(Entity zombie:box[line][a].getEntities()){
                if(zombie instanceof Zombie){
                    zombies.add((Zombie)zombie);
                }
            }
        }
        return zombies;
    }

    public Zombie targetLock(Box[][] box){
        Zombie target=null;
        for(Zombie zombie:this.InFrontOf(box)){
            if(target!=null){
                  if((int)zombie.getPos().x()<target.getPos().x()){
                      target=zombie;
            }
            }else{
                  target=zombie;
            }
        }
        return target;
    }

    public void shoot (Box [][] boxs){
        if(this.InFrontOf(boxs).size()>0 ){
            shoot=true;
            if(bullet==null){
                if(this instanceof FreezePeashooter){
                     bullet=new stop_bullet();
                     bullet.setPos(this.getPos().plus(new RealCoordinates(70, 0)));

                }else{
                 bullet=new simple_bullet();
                 bullet.setPos(this.getPos().plus(new RealCoordinates(70, 0)));
            }}
        }
            }
    public void bullet_move(Box [][] boxs,player p){
            if(bullet!=null){
              bullet.setTarget(this.targetLock(boxs));
              if(bullet.getTarget()!=null){
        if(bullet.getPos().plus(new RealCoordinates(200, 0)).x()<bullet.getTarget().getPos().x()){
            bullet.setPos(bullet.getPos().plus(new RealCoordinates(200, 0)));
           }else{
               bullet.getTarget().receivedDamage(500);
               if(bullet instanceof stop_bullet){
                ((stop_bullet)bullet).stop_mouvement(8000);
               }
               if( bullet.getTarget().getHealth()<=0){
                p.setMoney(bullet.getTarget().getReward());
                boxs[((int)bullet.getTarget().getPos().y()/100)-1][(((int)bullet.getTarget().getPos().x()/100))].removeEntity(bullet.getTarget());
               }
               bullet=null;
           }
       }else{
            bullet=null;
       }
        }}}
