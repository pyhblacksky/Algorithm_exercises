package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/17 15:13
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution695_岛屿的最大面积 {

    //递归计算每个岛屿的面积，取最大,dfs
    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
                return 0;
            }
            int max = 0;
            //boolean[][] visted = new boolean[grid.length][grid[0].length];
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == 1) {
                        max = Math.max(max, dfs(grid, i, j));
                    }
                }
            }
            return max;
        }

        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        int dfs(int[][] grid, int x, int y){
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[x].length && grid[x][y] == 1){
                grid[x][y] = 0;
                int res = 1;
                for(int i = 0; i < 4; i++){
                    res += dfs(grid, x+dx[i], y+dy[i]);
                }
                return res;
            }
            return 0;
        }

        //计算每个岛屿的面积
        int countArea(int[][] grid, int x, int y, boolean[][] visited){
            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
                return 0;
            }

            visited[x][y] = true;

            int up = 0;
            if(x-1 >= 0 && grid[x-1][y] == 1 && !visited[x-1][y]){
                up += countArea(grid, x-1, y, visited);
            }

            int down = 0;
            if(x+1 < grid.length && grid[x+1][y] == 1 && !visited[x+1][y]){
                down += countArea(grid, x+1, y, visited);
            }

            int left = 0;
            if(y+1 < grid[0].length && grid[x][y+1] == 1 && !visited[x][y+1]){
                left += countArea(grid, x, y+1, visited);
            }

            int right = 0;
            if(y-1 >= 0 && grid[x][y-1] == 1 && !visited[x][y-1]){
                right += countArea(grid, x, y-1, visited);
            }

            int area = up + down + right + left + 1;
            return area;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(new int[][]{{0,1}}));
    }

}
