package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/21 0021
 * @Description: stack
 * @version: 1.0
 */
/**
public class PolandNotation {
    public static void main(String[] args) {
        //先定一个逆波兰表达式
        String suffixExpression = "30 4 + 5 * 6 -";
        //1.先将suffixExpression放到ArrayList中
        //2.将ArrayList传递给一个方法，遍历配合栈完成
        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList=" + list);
        int res = calculate(list);
        System.out.println("计算的结果=" + res);
    }
    //将一个逆波兰表达式，一次奖数字和运算符放入ArrayList
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele: split) {
            list.add(ele);
        }
        return list;
    }

    //完成表达式的运算
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<String>();
        for(String item: ls) {
            //使用正则表达式来取出数
            if(item.matches("\\d+")) {//匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());//取出字符并转化成Integer型
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                } else if(item.equals("-")) {
                    res = num1 - num2;
                } else if(item.equals("*")) {
                    res = num1 * num2;
                } else if(item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算有误");
                }
                stack.push("" + res);
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}
**/

public class PolandNotation {
    public static void main(String[] args) {
        //将中缀表达式改为后缀表达式
        //1.1+((2+3)*4)-5   ->  1 2 3 + 4 * + 5 -
        //2.因为直接对str进行操作不方便，因此先将1+((2+3)*4)-5 中缀的表达式对应的List
        //将得到的中缀表达式对应的List转换成后缀表达式对应的List
        String expression = "10+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List" + infixExpressionList);
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List" + suffixExpressionList);
        System.out.printf("expression=%d", calculate(suffixExpressionList));
    }
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<String>();//符号栈
        List<String> s2 = new ArrayList<String>();
        for(String item: ls) {
            if(item.matches("\\d+")) {
                s2.add(item);
            } else if(item.equals("(")) {
                s1.push(item);
            } else if(item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//消除小括号“（”
            } else {
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出压入s2中
        while(s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }
    //方法：将中缀表达式转为对应的List
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;//对多位数的拼接
        char c;
        do{
            if((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                str = "";
                while(i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <=57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;
    }
    //将一个逆波兰表达式，一次奖数字和运算符放入ArrayList
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for(String ele: split) {
            list.add(ele);
        }
        return list;
    }

    //完成表达式的运算
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<String>();
        for(String item: ls) {
            //使用正则表达式来取出数
            if(item.matches("\\d+")) {//匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());//取出字符并转化成Integer型
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                } else if(item.equals("-")) {
                    res = num1 - num2;
                } else if(item.equals("*")) {
                    res = num1 * num2;
                } else if(item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算有误");
                }
                stack.push("" + res);
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }

}
//编写一个类，可以返回运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}