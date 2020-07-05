package Leetcode;

/**
 * @Author:QinZhubiao
 * @Date: 2020/6/17 0017
 * @Description: Leetcode
 * @version: 1.0
 */

/**
 * 动态规划首先是对数组进行遍历，当前最大连续子序列和为sum,结果为res
 * 如果sum>0则说明sum对结果有增益效益，则sum保留并加上当前遍历数字
 * 如果sum<0则说明sum对结果无增益效益，则需要舍弃，则sum更新为当前遍历数字
 * 每次比较sum和res大小,将最大值置为res,遍历返回结果
**/
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        LeetCode53 leetCode53 = new LeetCode53();
        int maxSub = leetCode53.maxSubArray(nums);
        System.out.println(maxSub);
    }
}
