package com.chap5;

import java.util.*;

/**
 * 把数组拍成最小的数
 * 如：[3,32,321]
 * 最小：321323
 */
public class No33 {
    public String PrintMinNumber(int [] numbers) {
        List<String> ls=new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            ls.add(String.valueOf(numbers[i]));
        }
        //函数式
        Collections.sort(ls,(str1,str2)->{
            String s1=str1+str2;
            String s2=str2+str1;
            return s1.compareTo(s2);
        });
        //普通写法
        Collections.sort(ls, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1=str1+str2;
                String s2=str2+str1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb=new StringBuilder(100);
        for (String l : ls) {
            sb.append(l);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr={3,32,321};
        System.out.println(new No33().PrintMinNumber(arr));
    }
}
