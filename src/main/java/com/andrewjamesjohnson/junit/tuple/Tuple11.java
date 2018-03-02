package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple11<A, B, C, D, E, F, G, H, I, J, K> implements TupleParameter {

    public static <A, B, C, D, E, F, G, H, I, J, K> Tuple11<A, B, C, D, E, F, G, H, I, J, K> of(A _1, B _2, C _3, D _4, E _5, F _6, G _7, H _8, I _9, J _10, K _11) {
        return new Tuple11<>(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11);
    }

    public A _1;
    public B _2;
    public C _3;
    public D _4;
    public E _5;
    public F _6;
    public G _7;
    public H _8;
    public I _9;
    public J _10;
    public K _11;

    private Tuple11(A _1, B _2, C _3, D _4, E _5, F _6, G _7, H _8, I _9, J _10, K _11) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
        this._7 = _7;
        this._8 = _8;
        this._9 = _9;
        this._10 = _10;
        this._11 = _11;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11);
    }
}