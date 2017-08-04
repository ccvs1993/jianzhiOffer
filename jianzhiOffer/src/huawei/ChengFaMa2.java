package huawei;

import java.util.*;

/**
 * Created by wangfei on 2017/7/12.
 * 题目描述
 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn； 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量，问能称出多少中不同的重量。

 注：
 称重重量包括0

 方法原型： public   static   int  fama( int  n,  int [] weight,  int [] nums)

 输入描述:
 输入包含多组测试数据。

 对于每组测试数据：

 第一行：n --- 砝码数(范围[1,10])

 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])

 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
 输出描述:
 利用给定的砝码可以称出的不同的重量数
 */
public class ChengFaMa2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){

            int cata=sc.nextInt();
            //保存砝码种类
            int[] weight=new int[cata];
            for (int i = 0; i < cata; i++) {
                weight[i]=sc.nextInt();
            }


            //保存各个种类的砝码的个数
            int[] num=new int[cata];
            for (int i = 0; i < cata; i++) {
                num[i]=sc.nextInt();
            }
            //保存第一个砝码的组合
            Set<Integer> set=new HashSet<>();
            for (int i = 0; i <= num[0]; i++) {
                set.add(i*weight[0]);
            }

            for (int i = 1; i < cata; i++) {
                List<Integer> ls=new ArrayList<>(set);
                for (int j = 0; j <= num[i]; j++) {
                    for (int k = 0; k < ls.size(); k++) {
                        set.add(ls.get(k)+j*weight[i]);
                    }
                }
            }

            System.out.println(set.size());
        }
    }
}
