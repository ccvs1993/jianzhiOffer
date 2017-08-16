package com.chap6;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 输入递增裴谞的数组和1个数字s，在数组中查找两个数，使得他们的和正好是s.
 * 如{1,2,4,7,11,15}和数字15，输出4，11
 */
public class No41 {
    public void findSum(int[] arr,int sum){
        int lo=0;
        int hi=arr.length-1;
        while(lo<hi){
            if (arr[lo]+arr[hi]<sum){
                lo++;
            }else if(arr[lo]+arr[hi]>sum){
                hi--;
            }else {
                System.out.println(arr[lo]+" "+arr[hi]);
                return;
            }
        }
    }
    

    @Test
    public void test() {
        int[] arr={1,2,4,7,11,15};
        findSum(arr,15);
    }
}
