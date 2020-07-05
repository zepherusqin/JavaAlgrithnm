package binarysorttree;


/**
 * @Author:QinZhubiao
 * @Date: 2020/4/7 0007
 * @Description: binarysorttree
 * @version: 1.0
 */
public class BinarySortTreeDemo {
    public static void main(String[] args){
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for(int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        System.out.println("中序遍历");
        binarySortTree.infixOrder();
        //测试插入一个节点
        //binarySortTree.add(new Node(2));
        //binarySortTree.infixOrder();

        //测试删除叶子节点
        //binarySortTree.delNode(2);
        //测试有一个子树的节点
        //binarySortTree.delNode(1);
        //测试有两个子树的结点
        binarySortTree.delNode(10);
        System.out.println("删除节点后");
        binarySortTree.infixOrder();
    }
}
class BinarySortTree {
    private Node root;
    public Node getRoot() {
        return root;
    }
    //查找要删除的结点
    public Node search(int value) {
        if(root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }
    //查找父节点
    public Node searchParent(int value) {
        if(root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }
    //编写方法
    /**
     *功能描述：
     *@param：node 传入的节点
     *@return: 返回以node为根节点的二叉排序树的最小节点的值
     *@auther:
     *@date:
    **/
//    public int delRightTreeMin(Node node) {
//        Node target = node;
//        //循环的查找左节点，就会找到最小值
//        while(target.left != null) {
//            target = target.left;
//        }
//        //删除最小节点
//        delNode(target.value);
//        return target.value;
//    }
    public int delLeftTreeMax(Node node) {
        Node target = node;
        while (target.right != null) {
            target = target.right;
        }

        delNode(target.value);
        return target.value;
    }

    //删除节点
    public void delNode(int value) {
        if(root == null) {
            return;
        } else {
            Node targetNode = search(value);
            if(targetNode == null) {
                return;
            }
            //如果当前二叉排序树只有一个节点
            if(root.left == null && root.right == null) {
                root = null;
                return;
            }
            //找到targetNode的父节点
            Node parent = searchParent(value);
            //如果删除的结点是叶子节点
            if(targetNode.left == null && targetNode.right == null) {
                //判断targeetNode是parent的左子节点还是右子节点
                if(parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if(parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if(targetNode.left != null && targetNode.right != null) {
                int maxVal = delLeftTreeMax(targetNode.right);
                targetNode.value = maxVal;
            } else { //删除只有一个子树的节点
                //要删除的节点只有左子节点
                if(targetNode.left != null) {
                    //如果targetNode是parent的左子节点
                    if(parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else {//如果targetNode是parent的右子节点
                        parent.right = targetNode.left;
                    }
                } else {
                    if(parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                }
            }
        }
    }
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

    //查找要删除的节点
    public Node search(int value) {
        if(value == this.value) {
            return this;
        } else if(value < this.value) {
            if(this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if(this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }
    //查找要删除节点的父节点
    public Node searchParent(int value) {
        //如果当前节点就是要删除节点的父节点，就返回
        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if(value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if(value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
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