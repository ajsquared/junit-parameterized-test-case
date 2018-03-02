package com.andrewjamesjohnson.junit.tuple;

import java.util.Arrays;
import java.util.Collection;

public class Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> implements TupleParameter {
    public A a;
    public B b;
    public C c;
    public D d;
    public E e;
    public F f;
    public G g;
    public H h;
    public I i;
    public J j;
    public K k;
    public L l;
    public M m;
    public N n;
    public O o;
    public P p;
    public Q q;

    public Tuple17(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j, K k, L l, M m, N n, O o, P p, Q q) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = o;
        this.p = p;
        this.q = q;
    }

    @Override
    public Collection<Object> elements() {
        return Arrays.asList(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q);
    }
}