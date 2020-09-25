package com.xingkx.package1;

/**
 * 抽象类
 * 1。抽象类不能被实例化，实例化的工作应该交由它的子类来完成，它只需要一个引用即可。
 * 2。抽象方法必须由子类进行重写。
 * 3。只要包含一个抽象方法的抽象类，该类必须要定义成抽象类，不管是否还包含有其他方法。
 * 4。抽象类中可以包含具体的方法，当然也可以不包含抽象方法。
 * 5。子类中的抽象方法不能与父类的抽象方法同名
 * 6。abstract不能与final并列修饰一个类
 * 7。abstract不能与private、static、final或native并列修饰同一个方法。
 */

/**
 * 接口
 * 1。Interface中的所有方法访问权限自动被声明为public（只能为public）其他的比如protected、private会编译报错
 * 2。Interface中的成员变量自动变为public static final，可以通过类命名直接访问：ImplementClass.name
 * 3。Interface中不存在实现的方法。在JDK1.8，允许给接口添加两种非抽象的方法实现1）默认方法，2）静态方法
 * 4。实现接口的非抽象类必须要实现该接口的所有方法，抽象类可以不用实现。
 * 5。不能使用new操作符实例化一个接口，但可以声明一个接口变量，该变量必须引用refer to一个实现该接口的类的对象。
 *    可以使用instanceof检查一个对象是否实现了某给特定的接口。例如：if(anObject instanceof Comparable){}.
 * 6。在实现多接口的时候一定要避免方法名的重复。
 */

/**
 * difference：
 * grammar层次：抽象类可以拥有任意范围的成员数据，同时也可以拥有自己的非抽象方法。只能继承一个抽象类，可以实现多个接口。
 * design层次：1。抽象层次不同，抽象类对类抽象，包括属性、行为，接口只是对行为的抽象。
 *            2。跨域不同，抽象类是一种继承is-a关系，接口是一种like-a关系，可以跨域不同的类。
 *            3。设计层次不同，抽象类是自底向上抽象，接口是自顶向下设计出来的。
 */
interface MyInterface{

    int id = 10;//默认修饰符public static final
    int getId();//默认修饰符public abstract
    //默认方法，由实现类调用
    default String get(){
        System.out.println("我是jdk1.8默认实现方法...");
        return "catch me if you can";
    }
    //这个是静态方法，由接口名调用
    static void staticmethod(){
        System.out.println("我是静态方法...");
    }
}
class TestInterface implements MyInterface{
    public int getId(){
        return 18;
    }

}
public class AbstractClassAndInterface {

    public static void main(String[] args) {
        MyInterface.staticmethod();
        TestInterface ti = new TestInterface();
        ti.get();
    }
}
