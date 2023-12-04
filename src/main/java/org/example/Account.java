package org.example;

public class Account {
    private double balance;
    private double deposit;

    public static Account autoCreate(double balance, double deposit) throws IllegalArgumentException {
        if (balance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        if (deposit < 0) {
            throw new IllegalArgumentException("Сумма депозита не может быть отрицательной");
        }
        return new Account(balance, deposit);
    }
    public Account(double balance, double deposit) {
        setBalance(balance);
        setDeposit(deposit);
    }

    public void withdrawBalance(double amount) throws InsufficientFundsException, IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Запрашиваемая сумма не может быть отрицательной!");
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException("Недостаточно средств. Текущий баланс: " + this.balance);
        }
        this.balance -= amount;
    }


    public double getBalance() {
        return this.balance;
    }

    public double getDeposit() {
        return this.deposit;
    }

    public void setBalance(double balance)  {
        this.balance = balance;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
}
