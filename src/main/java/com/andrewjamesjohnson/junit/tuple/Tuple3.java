package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple3<A, B, C> implements TupleParameter {

    public static <A, B, C> Tuple3<A, B, C> of(A _1, B _2, C _3) {
        return new Tuple3<>(_1, _2, _3);
    }

    public A _1;
    public B _2;
    public C _3;

    private Tuple3(A _1, B _2, C _3) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(_1, _2, _3);
    }
}