package midterm;

public class Enemy {

    int x = 0;
    int y = 0;
    int health = 100;
    boolean isAlive;
    int room;

    Enemy(boolean a, int b, int c, int d) {
        this.isAlive = a;
        this.x = b;
        this.y = c;
        room = d;
    }
    Enemy(boolean a, int b, int c, int d, int e) {
        this.isAlive = a;
        this.x = b;
        this.y = c;
        this.room = d;
        this.health = e;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int a) {
        this.x = a;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int a) {
        this.y = a;
    }

    public int getHP() {
        return this.health;
    }

    public void setHP(int a) {
        this.health = a;
    }
}
