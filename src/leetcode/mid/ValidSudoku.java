package leetcode.mid;

/**
 * @description: 36. 有效的数独
 * @see: <a>https://leetcode-cn.com/problems/valid-sudoku/</a>
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/1/3 下午10:33
 * @project: cc-leetcode
 */
public class ValidSudoku {

    /**
     * 个人常规解法：用数组计数是否重复
     * 17ms 98.83%
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] count = new int[9];
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                if (count[board[i][j] - '1'] > 0) {
                    return false;
                }
                count[board[i][j] - '1']++;
            }
        }
        for (int i = 0; i < board.length; i++) {
            int[] count = new int[9];
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') continue;
                if (count[board[j][i] - '1'] > 0) {
                    return false;
                }
                count[board[j][i] - '1']++;
            }
        }
        for (int i = 0; i < board.length / 3; i++) {
            for (int j = 0; j < board[i].length / 3; j++) {
                int[] count = new int[9];
                for (int k = i * 3; k < i * 3 + 3; k++) {
                    for (int l = j * 3; l < j * 3 + 3; l++) {
                        if (board[k][l] == '.') continue;
                        if (count[board[k][l] - '1'] > 0) {
                            return false;
                        }
                        count[board[k][l] - '1']++;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
}
