//-------------------------
//Assignment 3
//Written by: Mark Benedict Agluba, 40294956
//For COMP 248 S - Fall 2024
//-------------------------

//Java program that emulates an ATM. The program will allow the users to deposit money, withdraw and check their balance.
import java.util.Scanner;
public class A3_Q1 {
	private double totalAmount;

	public A3_Q1() {
		totalAmount = 0;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		A3_Q1 main = new A3_Q1();
		System.out.println("Welcome to the Best Bank ATM");
		boolean exitProgram = false;
		while (exitProgram != true) {
			System.out.println("------------------------------");
			System.out.println("Please choose an option: ");
			System.out.println("\t"+ "1. Check Balance");
			System.out.println("\t"+ "2. Deposit");
			System.out.println("\t"+ "3. Withdraw");
			System.out.println("\t"+ "4. Exit");
			System.out.print("Enter your choice: ");
			int userChoice = input.nextInt();
			if (userChoice == 1){
				main.checkBalance();
			} else if (userChoice == 2) {
				System.out.print("Enter amount to deposit: ");
				int deposit = input.nextInt();
				main.deposit(deposit);
			} else if(userChoice == 3) {
				System.out.print("Enter amount to withdraw(multiples of 5, 10, 50, or 100): ");
				int withdraw = input.nextInt();
				System.out.println(main.withdraw(withdraw));
			}
			else if (userChoice==4) {
				System.out.println("Goodbye!");
				exitProgram = true;
			} else {
				System.out.println("Invalid choice! Please try again.");
			}
			System.out.println();
		}
		input.close();
	}

	private void checkBalance() {
		System.out.println("Your balance is: $"+ String.format("%.2f", this.totalAmount));
	}

	private void deposit(int amountDeposit) {
        if( amountDeposit < 0) {
            System.out.println("You cannot deposit a negative number. Please try again!");
        } else {
            this.totalAmount += amountDeposit;
            System.out.println("Deposit successful!");
        }
    }

	private String withdraw(int amountWithdraw) {
        String bills = "You will receive: " + "\n";
        if(amountWithdraw > this.totalAmount) {
            bills = "You cannot withdraw more than the current balance.";
        }
        else if(amountWithdraw % 5 != 0) {
            bills="Invalid withdrawal amount! You can only withdraw amounts that are multiples of 5, 10, 50, or 100";
        } else {
            this.totalAmount -= amountWithdraw;
            while (amountWithdraw > 0 ) {
                if(amountWithdraw / 100 != 0) {
                    bills += "\t"+ (amountWithdraw /100)+" bill(s) of $100"+"\n";
                    amountWithdraw %=100;
                } else if(amountWithdraw / 50 != 0) {
                    bills += "\t"+ (amountWithdraw /50)+" bill(s) of $50"+"\n";
                    amountWithdraw %=50;
                } else if (amountWithdraw / 10 != 0) {
                    bills += "\t"+ (amountWithdraw /10)+" bill(s) of $10"+"\n";
                    amountWithdraw %=10;
                } else if (amountWithdraw / 5 != 0) {
                    bills += "\t"+ (amountWithdraw /5)+" bill(s) of $5"+"\n";
                    amountWithdraw %=5;
                }
            }
            bills += "Withdrawal successful!";    
        }
        return bills;
    }
}

