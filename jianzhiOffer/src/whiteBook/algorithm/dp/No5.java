package whiteBook.algorithm.dp;

import java.util.Scanner;

/**http://blog.csdn.net/baidu_28312631/article/details/47418773
 * 在上面的数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。
 * 路径上的每一步都只能往左下或 右下走。只需要求出这个最大和即可，不必给出具体路径。
 * 三角形的行数大于1小于等于100，数字为 0 - 99
 输入格式：
 5      //表示三角形的行数    接下来输入三角形
 7
 3   8
 8   1   0
 2   7   4   4
 4   5   2   6   5
 要求输出最大和

 tips
 maxSum[i][j]  (第i,j所在的数到最后一行的最远距离)=
    D[i][j]  r=N-1;
    max(maxSum[i+1][j],maxSum[i+1][j+1])+D[i][j] i<N-1
 */
public class No5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] temp=new int[n][n];
        int[][] aux=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                temp[i][j]=sc.nextInt();
                aux[i][j]=0;
            }
        }

        int dis=findPath3(temp,aux);
        System.out.println(dis);
    }

    /**
     *
     * @param temp
     * @param i
     * @param j
     * @param n 行数
     * @return temp[i][j]到最后一行的距离
     */
    private static int findPath(int[][] temp,int i,int j,int n) {
        if(i==n-1){
            return temp[i][j];
        }else {
            int temp1=findPath(temp,i+1,j,n);
            int temp2=findPath(temp,i+1,j+1,n);
            return Integer.max(temp1,temp2)+temp[i][j];
        }
    }

    /**
     * 改进1 对计算过程进行记忆
     * @param temp
     * @param i
     * @param j
     * @param n
     * @param aux辅助数组，记录当前路径到最后一行的最远距离
     * @return
     */
    private static int findPath2(int[][] temp,int i,int j,int n,int[][] aux) {
        if(i==n-1){
            return temp[i][j];
        }else if(aux[i][j]!=-1){
            return aux[i][j];
        }
        else{
            int temp1=findPath(temp,i+1,j,n);
            int temp2=findPath(temp,i+1,j+1,n);
            aux[i][j]= Integer.max(temp1,temp2)+temp[i][j];
            return aux[i][j];
        }
    }
    //递推型动态规划
    private static int findPath3(int[][] temp,int[][] aux){
        int row=temp.length;
        for (int i = row-1; i >=0 ; i--) {
            for (int j = 0; j <= i ; j++) {
                if(i==row-1){
                    aux[i][j]=temp[i][j];
                }else {
                    aux[i][j]=Integer.max(aux[i+1][j],aux[i+1][j+1])+temp[i][j];
                }

            }
        }
        return aux[0][0];
    }
}
