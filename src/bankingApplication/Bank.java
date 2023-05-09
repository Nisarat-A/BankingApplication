package bankingApplication;

public class Bank {
    private String name;
    public Bank(String name){
        this.name = name;
    }
   public void listAccounts() {
    }
    public void openAccount(Account account) {
    }
    public void closeAccount(int number) {
    }
    public void depositMoney(Account account , double amount) {
        account.deposit(amount);
    }
    public void withdrawMoney(Account account , double amount) {
        account.withdraw(amount);
    }

    public Account getAccount(int number) {
        String accName = "Noey";
        double balance = 0.00;
        Account account = new Account(number,name,balance);
        return account;
}}


