package com.xingkx.package1;

/**
 * 慎用继承：问一问自己是否需要从子类向父类进行向上转型。如果必须向上转型，则继承是必要的
 *         如果不需要，则另考虑
 * 1。父类变，子类就必须变
 * 2。继承破坏了继承，对于父类而言，他的实现细节对于子类来说都是透明的
 * 3。继承是一种强耦合关系
 *
 * 在继承中，子类可以自动转型为父类，但是父类强制转换成子类时只有当引用类型真正的身份为子类
 * 时才会强制转换成功，否则失败。
 */
class Person{
    protected String name;
    protected int age;
    protected String sex;

    Person(String name){
        this.name = name;
        System.out.println("Person Constructor-----" + name);
    }
}
class Husband extends Person{
    private Wife wife;

    /**
     * 构造器：父类的构造器只能被子类调用，而不能被继承。super()
     * 编译器会默认给子类调用父类的构造器，前提是父类有默认构造器，否则就要显示的使用super()来调用父类构造器，
     * 否则编译器会报错：无法找到符合父类形式的构造器。
     */
    Husband(){
        super("xingkx");
        System.out.println("Husband Constructor-----");
    }
}
class Wife extends Person{
    private Husband husband;
    Wife(){
        super("");
        System.out.println("Wife Constructor-----");
    }
}
public class ExtendVerify {

}
