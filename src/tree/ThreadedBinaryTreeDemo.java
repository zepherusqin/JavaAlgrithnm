package tree;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/2 0002
 * @Description: tree
 * @version: 1.0
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args){
        //测试中序线索二叉树
        HeroNode1 root = new HeroNode1(1, "tom");
        HeroNode1 node2 = new HeroNode1(3, "jack");
        HeroNode1 node3 = new HeroNode1(6, "kate");
        HeroNode1 node4 = new HeroNode1(8, "smith");
        HeroNode1 node5 = new HeroNode1(10, "zephyrus");
        HeroNode1 node6 = new HeroNode1(14, "bob");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();
        HeroNode1 leftNode = node5.getLeft();
        HeroNode1 rightNode = node5.getRight();
        System.out.println("10节点的前驱节点是：" + leftNode);
        System.out.println("10节点的后继节点是：" + rightNode);

        System.out.println("使用线索化的方式遍历二叉树");
        threadedBinaryTree.threadedList();
    }
}
//定义二叉树
class ThreadedBinaryTree {
    private HeroNode1 root;
    //为了实现线索化，需要创建指向当前节点的前驱节点的指针
    private HeroNode1 pre = null;
    public void setRoot(HeroNode1 root) {
        this.root = root;
    }
    //重载
    public void threadedNodes() {
        this.threadedNodes(root);
    }
    //遍历线索化二叉树的方法
    public void threadedList() {
        HeroNode1 node = root;
        while(node != null) {
            while(node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while(node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            //替换遍历的结点
            node = node.getRight();
        }
    }
    //编写对二叉树进行中序线索化的方法
    public void threadedNodes(HeroNode1 node) {
        if(node == null) {
            return;
        }
        //先线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前节点
        //处理当前节点的前驱节点
        if(node.getLeft() == null) {
            //让当前节点的左指针指向前驱
            node.setLeft(pre);
            //修改当前节点的左指针的类型，指向前驱节点
            node.setLeftType(1);
        }
        //处理后继节点
        if(pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //让当前节点是下一个节点的前驱节点
        pre = node;
        //线索化右子树
        threadedNodes(node.getRight());
    }

}
//创建结点
class HeroNode1 {
    private int no;
    private String name;
    private HeroNode1 left;
    private HeroNode1 right;
    //1.如果leftType等于0，表示指向左子树，等于1，表示指向前驱
    //2.如果rightType等于0，表示指向右子树，等于1，表示指向后继
    private int leftType;
    private int rightType;
    public HeroNode1(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode1 getLeft() {
        return left;
    }

    public void setLeft(HeroNode1 left) {
        this.left = left;
    }

    public HeroNode1 getRight() {
        return right;
    }
    public void setRight(HeroNode1 right) {
        this.right = right;
    }
    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}