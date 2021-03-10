package com.java.net.bank;

import java.util.Scanner;

/*
 * @author:-Tirtha Sharma
 * Position:- Full Stack Sofware Developer
 * 
 */

public class BankingApplication {

	public static void main(String[] args) {

		// creating the object of Bank Class

		Bank bank = new Bank("Balwan", "B001");
		bank.showMenu();

	}

}

class Bank {

	int balance;
	int previousTransaction;
	String customerId;
	String customerName;

	public Bank(String cname, String cid) {
		this.customerId = cid;
		this.customerName = cname;
	}

	public void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}

	public void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}

	public void getPreviousTransaction() {

		if (previousTransaction > 0) {
			System.out.println("Deposited:- " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn:- " + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occured!!!");
		}
	}

	public void showMenu() {

		char option = '\0';
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome:- " + customerName);
		System.out.println("Your id is:- " + customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");

		do {
			System.out.println("===============================");
			System.out.println("Enter an option");
			System.out.println("===============================");
			option = scan.next().charAt(0);
			System.out.println("\n");
			switch (option) {

			case 'A':
				System.out.println("==========================");
				System.out.println("Checking the Balance:- " + balance);
				System.out.println("==========================");
				System.out.println("\n");
				break;

			case 'B':
				System.out.println("==========================");
				System.out.println("Enter an amount to deposit:-");
				int dep_amount = scan.nextInt();
				deposit(dep_amount);
				System.out.println("==========================");
				System.out.println("\n");
				break;

			case 'C':
				System.out.println("==========================");
				System.out.println("Enter an amount to withdraw:-");
				int with_amount = scan.nextInt();
				withdraw(with_amount);
				System.out.println("==========================");
				System.out.println("\n");
				break;

			case 'D':
				System.out.println("==========================");
	                        System.out.println("Checking Previous Transactions:-");
				getPreviousTransaction();
				System.out.println("==========================");
				System.out.println("\n");
				break;

			case 'E':
				System.out.println("Exiting from the Bank Application!!");
				break;

			default:
				System.out.println("Invalid option took place and could not proceed further.Please try again!!!");
				break;
			}

		} while (option != 'E');

	}

}
