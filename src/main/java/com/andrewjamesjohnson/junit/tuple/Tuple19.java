package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> implements TupleParameter {

    public static <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> of(A _1, B _2, C _3, D _4, E _5, F _6, G _7, H _8, I _9, J _10, K _11, L _12, M _13, N _14, O _15, P _16, Q _17, R _18, S _19) {
        return new Tuple19<>(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19);
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
    public L _12;
    public M _13;
    public N _14;
    public O _15;
    public P _16;
    public Q _17;
    public R _18;
    public S _19;

    private Tuple19(A _1, B _2, C _3, D _4, E _5, F _6, G _7, H _8, I _9, J _10, K _11, L _12, M _13, N _14, O _15, P _16, Q _17, R _18, S _19) {
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
        this._12 = _12;
        this._13 = _13;
        this._14 = _14;
        this._15 = _15;
        this._16 = _16;
        this._17 = _17;
        this._18 = _18;
        this._19 = _19;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19);
    }
}