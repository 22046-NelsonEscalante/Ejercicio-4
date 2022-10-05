package Model;

public class Explorer extends Character{
    
    private Item[] Inventory = new Item[8];


    public Explorer(int maxHP, int currentHP, int ATK, String entryQuote, String winQuote, String loseQuote, Item[] inventory) {
        super(maxHP, currentHP, ATK, entryQuote, winQuote, loseQuote, inventory);
        setInventory(inventory);
    }

    public Item[] getInventory() {
        return Inventory;
    }

    public void setInventory(Item[] inventory) {
        Inventory = inventory;
    }
}
