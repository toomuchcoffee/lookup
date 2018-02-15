package de.toomuchcoffee.lookup.impl;

import java.util.ArrayList;
import java.util.List;

import de.toomuchcoffee.lookup.Lookup;

public class SimpleLookup<T> implements Lookup<T> {

    private List<List<T>> table = new ArrayList<>();

    public void add(final List<T> row) {
        table.add(row);
    }

    public T find(final int findInCol, final Object matchWith, final int resultCol) {
        return table.stream()
                .filter(row -> row.get(findInCol).equals(matchWith))
                .findFirst()
                .map(row -> row.get(resultCol))
                .orElse(null);
    }
}
