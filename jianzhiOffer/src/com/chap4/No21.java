package com.chap4;

import java.util.Stack;

/**
 * Created by wangfei on 2017/7/6.
 * 包含min函数的栈
 * 定义栈的数据结构，在该类型中实现一个能够得到栈的最小元素的min函数，在栈中，
 * 调用min,push,pop的时间复杂度都是O(1)
 *
 * 思路：使用2个栈，一个保存压入的数据，另一个保存每次压入时当前的最小值。
 */
public class No21 {

    Stack<Integer> stack=new Stack<>();
    Stack<Integer> auxStack=new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(auxStack.size()==0 ||auxStack.peek()>node){
            auxStack.push(node);
        }else{
            auxStack.push(auxStack.peek());
        }


    }

    public void pop() {
        stack.pop();
        auxStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return auxStack.peek();
    }

    public static void main(String[] args) {
        No21 stk=new No21();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(1);

        stk.pop();
        System.out.println(stk.top());
        System.out.println(stk.min()); //1

    }
}

