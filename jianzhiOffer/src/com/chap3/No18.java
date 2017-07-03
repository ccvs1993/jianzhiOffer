package com.chap3;

/**
 * Created by wangfei on 2017/6/29.
 * 查找子树
 */
public class No18 {
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
        if(root1!=null && root2!=null) {
            if (root1.val == root2.val) {
                result = DoesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public static boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root2==null)
            return  true;
        if(root1==null)
            return false;
        if(root1.val!=root2.val){
            return false;
        }
        return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right,root2.right);
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(8);
        TreeNode t2=new TreeNode(8);
        TreeNode t3=new TreeNode(7);
        TreeNode t4=new TreeNode(9);
        TreeNode t5=new TreeNode(2);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;

        TreeNode s1=new TreeNode(8);
        TreeNode s2=new TreeNode(9);
        TreeNode s3=new TreeNode(2);
        s1.left=s2;
        s1.right=s3;

        System.out.println(HasSubtree(t1,s1));


    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}