package com.xingkx.ThreadDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 要点：要能区分好是类对象锁还是实例对象锁便能很灵活的运行synchronized同步锁了
 * 注意：开销大，可能造成死锁
 */
class MyThread implements Runnable{
    private int count;
    private static int num;

    @Override
    public void run() {
        String str = Thread.currentThread().getName();
        if(str.equals("SyncThread1")){
            syncAdd();

        } else if(str.equals("SyncThread2")){
            syncDecrease();
        }
        else{
            method();
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
    //无论操作的是不是同一个实例对象，只要是该类型，调用该方法，就只有一把锁可用，只允许一条线程执行代码块
    public void methodSameAsBelow(){
        synchronized (MyThread.class){
            for(int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": num = " +(num++));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public synchronized static void method() {
        for(int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ": num = " +(num++));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class SynchronizedTest {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        //1.这里证明了当两条或者多条线程同时访问一个同步方法的时候才会造成阻塞等待状态，可以是不同的同步方法
        Thread t1 = new Thread(myThread, "SyncThread1");
        Thread t2 = new Thread(myThread, "SyncThread2");
        t1.start();
        t2.start();

        //2.尽管两条线程操作不同的对象，但是调用的都是静态方法，锁定的也是类对象（类对象锁）
        Thread t3 = new Thread(new MyThread(), "SyncThread3");
        Thread t4 = new Thread(new MyThread(), "SyncThread4");
        t3.start();
        t4.start();

        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        //Executors.newCachedThreadPool()
        List<String> list = new ArrayList<>();
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        TreeMap treeMap = new TreeMap();
    }
}
