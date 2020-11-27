package com.leetcode.extension;

import java.util.Arrays;

public class Merge {
    public static int[] sort(int[] a){
        //这里不改变参数数组的内容，进行一个数组的复制,有范围的是Arrays.copyOfRange,无范围的是Arrays.copyOf
        int[] arr = Arrays.copyOfRange(a, 0, a.length);
        if(arr.length < 2){
            return arr;
        }
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(sort(left), sort(right));
    }
    public static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                result[k++] = left[i++];
            }
            else{
                result[k++] = right[j++];
            }
        }
        while(i < left.length){
            result[k++] = left[i++];
        }
        while(j < right.length){
            result[k++] = right[j++];
        }
        return result;

    }

    public static void main(String[] args) {
        int[] a = {100,5,9,1,3,7,6,4,2,8,0,-1,99, -2};
        int[] res = Merge.sort(a);
        System.out.println(Arrays.toString(res));
    }
}
