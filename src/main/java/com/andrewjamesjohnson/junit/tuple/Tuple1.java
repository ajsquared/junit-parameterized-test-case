package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple1<A> implements TupleParameter {

    public static <A> Tuple1<A> of(A _1) {
        return new Tuple1<>(_1);
    }

    public A _1;

    private Tuple1(A _1) {
        this._1 = _1;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(_1);
    }
}