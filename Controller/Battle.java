package Controller;

import Model.*;
import Model.Character;

import java.util.ArrayList;

public class Battle {
    private Character player;
    private ArrayList<Enemy> NPC;
    private int turnCounter = 1;


    public Battle(Character player, ArrayList<Enemy> NPC) {
        this.player = player;
        this.NPC = NPC;
    }


    public void PlayerAction() {
        setTurnCounter(0);
    }

    public void EnemyAction() {
        for (Enemy e: NPC) {

        }

        setTurnCounter(1);
    }


    public void Attack(Character attacker, Character target) {
        target.setCurrentHP((target.getCurrentHP())-(attacker.getATK()));
    }


    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public int getTurnCounter() {
        return turnCounter;
    }
}
