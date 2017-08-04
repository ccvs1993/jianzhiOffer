package whiteBook.algorithm.chap2.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangfei on 2017/6/24.
 * 获取一个数组中最长的连续的元素序列
 * eg [1,3,5,2]
 * result:[1,2,3]
 */
public class No5 {

    public static int longestSub(int[] arr){
        //key:数组arr中的元素，value：当前key中元素所在的连续序列的长度
       Map<Integer,Integer> map=new HashMap<>();
       int result=0;

       for(int num:arr){
           if(!map.containsKey(num)){
               int left=map.containsKey(num-1)?map.get(num-1):0;
               int right=map.containsKey(num+1)?map.get(num+1):0;
               int len=left+right+1;

               map.put(num,len);

               result=Math.max(result,len);

               map.put(num-left,len);
               map.put(num+right,len);
           }else
               continue;
       }
       return result;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,5,7,9,4};
        System.out.println(longestSub(arr));
    }
}
