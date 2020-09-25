package com.xingkx.package1;

/**
 * 总结
 * 1。能否拥有静态成员（方法，属性）
 * 静态内部类可以拥有，而非静态内部类不可以拥有
 * 2。访问外部类的成员
 * 静态内部类只能够访问外部类的静态成员，而非静态内部类都可以访问（包括private和静态成员）
 * 3。二者在创建的时候有区别
 *
 * 外部类可以访问内部类的所有方法和属性，包括私有方法和属性

 */
class Test1{

}
class Test2{

}

/**
 * 每个内部类都能独立地继承或实现接口，无论外部类是否继承或实现接口，对于内部类没有影响
 * 也就是说内部类使得多重继承的解决方案变得更加完整
 */
public class StaticClassVerify extends Test1{
    public int a = 1;
    private static int b = 2;
    protected int c = 3;
    public static int d = 4;
    private int t = 6;
    public void testFunction(){
        //外部类可以调用内部类的静态方法和属性，非静态的必须要创建类的对象之后才能调用
        StaticInnerClass.print1();
        System.out.println(StaticInnerClass.e);

        StaticInnerClass staticInnerClass = new StaticInnerClass();

        NormalInnerClass innerClass = new NormalInnerClass();
        innerClass.print3();
        System.out.println(innerClass.f);
    }
    /**
     * 静态内部类，只有内部类才可以加static
     * 静态内部类与外层类绑定，即使没有创建外层类的对象，一样存在
     * 只能引用外部类的static成员变量（也就是类变量）
     */
    public static class StaticInnerClass extends Test2{
        public int d;
        private static int e;
        public static void print1(){
            System.out.println("StaticInnerClass call static print1()");
        }
        public void print2(){
            System.out.println("StaticInnerClass call un-static print2()");
        }
        public void print3(){
            //System.out.println(a);wrong
            System.out.println(b);//correct;

        }
    }
    public class NormalInnerClass extends Test2{
        //static int d = 4;wrong,Inner classes cannot have static declarations
        //public static void print(){};wrong
        private int f = 5;
        public double d = 3.3;
        public void print3(){
            System.out.println(a);//correct;
            System.out.println(b);//correct;
            testFunction();
        }
        //当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，即默认情况下访问的是成员内部类的成员
        //如何访问外部类的同名成员呢：外部类.this.成员变量
        //                       外部类.this.成员方法
        public StaticClassVerify getStaticClassVerify(){
            System.out.println("内部类的同名d：" + d);
            System.out.println("外部类的同名d：" + StaticClassVerify.this.d);
            return StaticClassVerify.this;
        }

    }

    //推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时
    public NormalInnerClass getNormalInnerClass(){
        return new NormalInnerClass();
    }

    public static void main(String[] args) {
        StaticClassVerify verify = new StaticClassVerify();
        System.out.println(verify.t);
        //创建静态内部类
        StaticClassVerify.StaticInnerClass staticInnerClass = new StaticClassVerify.StaticInnerClass();
        StaticInnerClass innerClass = new StaticInnerClass();
        //创建非静态内部类
        StaticClassVerify.NormalInnerClass normal= verify.new NormalInnerClass();
        NormalInnerClass normalInnerClass = verify.new NormalInnerClass();
        StaticClassVerify.NormalInnerClass n = verify.getNormalInnerClass();
        System.out.println(normalInnerClass.f);

        System.out.println(verify == normal.getStaticClassVerify());


    }
}
