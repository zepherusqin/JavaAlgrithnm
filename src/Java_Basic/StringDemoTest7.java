package Java_Basic;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/4 0004
 * @Description: Java_Basic
 * @version: 1.0
 */

/*
 * 统计大串中小串出现的次数
 * 举例：在字符串” woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun”中java出现了5次
 */
public class StringDemoTest7 {
    public static void main(String[] args){
        String maxString = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
        String minString = "java";
        int count = getCount(maxString, minString);
        System.out.println(count);
    }
    /**
     *功能描述：
     *@param：maxString minString
     *@return: int
    **/
    /**
    public static int getCounts(String maxString, String minString) {
        int count = 0;//先定义统计变量
        int index = maxString.indexOf(minString);//查找第一次出现的位置
        int startIndex = 0;
        // 判断位置是不是-1，如果是，就不继续了
        while (index != -1) {
            // 统计变量加1
            count++;
            // 计算最新的查找位置
            startIndex = index + minString.length();
            // 从最新的查找位置，再查一次小串在大串中出现的位置
            index = maxString.indexOf(minString, startIndex);
        }
        return count;
    }
     **/
    public static int getCount(String maxString, String minString) {
        // 定义统计变量
        int count = 0;

        // 第一次查找
        int index = maxString.indexOf(minString);

        while (index != -1) {
            count++;
            // 截取，得到新的大串
            maxString = maxString.substring(index + minString.length());
            // 继续查找
            index = maxString.indexOf(minString);
        }

        return count;
    }
}
