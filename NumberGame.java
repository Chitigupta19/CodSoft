import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public NumberGame() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hit = 0;
        int trail = 0;
        Random random = new Random();
        int number = random.nextInt(100);
        System.out.println("You have only five chances!!");

        for(int i = 0; i < 5; ++i) {
            System.out.println("Enter your number in the range of 1 to 100:");
            int guessNo = sc.nextInt();
            if (guessNo == number) {
                System.out.println("Bravo! You are correct");
                ++hit;
                System.out.println("Your total number of win :" + hit);
            } else if (number > guessNo) {
                System.out.println("OOPs! it's too low then the actual number.");
                ++trail;
                System.out.println("Try again");
                System.out.println("Total number of try" + trail);
            } else {
                System.out.println("OOPs! it's too high then the actual number.");
                ++trail;
                System.out.println("Try again");
                System.out.println("Total number of try" + trail);
            }
        }

        System.out.println("You are out of the game");
        System.out.println("The number is:" + number);
        System.out.println("Better luck next time!");
    }
}
