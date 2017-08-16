package whiteBook.algorithm.dp;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 请编写一个函数来计算给定的两个字符串的最长公共子序列，即 LCS。
 * 输入序列“ABCDGH”和“AEDFHR”的话，
 * LCS 是“ADH”，长度 为 3；
 * 输入是“AGGTAB”和“GXTXAYB”的话，LCS 是“GTAB”，长度 为 4。
 *
 *
 * tips:
 * //考虑以当前两个节点为末节点的 序列的公共子序列长度
 * //length(i,j)表示str[0,i-1]和str2[0,j-1]的LCS长度
 * length(i,j)=(length(i-1,j-1)+1)，                      str[i-1]==str[j-1](第i个==第j个)
 *             max{length(i,j-1),length(i-1,j)}           str[i-1]！=str[j-1]
 */
public class No13 {
    public static int lcs( String str1, String str2) {
        int[][] dpLen=new int[str1.length()+1][str2.length()+1];
        /**
         *
         注意i和j从1开始，表示第几个字符
         */
        for (int i = 1;i<=str1.length() ; i++) {
            for (int j = 1; j <=str2.length(); j++) {
                if(i==0 || j==0)
                    dpLen[i][j]=0;
                //i-1就是数组中第i个
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dpLen[i][j]=dpLen[i-1][j-1]+1;
                }else {
                    dpLen[i][j]=Integer.max(dpLen[i][j-1],dpLen[i-1][j]);
                }
            }

        }
        return dpLen[str1.length()][str2.length()];
    }


    public static void main(String[] args) {
        String s1="AGGTABDE";
        String s2="GXTXAYBED";
        System.out.println(lcs(s1,s2));

    }
}
