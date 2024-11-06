//-------------------------
//Assignment 3
//Written by: Mark Benedict Agluba, 40294956
//For COMP 248 S - Fall 2024
//-------------------------

//Java program that emulates an ATM. The program will allow the users to deposit money, withdraw and check their balance.
//
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Atm atm = new Atm();
		System.out.println("Welcome to the Best Bank ATM");
		boolean exitProgram = false;
		do {
			System.out.println("------------------------------");
			System.out.println("Please choose an option: ");
			System.out.println("\t"+ "1. Check Balance");
			System.out.println("\t"+ "2. Deposit");
			System.out.println("\t"+ "3. Withdraw");
			System.out.println("\t"+ "1. Exit");
			System.out.print("Enter your choice: ");
			int userChoice = input.nextInt();
			switch (userChoice) {
				case 1:
					atm.checkBalance();
					break;
				case 2:
					System.out.print("Enter amount to deposit: ");
					int deposit = input.nextInt();
					atm.deposit(deposit);
					break;
				case 3:
					System.out.print("Enter amount to withdraw(multiples of 5, 10, 50, or 100): ");
					int withdraw = input.nextInt();
					atm.withdraw(withdraw);
					break;
				case 4:
					System.out.println("Goodbye!");
					exitProgram = true;
					break;
				default:
					System.out.println("Invalid choice! Please try again.");
					break;
			}
			System.out.println();
		} while (exitProgram);
		
	}

}
