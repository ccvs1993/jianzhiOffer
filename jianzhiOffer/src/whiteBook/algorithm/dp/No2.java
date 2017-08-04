package whiteBook.algorithm.dp;

/**
 * Created by wangfei on 2017/6/24.
 * https://www.youtube.com/watch?v=q6OWnp9cteA&list=PLAs_zh6bLBdE_7pvuevd9OV9TUA1UlUzr&index=3
 * 求一个数组中，和最大的子数组之和
 * 如{1，2，3，4，-5，1，2}
 * 为{1，2，3，4}
 */
public class No2 {
    public static int maxSub(int arr[]){
        int n=arr.length;
        int[] dp=new int[n];
        dp[0]=arr[0];
        int result=dp[0];
        for (int i = 1; i < n; i++) {
            dp[i]=Integer.max(dp[i-1]+arr[i],arr[i]);
            result=Integer.max(dp[i],result);
        }
        return result;
    }
    //空间复杂度o(1)
    public static int maxSub2(int arr[]){
        int n=arr.length;
        int endHere=arr[0];
        int result=endHere;
        for (int i = 1; i < n; i++) {
            endHere=Integer.max(endHere+arr[i],arr[i]);
            result=Integer.max(endHere,result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,-5,1,2};
        System.out.println(maxSub2(arr));
    }
}
