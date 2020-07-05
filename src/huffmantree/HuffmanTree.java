package huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/3 0003
 * @Description: huffmantree
 * @version: 1.0
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }
    public static void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        } else {
            System.out.println("该树是空树");
        }
    }
    //创建赫夫曼树的方法
    public static Node createHuffmanTree(int[] arr) {
        //第一步：为了操作方便
        //1.遍历arr数组
        //2.将arr的每个元素构成一个Node
        //3.将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<Node>();
        for(int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {
            //(1)排序
            Collections.sort(nodes);
            System.out.println("nodes=" + nodes);
            //(2)取出根节点权值最小的两颗二叉树
            //取出权值最小的结点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //(3)构建新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //(4)从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent加入到nodes
            nodes.add(parent);

            // System.out.println("第一次处理后" + nodes);
        }
        //返回赫夫曼树的root
        return nodes.get(0);
    }
}
//为了让Node对象持续排序Collections集合排序
//让Node实现Comparables接口 可以看到它可以使继承他的类进行比较大小，只需要调用实现类的compareTo方法即可
class Node implements Comparable<Node>{
    int value;//结点权值
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }
    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    @Override
    public int compareTo(Node o) {
        //表示从小到大
        return this.value - o.value;
    }
}