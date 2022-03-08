/*
* Project 1
* Class: CmpSci-182/L
* Developer: Omar Salah
* Date: 3/7/2022
* Description: Simple application used to fulfill all Project 1 requirements by creating 2 power functions one iterative
*      and the other recursive with a driver function to run both on base 2 with powers from 0 to 10 inclusively
*      a function to compute harmonics to a user supplied depth and a credit card class initialized with user supplied
*      values and run simple operations. I added a few repls for easier control flow and in order to allow these to all
*      be built and run off of a single file with the user selecting which of these sub-applications to run.
*/

package com.company;
import java.util.Scanner;

public class Main {
    static Scanner sysIn = new Scanner(System.in);// This was used before really reading the requirements, I had built
//    everything out asking for user inputs for the base and powers prior in both power functions

    // The iterative approach to solving base 2 to the power of n
    public static void power1(int n) {
        int ret = 1;
        for (int i = n; i > 0; i--) {
            ret*=2;
        }
        System.out.println( "2^"+ n + " = " + ret +" Computed Iteratively");
    }
    // Power 2 helper function to utilize the system stack for the recursive approach to solving base 2 to the power of n
    public static int power2(int n) {
        if (n != 0) {
            return (2 * power2( n - 1));
        }
        else {
            return 1;
        }
    }
    // Power 2 driver to print and return the power2 output.
    public static void runPower2(int power) {
        System.out.println( "2^"+ power + " = " + power2(power) +" Computed Recursively");
    }
    // Driver function to run the both power functions from power of 0 to 10
    public static void runPowers() {
        for (int i = 0; i <= 10; i++) {
            power1(i);
            runPower2(i);
            System.out.println("\n");
        }
    }
    // Recursive helper function to compute harmonics
    public static double computeHarmonics(double n) {
        if(n>1) return (1 / n) + computeHarmonics(n - 1);
        else {
            return 1;
        }
    }
    // Driver method to run and print the values resulting from computing harmonics
    public static void runHarmonics(int n){
        System.out.println("The harmonic sum of "+n+" is "+computeHarmonics(n));
    }

    static class CreditCard{
        public CreditCard(){
            System.out.println("Please Enter the full name for the account: ");
            sysIn.nextLine();
            this.accountName = sysIn.nextLine();
            System.out.println("Please Enter the account number: ");// Although I should be autogenerating this
            this.accountNumber = sysIn.nextLong();
            System.out.println("Please Enter the starting balance: ");// Although should automatically be set to 0
            this.balance = sysIn.nextLong();
            this.rewardPoints = this.balance/2;
        }
        private String accountName;
        private long accountNumber,
                    balance,
                    rewardPoints;
        // This will take out a cash advance adding the amount of the transaction to the balance with interest while also
        //       adding the reward points earned for the transaction
        public void transaction(){
            long amount;
            System.out.println("Please purchase amount: ");
            amount = sysIn.nextLong();
            this.balance += amount + (amount*.2);
            this.rewardPoints += amount/2;
            this.showAccountInfo();
        }
        // This will take out a cash advance adding the amount of the transaction to the balance with interest while also
        //       adding the reward points earned for the cash advance
        public void cashAdvance(){
            long amount;
            System.out.println("Please Cash Advance amount: ");
            amount = sysIn.nextLong();
            this.balance += amount + amount*.25;
            this.rewardPoints += amount/2;
            this.showAccountInfo();
        }
        // This will make a payment deducting the amount paid from the balance of the account, and show the new account
        //      Information after payment including remaining balance.
        public void payment(){
            long amount;
            System.out.println("Please payment amount: ");
            amount = sysIn.nextLong();
            this.balance -= amount;
            this.showAccountInfo();
        }

        public void showAccountInfo(){
            System.out.println(
                    "Account holder Name: "+ this.accountName +
                    "\n Account Number: " + this.accountNumber +
                    "\n Transaction Interest Rate: 20%"+ // I could use variables set to the object for these but why
                    "\n Cash Advance Interest Rate: 25%"+ // Over engineer it
                    "\n Remaining Balance: "+ this.balance
            );
        }

        public void runCreditOps(){
            Boolean running = true;
            int userInput;

            while(running){
                System.out.println("Please choose an option number for which credit operation you would like to run" +
                        "\n1 : New Transaction" +
                        "\n2 : Request a Cash Advance" +
                        "\n3 : Make a payment" +
                        "\n4 : View Account Information" +
                        "\n0 : Exit Credit Menu " +
                        "\n\nPlease enter your command code:");
                userInput = sysIn.nextInt();
                switch(userInput){
                    case 1 :
                        this.transaction();
                        break;
                    case 2:
                        this.cashAdvance();
                        break;
                    case 3:
                        this.payment();
                        break;
                    case 4:
                        this.showAccountInfo();
                        break;
                    default:
                        running = false;
                }
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        // Flag indicator to run or halt REPL(Read Execute Print Loop)

        int userInput;
        Boolean running = true;
        CreditCard cc = null;

        while(running){
            System.out.println("Please choose an option number for which sub-application yout would like to run." +
                    "\n1 : Run Powers(Compute powers of base 2 from 0 to 10 inclusively)" +
                    "\n2 : Compute Harmonics" +
                    "\n3 : Open a New Credit Card" +
                    "\n4 : Run Credit Card Operations" +
                    "\n0 : Exit " +
                    "\n\nPlease enter your command code:");

            userInput = sysIn.nextInt();

            switch(userInput){
                case 1:
                    runPowers();
                    break;
                case 2:
                    System.out.println("Please enter the nth harmonic you would like computed");
                    int n = sysIn.nextInt();
                    runHarmonics(n);
                    break;
                case 3:
                    cc = new CreditCard();
                    break;
                case 4:
                    if(cc!=null){
                        cc.runCreditOps();
                    }else{
                        System.out.println("You must first create a new credit card before we can run operations\n\n");
                    }
                    break;
                default:
                    System.out.println("Thanks for giving us a shot!");
                    running = false;
            }
        }
    }
}
