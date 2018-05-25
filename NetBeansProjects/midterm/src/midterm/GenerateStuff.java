package midterm;

public class GenerateStuff {

    public static Item dagger = new Item();
    public static Item sword = new Item();
    public static Item javelin = new Item();
    public static Item chest = new Item();
    public static Item leggings = new Item();
    public static Item gauntlets = new Item();
    public static Item gold1 = new Item();
    public static Item gold2 = new Item();
    public static Item gold3 = new Item();
    public static Item gold4 = new Item();
    public static Item gold5 = new Item();
    public static Item gold6 = new Item();
    public static Item gold7 = new Item();
    public static Item gold8 = new Item();
    public static Item gold9 = new Item();
    public static int key;

    //Generates the Random pre-requisites for the game to work properly
    public void genRand() {
        int dag = Main.rand.nextInt(2);
        if (dag == 1) {
            genDag();
        }
        int swo = Main.rand.nextInt(2);
        if (swo == 1) {
            genSwo();
        }
        int jav = Main.rand.nextInt(2);
        if (jav == 1) {
            genJav();
        }
        int che = Main.rand.nextInt(2);
        if (che == 1) {
            genChe();
        }
        int leg = Main.rand.nextInt(2);
        if (leg == 1) {
            genLeg();
        }
        int arm = Main.rand.nextInt(2);
        if (arm == 1) {
            genArm();
        }

        key = Main.rand.nextInt(6) + 1;
        genGold();

    }

