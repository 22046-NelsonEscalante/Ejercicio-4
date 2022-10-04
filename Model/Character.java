package Model;

public class Character {
    
    private int maxHP;
    private int currentHP;
    private int ATK;    
    private String entryQuote;    
    private String winQuote;    
    private String loseQuote;


    public Character(int maxHP, int currentHP, int ATK, String entryQuote, String winQuote, String loseQuote) {
        setMaxHP(maxHP);
        setCurrentHP(currentHP);
        setATK(ATK);
        setEntryQuote(entryQuote);
        setWinQuote(winQuote);
        setLoseQuote(loseQuote);
    }

    
    public int getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    public int getCurrentHP() {
        return currentHP;
    }
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    public int getATK() {
        return ATK;
    }
    public void setATK(int aTK) {
        ATK = aTK;
    }
    public String getEntryQuote() {
        return entryQuote;
    }
    public void setEntryQuote(String entryQuote) {
        this.entryQuote = entryQuote;
    }
    public String getWinQuote() {
        return winQuote;
    }
    public void setWinQuote(String winQuote) {
        this.winQuote = winQuote;
    }
    public String getLoseQuote() {
        return loseQuote;
    }
    public void setLoseQuote(String loseQuote) {
        this.loseQuote = loseQuote;
    }
}
