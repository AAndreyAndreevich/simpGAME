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
        while (!currentCommand.equals("6")) {
            switch (currentCommand) {
                case "1":
                    System.out.println(player.getInventory());
                    break;
                case "2":
                    currentItem = scanner.nextLine();
                    for (SomeItem item : player.getInventory()) {
                        if (item.getName().equals(currentItem)) {
                            player.equip(item);
                            break;
                        }
                    }
                    break;
                case "3":
                    currentItem = scanner.nextLine();
                    for (SomeItem item : player.getInventory()) {
                        if (item.getName().equals(currentItem)) {
                            player.getInventory().remove(item);
                            break;
                        }
                    }
                    break;
                case "4"://пока выдаются ошибки на снятие
                    currentItem = scanner.nextLine();
                    if (player.getArmor().getName().equals(currentItem)){
                        player.unEquip(player.getArmor());
                    } else if (player.getWeapon().getName().equals(currentItem)) {
                        player.unEquip(player.getWeapon());
                    }
                    break;
                case "5":
                    if (player.getArmor() != null) System.out.println("Броня : " + player.getArmor().getName());
                    else System.out.println("Нет брони");
                    if (player.getWeapon() != null) System.out.println("Оружие : " + player.getWeapon().getName());
                    else System.out.println("Нет оружия");
                    System.out.println("Баланс : " + player.getMoney());
                    break;
                default:
                    System.out.println("Вы выбрали не то");
                    continue;
            }
            System.out.println("пишите:");
            currentCommand = scanner.nextLine();
        }
    }
}