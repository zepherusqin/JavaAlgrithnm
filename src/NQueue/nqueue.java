package NQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:QinZhubiao
 * @Date: 2020/3/13 0013
 * @Description: NQueue
 * @version: 1.0
 */
/**
 *功能描述：回溯法处理N皇后问题Leetcode51,52
 *@param：
 *@return:
 *@auther:
 *@date:
**/
public class nqueue {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        init(board);
        helper(res, board, 0);
        return res;
    }
    private void init (char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
    }
    public void helper(List<List<String>> res, char[][] board, int rowIndex) {
        if (rowIndex == board.length) {
            res.add(generate(board));
            return;
        }
        for (int colIndex = 0; colIndex < board.length; colIndex++) {
            if (isValid(board, rowIndex, colIndex)) {
                board[rowIndex][colIndex] = 'Q';
                helper(res, board, rowIndex + 1);
                board[rowIndex][colIndex] = '.';
            }
        }
    }
    private boolean isValid(char[][] board, int rowIndex, int colIndex) {
        for (int i = 0; i < rowIndex; i++) {
            if (board[i][colIndex] == 'Q') return false;
        }//看是否是同一列的，如果是，返回false

        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j] == 'Q') return false;
        }//看跟左上方是否冲突

        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < board.length; i--,j++) {
            if (board[i][j] == 'Q') return false;
        }//看跟右上方是否冲突
        return true;
    }
    private List<String> generate(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : row) {
                sb.append(c);
            }
            list.add(sb.toString());
        }
        return list;
    }
    public static void main(String[] args) {
        nqueue solution = new nqueue();
        List<List<String>> solveNQueens = solution.solveNQueens(4);
        int solveSize = solveNQueens.size();
        System.out.println("一共有 " + solveSize + " 种解。");

        for (int i = 0; i < solveNQueens.size(); i++) {
            System.out.println("第 " + (i + 1) + " 种解：");
            for (String line : solveNQueens.get(i)) {
                System.out.println(line);
            }
        }
    }
}




