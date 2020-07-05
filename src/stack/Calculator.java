package stack;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/19 0019
 * @Description: stack
 * @version: 1.0
 */
public class Calculator {
    public static void main(String[] args){
        String expression = "70+20*6-1";
        //创建两个栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";//用于拼接多位数
        //开始while循环扫描expression
        while(true) {
            //先一次得到每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么
            if(operStack.isOper(ch)) {
                if(!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                    //如果当前操作符的优先级大于栈中的操作符优先级，就直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            }else {
                //如果当前扫描的是数字，则入数栈
                //numStack.push(ch - 48);
                //分析思路
                //1.当处理多位数时，不能发现一个数就直接入栈，因为有可能是多位数
                //2.在处理数时，需要向expression的表达式的index后再看一位，如果是数就进行扫描，如果是符号才入栈
                //3.因此需要定义一个字符串，用于拼接
                keepNum += ch;
                //如果ch已经是最后一位了，直接入站
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        //重要！！！keepNum清零
                        keepNum = "";
                    }
                }
            }
            //index+1，并判断是否扫描到最后
            index++;
            if(index >= expression.length()) {
                break;
            }
        }
        //当表达式扫描完毕，就顺序从数栈和符号栈中pop出相应的字段
        while(true) {
            //如果符号栈为空，则计算到最后，数栈中只有一个数字
            if(operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.printf("表达式%s = %d",expression, res2);
    }
}
class ArrayStack2 {
    private int maxSize;
    private int[] stack;//数组，数据模拟栈，数据防在该数据中
    private int top = -1;//栈顶

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //返回当前栈顶的值，但不是整整的pop
    public int peek() {
        return stack[top];
    }
    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈
    public void push(int value) {
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈空，没有数据~~~");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //遍历
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for(int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
    //返回运算符的优先级,优先级使用数字表示，数字越大，优先级越高
    public int priority(int oper) {
        if(oper == '*'|| oper == '/') {
            return 1;
        } else if(oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char var) {
        return var == '+'|| var == '-'|| var == '*'|| var == '/';
    }
    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
