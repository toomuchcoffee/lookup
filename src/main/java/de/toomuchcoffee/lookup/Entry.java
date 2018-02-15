package de.toomuchcoffee.lookup;

public class Entry<L, M, R> {
    private L left;
    private M middle;
    private R right;

    public static <L, M, R>Entry<L, M, R> create(L left, M middle, R right) {
        return new Entry<>(left, middle, right);
    }

    private Entry(final L left, final M middle, final R right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public M getMiddle() {
        return middle;
    }

    public R getRight() {
        return right;
    }
}
