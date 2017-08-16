package wangyi;

import org.junit.Test;

import java.util.Scanner;

public class Exec2 {
    public static int reverse(int num){
        int result=0;
        while(true)
        {
            int n=num%10;//取出最低位上的数字
//也可以直接打印出来System.out.println(n);但不好，也可以用一个数组存起来，也不好，都因为翻转后的前后的那个0的问题
            result=result*10+n;//依次的反转存储得到反转的数字
            num=num/10;//降位
            if(num==0)
            {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(reverse(reverse(m)+reverse(n)));
    }
}
