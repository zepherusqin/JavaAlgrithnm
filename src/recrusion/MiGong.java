package recrusion;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/23 0023
 * @Description: recrusion
 * @version: 1.0
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for(int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for(int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("地图的情况");
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //使用递归回溯给小球找路
        setWay2(map, 1, 1);
        System.out.println("小球走过，并标识的地图的情况");
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    //1.map表示地图
    //2.i,j表示从地图的哪个位置出发
    //3.如果小球能到map[6][5]位置，则表示通路找到
    //4.当map[i][j]为0时，表示该点没有走过，当为1时，表示墙，2表示通路可以走，3表示该位置已经走过，但是走不通
    //5.在走迷宫时，要确定一个策略:下 右 上 左
    public static boolean setWay(int[][] map, int i, int j) {
        if(map[6][5] == 2) {
            return true;
        } else {
            if(map[i][j] == 0) {
                map[i][j] = 2;
                if(setWay(map, i+1, j)) {
                    //向下走
                    return true;
                } else if(setWay(map, i, j+1)) {//向右走
                    return true;
                } else if(setWay(map, i-1, j)) {//向上走
                    return true;
                } else if(setWay(map, i, j-1)) {//向左走
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
    //修改找路的策略上右下左
    public static boolean setWay2(int[][] map, int i, int j) {
        if(map[6][5] == 2) {
            return true;
        } else {
            if(map[i][j] == 0) {
                map[i][j] = 2;
                if(setWay2(map, i-1, j)) {
                    //向上走
                    return true;
                } else if(setWay2(map, i, j+1)) {//向右走
                    return true;
                } else if(setWay2(map, i+1, j)) {//向下走
                    return true;
                } else if(setWay2(map, i, j-1)) {//向左走
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
