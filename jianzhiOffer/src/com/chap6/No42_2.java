package com.chap6;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 字符串左旋操作
 * 如输入  abcdefg 和 2，输出：cdefgab
 */
public class No42_2 {

    public String LeftRotateString(String str,int n) {
        if(str==null||str.trim().equals(""))return str;
        int len=str.length();
        n=n%len;
        str+=str;
        return str.substring(n,n+len);
    }
    public String LeftRotateString2(String str,int n) {
        if(str==null||str.trim().equals(""))return str;
        LinkedList<Character> ls=new LinkedList<>();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            ls.add(ch);
        }
        for (int i = 0; i < n; i++) {
            Character first = ls.getFirst();
            ls.addLast(first);
            ls.remove(0);
        }
        StringBuilder sb=new StringBuilder(100);
        for(Character c:ls){
            sb.append(c);
        }
        return sb.toString();
    }



    @Test
    public void test() {

        System.out.println(LeftRotateString("abcdefg", 2));
    }
}
