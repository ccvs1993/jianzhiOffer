package com.chap5;

/**
 * 数组中的逆序对，如果前面一个数字大于后面一个数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求逆序对的总数。
 * 如{7，5，6，4}一个有5个逆序对：
 * (7,5)  (7,6) (7,4) (5,4) (6,4)
 */
public class No36 {
    public static int count=0;
    public int InversePairs(int [] array) {
        return 0;
    }

    public void merge(int[] array){
        if(array==null || array.length<=0) return;
        merge(array,0,array.length-1);
    }

    private void merge(int[] array, int l, int h) {
        if(l>=h)return;
        int mid=(h-l)/2+l;
        merge(array,l,mid);
        merge(array,mid+1,h);
        _merge(array,l,mid,h);

    }

    private void _merge(int[] array, int l, int mid, int h) {
        int[] temp=new int[h-l+1];
        for (int i = l; i <=h; i++) {
            temp[i-l]=array[i];
        }

        int j=l,k=mid+1;
        for (int i = l; i <=h; i++) {
            if(j>mid){
                array[i]=temp[k-l];k++;
            }else if(k>h){
                array[i]=temp[j-l];j++;

            } else if(temp[j-l]<temp[k-l]){
                array[i]=temp[j-l];j++;

            }else{
                array[i]=temp[k-l];k++;
                count+=mid-j+1;//第j个比k大 由于j已经从小到大排过序了 那么j到mid的也会比k大
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={7,5,6,4,3};
        new No36().merge(arr);

        System.out.println(No36.count);
    }
}
