package linklist;

import java.util.Stack;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/17 0017
 * @Description: linklist
 * @version: 1.0
 */
public class TestStack {
    public static void main(String[] args){
        Stack<String> stack = new Stack();
        //入栈
        stack.add("jack");
        stack.add("smith");
        stack.add("tom");
        //出栈
        while(stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
