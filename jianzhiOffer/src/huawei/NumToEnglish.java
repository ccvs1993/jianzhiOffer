package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangfei on 2017/7/12.
 * 题目描述
 Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 如22：twenty two，123：one hundred and twenty three。

 说明：
 数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
 输出格式为twenty two；
 非法数据请返回“error”；
 关键字提示：and，billion，million，thousand，hundred。

 方法原型：public static String parse(long num)



 输入描述:
 输入一个long型整数
 输出描述:
 输出相应的英文写法

 例1
 输入

 2356
 输出

 two thousand three hundred and fifty six
 */
public class NumToEnglish {
    public static String parse(long num){
        String[] english={"billion","million","thounsand","hundred"};
        int weishu=1;
        long shang=num;
        List<Long> ls=new ArrayList<>();
        while((num/10)!=0){
            weishu++;
            ls.add(num%10);
            num=num/10;
        }



        return null;
    }
    public static void main(String[] args) {
        parse(1234l);
    }
}
