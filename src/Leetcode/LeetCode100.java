package Leetcode;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/1 0001
 * @Description: Leetcode
 * @version: 1.0
 */
public class LeetCode100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(0);
        TreeNode q = new TreeNode(0);
        TreeNode pnode1 = new TreeNode(1);
        TreeNode pnode2 = new TreeNode(2);
        TreeNode pnode3 = new TreeNode(3);
        TreeNode pnode4 = new TreeNode(4);
        //TreeNode pnode5 = new TreeNode(5);
        //TreeNode pnode6 = new TreeNode(6);
        TreeNode qnode1 = new TreeNode(1);
        TreeNode qnode2 = new TreeNode(2);
        TreeNode qnode3 = new TreeNode(3);
        TreeNode qnode4 = new TreeNode(4);
        //TreeNode qnode5 = new TreeNode(5);
        //TreeNode qnode6 = new TreeNode(6);
        p.left = pnode1;
        p.right = pnode2;
        pnode1.left = pnode3;
        pnode1.right = pnode4;
        q.left = qnode1;
        q.right = qnode2;
        qnode1.left = qnode3;
        qnode2.left = qnode4;
        System.out.println("=====" + isSameTree(p,q));

    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val = x;}
}