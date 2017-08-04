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
public class ChengFaMa {
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
            int sumCount=0;
            for (int i = 0; i < cata; i++) {
                num[i]=sc.nextInt();
                sumCount+=num[i];
            }

            //存储重量的数组
            int[] array=new int[sumCount];
            int index=0;
            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num[i]; j++) {
                    array[index++]=weight[i];
                }
            }




           //List<List<Integer>> allList=new ArrayList<>();
            Set<Integer> set=new HashSet<>();
            int auxNum=1<<array.length;

            int tempNum=auxNum;
            for(int i=0;i<auxNum;i++){
                List<Integer> ls1=new ArrayList<>();
                for(int j=0;j<array.length;j++){
                    if((tempNum&1)==1){
                        ls1.add(array[j]);
                    }
                    tempNum=tempNum>>1;
                }
                //allList.add(ls1);
                int sum=0;
                for(Integer p:ls1){
                    sum+=p;
                }
                set.add(sum);
                tempNum=auxNum-i-1;
            }

//            Set<Integer> set=new HashSet<>();
//            for (List<Integer> lists : allList) {
//                int sum=0;
//                for (Integer i : lists) {
//                    sum+=i;
//                }
//                set.add(sum);
//            }
            System.out.println((set.size()));

        }
    }
}
