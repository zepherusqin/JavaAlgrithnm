**从尾到头打印单链表**

思路：
1.先将单链表进行反转，然后在遍历即可，这样的问题是会破坏原来的单链表的结构。不建议
2.可以利用栈这个数据结构，将各个节点压入到栈中，利用栈的先进后出的特点，就实现了逆序打印。
//具体代码
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
    
**单链表反转**

思路：
1.先定义一个节点reverseHead=new HeroNode()
2.从尾到头遍历原来的链表，每遍历一个节点，就将其取出，并放在reverseHead链表的最前端

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