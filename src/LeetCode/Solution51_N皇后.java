package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/4/24 20:29
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class Solution51_N皇后 {


    public List<List<String>> solveNQueens(int n) {
        if(n <= 0){
            return null;
        }

        List<List<String>> list = new ArrayList<>();
        dfs(0, n, new int[n], list);
        return list;
    }

    static void dfs(int r, int n, int[] cols, List<List<String>> list){
        if(r == n){
            //记录
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(cols[i] == j){
                        sb.append("Q");
                    } else{
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }

            list.add(temp);
            return;
        }

        for(int c = 0; c < n; c++){
            boolean ok = true;
            cols[r] = c;
            for(int i = 0; i < r; i++){
                if(cols[r] == cols[i] || r-i == cols[r] - cols[i] || r-i == cols[i] - cols[r]){
                    ok = false;
                    break;
                }
            }
            if(ok){
                dfs(r+1, n, cols, list);
            }
        }
    }

    //测试方法
    public static void main(String[] args){
        Solution51_N皇后 solution = new Solution51_N皇后();
        List<List<String>> list = solution.solveNQueens(8);
        printList(list);
    }

    public static void printList(List<List<String>> list){
        for(List<String> temp : list){
            for(String str : temp){
                System.out.println(str);
            }
            System.out.println("--------------------------");
        }
        System.out.println();
    }
}
