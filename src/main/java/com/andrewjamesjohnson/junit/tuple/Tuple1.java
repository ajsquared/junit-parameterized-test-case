package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple1<A> implements TupleParameter {
    public A a;

    public Tuple1(A a) {
        this.a = a;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(a);
    }
}