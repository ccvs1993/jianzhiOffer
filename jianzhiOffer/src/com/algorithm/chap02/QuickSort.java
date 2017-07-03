package com.algorithm.chap02;

/**
 * Created by wangfei on 2017/6/12.
 */
public class QuickSort {
    public static void quicksort(Integer[] arr){
        quicksort(arr,0,arr.length-1);
    }

    private static void quicksort(Integer[] arr, int lo, int hi) {
        if(lo>=hi) return;
        int j=partition(arr,lo,hi);
        quicksort(arr,lo,j-1);
        quicksort(arr,j+1,hi);
    }

    private static int partition(Integer[] arr, int lo, int hi) {
        int i=lo;
        int j=hi+1;
        Integer v=arr[lo];
        while(true){
            while(v>arr[++i])if (i==hi)break;
            while(v<arr[--j])if (j==lo)break;
            if(i>=j)break;
            swap(arr,i,j);
        }
        swap(arr,lo,j);
        return j;
    }

    private static void swap(Integer[] arr,int i,int j){
        Integer temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
