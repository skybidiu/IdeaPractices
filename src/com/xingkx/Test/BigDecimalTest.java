package com.xingkx.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

abstract class Test{
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void print(){
        System.out.println(getStr());
    }
    String str;

}
class Te extends Test{

}
class Person{
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

}
public class BigDecimalTest {
    public static void main(String[] args) throws IOException {

        Person p = new Person("xkx",1);
        Person tmp = p;
        p.id = 2;
        System.out.println(p.id + " " + p.name);
        System.out.println(tmp.id + " " + tmp.name);
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
        HashMap<String, String> hm = new HashMap<>(5);
    }
}
