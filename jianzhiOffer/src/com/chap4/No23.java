package com.chap4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**从上向下打印二叉树
 * 如        8
 *        6     10
 *     5    7  9    11
 *   打印：8 6 10 5 7 9 11
 * Created by wangfei on 2017/7/26.
 *
 */
public class No23{
    
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(8);
        TreeNode node2=new TreeNode(6);
        TreeNode node3=new TreeNode(10);
        TreeNode node4=new TreeNode(5);
        TreeNode node5=new TreeNode(7);
        TreeNode node6=new TreeNode(9);
        TreeNode node7=new TreeNode(11);
        
        node1.left=node2;node1.right=node3;
        node2.left=node4;node2.right=node5;
        node3.left=node6;node3.right=node7;

        List<Integer> ls=PrintFromTopToBottom(null);
        for (Integer l : ls) {
            System.out.println(l);
        }
        
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        List<TreeNode> temp=new LinkedList<>();
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null) return result;
        while(true){
            result.add(root.value);
            if(root.left!=null){
                temp.add(root.left);
            }
            if(root.right!=null){
                temp.add(root.right);
            }
            if(temp.size()<=0)
                break;
            root=temp.remove(0);
        }
        return result;
    }
}
