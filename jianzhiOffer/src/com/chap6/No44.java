package com.chap6;



import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 从扑克中随机抽取5张，判断是不是顺子。
 * A=1,2~10,J=11,Q=12,K=13,大小王可以看成任意数字
 */
public class No44 {
    public boolean isContinuous(int [] numbers) {
        ArrayList<Integer> ls=new ArrayList<>();
        int zeroNum=0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]>0){
                ls.add(numbers[i]);
            }else if(numbers[i]==0)
                zeroNum++;
        }
        Collections.sort(ls);
        for (int i = 0; i < ls.size()-1; i++) {
            if(ls.get(i).equals(ls.get(i+1)))
                return false;
        }
        int tail=ls.size()-1;
        /**
         * 1,3,5,0,0    1,3,4,6,0   (5-ls.size()==zeroNum && zeroNum>0 &&  ls.get(tail)-ls.get(0)<5)
         * 1,2,3,4,0     ls.get(tail)-ls.get(0)+1==ls.size()
         */
        if((5-ls.size()==zeroNum && zeroNum>0 &&ls.get(tail)-ls.get(0)<5) || ls.get(tail)-ls.get(0)+1==ls.size())
            return true;
        else return false;
    }

    @Test
    public void test() {
        System.out.println(isContinuous(new int[]{0,3,1,6,4}));
    }
}
