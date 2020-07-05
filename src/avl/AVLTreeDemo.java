package avl;
/**
 * @Author:QinZhubiao
 * @Date: 2020/4/8 0008
 * @Description: avl
 * @version: 1.0
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4, 3, 6, 5, 7, 8};
        //int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for(int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        //System.out.println("在没有平衡处理之前");
        System.out.println("树的高度=" + avlTree.getRoot().height());
        System.out.println("树的左子树高度="+ avlTree.getRoot().leftHeight());
        System.out.println("树的右子树高度="+ avlTree.getRoot().rightHeight());
        System.out.println("当前的根节点=" + avlTree.getRoot());
        System.out.println("根节点的左子节点=" + avlTree.getRoot().right.left);
    }
}
class AVLTree {
    private Node root;
    public Node getRoot() {
        return root;
    }

    //编写方法
    public void add(Node node) {
        if(root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }
    public void infixOrder() {
        if(root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空");
        }
    }
}

//创建节点
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    //返回左子树的高度
    public int leftHeight() {
        if(left == null) {
            return 0;
        }
        return left.height();
    }
    //返回右子树的高度
    public int rightHeight() {
        if(right == null) {
            return 0;
        }
        return right.height();
    }
    //返回以该节点为根的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }
    //左旋转方法
    private void leftRotate() {
       //创建新的结点，为当前根节点的值
       Node newNode = new Node(value);
       //把新节点的左子树设置为当前节点的左子树
        newNode.left = left;
        //把新节点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成右子节点的值
        value = right.value;
        //把当前节点的右子树设置成当前节点右子树的右子树
        right = right.right;
        //把当前节点的左子树（左子节点）设置成新的节点
        left = newNode;
    }
    //右旋转方法
    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点的方法
    //递归
    public void add(Node node) {
        if(node == null) {
            return;
        }
        if(node.value < this.value) {
            if(this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }

        }else {
            if(this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        //当添加一个结点，右子树的高度-左子树的高度>1
        if(rightHeight() - leftHeight() > 1) {
            //如果它的右子树的左子树的高度大于右子树高度，先对右子节点右旋转，再对当前节点左旋转
            if(right != null && rightHeight() > leftHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }
        //当添加一个结点，左子树的高度-右子树的高度>1
        if(leftHeight() - rightHeight() > 1) {
            if(left != null && leftHeight() > rightHeight()) {
                //先对当前节点的左节点左旋转
                left.leftRotate();
                rightRotate();
            } else {
                //直接右旋转
                rightRotate();
            }
            //rightRotate();
        }
    }

    public void infixOrder() {
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.infixOrder();
        }
    }
}
