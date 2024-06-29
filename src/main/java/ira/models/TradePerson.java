package ira.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TradePerson {

    private String name, stayLocation;
    private List<SomeItem> store;

}