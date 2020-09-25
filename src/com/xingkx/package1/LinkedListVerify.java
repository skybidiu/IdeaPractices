package com.xingkx.package1;

import java.util.LinkedList;

public class LinkedListVerify {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("five");
        list.addFirst("four");
        list.addLast("six");
        System.out.println(list);

        String first = list.remove();//remove first
        System.out.println(first);
        System.out.println(list);
        String res = list.removeFirst();
        System.out.println(res);

        list.removeFirstOccurrence("test");
        list.removeLastOccurrence("test");

        list.get(0);
        list.getFirst();
        list.getLast();
        System.out.println(list.indexOf("six"));
        System.out.println(list.indexOf("seven"));
    }
}
