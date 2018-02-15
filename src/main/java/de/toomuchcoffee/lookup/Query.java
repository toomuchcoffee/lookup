package de.toomuchcoffee.lookup;

import java.util.Objects;

public class Query<L, M, R> {
    private L left;
    private M middle;
    private R right;

    public Query<L, M, R> andLeft(L left) {
        this.left = left;
        return this;
    }

    public Query<L, M, R> andMiddle(M middle) {
        this.middle = middle;
        return this;
    }

    public Query<L, M, R> andRight(R right) {
        this.right = right;
        return this;
    }

    public boolean matches(final Entry<L, M, R> entry) {
        return matches(left, entry.getLeft()) &&
                matches(middle, entry.getMiddle()) &&
                matches(right, entry.getRight());
    }

    private boolean matches(Object q, Object e) {
        return q == null || Objects.equals(q, e);
    }
}
