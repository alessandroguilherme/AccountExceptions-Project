package model.entities;

import model.Exceptions.AccountException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        this.balance += amount;

    }

    public void withdraw(double amount) throws AccountException{
       withdrawControl(amount);
        this.balance -= amount;
    }

    private void withdrawControl(double amount) throws AccountException {
        if (amount > this.balance) {
            throw new AccountException("NOT ENOUGH BALANCE !");
        }
        if (amount > this.withdrawLimit) {
            throw new AccountException("THE AMOUNT EXCEENDS WITHDRAW LIMIT !");
        }
    }

}
