package Model;

public class Warrior extends Character{
    
    private Item[] Inventory = new Item[4];


    public Warrior(int maxHP, int currentHP, int ATK, String entryQuote, String winQuote, String loseQuote, Item[] inventory) {
        super(maxHP, currentHP, ATK, entryQuote, winQuote, loseQuote);
        setInventory(inventory);
    }

    public Item[] getInventory() {
        return Inventory;
    }

    public void setInventory(Item[] inventory) {
        Inventory = inventory;
    }
}
