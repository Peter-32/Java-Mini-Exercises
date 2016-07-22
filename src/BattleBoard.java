import java.util.Scanner;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Peter on 7/21/2016.
 */

public class BattleBoard {

    // A battle board

/*
 * ------------------------------
 * [*][*][*][*][*][*][*][*][*][*]
 * [*][*][*][*][*][*][*][*][*][*]
 * [*][*][*][*][*][*][*][*][*][*]
 * [*][*][*][*][*][*][*][T][*][*]
 * [*][F][*][*][*][*][*][*][*][*]
 * [*][*][*][*][*][*][*][*][*][*]
 * [*][*][*][*][*][*][*][*][*][*]
 * [*][*][*][*][*][*][*][*][*][*]
 * [*][*][*][*][L][*][*][D][*][*]
 * [*][*][*][*][*][*][*][*][*][*]
 * ------------------------------
*/

    static final int boardWidth = 7;
    static final int boardHeight = 7;
    static Scanner scanner = new Scanner(System.in);
    static String userInput;

    // Create the battle board 2D array

    static char[][] battleBoard = new char[boardWidth][boardHeight];
    private static void initializeBattleBoard() {
        for (char[] array : battleBoard) {
            Arrays.fill(array, '*');
        }
    }

    private static void repaint() {

        // print out the top border

        int h = 1;
        while (h < 30) {System.out.print("-"); h++; }
        System.out.println();

        // print out the battle board

        for (int i = 0; i < battleBoard.length; i++) {
            for (int j = 0; j < battleBoard[i].length; j++) {
                System.out.print("{" + battleBoard[i][j] + "}");
            }
            System.out.println();
        }

        // print out the bottom border

        h = 1;
        while (h < 30) {System.out.print("-"); h++; }
        System.out.println();
    }

    // This method drops the monster on the board in a random open position

    private static void dropMonsterOnBoardInRandomOpenPosition(Monster monster) {
        int randXPosition, randYPosition;
        do {
           randXPosition = (int) (Math.random() * boardWidth);
           randYPosition = (int) (Math.random() * boardHeight);
        } while (battleBoard[randYPosition][randXPosition] != '*');

        // place the monster on the board

        monster.placeMonster(randYPosition, randXPosition);
    }

    public static void issueCommand(String command, Monster[] monsterArray) {
        if (command.equalsIgnoreCase("left")) {
            for (Monster m : monsterArray) {
                if(m.getAlive())
                {
                    m.moveMonsterLeft(m);
                }
            }
        }
        if (command.equalsIgnoreCase("up")) {
            for (Monster m : monsterArray) {
                if(m.getAlive())
                {
                    m.moveMonsterUp(m);
                }
            }
        }
        if (command.equalsIgnoreCase("right")) {
            for (Monster m : monsterArray) {
                if(m.getAlive())
                {
                    m.moveMonsterRight(m);
                }
            }
        }
        if (command.equalsIgnoreCase("down")) {
            for (Monster m : monsterArray) {
                if(m.getAlive())
                {
                    m.moveMonsterDown(m);
                }
            }
        }
        if (command.equalsIgnoreCase("print locations")) {
            for (Monster m : monsterArray) {
                System.out.println(m.getName() + " - X location is " + m.getXLocation() + " and Y location is " +
            m.getYLocation());
            }
        }
        repaint();
    }

    public static void main(String[] args) {
        initializeBattleBoard();
        Monster[] monsterArray = new Monster[4];
        monsterArray[0] = new Monster("Drac",800,30,2);
        monsterArray[1] = new Monster("Slime",900,25,3);
        monsterArray[2] = new Monster("Rock Slime",750,35,2);
        monsterArray[3] = new Monster("Gran Slime",700,50,2);
        for (int i = 0; i < 4; i++) {
            dropMonsterOnBoardInRandomOpenPosition(monsterArray[i]);
        }
        repaint();

        // allow the monsters to move

        while (true) {
            System.out.println("Issue a command, your choices are:");
            System.out.println("up");
            System.out.println("right");
            System.out.println("left");
            System.out.println("down");
            System.out.println("exit");
            System.out.println("print locations");
            userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase(("exit"))) {
                break;
            }
            issueCommand(userInput, monsterArray);
        }

    }
}
