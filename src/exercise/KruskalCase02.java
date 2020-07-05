package exercise;

import kruskal.KruskalCase;

import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/17 0017
 * @Description: exercise
 * @version: 1.0
 */
public class KruskalCase02 {
    private int eNum;
    private char[] vertexs;
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {   0,  12, INF, INF, INF,  16,  14},
                {  12,   0,  10, INF, INF,   7, INF},
                { INF,  10,   0,   3,   5,   6, INF},
                { INF, INF,   3,   0,   4, INF, INF},
                { INF, INF,   5,   4,   0,   2,   8},
                {  16,   7,   6, INF,   2,   0,   9},
                {  14, INF, INF, INF,   8,   9,   0}
        };
        KruskalCase02 kruskalCase02 = new KruskalCase02(vertexs, matrix);
        kruskalCase02.print();
        kruskalCase02.kruskal02();
    }
    public KruskalCase02(char[] vertexs, int[][] matrix) {
        //初始化
        int vlen = vertexs.length;
        this.vertexs = vertexs;
        this.matrix = matrix;
        //统计边的条数
        for(int i = 0; i < vlen; i++) {
            for(int j = i + 1; j < vlen; j++) {
                if(this.matrix[i][j] != INF) {
                    eNum++;
                }
            }
        }
    }
    public void kruskal02() {
        int index = 0;
        //用于保存“已有最小生成树”中的每个顶点在最小生成树中的终点
        int[] ends = new int[eNum];
        //创建结果数组，保存最后的最小生成树
        Edata[] res = new Edata[eNum];
        //获取图中边的集合
        Edata[] edges = getEdges();
        System.out.println("图的边的集合=" + Arrays.toString(edges) + "共" + edges.length + "条边");
        //排序，从小到大
        sortEdges(edges);
        //遍历edges数组,将边添加到最小生成树中，判断是否构成回路
        for(int k = 0; k < eNum; k++) {
            //获取第i条边的第一个和第二个顶点
            int p = getPosition(edges[k].start);
            int q = getPosition(edges[k].end);
            //获取p1,p2顶点在已有最小生成树的终点
            int m = getEnd(ends, p);
            int n = getEnd(ends, q);
            //是否构成回路
            if (m != n) {//没构成回路
                ends[m] = n;//设置m在已有最小生成树的终点
                res[index++] = edges[k];
            }
        }
        //统计
        System.out.println("最小生成树为");
        for (int i = 0; i < index; i++) {
            System.out.println(res[i]);
        }
    }
    public void print() {
        System.out.println("邻接矩阵为:");
        for(int i = 0; i < vertexs.length; i++) {
            for(int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }
    public void sortEdges(Edata[] edges) {
        for(int i = 0; i < edges.length - 1; i++) {
            for(int j = 0; j < edges.length - i - 1; j++) {
                if(edges[j].weight > edges[j + 1].weight) {
                    Edata temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }
    private Edata[] getEdges() {
        int index = 0;
        Edata[] edges =  new Edata[eNum];
        for(int i = 0; i < vertexs.length; i++) {
            for(int j = i + 1; j < vertexs.length; j++) {
                if(matrix[i][j] != INF) {
                    edges[index++] = new Edata(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }
    private int getPosition(char ch) {
        for(int i = 0; i < vertexs.length; i++) {
            if(vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }
    private int getEnd(int[] ends, int i) {
        while(ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}
class Edata  {
    char start;
    char end;
    int weight;
    public Edata(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edata{" +
                "<" + start +
                "," + end +
                ">=" + weight +
                '}';
    }
}
