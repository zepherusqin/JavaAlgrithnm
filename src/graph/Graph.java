package graph;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/9 0009
 * @Description: graph
 * @version: 1.0
 */
public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图相应的邻接矩阵
    private int numOfEdges;//表示边的树目
    //定义数组boolean[]，记录某个结点是否被访问
    private boolean[] isVisited;
    public static void main(String[] args) {
        //测试
        int n = 5;
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环添加节点
        for(String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        //显示
        graph.showGraph();
//        System.out.println("图的结点的个数:" + graph.getNumOfVertex());
//        System.out.println("图的边的个数:" + graph.getNumOfEdges());
//        System.out.println(graph.getWeight(0, 2));
      //  System.out.println(graph.getValueByIndex(0));

        //测试dfs
        System.out.println("深度遍历");
        graph.dfs();
        System.out.println();
        System.out.println("广度遍历");
        graph.bfs();
    }
    //构造器
    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[5];
    }
    //得到第一个邻接节点的下标w
    public int getFirstNeighbor(int index) {
        for(int j = 0; j < vertexList.size(); j++) {
            if(edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }
    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for(int j = v2 + 1; j < vertexList.size(); j++) {
            if(edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历法
    //i第一次是0
    private void dfs(boolean[] isVisited, int i) {
        //首先访问该节点，输出
        System.out.printf(getValueByIndex(i) + "->");
        //将节点设置为已经访问
        isVisited[i] = true;
        //查找i的第一个临界点
        int w = getFirstNeighbor(i);
        while(w != -1) {
            if(!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w已经被访问过
            w = getNextNeighbor(i, w);
        }
    }
    //对dfs进行重载，遍历所有的结点，进行dfs
    public void dfs() {
        isVisited = new boolean[5];
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //对一个结点广度优先遍历
    private void bfs(boolean[] isVisited, int i) {
        int u; //表示队列的头结点对应下标
        int w; //表示邻接节点
        //队列，记录结点访问顺序
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "->");
        //标记为已访问
        isVisited[i] = true;
        //将节点加入队列
        queue.addLast(i);
        while(!queue.isEmpty()) {
            //取出队列头结点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻接点的下标w
            w = getFirstNeighbor(u);
            while(w != -1) {
                //是否被访问过
                if(!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    //标记已经访问
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //如果访问过，找下一个邻接点
                w = getNextNeighbor(u, w);
            }
        }
    }
    //便利所有的结点，都进行bfs
    public void bfs() {
        isVisited = new boolean[5];
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                bfs(isVisited,i);
            }
        }
    }
    //图中常用的方法
    //返回图结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }
    //显示对应的图的矩阵
    public void showGraph() {
        for(int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
    //返回结点i(下标)对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }
    //返回v1和v2的圈住
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }
    //返回图中边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }
    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
    //添加边
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
