package ira.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumFightStatus {

    WITHOUT_STATUS("Без статуса"),
    IN_FIGHT("В бою"),
    IN_DEFENCES("Статус защиты");

    private final String currentStatus;
}