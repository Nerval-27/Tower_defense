package fr.raphNerval.model.tower;

import fr.raphNerval.geometrie.RealCoordinates;
import fr.raphNerval.model.Entity;
import fr.raphNerval.model.enemy.Wave;
import fr.raphNerval.model.enemy.Zombie;
import fr.raphNerval.model.field.Box;
import fr.raphNerval.model.projectile.Bullet;
import fr.raphNerval.model.projectile.FreezePea;
import fr.raphNerval.model.projectile.Pea;
import fr.raphNerval.model.projectile.Sun;
import fr.raphNerval.player.Player;
import fr.raphNerval.view.GamePanel;

import java.util.ArrayList;

public class Plant extends  Entity {

    //*****ATTRIBUTS*****//
    private GamePanel gamePanel;
    protected int x,y;
    protected int damage;
    private boolean shoot=false;
    private RealCoordinates pos;
    private Bullet bullet=null;

    //*****CONSTRUCTEUR*****//
    public Plant(GamePanel gamePanel, int x, int y) {
        super(500, 0);
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
    public Bullet getBullet() {
        return bullet;
    }
    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
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
       // System.out.println(line+" "+column+" "+getPos()+" Pos "+" "+line+" "+column);
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
        if(!(this instanceof SunFlower)){
        if(this.InFrontOf(boxs).size()>0 ){
            shoot=true;
            if(bullet==null){
                if(this instanceof FreezePeashooter){
                    bullet=new FreezePea();
                    bullet.setPos(this.getPos().plus(new RealCoordinates(70, 0)));
                }else{
                    bullet=new Pea();
                    bullet.setPos(this.getPos().plus(new RealCoordinates(70, 0)));
                }
            }
        }
    }else{
            bullet=new Sun();
            bullet.setPos(this.getPos().plus(new RealCoordinates(70, 80)));
         }
    }

    public void bullet_move(Box [][] boxs,Wave wave,Player p){
        if(bullet!=null){
        if(!(bullet instanceof Sun)){
            bullet.setTarget(this.targetLock(boxs));
            if(bullet.getTarget()!=null){
                if(bullet.getPos().plus(new RealCoordinates(50, 0)).x()<bullet.getTarget().getPos().x()){
                    bullet.setPos(bullet.getPos().plus(new RealCoordinates(50, 0)));
                }else{
                    if(bullet instanceof FreezePea){
                        bullet.getTarget().receivedDamage(300);
                        ((FreezePea)bullet).stop_mouvement(2000);
                    }else{
                        bullet.getTarget().receivedDamage(200);
                    }
                    if( bullet.getTarget().getHealth()<=0){
                        wave.remove_enemy(bullet.getTarget());
                        p.setMoney(p.getMoney()+bullet.getTarget().getReward());
                        boxs[((int)bullet.getTarget().getPos().y()/100)-1][(((int)bullet.getTarget().getPos().x()/100))].removeEntity(bullet.getTarget());
                    }
                    bullet=null;
                }
            }else{
                bullet=null;
            }}else{
                if(!((SunFlower)this).isActive()){
                    ((SunFlower)this).setActive(true);
                    ((SunFlower)this).show_bullet(7000,p);
                    ((Sun)this.getBullet()).setShow(false);

                }
            }
        }
    }
}
