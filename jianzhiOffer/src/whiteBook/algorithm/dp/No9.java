package whiteBook.algorithm.dp;

/**
 * 在一个整数数组中，找到最长的递增的子序列。例如，对于数组 {1, 3, 2, 4}，返回 3。
 *
 * 递推式：
 * maxLength[i]=max{ maxLength[k] (k=0,1...i-1)  && array[i]>array[k]  }+1
 */
public class No9 {
    public static int longestIncreasingSubsequence(int[] arr){
        //用于记录当前各元素作为最大元素的最长递增序列长度
        int[] dpMaxLength=new int[arr.length];
        //int global_max=0;
        for (int i = 0; i < arr.length; i++) {
            dpMaxLength[i]=1;
            for (int k = 0; k <i ; k++) {
                if(arr[i]>arr[k] && dpMaxLength[k]+1>dpMaxLength[i])
                    dpMaxLength[i]=dpMaxLength[k]+1;
            }
        }

        return dpMaxLength[arr.length-1];

    }
    //输出序列(错的)
    public static int longestIncreasingSubsequence2(int[] arr){
        int max=1;
        //用于记录当前各元素作为最大元素的最长递增序列长度
        int[] dpMaxLength=new int[arr.length];
        //前驱元素数组，记录当前以该元素作为最大元素的递增序列中该元素的前驱节点，用于打印序列用
        int[] pre=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pre[i]=Integer.MIN_VALUE;
        }
        //int global_max=0;
        int i=0,k=0;
        for (i = 0; i < arr.length; i++) {
            //找到以array[i]为最末元素的最长递增子序列
            dpMaxLength[i]=1;
            for (k = 0; k <i ; k++) {
                if(arr[i]>arr[k] && dpMaxLength[k]+1>dpMaxLength[i]){

                    dpMaxLength[i]=dpMaxLength[k]+1;
                    pre[i]=arr[k];
                }
                //得到当前最长递增子序列的长度，以及该子序列的最末元素的位置
                if(max<dpMaxLength[i]){
                    max=dpMaxLength[i];
                }
            }
        }
        //输出序列
        for (int m = 0; m < pre.length; m++) {
            if(pre[m]!=Integer.MIN_VALUE){
                System.out.print(pre[m]+" ");
            }
        }
        System.out.println(arr[k]);
        return max;

    }
    public static void main(String[] args) {
        int[] arr={1,3,2,3,9};
        System.out.println(longestIncreasingSubsequence(arr));
        System.out.println("最长："+longestIncreasingSubsequence2(arr));
    }
}
