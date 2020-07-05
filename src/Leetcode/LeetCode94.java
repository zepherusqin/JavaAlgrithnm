package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/2 0002
 * @Description: Leetcode
 * @version: 1.0
 */
public class LeetCode94 {
    public static void main(String[] args) {
        TreeNode94 root = new TreeNode94(1);
        TreeNode94 node1 = new TreeNode94(2);
        TreeNode94 node2 = new TreeNode94(3);
        root.right = node1;
        node1.left = node2;
        //inorderTraversal(root);
        //System.out.println("===="+ inorderTraversal(root));
    }
    public List<Integer> inorderTraversal(TreeNode94 root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, root);
        return res;
    }
    void dfs(List<Integer> res, TreeNode94 root) {
        if(root == null){
            return;
        }
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }
}
class TreeNode94 {
    int val;
    TreeNode94 left;
    TreeNode94 right;
    TreeNode94(int x) {val = x;}
}
