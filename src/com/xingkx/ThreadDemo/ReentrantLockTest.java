package com.xingkx.ThreadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    static public class MyService{
        private Lock lock = new ReentrantLock();

        public void testMethod() {
            lock.lock();
            try {
                for(int i = 0; i < 5; i++){
                    System.out.println("ThreadName = " + Thread.currentThread().getName() + " " + (i + 1));
                }
            } finally {
                lock.unlock();
            }

        }
    }
    static public class MyThread extends Thread{
        private MyService myService;

        public MyThread(MyService myService){
            super();
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.testMethod();
        }
    }

    public static void main(String[] args) {
        MyService service = new MyService();

        MyThread t1 = new MyThread(service);
        MyThread t2 = new MyThread(service);
        MyThread t3 = new MyThread(service);

        t1.start();
        t2.start();
        t3.start();

    }
}
