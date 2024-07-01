package ira.models;

import ira.enums.EnumSomeStatus;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Monster extends SomePerson {

    private String name;
    private double power, health, agility, defence, accuracy, money;
    private boolean isAlive;
    private EnumSomeStatus someStatus;

}