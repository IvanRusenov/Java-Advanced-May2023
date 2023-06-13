package DefiningClassesLab.A03BankAccount;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {

    private static final double DEFAULT_INTEREST_RATE = 0.02;

    private int id;

    private double balance;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int accountCount = 0;


    //•	setInterestRate(double interest): void (static)
    //•	getInterest(int Years): double
    //•	deposit(double amount): void

    public static void setInterestRate(double interest){

        interestRate = interest;

    }

    public double getInterest(int years){


        return this.balance * interestRate * years;

    }

    public void deposit(double amount){

        this.balance += amount;

    }

    public int getId() {
        return this.id;
    }

    public BankAccount ( ){
        accountCount++;
        this.id = accountCount;
       this.balance = 0;
    }
}
