package orderstack;

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/9 0009
 * @Description: orderstack
 * @version: 1.0
 */
public class preOrderTest {
    public static void main(String[] args) {
        preNode[] node = new preNode[10];
        for(int i = 0; i < 10; i++) {
            node[i] = new preNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10)
                node[i].left = node[i * 2 + 1];
            if (i * 2 + 2 < 10)
                node[i].right = node[i * 2 + 2];
        }
        System.out.println("递归遍历~~");
        preOrder(node[0]);
        System.out.println("非递归遍历~~");
        preOrder1(node[0]);
    }
    //递归遍历
    public static void preOrder(preNode biTree) {
        System.out.println(biTree.value);
        preNode leftTree = biTree.left;
        if (leftTree != null) {
            preOrder(leftTree);
        }
        preNode rightTree = biTree.right;
        if (rightTree != null) {
            preOrder(rightTree);
        }
    }
    public static void preOrder1(preNode biTree)
    {//非递归实现
        Stack<preNode> stack = new Stack<preNode>();
        while(biTree != null || !stack.isEmpty())
        {
            while(biTree != null)
            {
                System.out.println(biTree.value);
                stack.push(biTree);
                biTree = biTree.left;
            }
            if(!stack.isEmpty())
            {
                biTree = stack.pop();
                biTree = biTree.right;
            }
        }
    }
}
class preNode
{
    int value;
    preNode left;
    preNode right;
    preNode(int value) {
        this.value = value;
    }
}