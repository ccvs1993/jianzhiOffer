package whiteBook.algorithm.dp;

/**
 * 假设你要遍历一个环形路径。在这条路径上，有 N 个加油站供你 使用，而加油站 i 的汽油量为 gas[i]。
 * 假设你的汽车的油箱的大小 是无限的。
 * 要从加油站 i 到其邻近的下一个加油站，将会用掉 cost[i] 的汽油。
 * 一开始你的汽车的油箱是空的，但是，你可以从任何一个加 油站开始遍历。
 * 如果能够遍历环形路径一次的话，返回所需的开始加 油站的最小索引，否则的话，返回-1。
 */
public class No12 {
    public static int canCompleteCircut(int[] gas,int[] cost){
        int count=gas.length;
        int[] array=new int[count];
        int sum=0,subSum=0,index=0;
        for (int i = 0; i < count; i++) {
            //对于第 i 个加油站，它能够给车子提供的净动力为 array[i] = gas[i] – cost[i]。
            array[i]=gas[i]-cost[i];
            sum+=array[i];
        }

        if(sum<0)
            return -1;

        for (int i = 0; i < count; i++) {
            subSum+=array[i];
            /**
             * 从记录的开始节点（index）起，到当前节点的过程中，
             * 一旦出现 subSum 小于 0，那么从开始节点到当前节点的所有节点都不能作为开始节点
             * 那么，开始点至少是 index+1.
             */
            if(subSum<0){
                subSum=0;
                index=i+1;
            }
        }
        return index;
    }
}
