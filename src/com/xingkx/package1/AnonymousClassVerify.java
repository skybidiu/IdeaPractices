package com.xingkx.package1;

/**
 * Notice
 * 1。使用匿名内部类时，必须是而且只能是继承一个类或者实现一个接口，不可兼得
 *    而且不可抽象，必须要实现继承的类或者实现的接口的所有抽象方法
 * 2。匿名内部类中不能定义构造函数
 * 3。匿名内部类中不能存在任何的静态成员变量和静态方法
 * 4。匿名内部类为局部内部类，所以局部内部类的所有限制同样对匿名内部类生效
 */
abstract class Bird{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}

public class AnonymousClassVerify {
    public void testAnonymous(Bird bird){
        System.out.println(bird.getName() + " can fly " + bird.fly() + " meters long.");
    }

    public static void main(String[] args) {
        AnonymousClassVerify anony = new AnonymousClassVerify();
        anony.testAnonymous(new Bird(){

            public int fly(){
                return 10000;
            }
            public String getName(){
                return "WildGoose";
            }
        });
    }
}
