import java.util.Scanner;

/**
 * Created by Peter on 7/19/2016.
 */
public class Sum1ToNOnlyMultiples3And5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program sums 1 to n");
        System.out.println("Please input a number n");
        int inputInt = scan.nextInt();
        int acc = 0;
        for (int i = 1; i <= inputInt; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                acc += i;
            }
        }
        System.out.println("The sum is " + acc);
    }
}
