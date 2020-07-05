package kmp;


import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/12 0012
 * @Description: kmp
 * @version: 1.0
 */
public class KMPMatch {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext("ABCDABD");
        System.out.println("next=" + Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index);
    }
    //kmp搜索
    public static int kmpSearch(String str1, String str2, int[] next) {
        //遍历
        for(int i = 0, j = 0; i < str1.length(); i++) {
            //需要处理str1.charAt(i) != str2.charAt(j)时，调整j的大小
            while(j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if(str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if(j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
    //获取字符串的部分匹配表
    public static int[] kmpNext(String dest) {
        //创建next数组
        int[] next = new int[dest.length()];
        next[0] = 0;//如果字符串长度是1部分匹配值是0
        for(int i = 1, j = 0; i < dest.length(); i++) {
            while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}


