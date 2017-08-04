package jishi;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by wangfei on 2017/7/12.
 */

public class No2_1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            System.out.println(match(str));
        }
    }
    public static boolean match(String inputStr) {

        int len = inputStr.length();

        boolean nobracket=false;
        for(int i=0;i<len;i++){
            if(isLeftBracket(inputStr.charAt(i)) || isRightBracket(inputStr.charAt(i))){
                nobracket=true;
                break;
            }
        }
        if(nobracket){
            return true;
        }

        LinkedList<Character> stack = new LinkedList<Character>();
        // 循环遍历字符串
        for (int i = 0; i < len; i++) {
            // 如果是左括号则入栈
            if (isLeftBracket(inputStr.charAt(i))) {
                stack.push(inputStr.charAt(i));
                // 如果是右括号
            } else if (isRightBracket(inputStr.charAt(i))) {
                // 栈空，则右括号没有匹配的左括号，则返回false
                if (stack.isEmpty()) {
                    return false;
                    // 栈不空，则和栈顶比较
                } else if (stack.peek().equals(inputStr.charAt(i))) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        // 循环结束后，栈空表示匹配完了，不空表示多余左括号
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isLeftBracket(char ch) {
        if (ch == '(' || ch == '[' || ch == '{') {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isRightBracket(char ch) {
        if (ch == ')' || ch == ']' || ch == '}') {
            return true;
        } else {
            return false;
        }
    }
}