package ira;

import ira.entities.Monster;
import ira.entities.Player;
import ira.enums.EnumSomeStatus;
import ira.models.SomeItem;

import java.util.ArrayList;
import java.util.List;

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
                EnumSomeStatus.WITHOUT_STATUS);
        Monster monster = new Monster(
                "Monster!!",
                1000.0,
                2000.0,
                500.0,
                500.0,
                100.0,
                2.0,
                EnumSomeStatus.WITHOUT_STATUS);

        player.attack(monster);
    }
}