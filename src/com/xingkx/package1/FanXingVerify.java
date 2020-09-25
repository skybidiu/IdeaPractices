package com.xingkx.package1;

/**
 * generics泛型，参数化类型，或将类型当作参数传递给类、方法或接口
 * @param <T>
 */
interface Calculate<T>{
    T calc();
}

//泛型接口未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中。
class MyCalc<T> implements Calculate<T>{
    public T calc(){
        return null;
    }
}
//如果泛型接口传入类型参数时，实现该泛型接口的实现类，要进行替换
class MyCalcString implements Calculate<String>{
    public String calc(){
        return null;
    }
}

public class FanXingVerify<T> {
    T item;

    public FanXingVerify(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    /**
     * 泛型方法基本介绍说明
     * 1）public与返回值中间<T>非常重要，可以理解为声明此方法为泛型方法
     * 2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法不是泛型方法
     * 3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T
     * 4）与泛型类的定义一下样，此处可以随便写为任意标识，常见的如T、E、K、V
     * @param t
     * @param <T>
     */
    public <T> void PrinterInfo(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        FanXingVerify<String> fxv = new FanXingVerify("Kaixuan_Xing");
        fxv.PrinterInfo(1);
        fxv.PrinterInfo(3.33);
        fxv.PrinterInfo("come on!");


    }
}
