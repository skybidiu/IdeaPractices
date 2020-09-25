package com.xingkx.package1;

/**
 * 所谓多态就是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时
 * 并不确定，而是在程序运行期间才确定，即一个引用变量到底会指向哪个类的实例对象，该引用变量
 * 发出的方法调用到底是哪个类中实现的方法，必须在由程序运行期间才能决定。因为在程序运行时才
 * 确定的类，这样，不用修改源程序代码，就可以让引用变量绑定到各种不同的类实现上，从而导致该
 * 引用调用的具体方法随之改变，即不修改程序代码就可以改变程序运行时所绑定的具体代码，让程序
 * 可以选择多个运行状态，这就是多态性。
 */
class Wine{
    public void fun1(){
        System.out.println("Wine's fun1....");
        fun2();
    }

    public void fun2(){
        System.out.println("Wine's fun2....");
    }

}

class JNC extends Wine{

    /**
     * @desc 子类重载父类方法
     *          父类中不存在该方法，向上转型后，父类是不能引用该方法的
     * @param str
     */
    public void fun1(String str){
        System.out.println("JNC's fun1....");
        fun2();
    }

    /**
     * 子类重写父类方法
     * 指向子类的父类引用调用fun2时，必定是调用该方法
     */
    public void fun2(){
        System.out.println("JNC's fun2....");
    }
}

public class DuoTaiVerify {
    /**
     * 总结
     * 指向子类的父类引用由于向上转型了，它只能访问父类中拥有的方法和属性， 而对于子类中存在而父类中不存在的方法
     * 该引用是不能使用的，尽管是重载该方法。若子类重写了父类中的某些方法，在调用该些方法的时候，必定是使用子类中
     * 定义的这些方法（动态连接，动态调用）
     *
     * @param args
     */
    public static void main(String[] args) {
        Wine wine = new JNC();
        wine.fun1();
        //output:Wine's fun1....
        //       JNC's fun2....
    }
}
