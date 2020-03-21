package com.hackerrank.code.multithreading;

public class SynchTest {

    synchronized void test1(){
        System.out.println("I am test 1");
    }

    synchronized  void  test2(){
        System.out.println("I am test 2");
        this.test1();
        System.out.println("I am test 2 ending");
    }

    public static void main(String[] args) {
        SynchTest s = new SynchTest();
        s.test2();
    }
}
