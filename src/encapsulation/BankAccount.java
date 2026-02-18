package encapsulation;

public class BankAccount{
    private double balance;  // data hiding

    // constructor
    public BankAccount(double balance) {
        this.balance = balance;
    }

    //getter
    public double getBalance() {
        return balance;
    }


    //setter
    public void deposit(double amount) {
        if(amount>0){
          balance+=amount;
            System.out.println("amount deposited : " + amount);
        }
    }

    //setter
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance){
            balance -=amount;
            System.out.println("the amount withdrawn is : "  + amount);
        }
    }
}