import java.util.Scanner;
class Account{
    String name,userName,password;
    float balance = 0.0f;
    int transaction = 0;
    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        this.name = sc.nextLine();
        System.out.println("Enter your userName");
        this.userName  = sc.nextLine();
        System.out.println("Enter your password");
        this.password = sc.nextLine();
    }
    public boolean Status(){
        boolean isStatus = false;
        Scanner sc = new Scanner(System.in);
        while (!isStatus){
            System.out.println("Enter your usernmae");
            String UserName = sc.nextLine();;
            if(UserName.equals(userName)){
                while (!isStatus){
                    System.out.println("Enter your password");
                    String Password = sc.nextLine();
                    if(Password.equals(password)){
                        System.out.println("Status:You are loggedin!");
                        isStatus = true;
                    }else {
                        System.out.println("Incorrect password");
                    }
                }
            }else {
                System.out.println("Incorrect username");
            }
        }
        return isStatus;
    }
    public void withdraw(){
        System.out.println("Enter amount to withdraw");
        Scanner sc =new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(balance>=amount){
                transaction++;
                balance-=amount;
                System.out.println("Withdraw sucessfully");
            }else{
                System.out.println("Insufficient balance");
                System.out.println("Your balance us"+balance);
            }
        } catch (Exception e) {}
    }
    public void deposit(){
        System.out.println("Enter amount to deposit(minimum 500)");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(amount>=500){
                transaction++;
                balance+=amount;
                System.out.println("Deposit sucessfully");
            }else{
                System.out.println("less than 500");
            }
        } catch (Exception e) {
        }
    }
    public void checkBalance(){
        System.out.println("Your current balance is (in Rs)"+balance);
    }
    public void Transaction(){
        if(transaction==0){
            System.out.println("No transaction happened");
        }else {
            System.out.println("your transaction completed");
        }
    }
}
public class ATMMachine {
    public static int number(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if (flag && input > limit || input < 1) {
                    System.out.println("choose the no.between 1 to" + limit);
                    flag = true;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("#### WELCOME TO ABC BANK ####");
        System.out.println("Enter 1 for register");
        System.out.println("Enter 2 for exit");
        int choose = number(2);
        if (choose == 1) {
            Account a = new Account();
            a.register();
            while (true) {
                System.out.println("Enter1-Login or 2- Exit");
                int c = number(2);
                if (c == 1) {
                    if (a.Status()) {
                        System.out.println("Login as" + a.name);
                        boolean isFinish = false;
                        while (!isFinish) {
                            System.out.println("1. Withdraw\n2.Deposit\n3.Check balance\n4.Transaction\n5.Exit");
                            System.out.println("Enter your choice");
                            int x = number(5);
                            switch (x) {
                                case 1:
                                    a.withdraw();
                                    break;
                                case 2:
                                    a.deposit();
                                    break;
                                case 3:
                                    a.checkBalance();
                                    break;
                                case 4:
                                    a.Transaction();
                                    break;
                                case 5:
                                    isFinish = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        }else {
            System.exit(0);
        }
    }
}

