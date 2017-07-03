package com.chap3;

import java.util.Arrays;

/**
 * Created by wangfei on 2017/6/26.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
 * 所有偶数位于数组的后半部分
 */
public class No14 {
    //我自己的实现，新开辟一个空间，奇数从新空间的第一位开始存，偶数从新空间的最后一位开始存
    public static Integer[] exch(Integer[] arr){
        Integer[] temp=new Integer[arr.length];
        int phead=0,ptail=arr.length-1;
        for (int i=0;i<arr.length;i++){
            if(!isEVen(arr[i])){
                temp[phead++]=arr[i];
            }else{
                temp[ptail--]=arr[i];
            }
        }
        return temp;
    }
    //书上的解法
    public static void reOrder(int[] array){
        int phead=0-1;
        int ptail=array.length;

        while(phead<ptail){
            while(!isEVen(array[++phead]));
            while (isEVen(array[--ptail]));
            if(phead<ptail)//这句话我忘了加了
                swap(array,phead,ptail);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static boolean isEVen(int num){
        return num%2==0;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        //Integer[] arr2 = exch(arr);
        reOrder(arr);
        for (int integer : arr) {
            System.out.print(integer+" ");
        }
    }
}
