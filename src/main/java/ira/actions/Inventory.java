package ira.actions;

import ira.models.Player;
import ira.models.SomeItem;
import lombok.SneakyThrows;

import java.util.Scanner;

public class Inventory {

    @SneakyThrows
    public static void inventory(Player player) {
        Scanner scanner = new Scanner(System.in);
        Thread thread = new Thread(() -> {
            String currentCommand;
            String currentItem;
            System.out.print(
                    "\nВыберите нужное действие с инвентарем:\n" +
                            "1. Посмотреть содержимое инвентаря\n" +
                            "2. Выкинуть предмет из инвентаря\n" +
                            "3. Надеть предмет\n" +
                            "4. Убрать оружие\n" +
                            "5. Снять броню\n" +
                            "6. Посмотреть экипировку и баланс\n" +
                            "7. Выйти\n"+
                            "Вводите: "
            );
            currentCommand = scanner.nextLine();
            while (!currentCommand.equals("7")) {
                switch (currentCommand) {
                    case "1":
                        System.out.println(player.getInventory());
                        break;
                    case "2":
                        currentItem = scanner.nextLine();
                        for (SomeItem item : player.getInventory()) {
                            if (item.getName().equals(currentItem)) {
                                player.getInventory().remove(item);
                                break;
                            }
                        }
                        break;
                    case "3":
                        currentItem = scanner.nextLine();
                        for (SomeItem item : player.getInventory()) {
                            if (item.getName().equals(currentItem)) {
                                player.equip(item);
                                break;
                            }
                        }
                        break;
                    case "4":
                        player.unEquip(player.getWeapon());
                        break;
                    case "5":
                        player.unEquip(player.getArmor());
                        break;
                    case "6":
                        if (player.getArmor() != null) System.out.println("Броня : " + player.getArmor().getName());
                        else System.out.println("Нет брони");
                        if (player.getWeapon() != null) System.out.println("Оружие : " + player.getWeapon().getName());
                        else System.out.println("Нет оружия");
                        System.out.println("Баланс : " + player.getMoney());
                        break;
                    default:
                        System.out.println("Данный пункт отсутствует, введите корректный вариант");
                        break;
                }
                System.out.print(
                        "\nВыберите нужное действие с инвентарем:\n" +
                                "1. Посмотреть содержимое инвентаря\n" +
                                "2. Выкинуть предмет из инвентаря\n" +
                                "3. Надеть предмет\n" +
                                "4. Убрать оружие\n" +
                                "5. Снять броню\n" +
                                "6. Посмотреть экипировку и баланс\n" +
                                "7. Выйти\n"+
                                "Вводите: "
                );
                currentCommand = scanner.nextLine();
            }
        });
        thread.start();
        thread.join();
    }
}