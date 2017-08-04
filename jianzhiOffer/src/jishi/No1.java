package jishi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wangfei on 2017/7/12.
 */
public class No1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String[] input = sc.nextLine().split("");
            Stack<String> stack=new Stack<>();
            for(String s:input){
                if(!Character.isDigit(s.getBytes()[0])){
                    stack.push(s);
                }
            }
            while (stack.size()>0){

            }

        }

        sc.close();
    }
}
