package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple2<A, B> implements TupleParameter {

    public static <A, B> Tuple2<A, B> of(A _1, B _2) {
        return new Tuple2<>(_1, _2);
    }

    public A _1;
    public B _2;

    private Tuple2(A _1, B _2) {
        this._1 = _1;
        this._2 = _2;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(_1, _2);
    }
}