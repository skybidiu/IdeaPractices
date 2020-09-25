package com.xingkx.package1;

/**
 * 普通代码块：方法名后面用{}括起来的代码段
 * 静态代码块：用static修饰的用{}括起来的代码段，目的是对静态属性进行初始化
 * 同步代码块：用synchronized关键字修饰，并使用{}～，表示同一时间只能有一个线程
 *          进入到该方法块中，是一种多线程保护机制
 * 构造代码块：类中直接定义，没有任何修饰符、前缀、后缀的代码块
 *
 */
public class CodeBlock {

    /**
     * 构造代码块:按照代码构造代码块的顺序插入到所有的构造函数的最前端，保证
     *          不管调用哪个构造函数都会执行所有的构造代码块，而构造代码块
     *          是依托构造函数执行的。
     * 场景使用：初始化实例变量、实例环境
     */
    {
        System.out.println("执行构造代码块...");
    }

    public CodeBlock(){
        System.out.println("执行无参构造函数...");
    }

    public CodeBlock(String id){
        System.out.println("执行有参构造函数...");
    }

    static{
        System.out.println("静态代码块");
    }

    public void test(){
        System.out.println("普通代码块");

    }

    /**
     * 静态代码块 > 构造代码块 > 构造函数
     * @param args
     */
    public static void main(String[] args) {
        CodeBlock cb = new CodeBlock();
        CodeBlock cb2 = new CodeBlock("CodeBlock");
    }
}
