package fr.raphNerval.model;

public class TowersCount {
    private boolean isFreezePeashooterAvailable;
    private boolean isPeashooterAvailable;
    private boolean isSunFlowerAvailable;
    private boolean isWalnutAvailable;

    public TowersCount(boolean isSunFlowerAvailable, boolean isPeashooterAvailable, boolean isWalnutAvailable, boolean isFreezePeashooterAvailable) {
        this.isFreezePeashooterAvailable = isFreezePeashooterAvailable;
        this.isPeashooterAvailable = isPeashooterAvailable;
        this.isSunFlowerAvailable = isSunFlowerAvailable;
        this.isWalnutAvailable = isWalnutAvailable;
    }

    public boolean isFreezePeashooterAvailable() {
        return isFreezePeashooterAvailable;
    }

    public void setFreezePeashooterAvailable(boolean freezePeashooterAvailable) {
        isFreezePeashooterAvailable = freezePeashooterAvailable;
    }

    public boolean isPeashooterAvailable() {
        return isPeashooterAvailable;
    }

    public void setPeashooterAvailable(boolean peashooterAvailable) {
        isPeashooterAvailable = peashooterAvailable;
    }

    public boolean isSunFlowerAvailable() {
        return isSunFlowerAvailable;
    }

    public void setSunFlowerAvailable(boolean sunFlowerAvailable) {
        isSunFlowerAvailable = sunFlowerAvailable;
    }

    public boolean isWalnutAvailable() {
        return isWalnutAvailable;
    }

    public void setWalnutAvailable(boolean walnutAvailable) {
        isWalnutAvailable = walnutAvailable;
    }
}
