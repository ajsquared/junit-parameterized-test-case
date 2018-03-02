package com.andrewjamesjohnson.junit.tuple;

import com.andrewjamesjohnson.junit.Parameter;

import java.util.Collection;
import java.util.stream.Collectors;

public interface TupleParameter extends Parameter {
    @Override
    default String description() {
        return elements().stream().map(Object::toString).collect(Collectors.joining(","));
    }

    Collection<Object> elements();
}
