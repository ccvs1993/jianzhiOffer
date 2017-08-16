package whiteBook.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

public class No4 {

    public static int fobi3(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {

            int r1 = fobi3(n - 1, map);
            int r2 = fobi3(n - 2, map);
            int res = r1 + r2;
            map.put(n, res);
            return res;
        }

    }

    public static int fobi3(int n){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        if(n<=1){
            return 1;
        }

        return fobi3(n-1,map)+fobi3(n-2,map);
    }

    public static void main(String[] args) {
        System.out.println(fobi3(2));
    }

}
