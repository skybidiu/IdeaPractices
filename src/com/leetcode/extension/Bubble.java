package com.leetcode.extension;

import java.util.Arrays;

public class Bubble {
    public static int[] sort(int[] a, int left, int right){
        int length = right - left + 1;

        for(int i = 1; i < length; i++){
            boolean swap = false;
            for (int j = left; j <= right - i; j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {5,9,1,3,7,6,4,2,8,0,-1};
        Bubble.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
