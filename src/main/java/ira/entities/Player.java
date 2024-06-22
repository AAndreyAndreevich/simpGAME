package ira.entities;

import ira.enums.EnumSomeStatus;
import ira.models.SomePerson;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Player extends SomePerson {

    private String name;
    private double power, health, agility, defence, accuracy, money;
    private EnumSomeStatus fightStatus;

}