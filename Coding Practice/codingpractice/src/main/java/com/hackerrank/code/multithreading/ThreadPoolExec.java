package com.hackerrank.code.multithreading;

import java.util.concurrent.*;

public class ThreadPoolExec {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "thread-name");
            }
        };
        MyTask task = new MyTask();
        ExecutorService executors = Executors.newCachedThreadPool(threadFactory);
        executors.execute(task);
    }
}


class MyTask implements Runnable{

    @Override
    public void run() {
        System.out.printf("Sarath Babu!!!");
    }
}