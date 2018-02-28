package com.andrewjamesjohnson.junit;

import java.util.Collection;

@FunctionalInterface
public interface ParameterGenerator<T extends Parameter> {
    Collection<T> generate();
}
