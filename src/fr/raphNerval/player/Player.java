package fr.raphNerval.player;

import javax.swing.*;

public class Player {

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money += money;
        updateMoneyLabel();
    }

    private int money;
    private JLabel moneyLabel;
    public Player(JLabel moneyLabel) {
        this.moneyLabel = moneyLabel;
        money = 500;
        updateMoneyLabel();
    }
    private void updateMoneyLabel() {
        moneyLabel.setText("" + money);
    }

}