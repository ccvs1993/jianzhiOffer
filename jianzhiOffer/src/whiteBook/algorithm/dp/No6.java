package whiteBook.algorithm.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 计算第n个素数
 *
 * tip：素数不能被第1个~第sqrt(n)的素数整除
 * int p=sqrt(n)
 *
 * Prime(n)  (第n个素数)   = G[ Prime(p-1),Prime(p-2),...Prime(1)  ]    ，G表示不能被G里面的元素整除
 * Prime(1) =2;
 */
public class No6 {

    public static int prime(int n){
        if(n==1)
            return 2;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,2);
        int i=3;
        int index=1;
        while(map.size()<n){
            int temp=(int)(Math.sqrt(i));
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if(temp%entry.getValue()==0){
                    i++;
                    break;
                }

            }
            map.put(index++,i++);

        }
        return map.get(map.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(prime(1000));
    }

}
