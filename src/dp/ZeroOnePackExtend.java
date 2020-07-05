package dp;
import java.util.Scanner;
/**
 * @Author:QinZhubiao
 * @Date: 2020/4/15 0015
 * @Description: dp
 * @version: 1.0
 */
/**
 * 0/1背包的降维，将空间复杂度降为O(V)
 */
public class ZeroOnePackExtend {
    // N表示物体的个数，V表示背包的载重
    int N,V;
    //用于存储每个物体的重量，下标从1开始
    private int[] weight;
    //存储每个物体的收益，下标从1开始
    private int[] value;
    //降成一维数组，用来保存每种状态下的最大收益
    private int[] dp;

    /**
     * 使用非递归方式
     */
    public void ZeroOnePackNonRecursive() {
        //对一维数组F进行初始化
        for(int i = 0; i <= V; i++) {
            dp[i] = 0;
        }

        //注意边界问题，i是从1开始的
        for(int i = 1; i <= N; i++) {
            for(int j = V; j >= 0; j--) {
                //降序遍历
                if(j >= weight[i]) {
                    dp[j] = Math.max(dp[j - weight[i]] + value[i], dp[j]);
                }else {
                    //可以省略
                    dp[j]= dp[j];
                }
            }
        }

        //打印所有结果，我们要求的是dp[V]
        for(int i = 0; i <= V; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }


    /**
     * 输入格式：
     5 10
     2 2 6 5 4
     6 3 5 4 6
     * result:15
     * 第一行是物体个数、背包总空间；
     * 第二行是每个物体的空间；
     * 第三行是每个物体的收益。
     */
    public void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        V = sc.nextInt();

        //下标从1开始，表示第1个物品
        weight = new int[N + 1];
        value = new int[N + 1];
        dp = new int[V + 1];//注意是 V + 1

        for(int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++) {
            value[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) {
        ZeroOnePackExtend zope = new ZeroOnePackExtend();
        zope.init();
        zope.ZeroOnePackNonRecursive();
    }
}
