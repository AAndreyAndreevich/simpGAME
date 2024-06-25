package ira.actions;

import ira.models.Player;
import ira.models.SomeItem;

import java.util.Scanner;

public class Inventory {

    public static void inventory(Player player) {
        String currentCommand;
        String currentItem;
        Scanner scanner = new Scanner(System.in);
        System.out.println("пишите: ");
        currentCommand = scanner.nextLine();
        switch (currentCommand) {
            case "1":
                int i = 0;
                for (SomeItem item : player.getInventory()) {
                    i++;
                    System.out.println(i + " : " + item.getName());
                }
                Inventory.inventory(player);
            case "2":
                currentItem = scanner.nextLine();
                for (SomeItem item : player.getInventory()) {
                    if (item.getName().equals(currentItem)) {
                        player.equip(item);
                        Inventory.inventory(player);
                    }
                }
                Inventory.inventory(player);
            case "3":
                currentItem = scanner.nextLine();
                for (SomeItem item : player.getInventory()) {
                    if (item.getName().equals(currentItem)) {
                        player.getInventory().remove(item);
                        Inventory.inventory(player);
                    }
                }
                Inventory.inventory(player);
            case "4":
                currentItem = scanner.nextLine();
                //снятие
            case "5":
                System.out.println("Броня : " + player.getArmor().getName());
                System.out.println("Оружие : " + player.getWeapon().getName());
                System.out.println("Баланс : " + player.getMoney());
                break;
            case "56":
                System.out.println("Выход есть");
                break;
            default:
                System.out.println("Вы выбрали не то");
                Inventory.inventory(player);
        }

    }
}