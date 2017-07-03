package com.chap2.source;
//两个栈建立队列

import java.util.Stack;

/**
 * Created by wangfei on 2017/6/12.
 */
public class No7 {
    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();

    public void appendTail(Integer num){
        stack1.push(num);
    }

    public Integer deleteHead(){
        if(stack2.size()<=0){
            while(stack1.size()>0){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.size()<=0){
            return null;
        }

        return stack2.pop();
    }
}

