import java.util.*;
class Account{
    String name,userName,password;
    Scanner sc = new Scanner(System.in);
    float balance = 0.0f;
    int tranasction = 0;
    public void register()
    {
        System.out.println("Enter your name:");
        this.name = sc.nextLine();
        System.out.println("Enter your username:");
        this.userName = sc.nextLine();
        System.out.println("Enter your password:");
        this.password = sc.nextLine();
    }
    public boolean Status(){
        boolean isStatus = false;
        while(!isStatus){
            System.out.println("Enter your username:");
            String user = sc.nextLine();
            if(user.equals(userName)){
                while(!isStatus){
                    System.out.println("Enter your password");
                    String pass = sc.nextLine();
                    if(pass.equals(password)){
                        System.out.println("you have logged in sucessfully!");
                        isStatus = true;

                    }else{
                        System.out.println("Incorrecct Password Try again!");

                    }
                }
            }else{
                System.out.println("Incorrect Username. Try again!");
            }
        }
        return isStatus;
    }
    public void withdraw(){
        System.out.println("Enter amount to withdraw:");
        float amount = sc.nextFloat();
        try{
            if(balance>=amount){
                tranasction++;
                balance -= amount;
                System.out.println("Amount withdrawn sucessfully");
            }else{
                System.out.println("Insufficient Balance!");
                System.out.println("Your current balance is:"+balance);
            }
        }
        catch (Exception e){
        }
    }
    public void deposit(){
        System.out.println("Enter amount to deposit(minimum 500):");
        float amount = sc.nextFloat();
        try{
            if(amount>=500){
                tranasction++;
                balance += amount;
                System.out.println("Amount Deposited sucessfully");
            }else {
                System.out.println("Sorry! You cannot depoist amount less than 500");
            }
        }
        catch (Exception e){
        }
    }
    public void checkBalance(){
        System.out.println("Your current balance (in Rs) is:"+balance);
    }
    public void Tranasction (){
        if(tranasction == 0){
            System.out.println("No Transaction happened");
        }else{
            System.out.println("Transaction is Completed of "+tranasction);
        }
    }
}

public class ATMMachine {
    public static int number(int limit){
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean flag = false;
        while(!flag){
            try{
                input = sc.nextInt();
                flag = true;
                if(flag && input>limit || input<1 ){
                    System.out.println("Chose the no.between 1 to"+limit);
                    flag =  false;
                }
            }
            catch(Exception e){
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        return input;
    }
    public static void main(String args[]){
        System.out.println("###### Welcome to the ABC Bank of India #######");
        System.out.println("Enter 1 for register:");
        System.out.println("Enter 2 for exit:");
        int choose = number(2);
        if(choose == 1){
            Account  a = new Account();
            a.register();
            while(true){
                System.out.println("Enter 1- login or 2- exit");
                boolean isFinish = false;
                while (!isFinish){
                    System.out.println("1.Withdaw\n 2.Deposite\n 3.Check balance\n 4.Transaction\n 5.Exit");
                    System.out.println("Enter your choice:");
                    int  c = number(5);
                    if(c==1){
                        if(a.Status()){
                            System.out.println("##### Login as !" +a.name+"######");
                            boolean isDone = false;
                            while(!isDone){
                                System.out.println("1.Withdaw\n 2.Deposite\n 3.Check balance\n 4.Transaction\n 5.Exit");
                                System.out.println("Enter your choice:");
                                int  x= number(5);
                                switch(x){
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
                                        a.Tranasction();
                                        break;
                                    case 5:
                                        isDone =true;
                                        break;
                                }
                            }
                        }
                    }
                    else{
                        System.exit(0);
                    }
                }
            }

        }else{
            System.exit(0);
        }
    }
}