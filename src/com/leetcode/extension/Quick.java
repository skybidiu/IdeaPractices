package com.leetcode.extension;

import java.util.Arrays;

public class Quick {
    public static int[] sort(int[] a, int left, int right){
        //这里不改变参数数组的内容，进行一个数组的复制,有范围的是Arrays.copyOfRange,无范围的是Arrays.copyOf
        int[] arr = Arrays.copyOfRange(a, left, right + 1);
        return quickSort(arr, left, right);
    }
    public static int[] quickSort(int[] arr, int left, int right){
        if(left < right){
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
        return arr;
    }
    public static int partition(int[] arr, int left, int right){
        int pivot = left;
        int index = pivot + 1;
        for(int i = index; i <= right; i++){
            if(arr[i] < arr[pivot]){
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, index - 1, pivot);
        return index - 1;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        int[] a = {100,5,9,1,3,7,6,4,2,8,0,-1};
        int[] res = Quick.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(res));
    }
}
