package linklist;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/17 0017
 * @Description: linklist
 * @version: 1.0
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试~~~");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(6, "关胜", "大刀");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero5);
        doubleLinkedList.list();
        //修改测试
        HeroNode2 newheroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newheroNode);
        System.out.println("修改过后的链表情况~~~");
        doubleLinkedList.list();
        //测试删除节点
        doubleLinkedList.del(2);
        System.out.println("删除节点后的链表情况~~~");
        doubleLinkedList.list();
        //测试按照编号大小添加结点
        HeroNode2 hero6 = new HeroNode2(5, "武松", "打虎将");
        doubleLinkedList.addByOrder(hero6);
        System.out.println("插入结点后的链表情况~~~");
        doubleLinkedList.list();
    }
}
class DoubleLinkedList{
    //初始化一个头节点
    private HeroNode2 head = new HeroNode2(0, "", "");
    public HeroNode2 getHead() {
        return head;
    }
    //遍历双向链表
    //显示链表
    public void list() {
        //先判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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
    //添加结点
    public void add(HeroNode2 heroNode) {
        //因为头结点不能动，因此需要一个辅助变量
        HeroNode2 temp = head;
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
        heroNode.pre = temp;
    }
    //第二种方式添加英雄，即根据排名将英雄插入指定位置
    public void addByOrder(HeroNode2 heroNode) {
        //辅助变量,我们找的temp是要插入结点的前一个结点
        HeroNode2 temp = head;
        boolean flag = false;//标志添加的结点是否存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if(flag) { //不能添加，说明编号存在
            System.out.printf("准备添加的英雄的编号%d已经存在了,不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            heroNode.pre = temp;
            if(temp.next != null)//当新建的结点是最后一个结点时，不许执行下面一步，否则出现NULL指针
                temp.next.pre = heroNode;
            temp.next = heroNode;
        }
    }

    //结点内容修改
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if(head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找出需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
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
    //对于双向链表，可以直接找到要删除的结点
    public void del(int no) {
        //判断当前链表是否为空
        if(head.next == null) {
            System.out.println("链表为空，不能删除~~~");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//标记是否找到被删除节点
        while(true) {
            if(temp == null) {
                break;
            }
            if(temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.pre.next = temp.next;
            //如果是最后一个结点，下面的不需要执行
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
}
//定义HeroNode2,每一个HeroNode2对象都是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;
    //构造器
    public HeroNode2(int no, String name, String nickname) {
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
