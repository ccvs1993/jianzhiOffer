package com.chap5;

/**
 * 输入两个链表，找出它们的第一个公共结点
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class No37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null) return null;
        int longLen = getListLength(pHead1);
        int shortLen=getListLength(pHead2);
        int diff=longLen-shortLen;
        ListNode plong=pHead1;
        ListNode pshort=pHead2;
        if (diff<0){
            plong=pHead2;
            pshort=pHead1;
        }
        for (int i = 0; i < diff; i++) {
            plong=plong.next;
        }

        while(plong!=null && pshort!=null && plong!=pshort){
            plong=plong.next;
            pshort=pshort.next;
        }

        return  plong;
    }
    public int getListLength(ListNode pHead1){
        int i=0;
        for(ListNode ptemp1=pHead1;ptemp1!=null;ptemp1=ptemp1.next)i++;
        return i;
    }
}
