package com.algorithm.chap02;

import java.util.Arrays;

/**
 * Created by wangfei on 2017/6/14.
 * 二分搜索
 */
public class BinarySearch {
    public static int search(int[] arr,int num){
        int lo=0;
        int hi=arr.length-1;
        int mid;
        while(lo<=hi){//这个地方是小于等于，我之前写成小于，出错了
            mid=lo+(hi-lo)/2;
            if(num<arr[mid]) hi=mid-1;
            else if(num>arr[mid]) lo=mid+1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={9,8,7,6,5,4,3,2,1};
        Arrays.sort(arr);
        System.out.println(search(arr,9));
    }
}
