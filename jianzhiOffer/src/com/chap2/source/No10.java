package com.chap2.source;

/**
 * Created by wangfei on 2017/6/18.
 * 求一个十进制数的二进制表示中1的个数
 */
public class No10 {
    public static void main(String[] args) {
        //countOne(15);
        countOne_3(0x80000000);
    }
    //传统解法：当num=0x80000000时，负数移位最高位补1，num>>1每次最高位补1，最后形成0xffffffff,死循环
    public static void  countOne(int num){
        int temp=0;
        int count=0;
        while(num!=0){
            temp=num&1;
            if(temp==1)
                ++count;
            num=num>>1;
        }
        System.out.println(count);
    }
    //改进解法，让1每次左移1位
    public static void  countOne_2(int num){
        int aux=1;
        int count=0;
        while(aux!=0){
            if((num&aux)==aux)
                ++count;
            aux=aux<<1;
        }
        System.out.println(count);
    }

    /**
     * num=(num-1)&num,直到num变为0，统计操作次数
     * 如num=0x1100  第一次num=0x1000,第二次0x0000，共有2个1
     */

    public  static  void  countOne_3(int num){
        int count=0;
        while (num!=0){
            num=(num-1)&num;
            ++count;
        }
        System.out.println(count);
    }
}
