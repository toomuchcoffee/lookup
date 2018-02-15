package de.toomuchcoffee.lookup.impl;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

import de.toomuchcoffee.lookup.Lookup;

public class SimpleLookupTest {

    @Test
    public void find() {
        Lookup<String> lookup = new SimpleLookup<>();
        lookup.add(Arrays.asList("a", "b", "c"));
        lookup.add(Arrays.asList("foo", "bar", "baz"));
        assertThat(lookup.find(0, "foo", 1), is("bar"));
        assertThat(lookup.find(2, "c", 0), is("a"));
    }
}
