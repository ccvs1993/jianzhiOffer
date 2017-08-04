package com.chap4;

import java.util.*;

/**
 * 字符串的全排列
 * 如：a b c
 * 全排列：abc acb bac bca cab cba
 *
 *思路：首先求所有可能出现在第一个位置的字符，即把第一个字符和后面的所有字符交换
 * 第二部固定第一个字符，求后面的所有字符的排列
 */

public class No28 {

    public  ArrayList<String> Permutation(String str) {
        ArrayList<String> list=new ArrayList<>();

        if(str==null || str.length()==0)
            return list;

        Set<String> set=new HashSet<>();
        permutationHelper(set,str.toCharArray(),0);
        list.addAll(set);
        Collections.sort(list);
        return list;
    }

    /**
     *
     * @param set 存储排列结果
     * @param str
     * @param k 当前做排列操作的第一个字符
     */
    private  void permutationHelper(Set<String> set, char[] str, int k) {

        if(k==str.length){
            set.add(new String(str));
            return;
        }

        for (int i = k; i < str.length; i++) {
            swap(str,i,k);
            permutationHelper(set,str,k+1);
            swap(str,i,k);//复位
        }

    }
    private  void swap(char[] ch,int i,int j){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }

    /**
     *
     * 方法2
     */
    //字符逆序
    private void reverse(char[] ch,int start){
        int begin=start;
        int end=ch.length-1;
        while(start<end){
            swap(ch,start,end);
        }
    }
    private void reverse(char[] ch,int start,int tail){
        int begin=start;
        int end=tail;
        while(start<end){
            swap(ch,start,end);
        }
    }

    public  ArrayList<String> Permutation2(String str){
        ArrayList<String> list=new ArrayList<>();

        if(str==null || str.length()==0)
            return list;

        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        list.add(new String(ch));

        int len=ch.length;
        while(true){
            int p=len-1,q;
            //从p的位置向前找一个小于ch[p]的数
            while (p>=1 && ch[p-1]>=ch[p]) --p;
            if(p==0) break;

            //从p向后找一个比ch[p]大的数
            q=p;--p;
            while(q<len && ch[q]>ch[p])q++;
            --q;
            //交换这两个位置上的值
            swap(ch,p,q);
            //将p之后的序列倒序排列
            reverse(ch,p+1);

            list.add(new String(ch));

        }
        return list;
    }

    public boolean Next_permutation(char a[])
    {

        int p , q ,pFind;
        int pEnd = a.length-1;
        if(a[0] == a[pEnd])
            return false;
        p = pEnd;
        while(a[p] != a[0])
        {
            q = p;
            p--;
            if(a[p] < a[q])  //找降序的相邻2数,前一个数即替换数
            {
                //从后向前找比替换点大的第一个数
                pFind = pEnd;
                while(a[pFind] < a[p])
                --pFind;
                swap(a,p,pFind);

                //替换点后的数全部反转
                reverse(a,q, pEnd);
                return true;
            }
        }
        reverse(a,0 , pEnd);   //如果没有下一个排列,全部反转后返回false
        return false;
    }
    public static void main(String[] args) {
        String str="abc";
//        ArrayList<String> list = new No28().Permutation2(str);
//        list.forEach((n)-> System.out.println(n));
        char[] ch = str.toCharArray();
        int num=1;
        do
        {
            System.out.println("第"+(num++)+"个："+new String(ch));

        }while(new No28().Next_permutation(ch));
    }
}
