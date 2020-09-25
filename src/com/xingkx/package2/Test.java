package com.xingkx.package2;

public class Test {

    public static void main(String[] args) {
        Son son = new Son();
        son.init();
    }
}
class Father{
    public void init(){
        System.out.println("父类的init");
        diaoyong();
    }
    public void diaoyong(){
        System.out.println("父类的调用");
    }
}
class Son extends Father{
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void diaoyong() {
        super.diaoyong();
        System.out.println("子类也来啦");
    }
}
