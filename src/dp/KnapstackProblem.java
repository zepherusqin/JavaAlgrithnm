package dp;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/11 0011
 * @Description: dp
 * @version: 1.0
 */
public class KnapstackProblem {
    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2};
        int[] val = {12, 10, 20, 15};//物品的价值
        int m = 5;//背包的容量
        int n = val.length;//物品的个数
        //创建二维数组
        //v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n+1][m+1];
        //定义一个二维数组，记录放入商品的情况
        int[][] path = new int[n+1][m+1];

        //初始化第一行第一列
        for(int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for(int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        //根据公式动态规划
        for(int i = 1; i < v.length; i++) {
            for(int j = 1; j < v[0].length; j++) {
                //公式
                //当准备加入新增的物品的重量大于背包的重量
                if(w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else { //当新增加入的物品的重量小于背包的重量
                   // v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - w[i - 1]] + val[i - 1]);
                    // 用if-else写
                   if(v[i - 1][j] < v[i - 1][j - w[i - 1]] + val[i - 1]) {//装入
                       v[i][j] = v[i - 1][j - w[i - 1]] + val[i - 1];
                       path[i][j] = 1;
                   } else {//没装入
                       v[i][j] = v[i - 1][j];
                   }
                }
            }
        }
        //输出一下
        for(int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===========================");
        int i = path.length - 1;
        int j = path[0].length - 1;
        while(i > 0 && j > 0) {//从后向前打印输出
            if(path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }
}
