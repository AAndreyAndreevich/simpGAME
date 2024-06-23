package ira.models;

import ira.enums.EnumSomeStatus;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class SomePerson {

    private String name;
    private double power, health, agility, defence, accuracy, money;
    private boolean isAlive;
    private EnumSomeStatus fightStatus;

    public void attack(SomePerson target) {
        double startHealth = target.getHealth();
        double tempPower = this.getPower();
        if (target.getFightStatus() == EnumSomeStatus.IN_DEFENCES) {
            double tempPowerInDef = this.getPower();
            int stackDef = (int) target.getDefence()/100;
            double xDef = 1;
            for (int i = stackDef; i > 0; i--) {
                xDef-=0.1;
                if (xDef < 0.1) xDef = 0;
            }
            tempPowerInDef*=xDef;
            startHealth-=tempPowerInDef;
            System.out.printf(
                    "%s защитился! %s нанес всего %d урона!\nУ %s осталось %d здоровья!",
                    target.getName(), this.getName(), (int) tempPowerInDef, target.getName(), (int) startHealth);
            target.setFightStatus(EnumSomeStatus.WITHOUT_STATUS);
            if (startHealth <= 0) {
                target.setAlive(false);
                System.out.printf("%s повержен...", target.getName());
            }
        } else if ((Math.random() * 100) > this.getAccuracy()) {
            System.out.printf("%s промахнулся...следующий!", this.getName());
        } else if ((Math.random() * 1000) > this.getAgility()){
            startHealth -= tempPower;
            System.out.printf(
                    "%s нанес %d урона!\nУ %s осталось %d здоровья!",
                    this.getName(), (int) tempPower, target.getName(), (int) startHealth);
            if (startHealth <= 0) {
                target.setAlive(false);
                System.out.printf("%s повержен...", target.getName());
            }
        } else {
            tempPower*=2;
            startHealth-=tempPower;
            System.out.printf(
                    "Критическое попадание! %s нанес %d урона!\nУ %s осталось %d здоровья!",
                    this.getName(), (int) tempPower, target.getName(), (int) startHealth);
            if (startHealth <= 0) {
                target.setAlive(false);
                System.out.printf("%s повержен...", target.getName());
            }
        }
    }

    public void defend() {
        this.setFightStatus(EnumSomeStatus.IN_DEFENCES);
    }

    public void trade(SomePerson target) {}

}