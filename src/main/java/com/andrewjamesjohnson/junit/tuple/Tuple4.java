package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple4<A, B, C, D> implements TupleParameter {
    public A a;
    public B b;
    public C c;
    public D d;

    public Tuple4(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(a, b, c, d);
    }
}