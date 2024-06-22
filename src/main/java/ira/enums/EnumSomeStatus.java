package ira.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumSomeStatus {

    WITHOUT_STATUS("Без статуса"),
    IN_DEFENCES("Статус защиты");

    private final String currentStatus;
}