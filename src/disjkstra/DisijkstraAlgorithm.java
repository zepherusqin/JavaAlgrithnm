package disjkstra;

import java.util.Arrays;

/**
 * @Author:QinZhubiao
 * @Date: 2020/4/24 0024
 * @Description: disjkstra
 * @version: 1.0
 */
public class DisijkstraAlgorithm {
    public static void main(String[] args){
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;//表示不可以连接
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        //创建Graph对象
        Graph graph = new Graph(vertex, matrix);
        //测试显示
        graph.showGraph();
        //测试迪杰斯特拉算法
        graph.dsj(6);
        graph.showDijkstra();
    }
}
class Graph {
    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵
    private VisitedVertex vv;//已经访问的顶点集合
    //构造器
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showDijkstra() {
        vv.show();
    }
    //显示方法
    public void showGraph() {
        for(int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    //迪杰斯特拉算法实现
    /**
     *功能描述：
     *@param：index :表示出发顶点对应的下标
     *@return:
    **/
    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(index);//更新index顶点到周围顶点的距离

        for(int j = 1; j < vertex.length; j++) {
            index = vv.updateArr();//选择并访问新生物访问节点
            update(index);//更新index顶点到周围顶点的距离和前驱顶点
        }
    }

    //更新index下标顶点到周围顶点的距离和周围顶点的前驱节点
    private void update(int index) {
        int len = 0;
        for(int j = 0; j < matrix[index].length; j++) {
            len = vv.getDis(index) + matrix[index][j];
            if(!vv.in(j) && len < vv.getDis(j)) {
                vv.updatePre(j, index);//更新j顶点的前驱为index顶点
                vv.updateDis(j, len);//更新出发顶点到j的距离
            }
        }
    }
}
//已访问的顶点集合
class VisitedVertex {
    //记录各个顶点是否被访问过，1表示访问过，0表示未被访问过
    public int[] already_arr;
    //每个下标对应的值为前一个顶点下标，会动态更新
    public int[] pre_visited;
    //记录出发顶点到其他所有顶点的距离，比如G为出发点，则会记录G到其他顶点的距离，会动态更新，求的最短距离就会存放到dis
    public int[] dis;

    //构造器
    /**
     *功能描述：
     *@param：length:表示顶点的个数
     *@param: index:出发顶点对应的下标
    **/
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //初始化dis数组
        Arrays.fill(dis, 65535);
        //设置出发顶点的访问距离为0
        this.already_arr[index] = 1;
        this.dis[index] = 0;
    }
    /**
     *功能描述：判断index顶点是否被访问过
     *@param：index
     *@return:如果访问过，返回true,否则为false
    **/
    public boolean in(int index) {
        return already_arr[index] == 1;
    }
    /**
     *功能描述：更新出发顶点到index顶点的距离
     *@param:index
     *@return:len
    **/
    public void updateDis(int index, int len) {
        dis[index] = len;
    }
    /**
     *功能描述：更新pre顶点的前驱顶点为index结点
     *@param：pre
     *@param: index
     **/
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     *功能描述：返回出发顶点到index顶点的距离
     *@param：index
     *@return:
    **/
    public int getDis(int index) {
        return dis[index];
    }

    //继续选择并返回访问顶点，比如这里的G之后，就是A点为新的访问顶点
    public int updateArr() {
        int min = 65535, index = 0;
        for(int i = 0; i < already_arr.length; i++) {
            if(already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }

    //显示最后的结果
    public void show() {
        System.out.println("=============================");
        //输出already_arr
        for(int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出pre_visited
        for(int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出dis
        for(int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count = 0;
        for(int i : dis) {
            if(i != 65535) {
                System.out.print(vertex[count] + "(" + i + ")");
            } else {
                System.out.println("N ");
            }
            count++;
        }
        System.out.println();
    }
}