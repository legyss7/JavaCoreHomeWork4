package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начальный баланс: ");
        double balance = scanner.nextDouble();
        System.out.print("Введите сумму депозита: ");
        double deposit = scanner.nextDouble();
        Account account;
        try {
            account = Account.autoCreate(balance, deposit);
            System.out.println("Счет открыт. Новый баланс: " + account.getBalance());
            System.out.println("Сумма на депозите: " + account.getDeposit());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.print("Введите сумму вывода: ");
        double withdrawalAmount = scanner.nextDouble();
        try {
            account.withdrawBalance(withdrawalAmount);
            System.out.println("Вывод успешен. Новый баланс: " + account.getBalance());
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}








