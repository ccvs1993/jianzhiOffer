package wangyi;

import java.util.Scanner;

public class Exec3 {
    public static long minuYue(long N) {
        long sum = 0;
        long temp;
        for (long i = 1; i <= N; ++i) {
            temp = i;
            while (0 == temp % 2)
                temp /= 2;
            sum += temp;
        }
        return sum;
    }

    public static long sum(long n) {
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return  sum(n / 2) + n * n / 4;
        }
        else {
            return sum(n - 1) + n;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long m=sc.nextLong();
        System.out.println(minuYue(m));
    }
}
