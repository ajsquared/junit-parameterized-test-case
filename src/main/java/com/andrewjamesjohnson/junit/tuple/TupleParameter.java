package com.andrewjamesjohnson.junit.tuple;

import com.andrewjamesjohnson.junit.Parameter;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Base interface for generic tuple parameter classes
 */
public interface TupleParameter extends Parameter {
    @Override
    default String description() {
        return elements().stream().map(Object::toString).collect(Collectors.joining(","));
    }

    /**
     * Get all the elements of this tuple in order
     *
     * @return A {@code Collection} containing all the elements of this tuple
     */
    Collection<Object> elements();
}
