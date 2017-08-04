package whiteBook.algorithm.chap2.hashmap;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangfei on 2017/6/21.
 * Given a newspaper and message as two strings, check if the message can be composed using letters in the newspaper.

 给定两个字符串 newspaper 和 message ， 检查是否能够使用 newspaper 中的字母来组成 message。

 @Tag一旦需要统计一个元素集中元素出现的次数，就应该想到hash表
 */
public class No3 {
    public static boolean composed(String newspaper,String message){
        Map<Character,Integer> map=new HashMap<>();

        if(newspaper.length()<message.length())return false;

        for (int i=0;i<newspaper.length();i++){
            map.put(newspaper.charAt(i),map.get(newspaper.charAt(i))==null?1:(map.get(newspaper.charAt(i))+1));
        }
        for(int i=0;i<message.length();i++){
            if(map.get(message.charAt(i))!=null && map.get(message.charAt(i))>0){
                map.put(message.charAt(i),map.get(message.charAt(i))-1);
            }else
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(composed("qqwertyuiop","qqqwer"));
    }
}
