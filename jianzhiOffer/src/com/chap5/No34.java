package com.chap5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 求按照从小到大顺序排列的第1500个丑数
 * 丑数：只包含银子2，3，5的数。如6，8都是丑数，但14不是，因为它包含因子7.习惯上将1作为第一个丑数。
 */
public class No34 {
    public int GetUglyNumber_Solution(int index) {
        int[] ugly=new int[index];
        ugly[0]=1;
        int nextUlgyIndex=1;

        int p2=0,p3=0,p5=0;

        while (nextUlgyIndex<index){
            int min=min(ugly[p2]*2,ugly[p3]*3,ugly[p5]*5);
            ugly[nextUlgyIndex]=min;

            while(ugly[p2]*2<=ugly[nextUlgyIndex])++p2;
            while(ugly[p3]*3<=ugly[nextUlgyIndex])++p3;
            while(ugly[p5]*5<=ugly[nextUlgyIndex])++p5;

            ++nextUlgyIndex;
        }
       return ugly[nextUlgyIndex-1];
    }
    public int min(int a,int b,int c){
        int temp=a<b?a:b;
        return temp<c?temp:c;
    }


    public static void main(String[] args) {
        System.out.println(new No34().GetUglyNumber_Solution(7));
    }
}
