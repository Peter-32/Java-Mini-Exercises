/**
 * Created by Peter on 7/20/2016.
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        // title
        System.out.println();
        System.out.println("              This is a Multiplication Table");
        System.out.println();

        // draw top border
        System.out.print("       ");
        for (int i = 1; i < 13; i++) {
            System.out.format("%-4d",i);
        }
        System.out.println();
        System.out.println("     -------------------------------------------------");

        // draw body
        for (int i = 1; i < 13; i++) {
            // draw side border
            System.out.format("%-4d | ",i);
            // all 144 numbers
            for (int j = 1; j < 13; j++) {
                System.out.format("%-4d",i * j);
            }
            // new line
            System.out.println();
        }
    }
}
