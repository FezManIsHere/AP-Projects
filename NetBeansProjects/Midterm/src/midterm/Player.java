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
public class Player {

    int x;
    String name;
    int y;
    int health = 100;
    int score = 0;
    String symbol;
    int speed;

    Player(String a, int b, int c, String d, /*int e,*/int f, int g) {
        this.x = b;
        this.y = c;
        this.name = a;
        this.symbol = d;
        //this.score = e;
        this.health = f;
        this.speed = g;
    }
}
