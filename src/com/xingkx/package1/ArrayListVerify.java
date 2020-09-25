package com.xingkx.package1;

import java.util.ArrayList;
import java.util.List;

public class ArrayListVerify {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        List<String> temp = new ArrayList<>();
        temp.add("sad");
        temp.add("angry");

        list.add(null);
        list.add(1, "happy");
        list.addAll(temp);
        list.addAll(1,temp);

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.containsAll(temp));
        temp.add("regret");
        System.out.println(list.contains("disappointed"));
        System.out.println(list.containsAll(temp));
        list.set(3, "annoyed");
        System.out.println(list);

        list.remove(null);
        list.remove("null");//不存在字符串为null的
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.get(3));
    }
}
