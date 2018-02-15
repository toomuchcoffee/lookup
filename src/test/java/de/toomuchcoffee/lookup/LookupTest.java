package de.toomuchcoffee.lookup;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import de.toomuchcoffee.lookup.Entry;
import de.toomuchcoffee.lookup.Lookup;
import de.toomuchcoffee.lookup.Query;

public class LookupTest {
    private Lookup<String, String, String> lookup;

    @Before
    public void setUp() {
        lookup = new Lookup<>();
        lookup.add(Entry.create("a", "b", "c"));
        lookup.add(Entry.create("foo", "bar", "baz"));
    }

    @Test
    public void findByLeft() {
        Query<String, String, String> query = lookup.createQuery().andLeft("foo");
        Entry<String, String, String> entry = lookup.find(query);
        assertThat(entry, not(nullValue()));
        assertThat(entry.getMiddle(), is("bar"));
    }

    @Test
    public void findByMiddle() {
        Query<String, String, String> query = lookup.createQuery().andMiddle("bar");
        Entry<String, String, String> entry = lookup.find(query);
        assertThat(entry, not(nullValue()));
        assertThat(entry.getRight(), is("baz"));
    }

    @Test
    public void findByRight() {
        Query<String, String, String> query = lookup.createQuery().andRight("c");
        Entry<String, String, String> entry = lookup.find(query);
        assertThat(entry, not(nullValue()));
        assertThat(entry.getLeft(), is("a"));
    }

    @Test
    public void findNothing() {
        Query<String, String, String> query = lookup.createQuery().andLeft("foobar");
        Entry<String, String, String> entry = lookup.find(query);
        assertThat(entry, nullValue());

    }
}
