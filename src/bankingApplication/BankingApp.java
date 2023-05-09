package bankingApplication;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) throws SQLException {
        Account account ;
        int option = 0,number;
        String name;
        double balance , amount;
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
                    try {
                        bank.listAccounts();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    number= generateAccountNumber();
                    System.out.print("Enter Account Name : ");
                    name = sc.nextLine();
                    System.out.print("Enter Account Initial Balance : ");
                    balance = sc.nextDouble();
                    account = new Account(number,name,balance);
                    bank.openAccount(account);
                    break;
                case 3:
                    System.out.print("Enter Account Number to close :");
                    number= sc.nextInt();
                    bank.closeAccount(number);
                    System.out.println("Account Closed");
                    System.out.println();
                    break;
                case 4 :
                    System.out.print("Enter Account Number to deposit :");
                    number= sc.nextInt();
                    account = bank.getAccount(number);
                    System.out.println("Enter Amount : ");
                    amount = sc.nextDouble();
                    bank.depositMoney(account, amount);
                    System.out.println("Amount Deposited");
                    break;
                case 5 :
                    System.out.print("Enter Account Number to withdraw :");
                    number= sc.nextInt();
                    account = bank.getAccount(number);
                    System.out.print("Enter Amount : ");
                    amount = sc.nextDouble();
                    bank.withdrawMoney(account, amount);
                    break;
            }
        }
    }
    public static int generateAccountNumber(){
        Random random = new Random();
        int accNumber = 10000 + random.nextInt(900000);
        return accNumber;
    }
}