    public void genDag() {
        while (!Main.placed) {
            int l = Main.rand.nextInt(12);
            int m = Main.rand.nextInt(10) + 9;
            if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
                Main.hallway[m][l] = "D";
                dagger.setName("Dagger");
                dagger.setType("Weapon");
                dagger.setDMG(1);
                dagger.setHP(0);
                dagger.setX(m);
                dagger.setY(l);
                dagger.collected = false;
                int tempCounter = 0;
                for (int i = 0; i < Main.mapInv[0].length; i++) {
                    if (Main.mapInv[i][0] != null) {
                        if (Main.mapInv[i][0].type == "Weapon") {
                            tempCounter++;
                        }
                    }
                }
                Main.mapInv[tempCounter][0] = dagger;
                Main.placed = true;
            }
        }
        Main.placed = false;
    }

    public void genSwo() {
        while (!Main.placed) {
            int l = Main.rand.nextInt(12);
            int m = Main.rand.nextInt(10) + 9;
            if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
                Main.hallway[m][l] = "S";
                //Item sword = new Item("Sword", "Weapon", 2, 0);
                sword.setName("Sword");
                sword.setType("Weapon");
                sword.setDMG(2);
                sword.setHP(0);
                sword.setX(m);
                sword.setY(l);
                sword.setCollected(false);
                int tempCounter = 0;
                for (int i = 0; i < Main.mapInv[0].length; i++) {
                    if (Main.mapInv[i][0] != null) {
                        if (Main.mapInv[i][0].type == "Weapon") {
                            tempCounter++;
                        }
                    }
                }
                Main.mapInv[tempCounter][0] = sword;
                Main.placed = true;
            }
        }
        Main.placed = false;
    }

    public void genJav() {
        while (!Main.placed) {
            int l = Main.rand.nextInt(12);
            int m = Main.rand.nextInt(10) + 9;
            if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
                Main.hallway[m][l] = "J";
                //Item javelin = new Item("Javelin", "Weapon", 3, 0);
                javelin.setName("Javelin");
                javelin.setType("Weapon");
                javelin.setDMG(3);
                javelin.setHP(0);
                javelin.setX(m);
                javelin.setY(l);
                javelin.setCollected(false);
                int tempCounter = 0;
                for (int i = 0; i < Main.mapInv[0].length; i++) {
                    if (Main.mapInv[i][0] != null) {
                        if (Main.mapInv[i][0].type == "Weapon") {
                            tempCounter++;
                        }
                    }
                }
                Main.mapInv[tempCounter][0] = javelin;
                Main.placed = true;
            }
        }
        Main.placed = false;
    }

    public void genChe() {
        while (!Main.placed) {
            int l = Main.rand.nextInt(12);
            int m = Main.rand.nextInt(10) + 9;
            if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
                Main.hallway[m][l] = "C";
                //Item chest = new Item("Chest", "Armor", 0, 3);
                chest.setName("Chest");
                chest.setType("Armor");
                chest.setDMG(0);
                chest.setHP(3);
                chest.setX(m);
                chest.setY(l);
                chest.setCollected(false);
                int tempCounter = 0;
                for (int i = 0; i < Main.mapInv[1].length; i++) {
                    if (Main.mapInv[i][1] != null) {
                        if (Main.mapInv[i][1].type == "Armor") {
                            tempCounter++;
                        }
                    }
                }
                Main.mapInv[tempCounter][1] = chest;
                Main.placed = true;
            }
        }
        Main.placed = false;
    }

    public void genLeg() {
        while (!Main.placed) {
            int l = Main.rand.nextInt(12);
            int m = Main.rand.nextInt(10) + 9;
            if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
                Main.hallway[m][l] = "L";
                //Item leggings = new Item("Leggings", "Armor", 0, 1);
                leggings.setName("Leggings");
                leggings.setType("Armor");
                leggings.setDMG(0);
                leggings.setHP(1);
                leggings.setX(m);
                leggings.setY(l);
                leggings.setCollected(false);
                int tempCounter = 0;
                for (int i = 0; i < Main.mapInv[1].length; i++) {
                    if (Main.mapInv[i][1] != null) {
                        if (Main.mapInv[i][1].type == "Armor") {
                            tempCounter++;
                        }
                    }
                }
                Main.mapInv[tempCounter][1] = leggings;
                Main.placed = true;
            }
        }
        Main.placed = false;
    }

    public void genArm() {
        while (!Main.placed) {
            int l = Main.rand.nextInt(12);
            int m = Main.rand.nextInt(10) + 9;
            if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
                Main.hallway[m][l] = "A";
                //Item gauntlets = new Item("Gauntlets", "Armor", 0, 2);
                gauntlets.setName("Gauntlets");
                gauntlets.setType("Armor");
                gauntlets.setDMG(0);
                gauntlets.setHP(2);
                gauntlets.setX(m);
                gauntlets.setY(l);
                gauntlets.setCollected(false);
                int tempCounter = 0;
                for (int i = 0; i < Main.mapInv[1].length; i++) {
                    if (Main.mapInv[i][1] != null) {
                        if (Main.mapInv[i][1].type == "Armor") {
                            tempCounter++;
                        }
                    }
                }
                Main.mapInv[tempCounter][1] = gauntlets;
                Main.placed = true;
            }
        }
        Main.placed = false;
    }

    public void genGold() {
        int l = Main.rand.nextInt(12);
        int m = Main.rand.nextInt(10) + 9;
        if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
            Main.hallway[m][l] = "G";
            //Item gold = new Item("100", "Currency", 0, 0);
            gold1.setName("100G");
            gold1.setType("Currency");
            gold1.setDMG(0);
            gold1.setHP(0);
            gold1.setX(m);
            gold1.setY(l);
            gold1.setCollected(false);
            int tempCounter = 0;
            for (int j = 0; j < Main.mapInv[2].length; j++) {
                if (Main.mapInv[j][2] != null) {
                    if (Main.mapInv[j][2].type == "Currency") {
                        tempCounter++;
                    }
                }
            }
            Main.mapInv[tempCounter][2] = gold1;
            //Main.placed = true;
        }
        
        l = Main.rand.nextInt(12);
        m = Main.rand.nextInt(10) + 9;
        if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
            Main.hallway[m][l] = "G";
            //Item gold = new Item("100", "Currency", 0, 0);
            gold2.setName("100G");
            gold2.setType("Currency");
            gold2.setDMG(0);
            gold2.setHP(0);
            gold2.setX(m);
            gold2.setY(l);
            gold2.setCollected(false);
            int tempCounter = 0;
            for (int j = 0; j < Main.mapInv[2].length; j++) {
                if (Main.mapInv[j][2] != null) {
                    if (Main.mapInv[j][2].type == "Currency") {
                        tempCounter++;
                    }
                }
            }
            Main.mapInv[tempCounter][2] = gold2;
            //Main.placed = true;
        }
        
        l = Main.rand.nextInt(12);
        m = Main.rand.nextInt(10) + 9;
        if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
            Main.hallway[m][l] = "G";
            //Item gold = new Item("100", "Currency", 0, 0);
            gold3.setName("100G");
            gold3.setType("Currency");
            gold3.setDMG(0);
            gold3.setHP(0);
            gold3.setX(m);
            gold3.setY(l);
            gold3.setCollected(false);
            int tempCounter = 0;
            for (int j = 0; j < Main.mapInv[2].length; j++) {
                if (Main.mapInv[j][2] != null) {
                    if (Main.mapInv[j][2].type == "Currency") {
                        tempCounter++;
                    }
                }
            }
            Main.mapInv[tempCounter][2] = gold3;
            //Main.placed = true;
        }
        
        l = Main.rand.nextInt(12);
        m = Main.rand.nextInt(10) + 9;
        if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
            Main.hallway[m][l] = "G";
            //Item gold = new Item("100", "Currency", 0, 0);
            gold4.setName("100G");
            gold4.setType("Currency");
            gold4.setDMG(0);
            gold4.setHP(0);
            gold4.setX(m);
            gold4.setY(l);
            gold4.setCollected(false);
            int tempCounter = 0;
            for (int j = 0; j < Main.mapInv[2].length; j++) {
                if (Main.mapInv[j][2] != null) {
                    if (Main.mapInv[j][2].type == "Currency") {
                        tempCounter++;
                    }
                }
            }
            Main.mapInv[tempCounter][2] = gold4;
            //Main.placed = true;
        }
        
        l = Main.rand.nextInt(12);
        m = Main.rand.nextInt(10) + 9;
        if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
            Main.hallway[m][l] = "G";
            //Item gold = new Item("100", "Currency", 0, 0);
            gold5.setName("100G");
            gold5.setType("Currency");
            gold5.setDMG(0);
            gold5.setHP(0);
            gold5.setX(m);
            gold5.setY(l);
            gold5.setCollected(false);
            int tempCounter = 0;
            for (int j = 0; j < Main.mapInv[2].length; j++) {
                if (Main.mapInv[j][2] != null) {
                    if (Main.mapInv[j][2].type == "Currency") {
                        tempCounter++;
                    }
                }
            }
            Main.mapInv[tempCounter][2] = gold5;
            //Main.placed = true;
        }
        
        l = Main.rand.nextInt(12);
        m = Main.rand.nextInt(10) + 9;
        if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
            Main.hallway[m][l] = "G";
            //Item gold = new Item("100", "Currency", 0, 0);
            gold6.setName("100G");
            gold6.setType("Currency");
            gold6.setDMG(0);
            gold6.setHP(0);
            gold6.setX(m);
            gold6.setY(l);
            gold6.setCollected(false);
            int tempCounter = 0;
            for (int j = 0; j < Main.mapInv[2].length; j++) {
                if (Main.mapInv[j][2] != null) {
                    if (Main.mapInv[j][2].type == "Currency") {
                        tempCounter++;
                    }
                }
            }
            Main.mapInv[tempCounter][2] = gold6;
            //Main.placed = true;
        }
        
        l = Main.rand.nextInt(12);
        m = Main.rand.nextInt(10) + 9;
        if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
            Main.hallway[m][l] = "G";
            //Item gold = new Item("100", "Currency", 0, 0);
            gold7.setName("100G");
            gold7.setType("Currency");
            gold7.setDMG(0);
            gold7.setHP(0);
            gold7.setX(m);
            gold7.setY(l);
            gold7.setCollected(false);
            int tempCounter = 0;
            for (int j = 0; j < Main.mapInv[2].length; j++) {
                if (Main.mapInv[j][2] != null) {
                    if (Main.mapInv[j][2].type == "Currency") {
                        tempCounter++;
                    }
                }
            }
            Main.mapInv[tempCounter][2] = gold7;
            //Main.placed = true;
        }
        
        l = Main.rand.nextInt(12);
        m = Main.rand.nextInt(10) + 9;
        if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
            Main.hallway[m][l] = "G";
            //Item gold = new Item("100", "Currency", 0, 0);
            gold8.setName("100G");
            gold8.setType("Currency");
            gold8.setDMG(0);
            gold8.setHP(0);
            gold8.setX(m);
            gold8.setY(l);
            gold8.setCollected(false);
            int tempCounter = 0;
            for (int j = 0; j < Main.mapInv[2].length; j++) {
                if (Main.mapInv[j][2] != null) {
                    if (Main.mapInv[j][2].type == "Currency") {
                        tempCounter++;
                    }
                }
            }
            Main.mapInv[tempCounter][2] = gold8;
            //Main.placed = true;
        }
        
        l = Main.rand.nextInt(12);
        m = Main.rand.nextInt(10) + 9;
        if (l < 4 || l > 8 && Main.hallway[m][l] == ".") {
            Main.hallway[m][l] = "G";
            //Item gold = new Item("100", "Currency", 0, 0);
            gold9.setName("100G");
            gold9.setType("Currency");
            gold9.setDMG(0);
            gold9.setHP(0);
            gold9.setX(m);
            gold9.setY(l);
            gold9.setCollected(false);
            int tempCounter = 0;
            for (int j = 0; j < Main.mapInv[2].length; j++) {
                if (Main.mapInv[j][2] != null) {
                    if (Main.mapInv[j][2].type == "Currency") {
                        tempCounter++;
                    }
                }
            }
            Main.mapInv[tempCounter][2] = gold9;
            //Main.placed = true;
        }

    }
}