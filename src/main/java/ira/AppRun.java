package ira;

import ira.entities.Monster;
import ira.entities.Player;
import ira.enums.EnumFightStatus;

public class AppRun {
    public static void main(String[] args) {
        Player player = new Player(
                "Player!!",
                1000.0,
                2000.0,
                500.0,
                500.0,
                100.0,
                2.0,
                EnumFightStatus.WITHOUT_STATUS);
        Monster monster = new Monster(
                "Monster!!",
                1000.0,
                2000.0,
                500.0,
                500.0,
                100.0,
                2.0,
                EnumFightStatus.WITHOUT_STATUS);

        player.attack(monster);
    }
}