import java.util.Scanner;
import java.io.*;

/**
 * Created by Peter on 7/19/2016.
 */
public class SumOrProduct1ToN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        long accumulation = 0;
        String operation;

        // Get an integer from the user
        System.out.println("This program will display the product or sum of the numbers 1 to n");
        while (true) {
            System.out.print("Please input an integer n that is greater than 0: ");
            if (scan.hasNextInt()) {
                n = scan.nextInt();
                if (n > 0) {break;}
            } else {
                scan.next();
            }
        }

        // Get the operation from the user (product or sum)
        System.out.println("Would you like to get the product or sum?");
        while (true) {
            System.out.print("Please type product or type sum: ");
            operation = scan.nextLine();
            if (operation.equalsIgnoreCase("sum") || operation.equalsIgnoreCase("product")) {
                break;
            }
        }

        switch (operation.toLowerCase()) {
            case "sum":
                accumulation = 0;
                for (int i = 1; i <= n; i++) {
                    accumulation += i;
                }
                break;
            case "product":
                accumulation = 1;
                for (int i = 1; i <= n; i++) {
                    accumulation *= i;
                }
                break;
        }
        System.out.println("The answer is " + accumulation);
    }
}
