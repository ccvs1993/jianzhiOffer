package whiteBook.algorithm.dp;

/**
 * 给定 n 个非负的整数的一个数组。每个值表示一个柱形的高度。 假设你向柱形上倾注水，那么左柱之间和右柱之间储水量的最大值是 多少？
 */
public class No3 {
    static int trap(int A[], int n) {
        if (n <= 0)
            return 0;
        int[] dp=new int[n];//dp[i]代表节点左侧的最高海拔
        for (int i = 0; i < n; i++) {
            dp[i]=0;
        }
        int left_max = 0, right_max = 0, water = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = left_max;
            if (A[i] > left_max)
                left_max = A[i];
        }


        for (int i = n - 1; i >= 0; i--) {
            //对当前节点来说，只有左右侧的节点都比自己高的时候才能蓄水
            if (Integer.min(right_max, dp[i]) > A[i])
                /*当前节点的储水量，等于左侧最高海拔(dp[i])与右侧最高海拔(right_max)的较小值减去当前节点的海拔*/
                water += Integer.min(right_max, dp[i]) - A[i];
            //获得当前节点右侧最高的节点
            if (A[i] > right_max)
                right_max = A[i];
        }
        return water;
    }

    public static void main(String[] args) {
        int a[]={1,2,1,3};
        int trap1 = trap(a, 4);
        System.out.println(trap1);
    }
}
