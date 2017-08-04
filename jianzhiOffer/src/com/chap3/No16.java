package com.chap3;

/**
 * Created by wangfei on 2017/6/27.
 *
 * 反转链表
 * http://blog.csdn.net/guyuealian/article/details/51119499
 */
public class No16 {
    //遍历反转法
    public  static  Node reverseListDemo(Node head){
        Node reversedNode=null;
        Node currentNode=head;
        Node prevNode=null;

        while(currentNode!=null){
            Node nextNode=currentNode.next;

            if(nextNode==null){
                reversedNode=currentNode;
            }

            currentNode.next=prevNode;
            prevNode=currentNode;
            currentNode=nextNode;
        }

        return reversedNode;
    }

    //递归法
    public static Node reverseList2(Node head){
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if(head==null || head.next==null)
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        Node reHead=reverseList2(head.getNext());// 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }

    public static void show(Node node){
        Node temp=node;
        while (temp!=null){
            System.out.print(temp.getValue()+" ");
            temp=temp.next;
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        Node head=new Node(0);
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        head.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);

        show(head);
        Node reverseHead = reverseListDemo(head);
        show(reverseHead);
    }
}
class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}