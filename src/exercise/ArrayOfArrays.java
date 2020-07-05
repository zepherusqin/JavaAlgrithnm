package exercise;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/30 0030
 * @Description: exercise
 * @version: 1.0
 */
public class ArrayOfArrays {
    public static void main(String[] args) {
        int[][] a={{1,3,5},{2,4,6,8},{1,4,9,16,25,36},{10,20,30}};
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
                System.out.println("a["+i+"]["+j+"]="+a[i][j]);
        }
    }
}
