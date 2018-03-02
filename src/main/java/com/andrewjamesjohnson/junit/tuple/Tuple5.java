package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple5<A, B, C, D, E> implements TupleParameter {
    public A a;
    public B b;
    public C c;
    public D d;
    public E e;

    public Tuple5(A a, B b, C c, D d, E e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(a, b, c, d, e);
    }
}