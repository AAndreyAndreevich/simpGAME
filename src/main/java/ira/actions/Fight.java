package ira.actions;

import ira.enums.EnumSomeStatus;
import ira.models.SomePerson;

import java.util.Scanner;

public class Fight {

    public static void fight(SomePerson attacker, SomePerson defender) {
        Scanner scanner = new Scanner(System.in);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int turn = 1;
                System.out.printf("%s атаковал %s!", attacker.getName(), defender.getName());
                attacker.setSomeStatus(EnumSomeStatus.IN_FIGHT);
                defender.setSomeStatus(EnumSomeStatus.IN_FIGHT);
                while(!attacker.isAlive() | !defender.isAlive()) {
                    System.out.printf("===Ход: %d===", turn);

                }
            }
        });

        thread.start();
    }

}