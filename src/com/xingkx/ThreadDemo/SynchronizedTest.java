package com.xingkx.ThreadDemo;

class MyThread implements Runnable{
    private int count;

    @Override
    public void run() {
        String str = Thread.currentThread().getName();
        if(str.equals("SyncThread1")){
            syncAdd();

        } else if(str.equals("SyncThread2")){
            syncDecrease();
        }
    }

    public void syncAdd(){
        synchronized (this){
            for(int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" +(count++));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void syncDecrease(){
        synchronized (this){
            for(int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" +(count--));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class SynchronizedTest {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        //这里证明了当两条或者多条线程同时访问一个同步方法的时候才会造成阻塞等待状态，可以是不同的同步方法
        Thread t1 = new Thread(myThread, "SyncThread1");
        Thread t2 = new Thread(myThread, "SyncThread2");
        t1.start();
        t2.start();
    }
}
