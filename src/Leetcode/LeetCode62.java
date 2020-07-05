package Leetcode;

/**
 * @Author:QinZhubiao
 * @Date: 2020/6/18 0018
 * @Description: Leetcode
 * @version: 1.0
 */
public class LeetCode62 {
    public static void main(String[] args) {
        LeetCode62 leetCode62 = new LeetCode62();
        int path = leetCode62.uniquePaths(7, 3);
        System.out.println(path);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
