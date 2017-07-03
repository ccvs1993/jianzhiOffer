package com.chap3;

import org.junit.Test;

/**
 * Created by wangfei on 2017/6/21.
 */
public class No13 {
    public static void main(String[] args) {

    }
}


class ListNode {
    private int size;
    private Node head=null;

    public ListNode() {
        this.size = 0;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void addNode(int value){
        Node old=head;
        head=new Node();
        head.value=value;
        head.next=old;
        size++;
    }

    public void showList(){
        Node temp=head;
        while(temp.next!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    class Node{
        int value;
        Node next=null;
    }
}
