package ira;

import ira.enums.EnumItemStatus;
import ira.enums.EnumSomeStatus;
import ira.enums.EnumTypeItem;
import ira.models.Player;
import ira.models.SomeItem;

import java.util.ArrayList;

public class AppRun {
    public static void main(String[] args) {
        Player player = new Player("Player", 20, 20, 30, 40, 50, 60, true, EnumSomeStatus.WITHOUT_STATUS, new ArrayList<>(), null, null);
        System.out.println(player);
        SomeItem someItem = new SomeItem("Balalayka", 10, 2, 1, 3, 4, 5, EnumTypeItem.WEAPON, EnumItemStatus.WITHOUT_STATUS);
        SomeItem someItem2 = new SomeItem("Akula", 23, 2, 1, 3, 4, 5, EnumTypeItem.WEAPON, EnumItemStatus.WITHOUT_STATUS);
        player.unEquip(someItem);
        player.equip(someItem);
        System.out.println("нет в инвентаре");
        System.out.println(player);
        player.getInventory().add(someItem);
        player.getInventory().add(someItem2);
        System.out.println(player);
        player.equip(someItem);
        System.out.println("появился в инвентаре");
        System.out.println(player);
        player.equip(someItem2);
        System.out.println("надеваем на надетое");
        System.out.println(player);
        System.out.println("снимаем");
        player.unEquip(someItem2);
        System.out.println(player);
    }
}