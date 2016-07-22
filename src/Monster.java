import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by Peter on 7/21/2016.
 */

public class Monster {
    private String name;
    private char name1Char;
    private int health = 1000;
    private int attack = 20;
    private int mobility = 2;
    private int xLocation, yLocation;
    private Boolean alive = true;
    public static int numMonsters = 0;


    public String getName() {
        return name;
    }
    public char getName1Char() {
        return name1Char;
    }
    public int getHealth() {
        return health;
    }
    public int getAttack() {
        return attack;
    }
    public int getMobility() {
        return mobility;
    }
    public Boolean getAlive() {
        return alive;
    }
    public int getXLocation() {
        return xLocation;
    }
    public int getYLocation() {
        return yLocation;
    }

    // Returns true if successfully moves

    public Boolean placeMonster(int yLocation, int xLocation) {
        // if moving off the board, don't move the monster.

        if (xLocation >= BattleBoard.boardWidth || yLocation >= BattleBoard.boardHeight) { return false; }
        if (xLocation < 0 || yLocation < 0) { return false; }

        // Only move if the board location is a valid location

        if (BattleBoard.battleBoard[yLocation][xLocation] == '*') {
            this.xLocation = xLocation;
            this.yLocation = yLocation;
            BattleBoard.battleBoard[yLocation][xLocation] = this.getName1Char();
            return true;
        }
        return false;
    }

    public void moveMonsterUp(Monster m) {
        Boolean wasSuccessfulMove = placeMonster(m.yLocation - 1, m.xLocation);
        if (wasSuccessfulMove) {
            BattleBoard.battleBoard[yLocation + 1][xLocation] = '*';
        }
    }
    public void moveMonsterDown(Monster m) {
        Boolean wasSuccessfulMove = placeMonster(m.yLocation + 1, m.xLocation);
        if (wasSuccessfulMove) {
            BattleBoard.battleBoard[yLocation - 1][xLocation] = '*';
        }
    }
    public void moveMonsterLeft(Monster m) {
        Boolean wasSuccessfulMove = placeMonster(m.yLocation, m.xLocation - 1);
        if (wasSuccessfulMove) {
            BattleBoard.battleBoard[yLocation][xLocation + 1] = '*';
        }
    }
    public void moveMonsterRight(Monster m) {
        Boolean wasSuccessfulMove = placeMonster(m.yLocation, m.xLocation + 1);
        if (wasSuccessfulMove) {
            BattleBoard.battleBoard[yLocation][xLocation - 1] = '*';
        }
    }

    public Monster(String name) {
        this.name = name;
        this.name1Char = name.charAt(0);
        numMonsters++;
    }

    public Monster(String name, int health, int attack, int mobility) {
        this(name);
        this.health = health;
        this.attack = attack;
        this.mobility = mobility;
    }
}
