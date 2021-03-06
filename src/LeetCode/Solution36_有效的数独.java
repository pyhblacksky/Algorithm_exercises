package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: pyh
 * @Date: 2019/8/19 15:52
 * @Version: 1.0
 * @Function:
 * @Description:
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution36_有效的数独 {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            if(board == null || board.length == 0 || board.length > 9)
                return false;


            for(int i = 0; i < board.length; i++){
                //行遍历
                Set<Character> set = new HashSet<>();
                for(int j = 0; j < board[i].length; j++){
                    char c = board[i][j];
                    if(c == '.')
                        continue;
                    if(set.contains(c)){
                        return false;
                    }
                    set.add(c);
                }

                //列
                set = new HashSet<>();
                for(int j = 0; j < board[i].length; j++){
                    char c = board[j][i];
                    if(c == '.')
                        continue;
                    if(set.contains(c)){
                        return false;
                    }
                    set.add(c);
                }
            }

            //九宫格遍历
            for(int i = 0; i < 9; i += 3){
                for(int num = 0; num < 9; num += 3) {
                    Set<Character> set = new HashSet<>();
                    for (int j = num; j < num + 3; j++) {
                        for (int k = i; k < i + 3; k++) {
                            char c = board[j][k];
                            if (c == '.')
                                continue;
                            if (set.contains(c)) {
                                return false;
                            }
                            set.add(c);
                        }
                    }
                }
            }

            return true;
        }
    }
}
