import java.util.Scanner;

/**
 * Created by Peter on 7/19/2016.
 */
public class GreetAliceAndBob {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scan.nextLine();
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        if(name.equals("Bob") || name.equals("Alice")) {
            System.out.println("Hello " + name);
        } else {
            System.out.println("Hello.");
        }

        String end = scan.nextLine();
    }
}
