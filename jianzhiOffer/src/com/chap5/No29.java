package com.chap5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangfei on 2017/7/26.
 */
public class No29 {
    public static int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map=new HashMap<>();
        int len=array.length/2;
        for(Integer i:array){
            if(map.get(i)!=null){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue()>len){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
}
