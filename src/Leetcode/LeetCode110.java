package Leetcode;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/9 0009
 * @Description: Leetcode
 * @version: 1.0
 */
public class LeetCode110 {
    public static void main(String[] args) {
        TreeNode110 root = new TreeNode110(3);
        TreeNode110 tnode1 = new TreeNode110(9);
        TreeNode110 tnode2 = new TreeNode110(20);
        TreeNode110 tnode3 = new TreeNode110(15);
        TreeNode110 tnode4 = new TreeNode110(7);
        TreeNode110 tnode5 = new TreeNode110(11);
        root.left = tnode1;
        root.right = tnode2;
        tnode2.left = tnode3;
        tnode2.right = tnode4;
        tnode4.right = tnode5;
        System.out.println("是否是平衡二叉树:" + isBalanced(root));
    }
    public static boolean isBalanced(TreeNode110 root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
    private static int height(TreeNode110 root) {
        if (root == null) {
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    static class TreeNode110
    {
        int val;
        TreeNode110 left;
        TreeNode110 right;
        TreeNode110(int x) {val = x;}
    }
}
