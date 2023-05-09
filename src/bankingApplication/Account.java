package  bankingApplication;
public class Account {
    private int number ; // account number
    private String name; // account name
    private double balance; // account balance

    public Account(int number, String name, double balance){
        this.number = number;
        this.name = name;
        this.balance = balance;
    }
    public  void deposit(double amount){this.balance += amount;}
    public  void withdraw(double amount){this.balance -= amount;}
    public int getNumber(){return this.number;}
    public String getName(){return this.name;}
    public double getBalance(){return this.balance;}
}

