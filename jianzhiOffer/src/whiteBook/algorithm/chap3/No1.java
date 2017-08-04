package whiteBook.algorithm.chap3;

import javax.swing.tree.AbstractLayoutCache;

/**
 * Created by wangfei on 2017/7/3.
 * 哑节点

 链表操作时利用哑节点（Dummy Node）是一个非常好用的技巧：
 只要涉及操作 head 节点，不妨创建 dummy node:
 ListNode dummy = new ListNode(0);
 dummy->next = head;
 这使得操作 head 节点 与操作其他节点无异。
 ===================================================================================================
 给定一个链表和一个值 x，编写一个函数，对该链表重新排序， 以便所有小于 x 的节点都出现在大于或等于 x 的节点的前面。
 */
public class No1 {
    public static Node1 reorderList(Node1 head,int x){
        Node1 newHead=null;
        Node1 aDummy=new Node1(0);
        Node1 aCurr=aDummy;
        Node1 bDummy=new Node1(0);
        Node1 bCurr=bDummy;

        while (head!=null){
            Node1 next=head.next;
            head.next=null;
            if(head.value<x){
                aCurr.next=head;
                aCurr=head;
            }else {
                bCurr.next=head;
                bCurr=head;
            }
            head=next;
        }
        aCurr.next=bDummy.next;
        newHead=aDummy.next;
        return newHead;
    }

    public static void main(String[] args) {
        Node1 head=new Node1(5);
        Node1 node1=new Node1(4);
        Node1 node2=new Node1(2);
        Node1 node3=new Node1(1);
        head.next=node1;node1.next=node2;node2.next=node3;
        reorderList(head,3);
        show(head);

    }

    public static void show(Node1 head){
        Node1 temp=head;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
}

class Node1{
    int value;
    Node1 next;

    public Node1(int value) {
        this.value = value;
    }
}
