package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/19 20:14
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution79_单词搜索 {

    //回溯
    class Solution {
        public boolean exist(char[][] board, String word) {
            if(board == null || board.length == 0 || board[0] == null || board[0].length == 0){
                return false;
            }
            boolean res = false;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j] == word.charAt(0)){
                        res = help(board, word, 0, i, j, new boolean[board.length][board[i].length]);
                        if(res){
                            return true;
                        }
                    }
                }
            }

            return res;
        }

        private boolean help(char[][] board, String word, int index, int i, int j, boolean[][] mark){
            if(index == word.length()){
                return true;
            }

            if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || mark[i][j] || board[i][j] != word.charAt(index)){
                return false;
            }

            mark[i][j] = true;
            boolean up = help(board, word, index+1, i-1, j, mark);
            boolean down = help(board, word, index+1, i+1, j, mark);
            boolean left = help(board, word, index+1, i, j-1, mark);
            boolean right = help(board, word, index+1, i, j+1, mark);
            if(up || down || left || right){
                return true;
            }
            mark[i][j] = false;
            return false;
        }

    }
}
