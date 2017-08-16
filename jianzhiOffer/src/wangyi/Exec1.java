package wangyi;

import java.util.Scanner;

public class Exec1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int m=sc.nextInt();
            int n=sc.nextInt();
            int[][] num=new int[m][n];
            for (int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    num[i][j]=sc.nextInt();
                }
            }

            for (int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    System.out.print(num[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
