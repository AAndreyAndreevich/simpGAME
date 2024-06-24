package ira.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumTypeItem {

    WITHOUT_TYPE("Нужно оказалось просто"),
    POTION("Зелье"),
    WEAPON("Оружие"),
    ARMOR("Броня");

    private final String currentType;

}