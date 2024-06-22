package ira.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class SomeItem {

    private String name;
    private double power, health, agility, defence, accuracy, price;

}