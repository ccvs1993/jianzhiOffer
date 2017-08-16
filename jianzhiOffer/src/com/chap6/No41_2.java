package com.chap6;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 找出所有和为S的连续正数序列.
 * 如输入15，
 * 输出：{1，2，3，4，5}，{4，5，6}，{7，8}
 */
public class No41_2 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int sumTemp=0;
        ArrayList<Integer> ls=new ArrayList<>();
        for (int i = 1; i <= sum; i++) {
            sumTemp+=i;
            ls.add(i);
            if(sumTemp==sum){
                if(ls.size()>1)
                list.add(new ArrayList<>(ls));
            }else if(sumTemp>sum){
                while(sumTemp>sum){
                    sumTemp-=ls.get(0);
                    ls.remove(0);
                }
                if(sumTemp==sum){
                    if(ls.size()>1)
                    list.add(new ArrayList<>(ls));
                }
            }
        }

        return list;
    }

    @Test
    public void test() {
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(15);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer+" ");
            }
            System.out.println("");
        }
        System.out.println(arrayLists.size());
    }

    @Test
    public void test2() {
        ArrayList<Integer> ls=new ArrayList<>();
        ls.add(1);
        ls.add(2);
        System.out.println(ls.get(0));
        ls.remove(0);
        System.out.println(ls.get(0));
    }
}
