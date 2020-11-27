package com.leetcode.extension;

import java.util.Arrays;

//稳定，时间复杂度最坏为N的平方
public class Insertion {

    public static int[] sort(int[] a, int left, int right){
        for(int i = left, j = i; i < right; j = ++i){
            int ai = a[i + 1];
            while(ai < a[j]){
                a[j + 1] = a[j];
                if(j-- == left){
                    break;
                }
            }
            a[j + 1] = ai;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {5,9,1,3,7,6,4,2,8,0};
        Insertion.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
