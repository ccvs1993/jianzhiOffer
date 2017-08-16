package com.chap6;


import org.junit.Test;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 如输入 i am a student.
 * 输出：  student. a am i
 */
public class No42 {
    public String ReverseSentence(String str) {

        if(str==null||str.trim().equals(""))return str;
        String[] temp=str.split(" ");
        int lo=0;
        int hi=temp.length-1;
        int mid=(lo+hi)/2;
        while(lo<hi){
            swap(temp,lo,hi);
            lo++;
            hi--;
        }
        StringBuilder sb=new StringBuilder(100);
        for (String s : temp) {
            sb.append(s).append(" ");
        }
        return sb.substring(0,sb.length()-1);
    }

    private void swap(String[] temp, int lo, int hi) {
        String str=temp[lo];
        temp[lo]=temp[hi];
        temp[hi]=str;
    }

    @Test
    public void test() {
        System.out.println(ReverseSentence(" "));
    }


}
