package com.chap2.source;
/**
 * 两个队列模拟一个栈：
 * 输入数据存放q1，出栈时，先将q1中除了最后一个数据的所有数据移到q2，移除去
  q1的数据，再讲q2的数据复制回q1
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wangfei on 2017/6/12.
 */
public class No7Think {
    Queue<Integer> queue1=new LinkedList<>();
    Queue<Integer> queue2=new LinkedList<>();

    public void push(Integer num){
        queue1.add(num);
    }

    public Integer pop(){
        while(queue1.size()>1){
            queue2.add(queue1.poll());
        }
        Integer temp=queue1.poll();
        while (queue2.size()>0){
            queue1.add(queue2.poll());
        }
        return  temp;
    }
}

