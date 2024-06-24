package ira.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumItemStatus {

    WITHOUT_STATUS("Без статуса"),
    IN_INVENTORY("В инвентаре, хранится"),
    IN_STORE("В магазине, продается"),
    EQUIPPED("Экипированный, на персонаже");

    private final String currentStatus;

}