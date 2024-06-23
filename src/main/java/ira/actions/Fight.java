package ira.actions;

import ira.models.SomePerson;

public class Fight {

    public static void fight(SomePerson attacker, SomePerson defender) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int turn = 1;
                System.out.printf("%s атаковал %s!", attacker.getName(), defender.getName());
                while(true) {
                    System.out.printf("===Ход: %d===", turn);
                }
            }
        });

        thread.start();
    }

}