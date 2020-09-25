package com.xingkx.package1;

/**
 * 效率
 * + concat() append()
 */
public class StringVerify {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        String aa = "aa";
        System.out.println("a.compareTo(b) == " + a.compareTo(b));
        System.out.println("a.compareTo(c) == " + a.compareTo(c));
        System.out.println("a.compareTo(aa) == " + a.compareTo(aa));

        //StringBuffer = "abc";wrong，只能使用new
        //StringBuffer线程安全，XML解析、HTTP参数解析和封装等
        StringBuffer sb = new StringBuffer("abc");
        sb.append("def");
        sb.insert(1,"abcd");
        System.out.println(sb);
        sb.delete(1, 5);
        System.out.println(sb);

        //StringBuilder线程不安全，速度快

    }
}
