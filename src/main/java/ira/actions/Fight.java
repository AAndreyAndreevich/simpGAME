package ira.actions;

import ira.entities.Player;
import ira.enums.EnumSomeStatus;
import ira.models.SomePerson;

import java.util.Scanner;

public class Fight {

    public static void fight(SomePerson attacker, SomePerson defender) {
        Scanner scanner = new Scanner(System.in);
        Thread thread = new Thread(() -> {
            String currentAction;
            int randForBot;
            int turn = 1;
            System.out.printf("\n%s атаковал %s!\n", attacker.getName(), defender.getName());
            attacker.setSomeStatus(EnumSomeStatus.IN_FIGHT);
            defender.setSomeStatus(EnumSomeStatus.IN_FIGHT);
            while(attacker.isAlive() && defender.isAlive()) {
                System.out.printf("\n===Ход: %d===\n\n", turn);
                if (attacker.getClass() == Player.class) {
                    System.out.printf("%s выберите действие:\n", attacker.getName());
                    System.out.println("1. Атаковать");
                    System.out.println("2. Защититься");
                    currentAction = scanner.nextLine();
                    switch (currentAction) {
                        case "1":
                            attacker.attack(defender);
                            break;
                        case "2":
                            attacker.defend();
                            break;
                        default:
                            System.out.println("Вы должны выбрать атаковать или защититься");
                            continue;
                    }
                    if (defender.isAlive()) {
                        randForBot = (int) (Math.random() * 10);
                        System.out.printf("%s думает...\n", defender.getName());
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (randForBot % 2 != 0) {
                            System.out.printf("%s проводит защиту!\n", defender.getName());
                            defender.defend();
                        } else {
                            System.out.printf("%s проводит атаку!\n", defender.getName());
                            defender.attack(attacker);
                        }
                    }
                    turn++;
                } else {
                    randForBot = (int) (Math.random() * 10);
                    System.out.printf("%s думает...\n", attacker.getName());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (randForBot % 2 != 0) {
                        System.out.printf("%s проводит защиту!\n", attacker.getName());
                        attacker.defend();
                    } else {
                        System.out.printf("%s проводит атаку!\n", attacker.getName());
                        attacker.attack(defender);
                    }
                    if (defender.isAlive()) {
                        System.out.printf("%s выберите действие:\n", defender.getName());
                        System.out.println("1. Атаковать");
                        System.out.println("2. Защититься");
                        currentAction = scanner.nextLine();
                        switch (currentAction) {
                            case "1":
                                defender.attack(attacker);
                                break;
                            case "2":
                                defender.defend();
                                break;
                            default:
                                System.out.println("Вы должны выбрать атаковать или защититься");
                                continue;
                        }
                    }
                    turn++;
                }
            }
            attacker.setSomeStatus(EnumSomeStatus.WITHOUT_STATUS);
            defender.setSomeStatus(EnumSomeStatus.WITHOUT_STATUS);
        });

        thread.start();
    }

}