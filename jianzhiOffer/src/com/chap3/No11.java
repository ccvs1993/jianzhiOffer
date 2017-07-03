package com.chap3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangfei on 2017/6/19.
 * 实现一个函数求一个数的N次方，🙅考虑大数问题
 */
public class No11 {
    //不高效的写法
    public static double power(double base,int exponent){
        if(Double.compare(base,0d)==0 && exponent<0){
            throw  new RuntimeException("指数小于0时，底数不能为0");
        }
        if(exponent==0)
            return 1d;

        double result=1d;
        int absoluteExp=exponent>0?exponent:(0-exponent);
        for(int i=0;i<absoluteExp;i++){
            result*=base;
        }
        if (exponent>0)
            return result;
        else
            return 1/result;
    }

    /*高效的写法*
        a^n=    a^(n/2) * a^(n/2) ; n为偶数
                a^[(n-1)/2] * a^[(n-1)/2] * a;  n为奇数
    */
    public static double power2(double base,int exponent){
        if(Double.compare(base,0d)==0 && exponent<0){
            throw  new RuntimeException("指数小于0时，底数不能为0");
        }
        if(exponent==0)
            return 1d;
        int absoluteExp=exponent>0?exponent:(0-exponent);
        double result=power_sub(base,absoluteExp);
        if (exponent>0)
            return result;
        else
            return 1/result;
    }

    public static double power_sub(double base,int exponent){
        if(exponent==0) return 1d;
        if(exponent==1) return base;
        double result=power_sub(base,exponent>>1);
        result=result*result;
        //当exp为奇数时
        if(exponent%2==1)
            result*=base;
        return result;
    }


    public static void main(String[] args) {
        //System.out.println(power(0.0d,0));
        System.out.println(power2(2d,-1));
    }


}
