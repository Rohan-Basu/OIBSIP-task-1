import java.util.Scanner;

class ATM {
    public static final int USER_ID = 1234;
    public static final int USER_PASSWORD = 4321;
    public static int BALANCE = 10000;
    public static String transaction_history[] = new String[10];
    public static int c = 0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User ID: ");
        int user_id = sc.nextInt();
        System.out.println("Enter User password: ");
        int user_pass = sc.nextInt();

        if (user_id == USER_ID && user_pass == USER_PASSWORD) {
            System.out.println("Authentication successful!");
            while (true) {
                System.out.println("1. Transaction history.");
                System.out.println("2. Withdraw.");
                System.out.println("3. Deposit.");
                System.out.println("4. Transfer.");
                System.out.println("5. Quit.");
                System.out.println("Enter your choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        Transaction_History obj1 = new Transaction_History();
                        obj1.trans_his();
                        break;
                    case 2:
                        Withdraw obj2 = new Withdraw();
                        obj2.withdraw();
                        break;
                    case 3:
                        Deposit obj3 = new Deposit();
                        obj3.deposit();
                        break;
                    case 4:
                        Transfer obj4 = new Transfer();
                        obj4.tran();
                        break;
                    case 5:
                        System.out.println("Thank you for using our ATM!");
                        System.exit(0);
                    default:
                        System.out.println("Wrong choice entered!");
                }
            }
        }

        else {
            System.out.println("Authentication failed!");
            System.exit(0);
        }
    }
}

class Transaction_History {
    void trans_his() {
        for (int i = 0; i < 10; i++) {
            System.out.println(ATM.transaction_history[i]);
        }
        System.out.println("Account balance: " + ATM.BALANCE);
    }
}

class Withdraw {
    void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to be withdrawn: ");
        int withd = sc.nextInt();
        if (withd > ATM.BALANCE) {
            System.out.println("Insufficient Balance!");
        } else {
            ATM.BALANCE = ATM.BALANCE - withd;
            String s = Integer.toString(withd);
            String s1 = "-" + s;
            ATM.transaction_history[ATM.c] = s1;
            ATM.c++;
        }
    }
}

class Deposit {
    void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to be deposited: ");
        int dep = sc.nextInt();
        ATM.BALANCE = ATM.BALANCE + dep;
        String s = Integer.toString(dep);
        String s1 = "+" + s;
        ATM.transaction_history[ATM.c] = s1;
        ATM.c++;
    }
}

class Transfer {
    void tran() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to be transfered: ");
        int transfer = sc.nextInt();
        if (transfer > ATM.BALANCE) {
            System.out.println("Insufficient Balance!");
        } else {
            ATM.BALANCE = ATM.BALANCE - transfer;
            String s = Integer.toString(transfer);
            String s1 = "-" + s + "(transfered)";
            ATM.transaction_history[ATM.c] = s1;
            ATM.c++;
        }
    }
}