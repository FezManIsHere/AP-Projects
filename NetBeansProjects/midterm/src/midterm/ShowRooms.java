/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

/**
 *
 * @author Carter
 */
public class ShowRooms {

    public static void showHallway() {
        for (int i = 5; i < Main.hallway.length; i++) {
            for (int j = 4; j <= 8; j++) {
                System.out.print(Main.hallway[i][j] + "   ");
            }
            System.out.print("\n\n");
        }
    }

    public static void show1() {
        for (int i = 17; i <= 19; i++) {
            for (int j = 0; j <= 4; j++) {
                System.out.print(Main.hallway[i][j] + "   ");
            }
            System.out.print("\n\n");
        }
    }

    public static void show2() {
        for (int i = 13; i <= 15; i++) {
            for (int j = 0; j <= 4; j++) {
                System.out.print(Main.hallway[i][j] + "   ");
            }
            System.out.print("\n\n");
        }
    }

    public static void show3() {
        for (int i = 9; i <= 11; i++) {
            for (int j = 0; j <= 4; j++) {
                System.out.print(Main.hallway[i][j] + "   ");
            }
            System.out.print("\n\n");
        }
    }

    public static void show4() {
        for (int i = 17; i <= 19; i++) {
            for (int j = 8; j <= 12; j++) {
                System.out.print(Main.hallway[i][j] + "   ");
            }
            System.out.print("\n\n");
        }
    }

    public static void show5() {
        for (int i = 13; i <= 15; i++) {
            for (int j = 8; j <= 12; j++) {
                System.out.print(Main.hallway[i][j] + "   ");
            }
            System.out.print("\n\n");
        }
    }

    public static void show6() {
        for (int i = 9; i <= 11; i++) {
            for (int j = 8; j <= 12; j++) {
                System.out.print(Main.hallway[i][j] + "   ");
            }
            System.out.print("\n\n");
        }
    }

    public static void show7() {
        for (int i = 5; i <= 7; i++) {
            for (int j = 8; j <= 11; j++) {
                System.out.print(Main.hallway[i][j] + "   ");
            }
            System.out.print("\n\n");
        }
    }

    public static void show8() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                System.out.print(Main.hallway[i][j] + "   ");
            }
            System.out.print("\n\n");
        }
    }
}
