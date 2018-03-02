package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple2<A, B> implements TupleParameter {
    public A a;
    public B b;

    public Tuple2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(a, b);
    }
}