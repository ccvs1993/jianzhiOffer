package whiteBook.algorithm.chap2.hashmap;

import org.junit.Test;

import java.util.*;

/**
 * Created by wangfei on 2017/6/21.
 *
 * Find a pair of two elements in an array, whose sum is a given target number.
 * Assume only one qualified pair of numbers existed in the array,
 * return the index of these numbers (e.g. returns (i, j), smaller index in the front).
 从一个数组中找出一对元素，其和是一个给定的目标数字。假设数组中只存在一个符合要求的数值对，返回这些数值的下标（例如， 返回(i, j)，较小的下标在前面）。

 @TAG当处理当前节点需要依赖于之前的部分结果时，可以考虑使用哈希表记录之前的处理结果。其本质类似于动态规划(Dynamic
 @TAGProgramming），利用哈希表以O(1)的时间复杂度利用之前的结果
 */
public class No4 {
    public static List<Integer> addsToTarget(List<Integer> nums,Integer target){
        //key为nums的值,value为nums的index
        Map<Integer,Integer> map=new HashMap<>();
        //保存输出的结果
        List<Integer> result=new ArrayList<>();

        int index=0;
        for(Integer num:nums){
            if(map.containsKey(target-num)){
                result.add(map.get(target-num));
                result.add(index);
                return result;
            }
            map.put(num,index);
            ++index;
        }
        return null;
    }

    @Test
    public void test() {
        Integer[] nums={1,2,3,4,5,6,7,8};
        List<Integer> test=new ArrayList(Arrays.asList(nums));
        List<Integer> indexs = addsToTarget(test, 15);
        System.out.println(indexs);
    }
}
