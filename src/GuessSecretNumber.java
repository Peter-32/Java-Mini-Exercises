import java.util.Scanner;
/**
 * Created by Peter on 7/20/2016.
 */
public class GuessSecretNumber {
    // a number between 1 and 100
    private static int secretNumber = (int) (Math.random() * 100) + 1;
    private static int guess;
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("A secret number between 1 and 100 has been generated.");
        System.out.println("Try to guess the number.");
        while (true) {
            System.out.print("Please guess a number: ");
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                if (guess < secretNumber) {
                    System.out.println("Too low.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high.");
                } else {
                    System.out.println("Congratulations you've guessed the secret number: " + secretNumber);
                    break;
                }
            } else {
                scanner.next();
            }
        }


    }
}
