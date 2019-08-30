package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/8/29 13:50
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution542_01矩阵 {

    //dfs，超时
    static class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0)
                return matrix;

            int[][] res = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] == 0){
                        continue;
                    }
                    boolean[][] judge = new boolean[matrix.length][matrix[0].length];
                    res[i][j] = dfs(matrix, i, j, judge);
                }
            }

            return res;
        }

        //dfs
        public int dfs(int[][] arr, int i, int j, boolean[][] visited){
            if(i < 0 || j < 0 || i >= arr.length || j >= arr[i].length || visited[i][j])
                return Integer.MAX_VALUE/2;

            if(arr[i][j] == 0)
                return 0;
            visited[i][j] = true;
            int up = 1+dfs(arr, i-1, j, visited);
            int down = 1+dfs(arr, i+1, j, visited);
            int left = 1+dfs(arr, i, j-1, visited);
            int right = 1+dfs(arr, i, j+1, visited);
            visited[i][j] = false;

            return Math.min(left, Math.min(right, Math.min(up, down)));
        }
    }

    //备忘录模式的dfs，同样超时
    static class Solution1 {
        public int[][] updateMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0)
                return matrix;

            int[][] res = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] == 0){
                        continue;
                    }
                    boolean[][] judge = new boolean[matrix.length][matrix[0].length];
                    res[i][j] = dfs(matrix, i, j, judge, res);
                }
            }

            return res;
        }

        //dfs,memo是备忘录
        public int dfs(int[][] arr, int i, int j, boolean[][] visited, int[][] memo){
            if(i < 0 || j < 0 || i >= arr.length || j >= arr[i].length || visited[i][j])
                return Integer.MAX_VALUE/2;

            if(arr[i][j] == 0)
                return 0;
            if(memo[i][j] != 0)
                return memo[i][j];
            visited[i][j] = true;
            int up = 1+dfs(arr, i-1, j, visited, memo);
            int down = 1+dfs(arr, i+1, j, visited, memo);
            int left = 1+dfs(arr, i, j-1, visited, memo);
            int right = 1+dfs(arr, i, j+1, visited, memo);
            visited[i][j] = false;

            return Math.min(left, Math.min(right, Math.min(up, down)));
        }
    }

    //bfs的方法,通过
    static class Solution2 {
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        public int[][] updateMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0)
                return matrix;

            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] == 0)
                        queue.offer(new int[]{i,j});
                    else
                        matrix[i][j] = 10001;
                }
            }

            while(!queue.isEmpty()){
                int len = queue.size();
                while(len > 0){
                    len--;
                    int[] tmp = queue.poll();
                    bfs(matrix, tmp[0], tmp[1]);
                }
            }

            return matrix;
        }

        void bfs(int[][] matrix, int x, int y){
            int min = matrix[x][y];
            for(int[] direct : directions){
                int xx = x + direct[0];
                int yy = y + direct[1];
                if(xx >= 0 && xx < matrix.length && yy >= 0 && yy < matrix[xx].length){
                    min = Math.min(min, matrix[xx][yy] + 1);
                    if(matrix[xx][yy] == 10001)
                        queue.offer(new int[]{xx,yy});
                }
            }
            matrix[x][y] = min;
        }

    }


    public static void main(String[] args) {
        int[][] matrix = {{1,1,0,0,1,0,0,1,1,0},{1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},{0,1,1,1,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,0,1,1,1},
                {0,1,1,1,1,1,1,0,0,1},{1,1,1,1,1,0,0,1,1,1},
                {0,1,0,1,1,0,1,1,1,1},{1,1,1,0,1,0,1,1,1,1}};

        long start = System.currentTimeMillis();
        Solution1 solution1 = new Solution1();
        int[][] res = solution1.updateMatrix(matrix);
        long end = System.currentTimeMillis();
        System.out.println("memo cost=" + (end-start));

        long start1 = System.currentTimeMillis();
        Solution2 solution2 = new Solution2();
        solution2.updateMatrix(matrix);
        long end1 = System.currentTimeMillis();
        System.out.println("normal cost="+(end1-start1));

        //printMatrix(res);
    }

    static void printMatrix(int[][] arr){
        for(int[] tmp : arr){
            for(int num : tmp){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
