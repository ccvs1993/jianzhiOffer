package com.chap2.source;

/**
 * Created by wangfei on 2017/6/15.
 * 斐波那契数列
 * f(n)=     0      n=0;
 *           1      n=1
 *           f(n-1)+f(n-2) n>1
 *
 * 注：🐸跳台阶可以看成斐波那契数列问题
 *      描述：青蛙一次可以跳1或2阶，对于n阶的台阶共有多少种跳法？
 *      分析：如果第一次跳1，剩下f（n-1）中跳法，如果第一次跳2，剩下f（n-2）中跳法，所以一共有f(n-1)+f(n-2)种
 */
public class No9 {
    public static void main(String[] args) {
        System.out.println(fab2(5));
    }
    //传统递归
    public static int fab(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        return fab(n-1)+fab(n-2);
    }

    //优化后的解法o(n):把递归改为循环
    public static long fab2(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        long a_n_minus_1=1;
        long a_n_minus_2=0;
        long a_n=0;
        for(int i=2;i<=n;i++){
            a_n=a_n_minus_1+a_n_minus_2;
            a_n_minus_2=a_n_minus_1;
            a_n_minus_1=a_n;
        }
        return a_n;
    }
}
