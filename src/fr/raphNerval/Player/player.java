package fr.raphNerval.Player;

public class player {
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money += money;
    }

    private int money;

    public player(){
        money=500;

}}
