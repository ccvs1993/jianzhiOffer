package com.algorithm.chap02;

import com.chap2.source.No7;
import org.junit.Test;

/**
 * Created by wangfei on 2017/6/21.
 */
public class ListNode {
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

    public int deleteFirst(){
        if (size<0)
        {
            System.out.println("链表为空，删除失败");
            return Integer.MIN_VALUE;
        }

        else{
            size--;
            int v=head.value;
            head=head.next;
            return  v;
        }
    }

    public int delete(int index){
        Node temp=head;
        if(index>size-1){
            System.out.println("索引越界，删除失败");
            return Integer.MIN_VALUE;
        }
        if(index==1)
            return deleteFirst();
        else {
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            int v=temp.next.value;
            temp.next=temp.next.next;
            size--;
            return v;
        }
    }
    //在index之后插入node
    public void insert(int index,int value){
        if(index<0 || index>size-1){
            System.out.println("索引越界");
            return;
        }
        if (index==1){
            addNode(value);
        }
        Node temp=head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        Node nextTemp=temp.next;

        Node toInsert=new Node();
        toInsert.value=value;

        temp.next=toInsert;
        toInsert.next=nextTemp;

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

    @Test
    public void test() {
        ListNode ls=new ListNode();
        for (int i = 0; i < 10; i++) {
            ls.addNode(i);
        }
        ls.delete(9);
        ls.insert(2,100000);
        ls.showList();
    }
}
