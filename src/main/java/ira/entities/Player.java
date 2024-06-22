package ira.entities;

import ira.enums.EnumFightStatus;
import ira.models.AnythingPerson;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Player extends AnythingPerson {

    private String name;
    private double power, health, agility, defence, accuracy, money;
    private EnumFightStatus fightStatus;

}