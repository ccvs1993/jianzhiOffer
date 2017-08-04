package com.chap4;

/**
 * Created by wangfei on 2017/7/3.
    输入一个二叉树，输出镜像
 */

public class No19 {

    public static void MirrorSubTree(BinaryTreeNode19 root){
        if(root==null) return;
        if(root.leftNode!=null || root.rightNode!=null){
            BinaryTreeNode19 temp=root.leftNode;
            root.leftNode=root.rightNode;
            root.rightNode=temp;

            if(root.leftNode!=null)
                MirrorSubTree(root.leftNode);
            if(root.rightNode!=null)
                MirrorSubTree(root.rightNode);
        }
    }
    public static void main(String[] args) {
        BinaryTreeNode19 root=new BinaryTreeNode19(1);
        BinaryTreeNode19 right=new BinaryTreeNode19(3);
        BinaryTreeNode19 left=new BinaryTreeNode19(2);
        root.leftNode=left;
        root.rightNode=right;
        System.out.println(root.value+" "+ root.leftNode.value+" "+root.rightNode.value);
        MirrorSubTree(root);
        System.out.println(root.value+" "+ root.leftNode.value+" "+root.rightNode.value);
    }
}
class BinaryTreeNode19{
    int value;
    BinaryTreeNode19 leftNode=null;
    BinaryTreeNode19 rightNode=null;

    public BinaryTreeNode19(int value) {
        this.value = value;
    }
}