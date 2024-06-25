package ira.models;

import ira.enums.EnumItemStatus;
import ira.enums.EnumSomeStatus;
import ira.enums.EnumTypeItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Player extends SomePerson {

    private String name;
    private double power, health, agility, defence, accuracy, money;
    private boolean isAlive;
    private EnumSomeStatus someStatus;
    private List<SomeItem> inventory;
    private SomeItem weapon;
    private SomeItem armor;

    public void equip(SomeItem someItem) {
        if (someItem.getType().equals(EnumTypeItem.WEAPON)) {
            if (this.getWeapon() != null) {
                this.unEquip(this.getWeapon());
            }
            this.setPower(this.getPower() + someItem.getPower());
            this.setHealth(this.getHealth() + someItem.getHealth());
            this.setAgility(this.getAgility() + someItem.getAgility());
            this.setDefence(this.getDefence() + someItem.getDefence());
            this.setAccuracy(this.getPower() + someItem.getAccuracy());
            this.setWeapon(someItem);
            someItem.setStatus(EnumItemStatus.EQUIPPED);
            this.getInventory().remove(someItem);
            System.out.println(this.getWeapon().getName() + " экипирован");
        } else if (someItem.getType().equals(EnumTypeItem.ARMOR)) {
            if (this.getArmor() != null) {
                this.unEquip(this.getArmor());
            }
            this.setPower(this.getPower() + someItem.getPower());
            this.setHealth(this.getHealth() + someItem.getHealth());
            this.setAgility(this.getAgility() + someItem.getAgility());
            this.setDefence(this.getDefence() + someItem.getDefence());
            this.setAccuracy(this.getPower() + someItem.getAccuracy());
            this.setArmor(someItem);
            someItem.setStatus(EnumItemStatus.EQUIPPED);
            this.getInventory().remove(someItem);
            System.out.println(this.getArmor().getName() + " экипирован");
        } else {
            System.out.println("Этот предмет нельзя надеть...");
        }
    }

    public void unEquip(SomeItem someItem) {
        if (someItem.equals(this.getArmor())) {
            someItem.setStatus(EnumItemStatus.IN_INVENTORY);
            this.getInventory().add(someItem);
            this.setArmor(null);
            this.setPower(this.getPower() - someItem.getPower());
            this.setHealth(this.getHealth() - someItem.getHealth());
            this.setAgility(this.getAgility() - someItem.getAgility());
            this.setDefence(this.getDefence() - someItem.getDefence());
            this.setAccuracy(this.getPower() - someItem.getAccuracy());
            System.out.println(someItem.getName() + " перемещен в инвентарь");
        } else if (someItem.equals(this.getWeapon())) {
            someItem.setStatus(EnumItemStatus.IN_INVENTORY);
            this.getInventory().add(someItem);
            this.setWeapon(null);
            this.setPower(this.getPower() - someItem.getPower());
            this.setHealth(this.getHealth() - someItem.getHealth());
            this.setAgility(this.getAgility() - someItem.getAgility());
            this.setDefence(this.getDefence() - someItem.getDefence());
            this.setAccuracy(this.getPower() - someItem.getAccuracy());
            System.out.println(someItem.getName() + " перемещен в инвентарь");
        } else {
            System.out.println("На вас это не надето...");
        }
    }
}