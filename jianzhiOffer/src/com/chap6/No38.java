package com.chap6;

/**
 * 统计一个数字在排序数组中出现的次数，如输入{1，2，3，3，3，3，4，5}和数字3，由于3出现了4次，因此输出4
 */
public class No38 {

    public int GetNumberOfK(int [] array , int k) {
        if (array==null || array.length<=0) return 0;
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==k){
                count++;
            }
            if(array[i]>k)
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,3,3,3,4,5};
        System.out.println(new No38().GetNumberOfK(array,3));
    }

}
