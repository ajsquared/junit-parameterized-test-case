package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple4<A, B, C, D> implements TupleParameter {

    public static <A, B, C, D> Tuple4<A, B, C, D> of(A _1, B _2, C _3, D _4) {
        return new Tuple4<>(_1, _2, _3, _4);
    }

    public A _1;
    public B _2;
    public C _3;
    public D _4;

    private Tuple4(A _1, B _2, C _3, D _4) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(_1, _2, _3, _4);
    }
}