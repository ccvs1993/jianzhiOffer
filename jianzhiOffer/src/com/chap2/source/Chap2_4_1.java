package com.chap2.source;

/**
 * Created by wangfei on 2017/6/13.
 * 求数组中第k大的数
 * 利用快速排序的思想，从数组S中随机找出一个元素X，把数组分为两部分Sa和Sb。Sa中的元素大于等于X，Sb中元素小于X。这时有两种情况：

     1. Sa中元素的个数小于k，则Sb中的第k-|Sa|个元素即为第k大数；
     2. Sa中元素的个数大于等于k，则返回Sa中的第k大数。
     利用快排的partion思想 T(n) = 2T(n/2) + O(1)   时间复杂度为O(n)
     该方法只有当我们可以修改输入的数组时可用，位于数组左边的k个数字就是最小的k个数字（但这k个数字不一定是排序的），位于第k个数右边的数字都比第k个数字大
 */
public class Chap2_4_1 {
    public static void main(String[] args) {
        Integer arr[]={5,3,2,1};
//        QuickSort.quick(arr);
//        for (Integer integer : arr) {
//            System.out.println(integer);
//        }
        QuickSort.findK(arr, 0, arr.length - 1, 4);

    }
}

class QuickSort{
    public static void quick(Integer[] arr){
        quick(arr,0,arr.length-1);
    }

    private static void quick(Integer[] arr, int lo, int hi) {
        if(lo>=hi)return;
        int j=partition(arr,lo,hi);
        quick(arr,lo,j-1);
        quick(arr,j+1,hi);
    }


    public static void findK(Integer[] arr,int lo,int hi ,int k){
        int temp;
        temp=partition(arr,lo,hi);
        if(temp==k-1){
            System.out.println("第"+(temp+1)+"大的数是"+arr[temp]);
        }else if(temp>k-1){
            findK(arr,lo,temp-1,k);
        }else{
            findK(arr,temp+1,hi,k);
        }
    }

    private static int partition(Integer[] arr, int lo, int hi) {
        int i=lo;
        int j=hi+1;
        Integer v=arr[lo];
        while(true){
            while(v>arr[++i]) if(i==hi)break;
            while(v<arr[--j]) if(j==lo)break;
            if(i>=j) break;
            swap(arr,i,j);
            }
            swap(arr,lo,j);
        return j;
    }
    public static void swap(Integer[] arr,int i,int j){
        Integer temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
