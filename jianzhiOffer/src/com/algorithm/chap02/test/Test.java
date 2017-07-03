package com.algorithm.chap02.test;

import com.algorithm.chap02.QuickSort;

/**
 * Created by wangfei on 2017/6/12.
 */
public class Test {
    @org.junit.Test
    public void testQuickSort() {
        Integer arr[]={5,3,2,1};
        QuickSort.quicksort(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }
}
