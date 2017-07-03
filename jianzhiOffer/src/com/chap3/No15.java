package com.chap3;

import java.util.List;

/**
 * Created by wangfei on 2017/6/26.
 * 链表中倒数第k个节点
 * 输入一个链表，输出该链表中的第k个节点
 * 如链表从头节点开始的值是1，2，3，4，5，6，则链表的倒数第3个节点是4
 */
public class No15 {


    public static void main(String[] args) {
        ListNode15 ls=new ListNode15();
        for (int i = 0; i < 10; i++) {
            ls.add(i+1);
        }
        ls.findLastK(4);
        System.out.println(ls.hasLoop());

    }
}
class ListNode15{
    private Node head=null;

    public  void add(int value){
        Node temp=head;
        head=new Node();
        head.value=value;
        head.next=temp;
    }

    public void findLastK(int k){
        if(k==0 || head==null) return;

        Node phead=head;
        for (int i=0;i<k-1;i++){
            if(phead.next!=null){
                phead=phead.next;
            }else return;
        }
        Node p2=head;
        while (phead.next!=null){
            p2=p2.next;
            phead=phead.next;
        }
        System.out.println(p2.value);

    }
    //判断是否有环
    public boolean hasLoop(){
        Node slow=head;
        Node fast=head;
        if(fast==null || fast.next==null)return false;
        do {
            slow=slow.next;
            fast=fast.next.next;
        }while (slow!=fast && fast!=null &&fast.next!=null);

        if(slow==fast)
            return true;
        else
            return false;
    }

    public void show(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
    }

    class Node{
        int value;
        Node next;
    }
}
