package com.chap2.source;

/**
 * Created by wangfei on 2017/6/14.
 * 旋转数组的最小数字，
 * 原数组（已经从小到大排好序）：1 2 3 4 5
 * 旋转后的数组 3   4    5    1    2
 *             lo      mid       hi
 * 求旋转后的数组中最小的元素
 *
 * key:数组分为两部分，都是递增数组。
 * 使用二分法，如果mid元素小于lo元素，则说明mid位于前半部分，目的元素在mid之后
 *            如果mid元素小于hi元素，则说明mid位于后半部分，目的元素在mid之前
 */
public class No8 {
    public static int findMinIndex(int[] arr){
        int lo=0;
        int hi=arr.length-1;
        int mid=0;
        //说明数组是排好序的
        if(arr[lo]<arr[hi]) return -1;

        while(lo<=hi){
            mid=lo+(hi-lo)/2;
            //如果中间元素和lo,hi相等，只能顺序查找
            if(arr[lo]==arr[hi] && arr[mid]==arr[lo]){
                return linearSearch(arr);
            }
            if(arr[lo]<arr[mid]) lo=mid;
            else if(arr[mid]<arr[hi]) hi=mid;
            else return hi;
        }
        return  -1;
    }

    public static int linearSearch(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(min<arr[i]){
                min=arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr={1,0,1,1,1};
        System.out.println(findMinIndex(arr));
    }
}
