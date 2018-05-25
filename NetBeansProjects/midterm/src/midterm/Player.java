package midterm;

public class Player {

    String name;
    int x;
    int y;
    int health = 100;
    int score = 0;
    String symbol;

    Player(String a, int b, int c, String d, /*int e,*/ int f) {
        this.x = b;
        this.y = c;
        this.name = a;
        this.symbol = d;
        //this.score = e;
        this.health = f;
    }
}
