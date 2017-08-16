package whiteBook.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，我们可以将 s 切割使得切割后的每一段都是 一个回文。
 * 例如，‘abba’是回文，‘a’也是回文，但‘ab’不是回 文。
 * 请编写一个函数，针对给定的字符串，返一个回文分割所需的最 小的分隔次数。
 */
public class No7 {
    public static int CountPalindromeCut(String str){
        if(str==null) return 0;
        int length=str.length();

        int[][] palins=new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                palins[i][j]=0;
            }
        }
        //记录从i到字符串末尾的分割数
        int[] minCut=new int[length+1];
        for (int i = 0; i <=length ; i++) {
            minCut[i]=length-i-1;
        }

        for (int i = length-1; i >=0 ; --i) {
            for (int j = i; j < length; j++) {
                //判断是否回文
                if((str.charAt(i)==str.charAt(j)) && (palins[i+1][j-1]==1 || j-i<=1)){
                    palins[i][j]=1;
                    //求最小分割数
                    minCut[i]=Integer.min(minCut[j+1]+1,minCut[i]);
                }
            }
        }
        return minCut[0];
    }

    public static void main(String[] args) {

        System.out.println(CountPalindromeCut("abacdc"));
    }
}
