package bankingApplication;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Account account ;
        int option = 0,number;
        String name;
        double balance;
        Bank bank = new Bank("KK");
        Scanner sc = new Scanner(System.in);
        while(option != 6){

            System.out.println("Main Menu");
            System.out.println("1. Display all the accounts");
            System.out.println("2. Open New account");
            System.out.println("3. Close Existing accounts");
            System.out.println("4. Deposit from account");
            System.out.println("5. Withdraw from account");
            System.out.println("6. Exit");

            System.out.print("Enter your choice : "); // select menu
            option = sc.nextInt(); // get input from user
            sc.nextLine(); // consume the \n (enter) from the input buffer
            System.out.println();
            switch (option){
                case 1:
                case 2:  number= 1111;
                    System.out.print("Enter Account Name : ");
                    name = sc.nextLine();
                    System.out.print("Enter Account Initial Balance : ");
                    balance = sc.nextDouble();
                    account = new Account(number,name,balance);
                    bank.openAccount(account);
            }
        }

    }
}