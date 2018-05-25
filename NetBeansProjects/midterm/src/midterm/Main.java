package midterm;

import java.util.Random;
import java.util.Scanner;

public class Main {

    //Leave main alone, one line max
    public static void main(String[] args) {
        play();
    }

    /* This is the major dump of stuff, specifically a few components
	that are TOTALLY around the same number of lines of code */
    public static void play() {
        intro();
        name();
        explanation();
    }

    //Gives the introduction of the game to the user
    public static void intro() {
        System.out.println(
                "Welcome to a Game. This Game is unlike any you have ever played. Ha-ha, that was funny.\n\n"
                + ""
                + "This is your standard dungeon crawler, complete with an awful map, randomly-generated rooms,\n"
                + "and weapons that could either be OP or useless.\n\n"
                + ""
                + "Warnings, be careful, etc etc, have fun.");
    }

    //Gets the name of the user
    public static void name() {
        System.out.println("\n\n\nSo, it is time to learn of your name, young hero.\nWhat's your preferred alias, squirt?");
        name = scan.nextLine();
    }

    //Intrduces the mechanics
    public static void explanation() {
        System.out.println(
                "The game works as so: You are in a hallway. At the end is a locked door (notated B), with a boss in the room.\n"
                        + "This mafia boss has taken your family, and you seek vengeance.\n"
                + "You need to clear rooms (notated R) to find the key. One of the rooms will have an enemy who drops the key, and it is randomly selected.\n"
                + "Furthermore, inside of the rooms there are random chances to spawn gear and/or enemies. Gear will increase damage dealt\n"
                + "or decrease damage taken, depending on the type. Enemies that spawn (E) will do damage on an RNG scale, as you do, but\n"
                + "they do considerably less. Your health can only increase by use of the Healing well (W), which \n"
                + "spawns only once. Finally, gold drops in rooms and on killed enemies, and is used in the vending machine.\n"
                + "After you clear enough rooms to get your preference of gear and the key, you will go through the locked door to fight the\n"
                + "boss. If you kill him, you win. Use H for a list of commands and the characters that represent various objects.\n\n"
                + "Type 'B' to begin");
        String start = scan.next();
        switch (start.toLowerCase()) {
            case "b":
                game();
            default:
                break;
        }
    }

    //Major compilation of spaghetti that would make pastafarianists change religions
    public static void game() {
        startHallway();
        startInv();
        gen.genRand();
        hallway[player.x][player.y] = player.symbol;
        help();
        while (play) {
            turn = scan.nextLine();
            if (turn.toLowerCase().matches("n|ne|e|se|s|sw|w|nw")) {
                Main.hallway[Main.player.x][Main.player.y] = ".";
                move.movePlayerH(turn);
                map();
            }

            switch (turn.toLowerCase()) {
                case "help":
                    help();
                    break;
                case "map":
                    displayHallway();
                    break;
                case "symbols":
                    symbols();
                    break;
                case "inventory":
                    showInventory();
                    break;
                case "attack":
                    attack();
                    break;
            }

            checksPickupsMovementsAttacks();
        }
    }

    //Displays the map of the current location
    public static void map(/*boolean a*/) {
        checkRoom();
        doTheDoors();
        doTheDrops();
        doTheEnemies();
        hallway[player.x][player.y] = player.symbol;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        switch (currentRoom) {
            case 0:
                displayMap.showHallway();
                break;
            case 1:
                displayMap.show1();
                break;
            case 2:
                displayMap.show2();
                break;
            case 3:
                displayMap.show3();
                break;
            case 4:
                displayMap.show4();
                break;
            case 5:
                displayMap.show5();
                break;
            case 6:
                displayMap.show6();
                break;
            case 7:
                displayMap.show7();
                break;
            case 8:
                displayMap.show8();
                break;
        }

        //displayHallway();
    }

    //Displays the hallway
    public static void displayHallway() {
        doTheDoors();
        doTheEnemies();
        hallway[player.x][player.y] = player.symbol;
        for (int i = 0; i < hallway.length; i++) {
            for (int j = 0; j < hallway[0].length; j++) {
                System.out.print(hallway[i][j] + " ");
            }
            System.out.print("\n");
        }
        //System.out.println(player.x + ", " + player.y);
    }
    //Prep hallway for use...set initial array values for the displaying to look nice

