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

    private static final int boardWidth = 10;
    private static final int boardHeight = 10;

    // Create the battle board 2D array

    static char[][] battleBoard = new char[boardWidth][boardHeight];
    private static void initializeBattleBoard() {
        for (char[] array : battleBoard) {
            Arrays.fill(array, '*');
        }
    }

    private static void paint() {

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
        } while (battleBoard[randXPosition][randYPosition] != '*');

        // place the monster on the board

        monster.placeMonster(randXPosition, randYPosition);
        battleBoard[randXPosition][randYPosition] = monster.getName1Char();
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
        paint();
    }
}
