package com.chap3;

/**
 * Created by wangfei on 2017/6/29.
 * 合并两个递增排序的链表，是的合并后的新链表的节点仍然是按照递增排序的
 * 如 链表1： 1 3 5 7
 *    链表2： 2 4 6 8
 *    合并后：1 2 3 4 5 6 7 8
 */
public class No17 {
    //合并链表
    public static Node17 mergeNode(Node17 node1,Node17 node2){
        if(node1==null)return node2;
        if(node2==null) return node1;
        Node17 head=null;
        if(node1.value<node2.value){
            head=node1;
            head.next=mergeNode(node1.next,node2);
        }else {
            head=node2;
            head.next=mergeNode(node1,node2.next);
        }
        return head;
    }
    public static void show(Node17 node){
        Node17 temp=node;
        while (temp!=null){
            System.out.print(temp.getValue()+" ");
            temp=temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node17 head1=new Node17(1);
        Node17 node1=new Node17(3);
        Node17 node2=new Node17(5);
       // Node17 node3=new Node17(7);
        head1.next=node1;
        node1.next=node2;
       // node2.next=node3;

        Node17 head2=new Node17(2);
        Node17 node11=new Node17(4);
        Node17 node12=new Node17(6);
        Node17 node13=new Node17(8);
        head2.next=node11;
        node11.next=node12;
        node12.next=node13;

        show(head1);
        show(head2);
        Node17 node = mergeNode(head1, head2);
        show(node);
    }
}
class Node17{
    int value;
    Node17 next;

    public Node17(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node17 getNext() {
        return next;
    }

    public void setNext(Node17 next) {
        this.next = next;
    }
}