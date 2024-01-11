package fr.raphNerval.model.enemy;

import java.io.Serializable;

public class EnemiesCount implements Serializable {

    //*****ATTRIBUTS*****//
    private boolean isNormalZombie;
    private boolean isConeZombie;
    private boolean isMasstifZombie;
    private static final long serialVersionUID = 1L;

    //*****CONSTRUCTEUR*****//
    public EnemiesCount(boolean isNormalZombie, boolean isConeZombie, boolean isMasstifZombie) {
        this.isNormalZombie = isNormalZombie;
        this.isConeZombie = isConeZombie;
        this.isMasstifZombie = isMasstifZombie;
    }

    //*****ACCESSEURS*****//
    public boolean isNormalZombie() {
        return isNormalZombie;
    }
    public void setNormalZombie(boolean normalZombie) {
        isNormalZombie = normalZombie;
    }
    public boolean isConeZombie() {return isConeZombie;}
    public void setConeZombie(boolean coneZombie) {
        isConeZombie = coneZombie;
    }
    public boolean isMasstifZombie() {
        return isMasstifZombie;
    }
    public void setMasstifZombie(boolean masstifZombie) {
        isMasstifZombie = masstifZombie;
    }
}


