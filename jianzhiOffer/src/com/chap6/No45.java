package com.chap6;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 圆圈中最后剩下的数字
 *
 * 0，1，2，。。。，n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字，
 * 求这个圆圈里剩下的最后一个数字
 */
public class No45 {
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public int LastRemaining_Solution(int n, int m) {
        //构造环形链表
        Node head=new Node(-1);
        Node p=head;
        head.next=new Node(0);
        p=head.next;
        for (int i = 1; i < n; i++) {
            p.next=new Node(i);
            p=p.next;
        }
        p.next=head.next;

//        for(Node temp=head.next;temp.next!=null;temp=temp.next){
//            System.out.println(temp.value);
//            if(temp.next==head.next)
//                break;
//        }
        int nums=0;
        int size=n;
        Node current=head.next;
        Node pnext=head.next;
        while(size>1){
            for(int i=0;i<m;i++){
                pnext=pnext.next;
            }
            current.next=pnext;
            current=current.next;
            nums++;
            size--;
        }
        return current.value;
    }



    public int LastRemaining_Solution2(int n, int m) {
        if(m == 0 || n == 0) {
            return -1;
        }
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            data.add(i);
        }
        int index = -1;
        while (data.size() > 1) {
            //          System.out.println(data);
            index = (index + m) % data.size();
            //          System.out.println(data.get(index));
            data.remove(index);
            index--;
        }
        return data.get(0);
}


    @Test
    public void test() {
        int i = LastRemaining_Solution2(6, 6);
        System.out.println(i);
    }
}
