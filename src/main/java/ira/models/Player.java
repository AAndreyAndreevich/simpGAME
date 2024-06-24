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
        SomeItem dopeItem = new SomeItem("Balda", 0,0,0,0,0,0, EnumTypeItem.WITHOUT_TYPE, EnumItemStatus.WITHOUT_STATUS);
        for (SomeItem item : this.getInventory()) {
            if (item.equals(someItem)) {
                dopeItem = someItem;
            } else {
                System.out.println("Данного предмета нет в вашем инвентаре...");
            }
        }
        if (dopeItem.getType().equals(EnumTypeItem.WEAPON)) {
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
        } else if (dopeItem.getType().equals(EnumTypeItem.ARMOR)) {
            if (this.getArmor() != null) {
                this.unEquip(this.getWeapon());
            }
            this.setPower(this.getPower() + someItem.getPower());
            this.setHealth(this.getHealth() + someItem.getHealth());
            this.setAgility(this.getAgility() + someItem.getAgility());
            this.setDefence(this.getDefence() + someItem.getDefence());
            this.setAccuracy(this.getPower() + someItem.getAccuracy());
            this.setArmor(someItem);
            someItem.setStatus(EnumItemStatus.EQUIPPED);
            this.getInventory().remove(someItem);
        } else if (dopeItem.getType().equals(EnumTypeItem.WITHOUT_TYPE)) {
            System.out.println("У вас нет этого предмета...");
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
        } else if (someItem.equals(this.getWeapon())) {
            someItem.setStatus(EnumItemStatus.IN_INVENTORY);
            this.getInventory().add(someItem);
            this.setWeapon(null);
            this.setPower(this.getPower() - someItem.getPower());
            this.setHealth(this.getHealth() - someItem.getHealth());
            this.setAgility(this.getAgility() - someItem.getAgility());
            this.setDefence(this.getDefence() - someItem.getDefence());
            this.setAccuracy(this.getPower() - someItem.getAccuracy());
        } else {
            System.out.println("На вас это не надето...");
        }
    }
}