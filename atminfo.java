import java.util.Scanner;
public class  atminfo {
    String Name;
    String User_Name;
    String Password;
    String Account_No;
    float Balance = 500000f;
    int Transactions = 0;
    String Transaction_History = "";

    public void register() {
        Scanner obj = new Scanner(System.in);
        System.out.print("\nPlease Enter Your Name... ");
        this.Name = obj.nextLine();
        System.out.print("\n Enter Your Username.... ");
        this.User_Name = obj.nextLine();
        System.out.print("\nEnter Your Password.... ");
        this.Password = obj.nextLine();
        System.out.print("\nEnter Your Account Number.... ");
        this.Account_No = obj.nextLine();
        System.out.println("\nRegistration Process Done Sucessfully ..Go to login Page....");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner obj = new Scanner(System.in);
        while ( !isLogin ) {
            System.out.print("\nEnter Your Username... ");
            String Username = obj.nextLine();
            if ( Username.equals(User_Name) ) {
                while ( !isLogin ) {
                    System.out.print("\nEnter Your Password... ");
                    String Password = obj.nextLine();
                    if ( Password.equals(Password) ) {
                        System.out.print("\nLogin successful!!");
                        isLogin = true;
                    }
                    else {
                        System.out.println("\nIncorrect Password..");
                    }
                }
            }
            else {
                System.out.println("\nUsername not found...Please try again after some times...");
            }
        }
        return isLogin;
    }

    public void withdraw() {

        System.out.print("\nEnter amount to withdraw - ");
        Scanner obj = new Scanner(System.in);
        float amount = obj.nextFloat();
        try {

            if ( Balance >= amount ) {
                Transactions++;
                Balance -= amount;
                System.out.println("\nWithdraw Successfully");
                String str = amount + " Rs Withdrawed\n";
                Transaction_History = Transaction_History.concat(str);

            }
            else {
                System.out.println("\nInsufficient Balance");
            }

        }
        catch ( Exception e) {
        }
    }

    public void deposit() {

        System.out.print("\nEnter amount to deposit - ");
        Scanner obj = new Scanner(System.in);
        float amount = obj.nextFloat();

        try {
            if ( amount <= 500000f ) {
                Transactions++;
                Balance += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + " Rs. deposited\n";
                Transaction_History = Transaction_History.concat(str);
            }
            else {
                System.out.println("\nSorry...Limit is 100000.00");
            }

        }
        catch ( Exception e) {
        }
    }

    public void transfer() {

        Scanner obj = new Scanner(System.in);
        System.out.print("\nEnter Receiptent Name : ");
        String receiptent = obj.nextLine();
        System.out.print("\nEnter amount to  be transfer : ");
        float amount = obj.nextFloat();

        try {
            if ( Balance >= amount ) {
                if ( amount <= 50000f ) {
                    Transactions++;
                    Balance -= amount;
                    System.out.println("\nSuccessfully Transfered to " + receiptent);
                    String str = amount + " Rs transfered to " + receiptent + "\n";
                    Transaction_History = Transaction_History.concat(str);
                }
                else {
                    System.out.println("\nSorry...Daily transfer limit is 50000.00");
                }
            }
            else {
                System.out.println("\n Sorry..Due to Insufficient Balance on your account..Unable to transfer");
            }
        }
        catch ( Exception e) {
        }
    }

    public void checkBalance() {
        System.out.println("\n" + Balance + " Rs");
    }

    public void transHistory() {
        if ( Transactions == 0 ) {
            System.out.println("\nTransaction Section is Empty...");
        }
        else {
            System.out.println("\n" + Transaction_History);
        }
    }
}


class Interface {


    public static int Input(int limit) {
        int input = 0;
        boolean flag = false;

        while ( !flag ) {
            try {
                Scanner obj = new Scanner(System.in);
                input = obj.nextInt();
                flag = true;

                if ( flag && input > limit || input < 1 ) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            }
            catch ( Exception e ) {
                System.out.println("Enter only integer value....");
                flag = false;
            }
        }
        return input;
    }


    public static void main(String[] args) {

        System.out.println("\n-------WELCOME TO ATM SYSTEM-----\n");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter Your Choice... ");
        int choice = Input(2);

        if ( choice == 1 ) {
            atminfo b = new atminfo();
            b.register();
            while(true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter Your Choice... ");
                int choice_1 = Input(2);
                if ( choice_1 == 1 ) {
                    if (b.login()) {
                        System.out.println("\n\n-------Welcome again Dear Customer " + b.Name + " -------\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("\nEnter Your Choice... ");
                            int c = Input(6);
                            switch(c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else {
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }


        System.out.println("....Thank you Visit Again...");
    }

}
