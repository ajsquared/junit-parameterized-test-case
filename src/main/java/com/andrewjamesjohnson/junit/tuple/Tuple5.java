package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple5<A, B, C, D, E> implements TupleParameter {

    public static <A, B, C, D, E> Tuple5<A, B, C, D, E> of(A _1, B _2, C _3, D _4, E _5) {
        return new Tuple5<>(_1, _2, _3, _4, _5);
    }

    public A _1;
    public B _2;
    public C _3;
    public D _4;
    public E _5;

    private Tuple5(A _1, B _2, C _3, D _4, E _5) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(_1, _2, _3, _4, _5);
    }
}