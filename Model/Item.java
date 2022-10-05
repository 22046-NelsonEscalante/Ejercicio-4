package Model;

public class Item {
    
    private String name;
    private int healing;

    
    public Item(String name, int healing) {
        setName(name);
        setHealing(healing);
    }
    

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
