package whiteBook.algorithm.dp;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个值 N，这个 N 表示我们需要换成 N 个美分的零钱，
 * 并且 我们拥有可以无限供应的、面值为 S = { S1, S2, .. , Sm} 的硬 币。
 * 1.请实现一个函数，计算找零的方式
 * 2.求最少需要多少硬币
 */
public class No8 {
    /**
     *1.请实现一个函数，计算找零的方式(原始递归)
     * @param s 零钱种类
     * @param money: money to change
     * @param n 要使用多少种面值
     * @return 换零钱的方式
     */
    public static int coinChange(int[] s,int money,int n){
        if(money==0)//分配完了
            return 1;
        if(money<0 || n==0)//分配未成功
            return 0;
        return coinChange(s,money-s[n-1],n)+coinChange(s,money,n-1);
    }

    /**
     * 与斐波那契数列类似（原始递归+记录）,不对。。。
     * @param s
     * @param money
     * @param n
     * @return
     */
    public static int coinChangeS1(int[] s,int money,int n){
        Map<Integer,Integer> map=new HashMap<>();
        //map.put(0,1);
        //map.put(1,1);
//        if(money==0)//分配完了
//            return 1;
//        if(money<0 || n==0)//分配未成功
//            return 0;
        return coinChangeS1(s,money,n-1,map)+coinChangeS1(s,money-s[n-1],n,map);
    }
    public static int coinChangeS1(int[] s, int money, int n, Map<Integer,Integer> map){
        if(map.containsKey(money))
            if(map.get(money)>0)
                return map.get(money);
        if(money==0)//分配完了
        {
            map.put(0,1);
            return 1;
        }
        if(money<0 || n==0)//分配未成功
            return 0;

        int ret1= coinChangeS1(s,money-s[n-1],n,map);
        int ret2= coinChangeS1(s,money,n-1,map);
        int res=ret1+ret2;
        map.put(money,res);
        return res;

    }

    /**
     * 1.请实现一个函数，计算找零的方式(dp，书上给的，答案不对)
     */
//    public static int coinChange2(int[] s,int money,int n){
//        int[] dp=new int[money+1];
//        dp[0]=1;
//
//            for (int j = 0; j < n; j++) {
//                for (int i = 1; i <=money ; i++)
//                    dp[i]+=(i>=s[j])?(dp[i-s[j]]):0;
//            }
//
//        return dp[money];
//    }

    /**
     * leetcode  的答案
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange2( int[] coins,int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
    /*http://www.cnblogs.com/DarkMaster/p/3903751.html结果不对*/
    public static int coinChange3( int[] coins,int amount) {

        int [][] dp=new int[amount+1][coins.length];
        for (int i = 1; i < amount; i++) {
            for (int j = 0; j <coins.length; j++) {
                dp[i][j]=get(dp,i,j)+get(dp,i-coins[j],j);
            }
        }
        return dp[amount][coins.length-1];
    }
    public static int get(int[][] dp,int i,int j){
        if (i==0)
            return 1;
        if (j==0)
            return 0;
        if (i<0)
            return 0;
        return dp[i][j];
    }

    /**
     * 求最少需要多少硬币
     * @param s
     * @param money
     * @param n
     * @return
     */
    public static int coinChangeMinWay(int[] s,int money,int n){
        int[] minChange=new int[money+1];

        for (int i = 1; i <= money; i++) {
            minChange[i]=Integer.MAX_VALUE;
            for (int j = 0; j < s.length; j++) {
                //当前的钱数i必须>=s[j],否则用不到s[j],并且不用s[j]的组合已经算出来了
                if(s[j]<=i && minChange[i-s[j]]!=Integer.MAX_VALUE){
                    minChange[i]=Integer.min(minChange[i],minChange[i-s[j]]+1);
                }
            }
        }
        if (minChange[money]==Integer.MAX_VALUE)
            return -1;
        return minChange[money];
    }
    //我自己的方法,先从最大的零钱开始取
    public static int coinChangeMinWay2(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        int count=0;
        for (int i=coins.length-1;i>=0;i--) {

            int temp=amount%coins[i];

            if(temp==amount)
                continue;


            if(temp==0){
                return count+amount/coins[i];
            }

            count+=amount/coins[i];
            amount=amount%coins[i];
        }
        if(amount==0)
            return count;
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] s={1,2,5};
        System.out.println(coinChange(s,10,3));
        System.out.println(coinChangeS1(s,10,3));
        System.out.println(coinChange2(s,10));

        //System.out.println(coinChangeMinWay(s,6,3));
        //System.out.println(coinChangeMinWay2(s,19999));
    }
}
