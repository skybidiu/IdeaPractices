package com.xingkx.package1;

/**
 * Java实现多态有三个必要条件：
 * 继承、在多态中必须存在有继承关系的子类和父类
 * 重写、子类对父类中某些方法进行重新定义，在调用这些方法时就会调用子类的方法
 * 向上转型、在多态中需要将子类的引用赋给父类对象
 *
 * 实现形式：继承和接口
 */

class A{
    public String show(A obj){
        return ("A and A");
    }

    public String show(D obj){
        return ("A and D");
    }

}

class B extends A{
    //重写
    public String show(A obj){
        return ("B and A");
    }

    public String show(B obj){
        return ("B and B");
    }

}

class C extends B{

}

class D extends B{

}

public class DuoTaiCondition {
    /**
     * 当超类对象引用变量 引用子类对象时，被引用对象的类型而不是引用变量 而不是 引用变量的类型决定了调用谁的成员方法
     * 但是这个被调用的方法必须是在超类中定义过的，也就是说被子类覆盖的方法，但是它仍然要根据继承链中方法调用的优先级
     * 来确认方法，该优先级为：this.show(O),super.show(O),this.show((super)O),super.show((super)O).
     * @param args
     */
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a2.show(b));
        System.out.println("5--" + a2.show(c));
        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
    }
}
