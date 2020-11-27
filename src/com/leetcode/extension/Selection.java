package com.leetcode.extension;

import java.util.Arrays;

public class Selection {
    public static int[] sort(int[] a, int left, int right){
        for(int i = left; i < right; i++){
            int min = i;
            for(int j = i + 1; j <= right; j++){
                if(a[min] > a[j]){
                    min = j;
                }
            }
            if(i != min){
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {10,5,9,1,3,7,6,4,2,8,0,-1};
        Selection.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
