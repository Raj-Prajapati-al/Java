// Create a custom exception class and use it in your program

import java.util.Scanner;

class FunnyWarning extends Exception
{
    double amount;
    public FunnyWarning(double amount)
    {
        this.amount = amount;
    }
}
class Bank
{
    double balance;
    public Bank(double balance)
    {
        this.balance = balance;
    }
    public void withdrawAmount(double amt)  throws FunnyWarning
    {
        if(amt <= balance){
            balance -= amt;
            System.out.println("You Withdrawn $" + amt + "From your Account..");
        }    
        else{
            double diff = amt - balance;
            throw new FunnyWarning(diff);
        }
    }
    public void deposit(double amt)
    {
        if(amt > 0)
        {
            balance += amt;
            System.out.println("You Deposited $"  + amt + " To your Account..");
        }
        else{
            System.out.println("AMount should be greater than Zero...");
        }
    }
}
public class Third 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Amount for Initial Deposit: ");
        double amount = scanner.nextDouble();

        Bank b1 = new Bank(amount);

        System.out.print("\nEnter amount for Deposit: ");
        b1.deposit(scanner.nextDouble());
        System.out.print("\nEnter amount for Withdrawl: ");
        try
        {
            b1.withdrawAmount(scanner.nextDouble());
        }
        catch(FunnyWarning e)
        {
            System.out.println("You should give " + e.amount + " First For withdrawing above Your Balance...");
        }
        scanner.close();
    }    
}
