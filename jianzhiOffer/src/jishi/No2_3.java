package jishi;

import java.util.Scanner;
import java.util.Stack;

import static jishi.No2_1.match;

/**
 * Created by wangfei on 2017/7/12.
 */


public class No2_3 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            System.out.println(check(str)==1?true:false);
        }




    }

    public static int check(String str){
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c){
                case '(':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.pop()!= '(')
                    {
                        return 0;
                    }
                    break;
                case ']':
                    if (stack.pop() != '[')
                    {
                        return 0;
                    }
                    break;
                case '}':
                    if (stack.pop() != '{')
                    {
                        return 0;
                    }
                    break;
            }


        }

        int re = 0;
        if(stack.isEmpty()){
            re=1;
        }else {
            re=0;
        }
        if (re == 1)
        {
            return 1;
        }
        else
        {
            return 0;
        }

}

}