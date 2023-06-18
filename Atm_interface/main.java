package com.company;

import java.util.*;

class ATM_System {
    static int balance = 1000;
    static ArrayList<Integer> acc_no = new ArrayList<>();
    static ArrayList<Integer> amount= new ArrayList<>();


    static class ATM_options {
        public int display() {
            Scanner sc = new Scanner(System.in);
            System.out.println("----xxx  WELCOME TO ATM INTERFACE  xxx----");
            System.out.println("----  SELECT ONE OPTION BELOW ----");
            System.out.println("1. Transaction History" +
                    " 2. Withdraw" +
                    " 3. Deposit" +
                    " 4. Transfer" +
                    " 5. Exit");
            int z = sc.nextInt();
            return z;
        }
    }

    static class Transaction_history {
        public void transac() {
            if (acc_no.isEmpty()) {
                System.out.println("No Transactions yet!!");
            } else {
                int maxLength = Math.max(acc_no.size(), amount.size());
                for (int i = 0; i < maxLength; i++) {
                    if (i < acc_no.size()) {
                        System.out.println("Account " + "Amount");
                        System.out.print(acc_no.get(i) + "  ");
                    }
                    if (i < amount.size()) {
                        System.out.print(amount.get(i));
                    }
                    System.out.println();
                }
            }
        }
    }

    static class Withdraw {
        public int withdraw() {
            if(balance > 100) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter amount to withdraw: ");
                int wd = sc.nextInt();
                System.out.println("Amount Withdrawn");
                balance = balance - wd;
            }
            else{
                System.out.println("Insufficient Funds");
            }
            return balance;
        }
    }

    static class Deposit {
        public int deposit() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the amount: ");
            int bal = sc.nextInt();
            balance = bal+balance;
            return balance;
        }
    }

    static class Transfer {
        public void transfer() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the account");
            int acc = sc.nextInt();
            double num =  Math.floor(Math.log10(acc) + 1);
            if (num > 5.0 && num <10.0) {
                acc_no.add(acc);
                System.out.println("Enter the amount: ");
                int amt =sc.nextInt();
                balance = balance-amt;
                amount.add(amt);
                System.out.println("Your current balance is: "+balance);
            }

            else{
                System.out.println("Not a correct ATM account");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int id = 536985, pin = 12365;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your id: ");
        int id_1 = sc.nextInt();
        System.out.println("Enter your pin");
        int pin_1 = sc.nextInt();
        if (id == id_1 && pin == pin_1) {
            while (true) {
                ATM_System.ATM_options ao = new ATM_System.ATM_options();
                int req = ao.display();
                if (req == 3) {
                    ATM_System.Deposit d = new ATM_System.Deposit();
                    int dep = d.deposit();
                    System.out.println("Amount Deposited");
                    System.out.println("Your current balance is " + dep);
                } else if (req == 2) {
                    ATM_System.Withdraw aw = new ATM_System.Withdraw();
                    int withdraw = aw.withdraw();
                    System.out.println("Your current balance is " + withdraw);
                } else if (req == 4) {
                    ATM_System.Transfer t = new ATM_System.Transfer();
                    t.transfer();
                } else if (req == 1) {
                    ATM_System.Transaction_history at = new ATM_System.Transaction_history();
                    at.transac();
                } else if (req == 5) {
                    System.out.println("---xxxx Thanks For Visiting Us xxxx---");
                    break;
                }
            }
        }
        else{
            System.out.println("Invalid pin");
        }
    }
}
