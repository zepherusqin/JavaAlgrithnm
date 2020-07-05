package prim;
import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/16 0016
 * @Description: prim
 * @version: 1.0
 */
public class PrimAlgorithm {
    public static void main(String[] args){
        //测试
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},
        };
        //创建MGraph对象
        MGraph graph = new MGraph(verxs);
        //创建MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        minTree.showGraph(graph);
        //测试
        minTree.prim(graph, 0);
    }
}
//创建最小生成树
class MinTree {
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for(i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for(j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }
    //显示图的方法
    public void showGraph(MGraph graph) {
        for(int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
//        for(int i = 0; i < graph.verxs; i++) {
//            for(int j = 0; j < graph.verxs; j++) {
//                System.out.print(graph.weight[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
    //编写prim算法，得到最小生成树
    /**
     *功能描述：
     *@param：graph 图
     *@param: v表示从图的第几个顶点开始生成‘A’->0 'B'->1.....
    **/
    public void prim(MGraph graph, int v) {
        //标记顶点是否被访问过
        int visited[] = new int[graph.verxs];
//        for(int i = 0; i < graph.verxs; i++) {
//            visited[i] = 0;
//        }
        //把当前这个节点标记为已访问
        visited[v] = 1;
        //h1和h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        //minWeight初始化为一个大数，后面会被替换
        int minWeight = 10000;
        //n个顶点，n-1条边
        for(int k = 1; k < graph.verxs; k++) {
            //确定每一次生成的子图和哪个节点的距离最近
            for(int i = 0; i < graph.verxs; i++) {//i表示被访问过的结点
                for(int j = 0; j < graph.verxs; j++) {//j表示未被访问的结点
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条最小的边
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前找到的结点标记为已访问
            visited[h2] = 1;
            //重新设置为最大值
            minWeight = 10000;
        }

    }
}
class MGraph {
    int verxs; //表示图的结点个数
    char[] data;//存放结点数据
    int[][] weight;//存放边，邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
