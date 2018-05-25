package midterm;

public class Movement {

    //Moves the player within the hallway
    public static void movePlayerH(String dir) {
        switch (dir.toLowerCase()) {
            case "n":
                playerUpH();
                break;
            case "ne":
                playerUpH();
                playerRightH();
                break;
            case "e":
                playerRightH();
                break;
            case "se":
                playerRightH();
                playerDownH();
                break;
            case "s":
                playerDownH();
                break;
            case "sw":
                playerDownH();
                playerLeftH();
                break;
            case "w":
                playerLeftH();
                break;
            case "nw":
                playerLeftH();
                playerUpH();
                break;
        }

    }

    //Move the player up
    public static void playerUpH() {
        if (Main.hallway[Main.player.x - 1][Main.player.y] == Main.hallway[5][6]) {
            if (Main.hasKey) {
                Main.player.x--;
            }
        } else if (Main.player.x - 1 >= 0 && Main.hallway[Main.player.x - 1][Main.player.y] != " ") {
            Main.player.x--;
        }
    }

    //Move the player right
    public static void playerRightH() {
        if (Main.player.y + 1 < Main.hallway[0].length && Main.hallway[Main.player.x][Main.player.y + 1] != " ") {
            Main.player.y++;
        }
    }

    //Move the player down
    public static void playerDownH() {
        if (Main.player.x + 1 < Main.hallway.length && Main.hallway[Main.player.x + 1][Main.player.y] != " ") {
            Main.player.x++;
        }
    }

    //Move the player left
    public static void playerLeftH() {
        if (Main.player.y - 1 >= 0 && Main.hallway[Main.player.x][Main.player.y - 1] != " ") {
            Main.player.y--;
        }
    }
}
