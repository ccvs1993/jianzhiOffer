package com.chap6;

import apple.laf.JRSUIUtils;

/**
 * 1.求二叉树的深度
 *
 * 2.输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class No39 {
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftCount=TreeDepth(root.left);
        int rightCount=TreeDepth(root.right);
        return leftCount>rightCount?(leftCount+1):(rightCount+1);
    }

    public boolean IsBalanced_Solution(TreeNode root) {
       if(root==null)
           return true;
        int leftCount=TreeDepth(root.left);
        int rightCount=TreeDepth(root.right);
        if(leftCount-rightCount>1 || rightCount-leftCount>1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
}

