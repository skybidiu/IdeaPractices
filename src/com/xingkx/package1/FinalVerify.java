package com.xingkx.package1;

/**
 * 1编译器常量，在类加载的过程就已经完成了初始化，永远不可改变
 * 2运行期初始化
 *
 * 父类的final方法是不能被子类所覆盖的，也就是说子类是不够存在和父类一模一样的方法的。
 *
 * final修饰类，它的成员变量可以为final，也可以为非final；
 * 而它的方法则会自动的加上final
 * 注：类的private方法会隐式地被指定为final方法
 */

import java.util.Random;

class People{
    private String name;

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class FinalVerify {
    private final String final01 = "xingkx";

    private final String final02;//构造器常量，在实例化一个对象时被初始化

    private static Random random = new Random();
    private final int fianl03 = random.nextInt(50);//使用随机数来初始化

    public final People final04 = new People("kaixuanxing");//final指向引用数据类型

    public FinalVerify(String final02) {
        this.final02 = final02;
    }

    @Override
    public String toString() {
        return "FinalVerify{" +
                "final01='" + final01 + '\'' +
                ", final02='" + final02 + '\'' +
                ", fianl03=" + fianl03 +
                ", final04=" + final04.getName() +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("-----第一次创建-----");
        FinalVerify fv1 = new FinalVerify("cm");
        System.out.println(fv1);

        System.out.println("-----第二次创建-----");
        FinalVerify fv2 = new FinalVerify("zj");
        System.out.println(fv2);

        System.out.println("-----修改引用对象-----");
        fv2.final04.setName("xingkaixuan");
        System.out.println(fv2);

        //interesting
        String str = "xingkaixuan";
        final String pre1 = "xing";
        String pre2 = "xing";
        final String pre3 = getPre();

        /**
         * 当final变量是基本数据类型以及String类型时，如果在编译期间能知道确切值，则编译器会
         * 把它当作编译期常量使用。
         */
        String whole1 = pre1 + "kaixuan";
        String whole2 = pre2 + "kaixuan";
        String whole3 = pre3 + "kaixuan";
        //pre2的访问需要在运行时通过链接来进行
        //pre3也是在运行时才知道
        System.out.println(str == whole1);//true
        System.out.println(str == whole2);//false
        System.out.println(str == whole3);//false
    }

    public static String getPre(){
        return "xing";
    }
}
