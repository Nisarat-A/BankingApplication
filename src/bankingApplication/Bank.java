package bankingApplication;

import java.sql.*;

public class Bank {
    private String name;
    public Bank(String name){
        this.name = name;
    }
   public void listAccounts() throws SQLException {
         Connection con = BankConnection.connect();
       String sql = "select * from account";
       Statement statement = con.createStatement();
       ResultSet result = statement.executeQuery(sql);
       while (result.next()){
           System.out.println("List" + result.getString(1) + " " + result.getString(2) + " " + result.getString(3)
           + "\n");
       }
    }
    public void openAccount(Account account) {
        Connection con = BankConnection.connect();
        String sql = "insert into account (accID,accName,accBalance) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, account.getNumber() );

            preparedStatement.setString(2, account.getName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);

}
    }
    public void closeAccount(int number) {
        Connection con = BankConnection.connect();
        String sql = "delete from account where accID = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void depositMoney(Account account , double amount) throws SQLException {
        account.deposit(amount);
        System.out.println(account.getBalance());
        Connection con = BankConnection.connect();
        String sql = "Update account set accBalance = ? where accID = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, account.getNumber());

        preparedStatement.setDouble(3, account.getBalance());
        preparedStatement.executeUpdate();
    }
    public void withdrawMoney(Account account , double amount) throws SQLException {
        account.withdraw(amount);
        System.out.println(account.getBalance());
        Connection con = BankConnection.connect();
        String sql = "Update account set accBalance = ? where accID = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, account.getNumber());

        preparedStatement.setDouble(3, account.getBalance());
        preparedStatement.executeUpdate();
    }

    public Account getAccount(int number) throws SQLException {
        Connection con = BankConnection.connect();
        Account account = null ; // initialize account to null
        String accountName = "" ;
        double balance = 0.0;
        String sql = "select * from account where accID =' " + number + "'";
    Statement statement;

        statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
             accountName = result.getString(2);
    balance = result.getDouble(3);
        }
        account =  new Account(number,accountName,balance);
    return account;
        }}


