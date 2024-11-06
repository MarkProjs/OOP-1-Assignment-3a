public class Atm {
    private double totalAmount;

    public Atm() {
        this.totalAmount = 0;
    }

    public void checkBalance() {
        System.out.println("Your balance is: $"+ String.format("%.2f", this.totalAmount));
    }

    public void deposit(int amountDeposit) {
        this.totalAmount += amountDeposit;
        System.out.println("Deposit successful!");
    }

    public String withdraw(int amountWithdraw) {
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
