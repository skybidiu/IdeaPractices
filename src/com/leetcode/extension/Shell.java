package com.leetcode.extension;

import java.util.Arrays;

//不稳定，时间复杂度较难分析，根据增量序列的多样性和构造的复杂性来决定，最坏也为N的平方，好一点N的二分之三
public class Shell {
    public static int[] sort(int[] a, int left, int right){
        int length = right - left + 1;
        for(int step = length / 2; step >= 1; step /= 2) {
            for(int i = left + step; i <= right; i++){
                int curr = a[i];
                int j = i - step;
                while(j >= left && a[j] > curr){
                    a[j + step] = a[j];
                    j -= step;
                }
                a[j + step] = curr;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {5,9,1,3,7,6,4,2,8,0,-1};
        Shell.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
