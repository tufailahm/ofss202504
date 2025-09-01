package com.training.inheritdemos;

class Demo
{
   public void applyCharges()
    {

    }
}
interface Charges
{
        int amount=100;
        void applyCharges();
    void addCharges();
    void resetCharges();
}
interface PremimumCharges extends Charges
{
    void addPremimumCharges();
}
interface Perks{
    int amount=400;
}
final class IdCard
{

}
abstract class BankAccount {
    int balance;
    public abstract void openAccount();
    public abstract void depositMoney();
    public abstract void withdrawMoney();
    public abstract void maintenanceCharges();
    public void closingAccount(){
        System.out.println("Accout closed");
    }
    public final void linkAadhar(){
        System.out.println("Accout closed");
    }
}
abstract class  SavingsAccount extends BankAccount {
    @Override
    public void openAccount() {
        System.out.println("Savings Account opened");
    }
    @Override
    public void depositMoney() {
    }
    @Override
    public void withdrawMoney() {
    }
}
class SalaryAccount extends SavingsAccount {

    @Override
    public void maintenanceCharges() {

    }
}
class StudentAccount extends SavingsAccount implements Charges,Perks {

    @Override
    public void maintenanceCharges() {

    }

    @Override
    public void applyCharges() {

    }

    @Override
    public void addCharges() {
     //   amount=199;
        System.out.println(Charges.amount);
    }

    @Override
    public void resetCharges() {

    }
}


 class CurrentAccount extends Demo implements  Charges {

     @Override
     public void addCharges() {
     }
     @Override
     public void resetCharges() {

     }
 }

public class Demo2 {
    public static void main(String[] args) {
        BankAccount a = new SalaryAccount();
        a.openAccount();
        a.closingAccount();

     //   a= new CurrentAccount();
        a.openAccount();
        a.closingAccount();


    }
}
