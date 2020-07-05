package Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/13 0013
 * @Description: Leetcode
 * @version: 1.0
 */
public class LeetCode22 {
    public static List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        traceBack("", 0, 0, n, parenthesis);
        return parenthesis;
    }

    private static void traceBack(String str, int left, int right, int n,
                                  List<String> parenthesis) {
        if (str.length() == 2 * n) {
            parenthesis.add(new String(str));
            return;
        }
        if (left < n) {
            traceBack(str + '(', left + 1, right, n, parenthesis);
        }
        if (right < left) {
            traceBack(str + ')', left, right + 1, n, parenthesis);
        }
    }
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
