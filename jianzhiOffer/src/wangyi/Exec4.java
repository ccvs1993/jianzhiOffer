package wangyi;

import java.util.Scanner;

/**
 * 买苹果
 */
public class Exec4 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a = n / 6;
        int b = n / 8;
        boolean flag=true;
        for (int i = b;i >= 0;i--)
        {
            for (int j = 0;j <= a;j++)
            {
                if (6 * j + 8 * i == n)
                {
                    System.out.println(i+j);
                    flag=false;
                }
                if(!flag){
                    break;
                }
            }
        }
        if(flag){
            System.out.println(-1);
        }
    }
}
