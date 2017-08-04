package whiteBook.algorithm.dp;

/**
 * Created by wangfei on 2017/6/24.
 * https://www.youtube.com/watch?v=q6OWnp9cteA&list=PLAs_zh6bLBdE_7pvuevd9OV9TUA1UlUzr&index=3
 * 一个m*n的矩阵，求从左上角到右下角的和最小
 * 如
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */
public class No1 {
    public static int minDistance(int arr[][]){
        int m=arr.length;
        int n=arr[0].length;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0){
                    if(j==0){
                        dp[i][j]=arr[i][j];
                    }else{
                        dp[i][j]=dp[i][j-1]+arr[i][j];
                    }
                }else if (j==0){
                    dp[i][j]=dp[i-1][j]+arr[i][j];
                }else {
                    dp[i][j]=Integer.min(dp[i-1][j],dp[i][j-1])+arr[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6}};
        int s = minDistance(arr);
        System.out.println(s);
    }
}
