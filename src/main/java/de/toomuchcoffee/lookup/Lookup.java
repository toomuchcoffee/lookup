package de.toomuchcoffee.lookup;

import java.util.List;

public interface Lookup<T> {
    void add(List<T> row);

    T find(int findInCol, Object matchWith, int resultCol);
}
