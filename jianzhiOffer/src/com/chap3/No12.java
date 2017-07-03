package com.chap3;

import java.util.Arrays;

/**
 * Created by wangfei on 2017/6/20.
 * 给定数字n
 * 打印1到最大的n位数
 */
public class No12 {
    public static void printN(int n){
        if(n<=0)return;
        String[] sb=new String[n];
        printSub(n,sb,0);

    }

    public static void printSub(int n,String[] sb,int index){
        --n;
        for(int i=0;i<10;i++){
            sb[index]=i+"";
            if(n==0){
                printNum(sb);
            }else{
                printSub(n,sb,index+1);
            }
        }
    }

    public static  void printNum(String[] str){
        boolean isBeagin0=true;

        for(String s:str){
            if(!s.equals("0") && isBeagin0){
                isBeagin0=false;
            }
            if(!isBeagin0){
                System.out.print(s);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printN(3);
    }
}
