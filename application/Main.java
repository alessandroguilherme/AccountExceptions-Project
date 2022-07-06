package application;

import java.util.Scanner;

import model.Exceptions.AccountException;
import model.entities.Account;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter account Data:");
        System.out.print("NUMBER: ");
        int number = input.nextInt();
        System.out.print("HOLDER: ");
        input.next();
        String holder = input.nextLine();
        System.out.print("INITIAL BALANCE: ");
        double balance = input.nextDouble();
        System.out.print("WITHDRAW LIMIT: ");
        double withdrawLimit = input.nextDouble();

        Account account = new Account(number, holder, balance, withdrawLimit);

        System.out.print("\nENTER AMOUNT FOR WITHDRAW: ");
        double amount = input.nextDouble();

        try {
            account.withdraw(amount);

            System.out.println("\nNEW BALANCE: " + account.getBalance());

        } catch (AccountException e) {

            System.out.println("\nWITHDRAW ERROR: " + e.getMessage());

        }

        input.close();

    }

}
