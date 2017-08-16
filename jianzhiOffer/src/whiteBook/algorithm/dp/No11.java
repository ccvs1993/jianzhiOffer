package whiteBook.algorithm.dp;

/**
 * 在一个数组中找出一个连续的子数组，它至少包含 1 个数字，并 且所有数字的和最大
 * tips:
 * sum[i]为到i的连续子数组的最大值
 * sum[i]=max{sum[i-1]+arr[i],arr[i]}
 */
public class No11 {
    public static int maxSubArray(int[] arr){
        int dp=arr[0];
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
                dp=Integer.max(dp+arr[i],arr[i]);
                if(max<dp)
                    max=dp;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr={1,-2,3,10,-4,7,2,-5};
        System.out.println(maxSubArray(arr));
    }

}
