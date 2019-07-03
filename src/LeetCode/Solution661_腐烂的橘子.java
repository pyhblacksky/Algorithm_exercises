package LeetCode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/7/2 20:47
 * @Version: 1.0
 * @Function:
 * @Description:
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 *
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *  
 *
 * 提示：
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution661_腐烂的橘子 {
    //BFS
    class Solution {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        public int orangesRotting(int[][] grid) {
            if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
                return -1;

            int row = grid.length;
            int col = grid[0].length;

            Queue<Integer> queue = new ArrayDeque<>();
            Map<Integer, Integer> depth = new HashMap<>();
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == 2){
                        int code = i*col + j;
                        queue.add(code);
                        depth.put(code, 0);
                    }
                }
            }

            int res = 0;
            while(!queue.isEmpty()){
                int code = queue.poll();
                int r = code / col;
                int c = code % col;
                for(int k = 0; k < 4; k++){
                    int nr = r + dx[k];
                    int nc = c + dy[k];
                    if(nr >= 0 && nc >= 0 && nr < row && nc < col && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        int ncode = nr * col + nc;
                        queue.add(ncode);
                        depth.put(ncode, depth.get(code) + 1);
                        res = depth.get(ncode);
                    }
                }
            }

            for(int[] arr : grid){
                for(int num : arr){
                    if(num == 1)
                        return -1;
                }
            }

            return res;
        }
    }

}
