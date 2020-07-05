package exercise;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/16 0016
 * @Description: exercise
 * @version: 1.0
 */
public class SingleLinkedList2 {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode hero5 = new HeroNode(5, "关胜", "大刀");
        HeroNode hero6 = new HeroNode(7, "秦明", "霹雳火");
        SingLinkList singLinkList = new SingLinkList();
        //测试添加
        singLinkList.add(hero1);
        singLinkList.add(hero2);
        singLinkList.add(hero3);
        singLinkList.add(hero4);
        singLinkList.add(hero5);
        singLinkList.add(hero6);
        singLinkList.list();
        //测试插入结点
        HeroNode hero7 = new HeroNode(6, "林冲", "豹子头");
        System.out.println("插入一个结点之后：");
        singLinkList.addByOrder(hero7);
        singLinkList.list();
    }
}

class SingLinkList {
    //初始化一个头结点
    private HeroNode head = new HeroNode(0, "", "");
    //1.添加结点:按顺序添加
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        //遍历链表，找到最后
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    //2.插入结点
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while(true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.no > heroNode.no) {
                break;
            } else if(temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp =temp.next;
        }
        //插入
        if(flag) {
            System.out.println("准备添加的编号%d已经在列表中了" + heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //显示方法
    public void list() {
        //先判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空^_^");
            return;
        }
        HeroNode temp = head.next;
        while(true) {
            if(temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

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
    //重写toString方法
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name +", nickname=" + nickname +"]";
    }
}
