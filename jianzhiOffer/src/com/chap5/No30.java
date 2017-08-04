package com.chap5;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 输入n个数，找出其中最小的k个数
 */
public class No30 {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ls=new ArrayList<>();
        TreeSet<Integer> set=new TreeSet<>();

        if(input.length<k ||k<1)
            return ls;

        for (int i = 0; i < input.length; i++) {
            if(set.size()<k){
                set.add(input[i]);
            }else{
                Integer max=set.last();
                if (input[i]<max){
                    set.remove(max);
                    set.add(input[i]);
                }
            }
        }
        for(Integer i : set){
            ls.add(i);
        }
        return ls;
    }

    public static void main(String[] args) {
        int[] arr={4,5,1,6,1,7,3,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(arr, 4);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}
