package ira;

import ira.actions.Inventory;
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
        SomeItem someItem3 = new SomeItem("Nebula", 15, 2, 1, 3, 4, 5, EnumTypeItem.WEAPON, EnumItemStatus.WITHOUT_STATUS);
        SomeItem someItem4 = new SomeItem("Oves", 2, 2, 1, 3, 4, 5, EnumTypeItem.WEAPON, EnumItemStatus.WITHOUT_STATUS);
        SomeItem someItem5 = new SomeItem("Uhuja", 230, 2, 1, 3, 4, 5, EnumTypeItem.ARMOR, EnumItemStatus.WITHOUT_STATUS);
        player.getInventory().add(someItem);
        player.getInventory().add(someItem2);
        player.getInventory().add(someItem3);
        player.getInventory().add(someItem4);
        player.getInventory().add(someItem5);
        Inventory.inventory(player);
        for (SomeItem item : player.getInventory()) {
            System.out.println(item.getName());
        }
        System.out.println(player.getPower());
    }
}