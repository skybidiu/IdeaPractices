package com.leetcode.extension;

import java.util.Arrays;

public class Heap {
    public static int[] sort(int[] a, int left, int right){
        int[] arr = Arrays.copyOfRange(a, left, right + 1);
        buildMaxHeap(arr, left, right);
        for(int i = right; i > left; ){
            swap(arr, left, i--);
            heapify(arr, left, i);
        }
        return arr;
    }
    public static void buildMaxHeap(int[] arr, int left, int right){
        for(int i = left + (right - left - 1) / 2; i >= left; i--){
            heapify(arr, i, right);
        }
    }
    public static void heapify(int[] arr, int i, int right){
        int temp = arr[i];
        for(int pos = 2 * i + 1; pos <= right; pos = pos * 2 + 1){
            if(pos + 1 <= right && arr[pos] < arr[pos + 1]){
                pos++;
            }
            if(arr[pos] > temp) {
                arr[i] = arr[pos];
                i = pos;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
    public static void heapifyBySwap(int[] arr, int i, int right){
        for(int pos = 2 * i + 1; pos <= right; pos = pos * 2 + 1){
            if(pos + 1 <= right && arr[pos] < arr[pos + 1]){
                pos++;
            }
            if(arr[i] < arr[pos]) {
                swap(arr, i, pos);
                i = pos;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {100,5,9,1,3,7,6,4,2,8,0,-1};
        int[] res = Heap.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(res));
    }
}
