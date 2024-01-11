package fr.raphNerval.player;

import javax.swing.*;

public class Player {

    //*****ATTRIBUTS*****//
    private int money;
    private JLabel moneyLabel;

    //*****CONSTRUCTEUR*****//
    public Player(JLabel moneyLabel, int initialMoney) {
        this.moneyLabel = moneyLabel;
        this.money = initialMoney;
        updateMoneyLabel();
    }

    //*****ACCESSEURS*****//
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
        updateMoneyLabel();
    }

    //*****METHODES******//
    public boolean placePlant(int cost) {
        if (money >= cost) {
            money -= cost;
            updateMoneyLabel();
            return true;
        } else {
            return false;
        }
    }

    private void updateMoneyLabel() {
        moneyLabel.setText("" + money);
    }
}
