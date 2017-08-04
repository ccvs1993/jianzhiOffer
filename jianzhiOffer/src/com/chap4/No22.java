package com.chap4;

import java.util.Stack;

/**
 * Created by wangfei on 2017/7/6.
 * 栈的压入、弹出
 * 将一个序列压入栈（压栈的过程中可以弹出），判断另一组序列是否可以为该序列的弹出序列
 * 如压入 1 2 3 4 5，
 *  4 5 3 2 1可以为他的弹出序列
 *
 * 规律：如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。
 * 如果下一个弹出的数字不在栈顶，把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。
 * 如果所有的数字都压入栈了还没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列
 */
public class No22 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stk=new Stack<>();
        if(pushA.length!=popA.length || (pushA==null && popA==null))
            return false;
        int i=0;
        int j=0;
        while(true){
            int temp=popA[i];
            while(stk.empty() || stk.peek()!=temp){
                if(j==pushA.length)
                    return false;
                stk.push(pushA[j++]);

            }
            stk.pop();
            i++;
            if(i==popA.length)
                return true;
        }
    }

    public static void main(String[] args) {
        int[] pushA={1,2,3,4,5};
        int[] popA ={4,5,3,2,1};
        int[] popB ={4,3,5,1,2};
        System.out.println(new No22().IsPopOrder(pushA,popA));
    }
}
