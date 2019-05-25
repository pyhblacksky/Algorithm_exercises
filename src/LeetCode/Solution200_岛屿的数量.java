package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/24 20:07
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */
public class Solution200_岛屿的数量 {

    int[] dx = {-1, 1, 0, 0};//方向
    int[] dy = {0, 0, -1, 1};//方向
    //验证是否合法
    private boolean valid(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return false;
        if (j < 0 || j >= grid[0].length) return false;
        return grid[i][j] == '1';
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }

       //return unionFind(grid);

        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                count += grid[i][j] - '0';
                dfs(grid, i, j);
            }
        }
        return count;
    }

    /***************************************************************/
    //深度优先搜索dfs,相当于是感染算法
    public void dfs(char[][] grid, int i, int j) {
        if (valid(grid, i, j)) {
            grid[i][j] = '0';
            for (int k = 0; k < 4; k++) {
                dfs(grid, i + dx[k], j + dy[k]);
            }
        }
    }

    /**************************************************************/
    //使用并查集的方法

    public int unionFind(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        Union union = new Union(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (valid(grid, i, j)) {
                    int middle = i * grid[0].length + j;
                    for (int k = 0; k < 4; k++) {
                        if (valid(grid, i + dx[k], j + dy[k])) {
                            int around = (i + dx[k]) * grid[0].length + j + dy[k];
                            union.union(around, middle);
                        }
                    }
                }
            }
        }
        return union.count();
    }

    class Union{
        private int[] parent;
        private int count;

        public Union(int size){
            parent = new int[size];
            for(int i = 0; i < size; i++){
                parent[i] = i;
            }
        }

        public Union(char[][] grid) {
            parent = new int[grid.length * grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * grid[0].length + j] = i * grid[0].length + j;
                        count++;
                    }
                }
            }
        }

        public int find(int p){
            while(p != parent[p]){
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);

            if (pRoot != qRoot) {
                parent[pRoot] = qRoot;
                count--;
            }
        }

        public int count(){
            return count;
        }
    }


}
