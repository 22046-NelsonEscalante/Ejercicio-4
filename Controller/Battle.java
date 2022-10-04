package Controller;

import Model.*;
import Model.Character;
import java.util.Random;

public class Battle {
    private int turnCounter = 1;


    public String EnemyAttack(Enemy attacker, Character target) {
        target.setCurrentHP((target.getCurrentHP())-(attacker.getATK()));
        return attacker.getName() + " te ataca por " + attacker.getATK() + " de daño.";
    }

    public String PlayerAttack(Character attacker, Enemy target) {
        target.setCurrentHP((target.getCurrentHP())-(attacker.getATK()));
        return "Atacas por " + attacker.getATK() + " de daño.";
    }

    public String Ability(Enemy attacker, Character target) {
        int roll = d20();
        switch (attacker.getAbility()) {
            case "Fotosíntesis":
                double healCalc = attacker.getCurrentHP()*0.5*(roll/20);
                int heal = (int)healCalc;
                attacker.setCurrentHP(attacker.getCurrentHP() + heal);
                return "La " + attacker.getName() + " absorbe luz solar y se cura " + heal + "PS!";
            case "Afilar":
                double ATKcalc = attacker.getATK() * 1.2;
                int ATK = (int)ATKcalc;
                attacker.setATK(ATK);
                return "El " + attacker.getName() + " afila sus garras!";
            default:
                /*Texto que solo se lee en caso de no definir una habilidad, como un placeholder. */
                return "El enemigo gruñe...";
        }
    }


    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public int d20() {
        Random rand = new Random();

        int d20 = rand.nextInt(20);
        d20 += 1;
        return d20;
    }
}
