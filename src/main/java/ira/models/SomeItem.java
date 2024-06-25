package ira.models;

import ira.enums.EnumItemStatus;
import ira.enums.EnumTypeItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SomeItem {

    private String name;
    private double power, health, agility, defence, accuracy, price;
    private EnumTypeItem type;
    private EnumItemStatus status;

}