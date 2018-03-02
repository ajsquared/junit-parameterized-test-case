package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple6<A, B, C, D, E, F> implements TupleParameter {
    public A a;
    public B b;
    public C c;
    public D d;
    public E e;
    public F f;

    public Tuple6(A a, B b, C c, D d, E e, F f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(a, b, c, d, e, f);
    }
}