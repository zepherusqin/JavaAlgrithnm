package Leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/8 0008
 * @Description: Leetcode
 * @version: 1.0
 */
public class LeetCode104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode tnode1 = new TreeNode(9);
        TreeNode tnode2 = new TreeNode(20);
        TreeNode tnode3 = new TreeNode(15);
        TreeNode tnode4 = new TreeNode(7);
        TreeNode tnode5 = new TreeNode(12);
        root.left = tnode1;
        root.right = tnode2;
        tnode2.left = tnode3;
        tnode2.right = tnode4;
        tnode4.right = tnode5;
        int res = maxDepth(root);
        System.out.println(res);
    }
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
