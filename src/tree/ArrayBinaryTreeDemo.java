package tree;

import javax.swing.plaf.PanelUI;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/1 0001
 * @Description: tree
 * @version: 1.0
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        //arrBinaryTree.preOrder();
        //arrBinaryTree.infixOrder();
          arrBinaryTree.postOrder();
    }
}
class ArrBinaryTree {
    private int[] arr;//存储数据结点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder() {
        this.preOrder(0);
    }
    public void infixOrder() {
        this.infixOrder(0);
    }
    public void postOrder() {
        this.postOrder(0);
    }
    //编写一个方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index) {
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归遍历
        if((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        if((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
    //编写一个方法，完成顺序存储二叉树的中序遍历
    public void infixOrder(int index) {
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树中序遍历");
        }
       // System.out.println(arr[index]);
        //向左递归遍历
        if((index * 2 + 1) < arr.length) {
            infixOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if((index * 2 + 2) < arr.length) {
            infixOrder(2 * index + 2);
        }
    }
    //编写一个方法，实现顺序存储的后序遍历
    public void postOrder(int index) {
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树后序遍历");
        }
        if((index * 2 + 1) < arr.length) {
            postOrder(2 * index + 1);
        }
        if((index * 2 + 2) < arr.length) {
            postOrder(2 * index + 2);
        }
        System.out.println(arr[index]);
    }
}
