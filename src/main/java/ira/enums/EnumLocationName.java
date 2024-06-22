package ira.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumLocationName {

    FOREST("Некий лес"),
    CITY("Некий город");

    private final String locationName;

}