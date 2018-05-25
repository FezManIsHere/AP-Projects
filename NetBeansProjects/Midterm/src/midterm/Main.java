package midterm;

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
        name = user.nextLine();
    }

    public static void explanation() {
        System.out.println(
                "The game works as so: You are in a hallway. At the end is a locked door (notated B), with a boss in the room.\n"
                + "You need to clear rooms (notated R) to find the key. One of the rooms with have a key, and it is randomly selected.\n"
                + "Furthermore, inside of the rooms there are random chances to spawn gear and/or enemies. Gear will increase damage dealt\n"
                + "or decrease damage taken, depending on the type. Enemies that spawn (E) will do damage on an RNG scale, as you do, but\n"
                + "they do considerably less. Your health can only increase by use of HP potions (H), which can be bought from the vending\n"
                + "machine at the end of the hallway. Finally, gold drops in rooms and on killed enemies, and is used in the vending machine.\n"
                + "After you clear enough rooms to get your preference of gear and the key, you will go through the locked door to fight the\n"
                + "boss. If you kill him, you win. Use H for a list of commands and the characters that represent various objects.\n\n"
                + "Type 'S' to start");
        String start = user.next();
        switch (start.toLowerCase()) {
            case "s":
                game();
            default:
                break;
        }
    }

    //Major compilation of spaghetti that would make pastafarianists change religions
    public static void game() {
        //System.out.println("yay");
        startHallway();
        map(location);
    }

    //Displays the map of the current location
    public static void map(String loc) {
        switch (loc) {
            case "hallway":
                displayHallway();
            case "room":
                displayCurrentRoom();
        }
    }

    //Displays the hallway
    public static void displayHallway() {
        hallway[player.x][player.y] = player.symbol;
        for (int i = 0; i < hallway.length; i++) {

            for (int j = 0; j < hallway[0].length; j++) {
                System.out.print(hallway[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    //Displays the current room the player is in
    public static void displayCurrentRoom() {

    }

    //Prep hallway for use...set initial array values for the displaying to look nice
    public static void startHallway() {
        for (int i = 1; i < hallway.length; i++) {
            for (int j = 1; j <= 3; j++) {
                hallway[i][j] = ".";
            }
        }
        for (int k = 0; k <= 4; k += 4) {
            for (int z = 1; z < hallway.length - 1; z += 2) {
                hallway[z][k] = "R";
                //hallway[z][k] = alpha[alphaCount];
                //alphaCount++;
            }
        }
        for (int i = 0; i < hallway.length; i++) {

            for (int j = 0; j < hallway[0].length; j++) {
                if (hallway[i][j] == null) {
                    hallway[i][j] = " ";
                }
            }
        }
    }

    //Moves the player within the hallway
    public static int[] movePlayerH(String dir, int[] coord) {
        switch (dir.toLowerCase()) {
            case "n":
                coord = playerUpH(coord);
            case "e":
                coord = playerRightH(coord);
            case "s":
                coord = playerDownH(coord);
            case "w":
                coord = playerLeftH(coord);
        }
        return coord;
    }

    //Move the player up
    public static int[] playerUpH(int[] coord) {
        if (coord[0] - 1 > 0) {
            coord[0]--;
        }
        return coord;
    }

    //Move the player right
    public static int[] playerRightH(int[] coord) {
        if (coord[1] + 1 < hallway[0].length) {
            coord[1]++;
        }
        return coord;
    }

    //Move the player down
    public static int[] playerDownH(int[] coord) {
        if (coord[0] + 1 < hallway.length) {
            coord[0]++;
        }
        return coord;
    }

    //Move the player left
    public static int[] playerLeftH(int[] coord) {
        if (coord[1] - 1 > 0) {
            coord[1]--;
        }
        return coord;
    }

    //Moves the player within the room
    public static int[] movePlayerR(String dir, int[] coord) {
        switch (dir.toLowerCase()) {
            case "n":
                coord = playerUpR(coord);
            case "e":
                coord = playerRightR(coord);
            case "s":
                coord = playerDownR(coord);
            case "w":
                coord = playerLeftR(coord);
        }
        return coord;
    }

    //Move the player up
    public static int[] playerUpR(int[] coord) {
        if (coord[0] - 1 > 0) {
            coord[0]--;
        }
        return coord;
    }

    //Move the player right
    public static int[] playerRightR(int[] coord) {
        if (coord[1] + 1 < hallway[0].length) {
            coord[1]++;
        }
        return coord;
    }

    //Move the player down
    public static int[] playerDownR(int[] coord) {
        if (coord[0] + 1 < hallway.length) {
            coord[0]++;
        }
        return coord;
    }

    //Move the player left
    public static int[] playerLeftR(int[] coord) {
        if (coord[1] - 1 > 0) {
            coord[1]--;
        }
        return coord;
    }

    //Variable declaration dump
    static Scanner user = new Scanner(System.in);
    public static String name;
    static String[][] hallway = new String[15][5];
    static String[][] room = new String[11][11];
    static String location = "hallway";
    static String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    static int alphaCount = 0;
    static Player player = new Player(name, 14, 2, "P", 100, 1);
    static int[] otherLoc = new int[2];
    static Item[][] inventory = new Item[10][3];
}