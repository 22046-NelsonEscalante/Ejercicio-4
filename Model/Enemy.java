package Model;

public class Enemy extends Character{
    
    private String name;
    private String description;
    private String ability;


    public Enemy(int maxHP, int currentHP, int ATK, String entryQuote, String winQuote, String loseQuote, String name, String description, String ability) {
        super(maxHP, currentHP, ATK, entryQuote, winQuote, loseQuote);
        setName(name);
        setDescription(description);
        setAbility(ability);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAbility() {
        return ability;
    }
    public void setAbility(String ability) {
        this.ability = ability;
    }
}
