package whiteBook.algorithm.chap2.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangfei on 2017/6/21.
 * Given two strings, determine if they are permutations of each other.
 给定两个字符串，判断它们是否是彼此可置换的(是否具有相同的字母)

 @Tag一旦需要统计一个元素集中元素出现的次数，就应该想到hash表
 */
public class No2 {
    //O(N+M)
    public static boolean permutation(String str1,String str2){
        if(str1.length()!=str2.length())
            return false;
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            map1.put(str1.charAt(i),map1.get(str1.charAt(i))==null?1:(map1.get(str1.charAt(i))+1));
            map2.put(str2.charAt(i),map2.get(str2.charAt(i))==null?1:(map2.get(str2.charAt(i))+1));
        }
        for (Character s : map1.keySet()) {
            if(map1.get(s)!=map2.get(s)){
                return false;
            }
        }
        return true;
    }

    //O(nlogn)
    public static boolean permutation2(String str1,String str2){
        char[] chars1=str1.toCharArray();
        char[] chars2=str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    @org.junit.Test
    public void test() {
        System.out.println(permutation("wang","wgan"));
       // System.out.println(permutation2("wang","wgan23"));
    }
}
