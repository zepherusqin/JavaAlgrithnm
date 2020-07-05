package kmp;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/12 0012
 * @Description: kmp
 * @version: 1.0
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        //测试
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int index = violeceMatch(str1, str2);
        System.out.println("index=" + index);
    }
    //暴力匹配算法实现
    public static int violeceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;//i指向str1
        int j = 0;//j指向str2
        while(i < s1Len && j < s2Len) {
            if(s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                //如果匹配失败,令i=i-(j-1),j=0
                i = i - (j - 1);
                j = 0;
            }
        }
        if(j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }
}
