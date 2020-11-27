package com.xingkx.Test;

class Father{
    public void test(){
        fatherfunc();
    }
    protected void fatherfunc(){
        System.out.println("call fatherfunc!");
    }
}
class Son extends Father{

    public void anotherTest(){
        fatherfunc();
    }
    protected void fatherfunc(){
        System.out.println("son call fatherfunc!");
    }
}

public class ExtendsTest {
    public static void main(String[] args) {
        Son son = new Son();
        String regex = "[<>/\\\\|:\"*?]";
        String rep = "abcd\"ef\\<g>h/i|j:k?lmn";
        rep = rep.replaceAll(regex, "");
        System.out.println(rep);
    }
}
