package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple8<A, B, C, D, E, F, G, H> implements TupleParameter {

	public static <A, B, C, D, E, F, G, H> Tuple8<A, B, C, D, E, F, G, H> of(A _1, B _2, C _3, D _4, E _5, F _6, G _7, H _8) {
		return new Tuple8<>(_1, _2, _3, _4, _5, _6, _7, _8);
	}

	public A _1;
	public B _2;
	public C _3;
	public D _4;
	public E _5;
	public F _6;
	public G _7;
	public H _8;

	private Tuple8(A _1, B _2, C _3, D _4, E _5, F _6, G _7, H _8) {
		this._1 = _1;
		this._2 = _2;
		this._3 = _3;
		this._4 = _4;
		this._5 = _5;
		this._6 = _6;
		this._7 = _7;
		this._8 = _8;
    }

    @Override
    public Collection<Object> elements() {
		return Arrays.asList(_1, _2, _3, _4, _5, _6, _7, _8);
    }
}