    public static void startHallway() {
        for (int i = 0; i < hallway.length; i++) {
            for (int j = 0; j < hallway[0].length; j++) {
                hallway[i][j] = " ";
            }
        }
        for (int i = 6; i < hallway.length; i++) {
            for (int j = 5; j <= 7; j++) {
                hallway[i][j] = ".";
            }
        }

        for (int i = 9; i < hallway.length; i++) {
            if (i % 4 != 0) {
                for (int j = 0; j < 4; j++) {
                    hallway[i][j] = ".";
                }
            }
        }
        for (int i = 5; i <= 7; i += 2) {
            hallway[19][i] = "M";
        }

        for (int i = 9; i < hallway.length; i++) {
            if (i % 4 != 0) {
                for (int j = 9; j < 13; j++) {
                    hallway[i][j] = ".";
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                hallway[i][j] = ".";
            }
        }

        for (int i = 5; i <= 7; i++) {
            for (int j = 9; j <= 11; j++) {
                hallway[i][j] = ".";
            }
        }
        hallway[6][11] = "W";

        doTheDoors();
        //b
        //doTheDrops();
        doTheEnemies();
        doTheMembers();
        for (int i = 0; i < hallway.length; i++) {
            for (int j = 0; j < hallway[0].length; j++) {
                if (hallway[i][j] == null) {
                    hallway[i][j] = " ";
                }
            }
        }
    }

    //Sets the symbols for the doors
    public static void doTheDoors() {
        for (int k = 4; k <= 8; k += 4) {
            for (int z = 10; z < hallway.length - 1; z += 4) {
                hallway[z][k] = "R";
            }
        }
        hallway[6][4] = "V";
        hallway[6][8] = "H";
        hallway[5][6] = "B";
    }

    public static void doTheEnemies() {
        for (Enemy enemy : enemies) {
            if (enemy.isAlive) {
                hallway[enemy.getX()][enemy.getY()] = "E";
            }
        }
    }

    public static void doTheMembers() {

    }

    public static void doTheDrops() {
        if (GenerateStuff.dagger.getCollected() == false) {
            hallway[GenerateStuff.dagger.getX()][GenerateStuff.dagger.getY()] = "D";
        }
        if (GenerateStuff.sword.getCollected() == false) {
            hallway[GenerateStuff.sword.getX()][GenerateStuff.sword.getY()] = "S";
        }
        if (GenerateStuff.javelin.getCollected() == false) {
            hallway[GenerateStuff.javelin.getX()][GenerateStuff.javelin.getY()] = "J";
        }
        if (GenerateStuff.chest.getCollected() == false) {
            hallway[GenerateStuff.chest.getX()][GenerateStuff.chest.getY()] = "C";
        }
        if (GenerateStuff.leggings.getCollected() == false) {
            hallway[GenerateStuff.leggings.getX()][GenerateStuff.leggings.getY()] = "L";
        }
        if (GenerateStuff.gauntlets.getCollected() == false) {
            hallway[GenerateStuff.gauntlets.getX()][GenerateStuff.gauntlets.getY()] = "A";
        }
        if (GenerateStuff.gold1.getCollected() == false) {
            hallway[GenerateStuff.gold1.getX()][GenerateStuff.gold1.getY()] = "G";
        }
        if (GenerateStuff.gold2.getCollected() == false) {
            hallway[GenerateStuff.gold2.getX()][GenerateStuff.gold2.getY()] = "G";
        }
        if (GenerateStuff.gold3.getCollected() == false) {
            hallway[GenerateStuff.gold3.getX()][GenerateStuff.gold3.getY()] = "G";
        }
        if (GenerateStuff.gold4.getCollected() == false) {
            hallway[GenerateStuff.gold4.getX()][GenerateStuff.gold4.getY()] = "G";
        }
        if (GenerateStuff.gold5.getCollected() == false) {
            hallway[GenerateStuff.gold5.getX()][GenerateStuff.gold5.getY()] = "G";
        }
        if (GenerateStuff.gold6.getCollected() == false) {
            hallway[GenerateStuff.gold6.getX()][GenerateStuff.gold6.getY()] = "G";
        }
        if (GenerateStuff.gold7.getCollected() == false) {
            hallway[GenerateStuff.gold7.getX()][GenerateStuff.gold7.getY()] = "G";
        }
        if (GenerateStuff.gold8.getCollected() == false) {
            hallway[GenerateStuff.gold8.getX()][GenerateStuff.gold8.getY()] = "G";
        }
        if (GenerateStuff.gold9.getCollected() == false) {
            hallway[GenerateStuff.gold9.getX()][GenerateStuff.gold9.getY()] = "G";
        }
    }

    public static void attack() {
        for (Enemy enemy : enemies) {
            if (enemy.isAlive && enemy.room == currentRoom) {
                if (enemy.y - player.y <= 1 || player.y - enemy.y <= 1) {
                    int power = 0;
                    for (int i = 0; i < inventory[0].length; i++) {
                        if (inventory[i][0] != null) {
                            power += (inventory[i][0].dmg * 10);

                        }
                    }
                    int dmg = rand.nextInt(power);
                    enemy.health -= dmg;
                    System.out.println("You did " + dmg + " damage to enemy!");
                }
                if (enemy.health <= 0) {
                    enemy.isAlive = false;
                    if (GenerateStuff.key == currentRoom) {
                        hasKey = true;
                        System.out.println("You have the key. You can now fight the boss");
                    }
                    if (enemy.room == 8) {
                        System.out.println("Congratulations! You beat the mafia boss!");
                        play = false;
                    }
                }
            }
        }
    }

    //Prints a help statement to list commands
    public static void help() {
        System.out.println("\n\n\n\n\n\n\n"
                + "Type Help for this menu\n"
                + "Type Map to see the map\n"
                + "Type Symbols to see what the symbols on the level mean\n"
                + "Type Inventory to see your inventory\n"
                + "Type Attack to attack an enemy if nearby\n"
                + "Type N/NE/E/SE/S/SW/W/NW to move");
    }

    //Explains the various symbols 
    public static void symbols() {
        System.out.println("\n\n\n\n\n\n\n"
                + "R are rooms you can go into\n"
                + ". are the empty places you can walk\n"
                + "V is the vending machine\n"
                + "H is the indicator for the healing room\n"
                + "W is the one-time use healing well\n"
                + "B is the boss room door and the boss once you enter\n"
                + "E are enemies\n"
                + "\n"
                + "S is swords\n"
                + "J is javelins\n"
                + "D is daggers\n"
                + "\n"
                + "C is chest armor\n"
                + "L is leg armor\n"
                + "A is arm armor\n"
                + "\n"
                + "G is gold you can use in the shop\n"
                + "P is your party\n"
                + "M is party members you can pick up");
    }

    //Checks the location of the player, in the interest of displaying the correct portion of the level and restraining enemies elsewhere from attacking
    public static void checkRoom() {
        if (player.y <= 4 && player.x > 8) {
            if (player.x <= 11) {
                currentRoom = 3;
            } else if (player.x <= 15) {
                currentRoom = 2;
            } else if (player.x <= 19) {
                currentRoom = 1;
            }
        } else if (player.y >= 8 && player.x > 8) {
            if (player.x <= 11) {
                currentRoom = 6;
            } else if (player.x <= 15) {
                currentRoom = 5;
            } else if (player.x <= 19) {
                currentRoom = 4;
            }
        } else if (player.x <= 5 && player.y <= 6) {
            currentRoom = 8;
        } else if (player.y >= 8 && player.x >= 5) {
            currentRoom = 7;
        } else {
            currentRoom = 0;
        }

    }

    //Displays all items in the player's inventory
    public static void showInventory() {
        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory[0].length; j++) {
                if (inventory[i][j] != null) {
                    System.out.print(inventory[i][j].getName() + "    ");
                }
                //System.out.print(weapon.getName() + " ");
            }
            System.out.print("\n");

        }
        //System.out.print(weapon.getName() + " ");
    }

    public static void startInv() {

        inventory[0][0] = weapon;
        inventory[0][1] = armor;
        inventory[0][2] = wallet;

        mapInv[0][0] = weapon;
        mapInv[0][1] = armor;
        mapInv[0][2] = wallet;

        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory[0].length; j++) {
                if (inventory[i][j] != null) {
                    stringInv[i][j] = inventory[i][j].getName();
                }
            }
        }
    }

    public static void checksPickupsMovementsAttacks() {
        if (hallway[player.x][player.y] == "M") {
            hallway[player.x][player.y] = ".";
            members++;
            System.out.println("You gained an ally");
        }
        if (hallway[player.x][player.y] == "W") {
            hallway[player.x][player.y] = ".";
            player.health = 100;
            System.out.println("Your health has been restored");
        }
        for (int i = 0; i < mapInv.length; i++) {
            for (int j = 0; j < mapInv[0].length; j++) {
                if (mapInv[i][j] != null) {
                    //System.out.print(mapInv[i][j] + "   ");
                    int tempCounter = 0;
                    if (mapInv[i][j].getX() == player.x && mapInv[i][j].getY() == player.y && mapInv[i][j].collected == false) {
                        //System.out.println("test");
                        if (mapInv[i][j].type == "Weapon") {
                            //System.out.println("wep test");
                            for (int x = 0; x < inventory[0].length; x++) {
                                if (inventory[x][0] != null) {
                                    //System.out.println("null test");
                                    if (inventory[x][0].type == "Weapon") {
                                        tempCounter++;
                                    }
                                }
                            }
                            inventory[tempCounter][0] = mapInv[i][j];
                            //System.out.println(inventory[tempCounter][0].name);
                            //mapInv[i][j].setName("");
                            //mapInv[i][j].setType("");
                            //mapInv[i][j].setDMG(0);
                            mapInv[i][j].setCollected(true);
                            //mapInv[i][j].setHP(0);
                            //System.out.println(inventory[tempCounter][0].name);
                        } else if (mapInv[i][j].type == "Armor") {
                            //System.out.println("arm test");
                            for (int x = 0; x < inventory[1].length; x++) {
                                if (inventory[x][1] != null) {
                                    //System.out.println("null test");
                                    if (inventory[x][1].type == "Armor") {
                                        tempCounter++;
                                    }
                                }
                            }
                            inventory[tempCounter][1] = mapInv[i][j];
                            //System.out.println(inventory[tempCounter][1].name);
                            //mapInv[i][j].setName("");
                            //mapInv[i][j].setType("");
                            //mapInv[i][j].setDMG(0);
                            mapInv[i][j].setCollected(true);
                            //mapInv[i][j].setHP(0);
                            //System.out.println(inventory[tempCounter][1].name);
                        } else if (mapInv[i][j].type == "Currency") {
                            //System.out.println("gold test");
                            for (int x = 0; x < inventory[2].length; x++) {

                                if (inventory[x][2] != null) {
                                    //System.out.println("null test");
                                    if (inventory[x][2].type == "Currency") {

                                        tempCounter++;
                                    }
                                }
                            }
                            inventory[tempCounter][2] = mapInv[i][j];

                            //System.out.println(inventory[tempCounter][2].name);
                            //mapInv[i][j].setName("");
                            //mapInv[i][j].setType("");
                            //mapInv[i][j].setDMG(0);
                            mapInv[i][j].setCollected(true);
                            //mapInv[i][j].setHP(0);
                            //System.out.println(inventory[tempCounter][2].name);
                        }
                    }
                }
            }
        }

        for (Enemy enemy : enemies) {
            if (enemy.isAlive && enemy.room == currentRoom) {
                hallway[enemy.x][enemy.y] = ".";
                if (enemy.getY() != player.y) {
                    if (player.y < enemy.y && (hallway[enemy.x][enemy.y - 1] == "." || hallway[enemy.x][enemy.y - 1] == "G" || hallway[enemy.x][enemy.y - 1] == "A" || hallway[enemy.x][enemy.y - 1] == "D" && hallway[enemy.x][enemy.y - 1] == "S" || hallway[enemy.x][enemy.y - 1] == "J" || hallway[enemy.x][enemy.y - 1] == "C" || hallway[enemy.x][enemy.y - 1] == "L")) {
                        enemy.y--;
                    }
                    if (player.y > enemy.y && (hallway[enemy.x][enemy.y + 1] == "." || hallway[enemy.x][enemy.y + 1] == "G" || hallway[enemy.x][enemy.y + 1] == "A" || hallway[enemy.x][enemy.y + 1] == "D" && hallway[enemy.x][enemy.y + 1] == "S" || hallway[enemy.x][enemy.y + 1] == "J" || hallway[enemy.x][enemy.y + 1] == "C" || hallway[enemy.x][enemy.y + 1] == "L")) {
                        enemy.y++;

                    }

                }
                if (enemy.getX() != player.x && (hallway[enemy.x - 1][enemy.y] == "." || hallway[enemy.x - 1][enemy.y] == "G" || hallway[enemy.x - 1][enemy.y] == "A" || hallway[enemy.x - 1][enemy.y] == "D" && hallway[enemy.x - 1][enemy.y] == "S" || hallway[enemy.x - 1][enemy.y] == "J" || hallway[enemy.x - 1][enemy.y] == "C" || hallway[enemy.x - 1][enemy.y] == "L")) {
                    if (player.x < enemy.x) {
                        enemy.x--;
                    }
                    if (player.x > enemy.x && (hallway[enemy.x + 1][enemy.y] == "." || hallway[enemy.x + 1][enemy.y] == "G" || hallway[enemy.x + 1][enemy.y] == "A" || hallway[enemy.x + 1][enemy.y] == "D" && hallway[enemy.x + 1][enemy.y] == "S" || hallway[enemy.x + 1][enemy.y] == "J" || hallway[enemy.x + 1][enemy.y] == "C" || hallway[enemy.x + 1][enemy.y] == "L")) {
                        enemy.x++;
                    }
                }

            }
        }
        
        for (Enemy enemy : enemies) {
            if (enemy.isAlive && enemy.room == currentRoom) {
                if (enemy.y - player.y <= 1 || player.y - enemy.y <= 1) {
                    int prot = 0;
                    for(int i = 0; i < inventory[1].length; i++) {
                        if (inventory[i][0] != null) {
                            prot += inventory[i][0].hp;
                        } 
                    }
                    int dmgTaken = rand.nextInt(15 - prot);
                    player.health -= dmgTaken;
                    System.out.println("You have taken " + dmgTaken + " damage!");
                    if(player.health <=0) {
                        System.out.println("You Died");
                        play = false;
                    }
                }
            }}

    }

    //Variable declaration dump
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    static String name;
    static String turn;
    static String[][] hallway = new String[20][13];
    static Player player = new Player(name, 19, 6, "P", 100);
    static Item[][] inventory = new Item[10][3];
    static Movement move = new Movement();
    static boolean play = true;
    static int currentRoom = 0;
    static ShowRooms displayMap = new ShowRooms();
    static boolean hasKey = false;
    static Item weapon = new Item("Weapons", "Weapon", 0, 0);
    static Item armor = new Item("Armor", "Armor", 0, 0);
    static Item wallet = new Item("Gold", "Currency", 0, 0);
    static String[][] stringInv = new String[10][3];
    static Item[][] partyInv = new Item[2][2];
    static Item[][] mapInv = new Item[10][3];
    static Enemy e1 = new Enemy(true, 18, 1, 1);
    static Enemy e2 = new Enemy(true, 14, 1, 2);
    static Enemy e3 = new Enemy(true, 10, 1, 3);
    static Enemy e4 = new Enemy(true, 18, 11, 4);
    static Enemy e5 = new Enemy(true, 14, 11, 5);
    static Enemy e6 = new Enemy(true, 10, 11, 6);
    static Enemy boss = new Enemy(true, 2, 2, 8);
    static Enemy[] enemies = {e1, e2, e3, e4, e5, e6, boss};
    static boolean placed = false;
    static GenerateStuff gen = new GenerateStuff();
    static int members = 0;
}
