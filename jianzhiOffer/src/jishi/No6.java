package jishi;

import java.util.*;

/**
 * Created by wangfei on 2017/7/12.
 */
public class No6 {

    static class Pair{

        int priority;
        int index;

        public Pair(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static void solution(List nums)
    {
        List<Pair> SortNums=new ArrayList<>();


        for (int i = 0; i < nums.size(); ++i)
        {
            SortNums.add(new Pair((Integer) nums.get(i), i));
        }
        Collections.sort(SortNums, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.priority - o1.priority;
            }
        });

        for (int i = 0; i < SortNums.size() - 1; i++)
        {
            System.out.print(SortNums.get(i).index+", ");
        }
        System.out.print(SortNums.get(SortNums.size() - 1).index);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(",");
            List<Integer> ls=new ArrayList<>();
            for(String s:str){
                ls.add(Integer.valueOf(s.trim()));
            }
            solution(ls);
            System.out.println();
        }

    }

}
