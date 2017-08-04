package com.chap5;

/**
 * 连续数组的最大和
 * 如[1,-2,3,10,-4,7,2,-5]
 * 最大的子数组为[3,10,-4,7,2] 和为18
 */
public class No31 {

    public static int FindGreatestSumOfSubArray(int[] array) {
        int max=Integer.MIN_VALUE;
        int sum=Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if(sum<=0){
                sum=array[i];
            }else{
                sum+=array[i];
            }
            if(sum>max){
                max=sum;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] array={1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
