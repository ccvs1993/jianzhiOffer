package com.chap2.test;

import com.chap2.source.No7;
import com.chap2.source.No7Think;

/**
 * Created by wangfei on 2017/6/12.
 */
public class Test {
    @org.junit.Test
    public void testNo7() {
        No7 no7=new No7();
        for (int i = 0; i < 10; i++) {
            no7.appendTail(i);
        }
        for (int i = 0; i < 5; i++) {

            System.out.println(no7.deleteHead());
        }
    }

    @org.junit.Test
    public void testNo7Think() {
        No7Think no7Think=new No7Think();
        for (int i = 0; i < 10; i++) {
            no7Think.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(no7Think.pop());
        }
    }
}
