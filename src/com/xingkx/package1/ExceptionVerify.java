package com.xingkx.package1;

/**
 * 对于可恢复的条件使用被检查的异常（CheckedException），发生在编译阶段，必须要使用try...catch(或者throws)
 * 否则编译不通过。
 * 对于程序错误（言外之意不可恢复，大错已经酿成）使用运行时异常（RuntimeException)，发生在运行期。
 *
 * 不论程序是否发生异常，finally代码块总是会执行。所以finally一般用来关闭资源。
 * 若程序中显示的声明了某个异常，则抛出异常时不会显示出处，否则，会显示异常的出处。
 */

/**
 * 自定义异常
 * 1。定义一个类继承Throwable或其子类
 * 2。添加构造方法（当然也可以不用添加，使用默认构造方法）
 * 3。在某个方法类抛出该异常
 * 4。捕捉该异常
 */

/**
 * 异常链
 * 两种方式处理异常，一是throws抛出交给上级处理，二是try...catch做具体处理。
 * try...catch的catch块我们可以不需要做任何处理，仅仅只用throw这个关键字将我们封装异常信息
 * 主动抛出来。然后再通过关键字throws继续抛出该方法异常。它的上层也可以做这样的处理，以此类推
 * 产生一条由异常构成的异常链。
 */

/**
 * 1尽可能的减小try块
 * 2保证所有资源都被正确释放，充分运用finally关键字
 * 3catch语句应当尽量制定具体的异常类型，而不应该指定涵盖范围太广的Exception类。
 * 4捕获异常以后要做适当的处理，并提供适量的错误原因信息
 * 5不要在finally块中处理返回值
 * 6不要在构造函数中抛出异常
 */

/**
 * throw和throws的区别
 * throws是方法抛出异常
 * throws是语句抛出一场，不可以单独使用，要么于try...catch配套使用，要么与throws配套使用。
 */
class MyException extends Exception{
    public MyException(){

    }

    public MyException(String message){
        super(message);
    }
}

public class ExceptionVerify {
    public void display(int i) throws MyException{
        if(i == 0){
            throw new MyException("该值不能为0......");
        } else {
            System.out.println(i / 2);
        }
    }

    public static void main(String[] args) {
        ExceptionVerify ev = new ExceptionVerify();
        try {
            ev.display(0);
            System.out.println("---------------");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
