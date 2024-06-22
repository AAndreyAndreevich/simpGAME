package ira.models;

import ira.enums.EnumSomeStatus;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class SomePerson {

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * ЗНАЧЕНИЯ МОГУТ ИЗМЕНЯТЬСЯ! ВСЕ ЗАВИСИТ ОТ ТОГО НА СКОЛЬКО УМНОЖАЕТСЯ (Math.random)!
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Максимальные значения для характеристик(выше не имеет смысла ставить при инициализации):
     * agility(ловкость, для шанса критического удара): 1000,
     * accuracy(меткость, для шанса попадания): 100,
     * defence(защита, для поглощения урона): 1000
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

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
            System.out.println(
                    target.getName() + " защитился! " + this.getName() + " нанес всего " + tempPowerInDef + " урона!\n"
                    + " У " + target.getName() + " осталось " + startHealth + " здоровья!");
            target.setFightStatus(EnumSomeStatus.WITHOUT_STATUS);
            if (startHealth <= 0) {
                target.setAlive(false);
                System.out.println(target.getName() + " повержен...");
            }
        } else if ((Math.random() * 100) > this.getAccuracy()) {
            System.out.println(this.getName() + " промахнулся...следующий!");
        } else if ((Math.random() * 1000) > this.getAgility()){
            startHealth -= tempPower;
            System.out.println(
                    this.getName() + " нанес " + tempPower + " урона!\n"
                    + " У " + target.getName() + " осталось " + startHealth + " здоровья!");
            if (startHealth <= 0) {
                target.setAlive(false);
                System.out.println(target.getName() + " повержен...");
            }
        } else {
            tempPower*=2;
            startHealth-=tempPower;
            System.out.println(
                    "Критическое попадание! " + this.getName() + " нанес " + tempPower + " урона!\n"
                    + " У " + target.getName() + " осталось " + startHealth + " здоровья!");
            if (startHealth <= 0) {
                target.setAlive(false);
                System.out.println(target.getName() + " повержен...");
            }
        }
    }

    public void defend() {
        this.setFightStatus(EnumSomeStatus.IN_DEFENCES);
    }

    public void trade(SomePerson target) {}

}