package com.hackerrank.code;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInt {
    final public AtomicInteger ai = new AtomicInteger();
    public void atomset(){
        ai.set(123);
    }
    public int getNumber(){
        return ai.get();
    }

    public static void main(String[] args) {
        AtomicInt a = new AtomicInt();
        a.atomset();
        System.out.println(a.getNumber());
    }
}
