package midterm;

public class Item {

    String name = "";
    String type = "";
    String[] loc = {};
    int dmg = 0;
    int hp = 0;
    int x = -1;
    int y = 0;
    boolean collected = true;
    Item() {
        
    }

    Item(String a, String b, /*String[], c*/ int d, int e) {
        this.name = a;
        this.type = b;
        this.dmg = d;
        this.hp = e;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String a) {
        this.name = a;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String a) {
        this.type = a;
    }
    
    public int getX() {
        return this.x;
    }
    
    public void setX(int a){
        this.x = a;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setY(int a) {
        this.y = a;
    }
    
    public boolean getCollected() {
        return this.collected;
    }
    
    public void setCollected(boolean a) {
        this.collected = a;
    }
    
    public int getDMG() {
        return this.dmg;
    }
    
    public void setDMG(int a) {
        this.dmg = a;
    }
    
    public int getHP() {
        return this.hp;
    }
    
    public void setHP(int a) {
        this.hp = a;
    }
    
    
}
