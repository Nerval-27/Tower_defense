package fr.raphNerval.model.tower;

public class TowersCount {

    //*****ATTRIBUTS*****//
    private boolean isFreezePeashooterAvailable;
    private boolean isPeashooterAvailable;
    private boolean isSunFlowerAvailable;
    private boolean isWalnutAvailable;

    //*****CONSTRUCTEUR*****//
    public TowersCount(boolean isSunFlowerAvailable, boolean isPeashooterAvailable, boolean isWalnutAvailable, boolean isFreezePeashooterAvailable) {
        this.isFreezePeashooterAvailable = isFreezePeashooterAvailable;
        this.isPeashooterAvailable = isPeashooterAvailable;
        this.isSunFlowerAvailable = isSunFlowerAvailable;
        this.isWalnutAvailable = isWalnutAvailable;
    }

    //*****ACCESSEURS*****//
    public boolean isFreezePeashooterAvailable() {
        return isFreezePeashooterAvailable;
    }
    public boolean isPeashooterAvailable() {
        return isPeashooterAvailable;
    }
    public boolean isSunFlowerAvailable() {
        return isSunFlowerAvailable;
    }
    public boolean isWalnutAvailable() {
        return isWalnutAvailable;
    }

}

