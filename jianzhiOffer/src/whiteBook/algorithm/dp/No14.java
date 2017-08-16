package whiteBook.algorithm.dp;

/**
 * 给定一个整数数组，每个元素都是 i 这一天的一个股票价格，i 是索引。
 * 设计一个算法来求解最大收益。你最多可以完成两次交易， 一次买入，一次卖出。
 */
public class No14 {
    //最好的
    public static int calculateMaxDpSimple(int[] prices){
        int firstBuy=Integer.MAX_VALUE;
        int afterFirstSell=0;
        int afterSecondBuy=Integer.MIN_VALUE;
        int afterSecondSell=0;

        for(int price:prices){
            firstBuy=Math.min(price,firstBuy);
            afterFirstSell=Math.max(afterFirstSell,price-firstBuy);
            afterSecondBuy=Math.max(afterFirstSell-price,afterSecondBuy);
            afterSecondSell=Math.max(afterSecondBuy+price,afterSecondSell);
        }
        return afterSecondSell;
    }
    //两遍dp
    public static int calculateMaxDp(int[] prices){
        int len=prices.length;
        int[] dp=new int[len];
        int min=prices[0];
        int max=0;
        for (int i = 1; i < len; i++) {
            if(prices[i]>prices[i-1]){
                dp[i]=Integer.max(dp[i-1],prices[i]-min);
            }else {
                dp[i]=dp[i-1];
                min=prices[i];
            }
        }
         int high=prices[len-1];
        int[] dpr = new int[len];
        int maxEarn=0;
        for (int i = len-2; i >=0 ; i--) {
            if (prices[i]<prices[i+1]){
                dpr[i]+=Math.max(high-prices[i],dpr[i+1]);
            }else {
                dpr[i]+=dpr[i+1];
                high=prices[i];
            }
            maxEarn=Integer.max(dp[i]+dpr[i],maxEarn);
        }

        return maxEarn;
    }

    //不能全部通过
    public static int calculateMax(int[] prices){
        int max=0;
        int money=0;
        for (int i = 1; i < prices.length; i++) {
            money=calculateMax(prices,0,i)+calculateMax(prices,i,prices.length-1);
            if(money>max)
                max=money;
        }
        return max;
    }
    public static int calculateMax(int[] prices,int start,int end) {
        //min:当前最低价格，max：当前最高收益
        int min=prices[start],max=0;
        for (int i = start+1; i <= end; i++) {
            if (prices[i]-min<max){
                max=prices[i]-min;
            }
            if(min>prices[i]){
                min=prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={3,8,5,1,7,8};
        //System.out.println(calculateMax(arr));
        System.out.println(calculateMaxDpSimple(arr));
    }
}
