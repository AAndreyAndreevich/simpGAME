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
                break;
            case "2"://пока хз не работает я спать должен по имени предмет надевать
                currentItem = scanner.nextLine();
                for (SomeItem item : player.getInventory()) {
                    if (item.getName().equals(currentItem)) player.equip(item);
                }
                break;
            case "3":
                currentItem = scanner.nextLine();
                for (SomeItem item : player.getInventory()) {
                    if (item.getName().equals(currentItem)) player.getInventory().remove(item);
                }
                break;
            case "4":
                System.out.println("Броня : " + player.getArmor().getName());
                System.out.println("Оружие : " + player.getWeapon().getName());
                System.out.println("Баланс : " + player.getMoney());
                break;
            default:
                System.out.println("Вы выбрали не то");
                Inventory.inventory(player);
        }
    }

}