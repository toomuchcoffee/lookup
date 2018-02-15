package de.toomuchcoffee.lookup;

import java.util.ArrayList;
import java.util.List;

public class Lookup<L, M, R> {

    private List<Entry<L, M, R>> table = new ArrayList<>();

    public void add(final Entry<L, M, R> entry) {
        table.add(entry);
    }

    public Query<L, M, R> createQuery() {
        return new Query<>();
    }

    public Entry<L, M, R> find(final Query<L, M, R> query) {
        return table.stream()
                .filter(query::matches)
                .findFirst()
                .orElse(null);
    }
}
