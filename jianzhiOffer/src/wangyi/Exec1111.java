package wangyi;

import java.util.Scanner;

public class Exec1111 {
    public static void main(String[] args) {
        boolean flag=false;
        Scanner sc=new Scanner(System.in);
        //每天的房钱,x>=1
        int x=sc.nextInt();
        //现有多少水果
        int f=sc.nextInt();
        //总钱数
        int d=sc.nextInt();
        //每个水果的价格
        int p=sc.nextInt();
        int count=0;
        //先吃自己的水果，只交房租
        for (int i = 0; i < f; i++) {
            if(d<x){
                flag=true;
                break;
            }
            d-=x;
            count++;

        }
        if(flag){
            System.out.println(count);;

        }        //买水果，交房租
        else{
            int count2=d/(p+x);
            System.out.println(count+count2);
        }

    }
}
