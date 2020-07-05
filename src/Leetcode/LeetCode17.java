package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/14 0014
 * @Description: Leetcode
 * @version: 1.0
 */
public class LeetCode17 {
    public  List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if (digits == null || digits.length() == 0) return res;
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'f'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        helper("", 0, digits, res, map);
        return res;
    }
    public void helper(String curr, int currIdx, String digits, List<String> res, HashMap<Character, char[]> map)
    {
        if (currIdx == digits.length()) {
            res.add(curr);
        } else {
            char c = digits.charAt(currIdx);
            if (map.containsKey(c)) {
                for (char ch : map.get(c)) {
                    helper(curr+ch, currIdx+1, digits, res, map);
                }
            } else {

            }
        }
    }
    public static  void main(String[] args) {
        //LeetCode17 solution = new LeetCode17();
        //List<String> list = LeetCode17.letterCombinations(23);
    }
}
