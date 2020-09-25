package com.xingkx.package2;

import java.util.*;

class ErrorTest{
    private Set<String> set = new HashSet<>();
    public ErrorTest(){

    }
    public void test(){
        Func func = new Func();
        func.add(set);
        System.out.println(set);
    }

}
class Func{
    public void add(Set<String> set){
        set.add("haha");
    }
}

public class SetTest{
    public static void main(String[] args) {
        ErrorTest et = new ErrorTest();
        et.test();

        List<String> list = new ArrayList<>();
        list.add("imhere");
        Iterator<String> it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
        //test。test成功
        //测试
    }
}
