package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple3<A, B, C> implements TupleParameter {
    public A a;
    public B b;
    public C c;

    public Tuple3(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(a, b, c);
    }
}