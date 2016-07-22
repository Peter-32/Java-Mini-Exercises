/**
 * Created by Peter on 7/19/2016.
 */
import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scan.nextLine();
        System.out.print("Hello " + name);
    }



}
