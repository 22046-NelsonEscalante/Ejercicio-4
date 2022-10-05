package View;

import java.util.Random;
import Model.*;
import Model.Character;
import Controller.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DriverProgram {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Model.Character player = new Character(0, 0, 0, null, null, null, null);
        ArrayList<Enemy> Enemies = new ArrayList<Enemy>();
        Battle battle = new Battle();
        int loop = 1;
        int level = 1;

        System.out.println("Escuchaste rumores de un gran tesoro, escondido en una jungla olvidada por el tiempo.");
        System.out.println("No tienes nada que perder, y decides arriesgar tu vida por la aventura...");

        while (loop == 1) {
            System.out.println("=====JUNGLA PROHIBIDA=====");
            System.out.println("\nSelecciona una opción.");
            System.out.println("1. COMENZAR EL JUEGO.");
            System.out.println("2. SALIR.");
            int menuOpt = Integer.parseInt(in.nextLine());

            switch (menuOpt) {
                case 1:
                    loop = 2;
                    break;
                case 2:
                    loop = 0;
                    break;
                default:
                    System.out.println("Por favor, ingresa un número válido.");
                    break;
            }
        }

        while (loop == 2) {
            System.out.println("Selecciona una clase.");
            System.out.println("1. Guerrero:\n\t* Una clase poderosa, pero con un inventario pequeño.");
            System.out.println("2. Explorador:\n\t* Una clase de fuerza media, pero con un gran inventario.");
            int menuOpt = Integer.parseInt(in.nextLine());

            switch (menuOpt) {
                case 1:
                    player = newWarrior();
                    System.out.println("La jungla se vuelve más espesa...");
                    loop = 3;
                    break;
                case 2:
                    player = newExplorer();
                    System.out.println("La jungla se vuelve más espesa...");
                    loop = 3;
                    break;
                default:
                    System.out.println("Ingresa un valor válido.");
                    break;
            }
        }

        while (loop == 3) {
            System.out.println("Ingresa una opción.");
            System.out.println("1. Adentrarse más...");
            System.out.println("2. Abandonar la aventura.");
            int menuOpt = Integer.parseInt(in.nextLine());

            switch (menuOpt) {
                case 1:
                    Enemies = generateEnemies(level);
                    for (Enemy e: Enemies) {
                        System.out.println(e.getEntryQuote());
                    }
                    battle.setTurnCounter(1);
                    loop = 4;
                    break;
                case 2:
                    loop = 0;
                    break;
                default:
                    System.out.println("Ingresa un valor válido.");
                    break;
            }
        }

        while (loop == 4) {
            ArrayList<Character> deaths = new ArrayList<Character>();

            for (Enemy e: Enemies) {
                if (e.getCurrentHP() <= 0) {
                    deaths.add(e);
                }
            }

            Enemies.removeAll(deaths);

            if (Enemies.isEmpty()) {
                battle.setTurnCounter(3);
            } else {
                switch (battle.getTurnCounter()) {
                    case 1:
                        System.out.println("Tienes "+player.getCurrentHP()+" PS");
                        System.out.println("Selecciona una acción:");
                        System.out.println("1. Atacar.");
                        System.out.println("2. Usar objeto.");
                        System.out.println("3. Inspeccionar.");
                        int option = Integer.parseInt(in.nextLine());

                        switch (option) {
                            case 1:
                                System.out.println("Selecciona un enemigo.");
                                listEnemies(Enemies);
                                int enemy = Integer.parseInt(in.nextLine());

                                if (enemy > 3 || enemy < 0) {
                                    System.out.println("Ingrese un valor válido.");
                                    break;
                                } else {
                                enemy--;
                                Enemy target = Enemies.get(enemy);

                                System.out.println(battle.PlayerAttack(player, target));

                                if (target.getCurrentHP() <= 0) {
                                    System.out.println(target.getLoseQuote());
                                    break;
                                }

                                battle.setTurnCounter(2);
                                break;
                                }

                            case 2:
                                System.out.println("Selecciona un objeto.");
                                listInventory(player.getInventory());
                                int itemInv = Integer.parseInt(in.nextLine());

                                if (itemInv > 3 || itemInv < 0) {
                                    System.out.println("Ingrese un valor válido.");
                                    break;
                                } else {
                                itemInv--;
                                Item item = player.getInventory()[itemInv];
                                
                                int heal = item.getHealing();
                                player.setCurrentHP(player.getCurrentHP() + heal);
                                battle.setTurnCounter(2);
                                break;
                                }
                            case 3:
                                System.out.println("Selecciona un enemigo.");
                                listEnemies(Enemies);
                                int inspectEnemy = Integer.parseInt(in.nextLine());

                                if (inspectEnemy > 3 || inspectEnemy < 0) {
                                    System.out.println("Ingrese un valor válido");
                                    break;
                                } else {
                                inspectEnemy--;

                                Enemy EnemyToInspect = Enemies.get(inspectEnemy);
                                System.out.println(EnemyToInspect.getDescription());
                                break;
                                }
                            default:
                                System.out.println("Ingrese un valor válido.");
                                break;
                        }

                    case 2:
                        for (Enemy e: Enemies) {
                            int roll = battle.d20();
                            if (roll <= 15) {
                                System.out.println(battle.EnemyAttack(e, player));
                                if (player.getCurrentHP() <= 0) {
                                    System.out.println(e.getWinQuote());
                                }
                            } else {
                                System.out.println(battle.Ability(e, player));
                            }
                        }
                        if (player.getCurrentHP() <= 0) {
                            System.out.println(player.getLoseQuote());
                            System.out.println("FIN DEL JUEGO.");
                            loop = 0;
                            break;
                        } else {
                        battle.setTurnCounter(1);
                        break;
                        }
                    case 3:
                        System.out.println("Sales victorioso de la batalla.");
                        loop = 3;
                }
            }
        }

        in.close();
    }


    public static void listEnemies(ArrayList<Enemy> enemies) {
        int cont = 1;
        for (Enemy e: enemies) {
            System.out.println(cont +". " + e.getName() + "\t" + e.getCurrentHP() + "PS");
            cont++;
        }
    }

    public static void listInventory(Item[] inv) {
        int cont = 1;
        for (Item i: inv) {
            System.out.println(cont +". "+ i.getName()+"\tRecupera "+i.getHealing()+" PS");
            cont++;
        }
    }

    /*===========================================CONSTRUCTORES===========================================*/
    public static ArrayList<Enemy> generateEnemies(int level) {
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();

        if (level == 1) {
            enemies.add(CarnPlant());
        } else {
            Random rand = new Random();
            int num = rand.nextInt(3);

            while (enemies.size() <= num) {
                int roll = rand.nextInt(2);
                switch (roll) {
                    case 0:
                        enemies.add(CarnPlant());
                        break;
                    case 1:
                        enemies.add(Bear());
                        break;
                }
            }
            return null;
        }

        return enemies;
    } 

    /*===========CHARACTER===========*/
    public static Warrior newWarrior() {
        Item[] inventory = {Potion(), Potion(), Potion(), Potion()};
        Warrior player = new Warrior(40, 40, 7, "Voy a aplastarte.", "No te metas conmigo.", "Ugh...", inventory);

        return player;
    }

    public static Explorer newExplorer() {
        Item[] inventory = {Potion(), Potion(), Potion(), Potion(), gPotion(), gPotion(), Potion() , Potion()};
        Explorer player = new Explorer(20, 20, 4, "Te derrotaré.", "Un paso más cerca del tesoro.", "Tan cerca...", inventory);

        return player;
    }

    /*===========ITEMS===========*/
    public static Item Potion() {
        Item potion = new Item("Poción", 10);

        return potion;
    }

    public static Item gPotion() {
        Item gPotion = new Item("Gran Poción", 20);

        return gPotion;
    }

    /*===========ENEMIES===========*/
    public static Enemy CarnPlant() {
        Enemy carnPlant = new Enemy(15, 15, 3, "Una hambrienta planta carnivora gigante avanza hacia ti!", "La planta se dará un festín hoy...", "La planta carnívora se convierte en un montón de hojas.", "Planta Carnívora", "Planta viviente con un gusto adquirido por las personas.", "Fotosíntesis", null);
        return carnPlant;
    }

    public static Enemy Bear() {
        Enemy bear = new Enemy(30, 30, 8, "Un poderoso oso te ataca!", "La fuerza del oso es suficiente para aplastarte.", "El oso dejó de moverse.", "Oso", "Un gran oso con garras afiladas.", "Afilar", null);
        return bear;
    }
}
