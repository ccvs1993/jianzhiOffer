package jishi;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * Created by wangfei on 2017/7/12.
 */
public class No5 {

    public static int max(int a,int b){
        int tmp;
        tmp = a < b ? b : a;
        return tmp;
    }
    //m行 n列
    public static int findMaxValue(int[][]p, int n, int m) {
        int i, j;
        // 先求第一行的累加值
        for (i = 0; i < n - 1; i++)
            p[0][i + 1] += p[0][i];
        // 再求第一列的累加值
        for (i = 0; i < m - 1; i++)
            p[i + 1][0] += p[i][0];
        // 每次选取左边或者上边两个数中最大值与当前值累加
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                p[i][j] += max(p[i - 1][j], p[i][j - 1]);
            }
        }
        // 右下角的值为最大值
        return p[m - 1][n - 1];
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            sc.nextLine();
            int M=sc.nextInt();
            int N=sc.nextInt();

            int[][] a=new int[M][N];

            System.out.println();

            for(int i=0;i<M;i++){
                for(int j=0;i<N;j++){
                    a[i][j]=sc.nextInt();
                }

            }

            for(int i=0;i<M;i++){
                for(int j=0;i<N;j++){
                    System.out.println(a[i][j]);
                }
            }

//            int tmp= findMaxValue(a, N, M);
//            System.out.println(tmp);

        }
    }
}
