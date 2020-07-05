package linklist;

import java.util.Stack;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/13 0013
 * @Description: linklist单链表的增删改查
 * @version: 1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建结点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkList singleLinkList = new SingleLinkList();
        //按顺序添加英雄
        //singleLinkList.add(hero1);
        //singleLinkList.add(hero2);
        //singleLinkList.add(hero3);
        //singleLinkList.add(hero4);
        //按标号顺序添加英雄
        singleLinkList.addByOrder(hero1);
        singleLinkList.addByOrder(hero4);
        singleLinkList.addByOrder(hero2);
        singleLinkList.addByOrder(hero3);
        //singleLinkList.addByOrder(hero3);

        //修改之前显示
        singleLinkList.list();

        //测试修改节点信息
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkList.update(newHeroNode);
        System.out.println("修改之后显示的:");
        singleLinkList.list();
/**
        //删除结点
        singleLinkList.del(1);
        System.out.println("删除之后显示的:");
        singleLinkList.list();
**/
        //求单链表有效结点的个数
        System.out.println("有效的结点个数="+getLength(singleLinkList.getHead()));

        //测试一下看看是否得到倒数第k个节点
        HeroNode res = findLastIndexNode(singleLinkList.getHead(), 4);
        System.out.println("res=" + res);

        //侧测试单链表的反转
        System.out.println("反转单链表：");
        reverseList(singleLinkList.getHead());
        singleLinkList.list();

        //逆序打印链表节点
        System.out.println("测试逆序打印单链表~~~");
        reversePrint(singleLinkList.getHead());
    }

    //逆序打印单链表
    public static void reversePrint(HeroNode head) {
        if(head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while(cur != null) {//入栈
            stack.push(cur);
            cur = cur.next;
        }
        while(stack.size() > 0) {//出栈
            System.out.println(stack.pop());
        }
    }

    //将单链表进行翻转
    public static void reverseList(HeroNode head) {
        if(head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助指针，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点cur的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个结点，就将其放在新的链表reverseHead的最前面
        while(cur != null) {
            next = cur.next;//先保存当前节点的下一个节点，不让断链
            cur.next = reverseHead.next;//将cur的下一个节点新的链表的最前端
            reverseHead.next = cur;
            cur = next;//让cur指向原链表的下一个节点
        }
        //将head.next指向reversehead.next
        head.next = reverseHead.next;
    }
    //查找链表的倒数第K个结点
    //1.编写一个方法，接收head节点，同时接收一个index
    //2.Index表示倒数第index个结点
    //3.把链表从头到尾遍历，得到链表的总长度getLength
    //4.得到size后，从表的第一个开始遍历(size-index)个
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //链表为空，返回null
        if(head.next == null) {
            return null;
        }
        //第一次遍历得到长度
        int size = getLength(head);
        //第二次遍历size-index位置，就是倒数的第k个结点
        //先做一个index校验
        if(index <= 0 || index > size) {
            return  null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size-index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //方法：获取到单链表的结点的个数(如果是带头节点的链表，不统计头节点)
    /**
     *功能描述：
     *@param：head 链表的头节点
     *@return: 返回的是有效结点的个数
     *@auther:
     *@date:
    **/
    public static  int getLength(HeroNode head) {
        if(head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助变量
        HeroNode cur = head.next;//没有统计头节点
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}


//定义一个SingleLinkList管理我们的英雄
class SingleLinkList {
    //初始化一个头结点，头结点不要动,不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");
    //返回头节点
    public HeroNode getHead() {
       return head;
    }
    //添加结点到单向链表
    //思路：当不考虑编号顺序时
    //1.找到当前节点的最后节点
    //2.将最后节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为头结点不能动，因此需要一个辅助变量
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环后，temp就指向了链表的最后
        temp.next = heroNode;
    }

    //第二种方式添加英雄，即根据排名将英雄插入指定位置
    public void addByOrder(HeroNode heroNode) {
        //辅助变量,我们找的temp是要插入结点的前一个结点
        HeroNode temp = head;
        boolean flag = false;//标志添加的结点是否存在
        while(true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.no > heroNode.no) {//位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在
                flag = true;//说明编号存在
                break;
            }
            temp =temp.next;
        }
        //判断flag
        if(flag) { //不能添加，说明编号存在
            System.out.printf("准备添加的英雄的编号%d已经存在了,不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息,根据no编号来修改，no编号不能改
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找出需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode.no);
        }
    }

    //删除结点
    //1.head不能动，因此我们需要一个辅助节点找到被删除节点的前一个节点
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;//标记是否找到被删除节点
        while(true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.no == no) {
                //找到了待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
    //显示链表
    public void list() {
        //先判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}
//定义HeroNode,每一个HeroNode对象都是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方便，重写toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name +", nickname=" + nickname +"]";
    }
}