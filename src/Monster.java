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
    public void placeMonster(int xLocation, int yLocation) {
        if (BattleBoard.battleBoard[xLocation][yLocation] == '*') {
            this.xLocation = xLocation;
            this.yLocation = yLocation;
        }

        // otherwise do nothing

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
