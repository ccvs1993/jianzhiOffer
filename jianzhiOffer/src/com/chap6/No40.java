package com.chap6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数组中只出现1次的数字
 * 一个整形数组中除了2个数字之外，其他的数字都出现了2次，只出现1次的2个数字
 * 时间复杂度：o(n),空间复杂度：o(1)
 */
public class No40 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int res=0;
        for (int i = 0; i < array.length; i++) {
            res^=array[i];
        }
        int fistOne = findFistOne(res);
        for (int i = 0; i < array.length; i++) {
            if(isBitOne(array[i],fistOne)){
                num1[0]^=array[i];
            }else {
                num2[0]^=array[i];
            }
        }
    }
    public int findFistOne(int num){
        int index=0;

        while(((num&1)==0) &&(index<Integer.SIZE)){
            num=num>>1;
            index++;
        }
        return index;
    }

    public boolean isBitOne(int num,int index){
        return ((num>>index)&1)==1;
    }
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    //自己写的，测试未成功
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {

        int temp=0;
        boolean flag=true;
        List<Integer> list =new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        Collections.sort(list);

        for (int i = 0; i < list.size();) {
            if(i==list.size()-1) {
                num2[0]=list.get(i);
                return;
            }
            if(list.get(i)==list.get(i+1)){
                i+=2;
            }else{
                if(flag){
                num1[0]=list.get(i);
                    flag=false;
                    i+=1;
                    continue;
                }
                if(i+2==list.size()){
                    num2[0]=list.get(i+1);
                    return;
                }
                num2[0]=list.get(i);
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array={2,4,3,6,3,2,5,5};
        int[] a=new int[1];
        int[] b=new int[1];
        new No40().FindNumsAppearOnce(array,a,b);
        System.out.println(a[0]+" "+b[0]);
    }
}
