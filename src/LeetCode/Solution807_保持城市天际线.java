package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/19 14:59
 * @Version 1.0
 * @Function:
 *
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
 *
 * 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。
 *
 * 建筑物高度可以增加的最大总和是多少？
 *
 * 例子：
 * 输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * 输出： 35
 * 解释：
 * The grid is:
 * [ [3, 0, 8, 4],
 *   [2, 4, 5, 7],
 *   [9, 2, 6, 3],
 *   [0, 3, 1, 0] ]
 *
 * 从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
 * 从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
 *
 * 在不影响天际线的情况下对建筑物进行增高后，新数组如下：
 *
 * gridNew = [ [8, 4, 8, 7],
 *             [7, 4, 7, 7],
 *             [9, 4, 8, 7],
 *             [3, 3, 3, 3] ]
 * 说明:
 *
 * 1 < grid.length = grid[0].length <= 50。
 *  grid[i][j] 的高度范围是： [0, 100]。
 * 一座建筑物占据一个grid[i][j]：换言之，它们是 1 x 1 x grid[i][j] 的长方体。
 *
 *
 * 解答：实际上就是找出数组中行和列的最大值，就是其天际线，在不超过此值的情况下对全数组进行增高
 */
public class Solution807_保持城市天际线 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int[] rowMaxList = new int[grid.length];
        int[] colMaxList = new int[grid[0].length];
        int rowLen = grid.length;
        int colLen = grid[rowLen-1].length;
        //计算每一行最大值
        for(int i = 0; i < rowLen; i++) {
            int max = 0;
            for (int j = 0; j < colLen; j++) {
                max = Math.max(max, grid[i][j]);
            }
            rowMaxList[i] = max;
        }

        //计算列最大值
        for(int i = 0; i < colLen; i++){
            int max = 0;
            for(int j = 0; j < rowLen; j++){
                max = Math.max(max, grid[j][i]);
            }
            colMaxList[i] = max;
        }

        int res = 0;
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                int limit = Math.min(rowMaxList[i], colMaxList[j]);
                int diff = limit - grid[i][j];
                res += diff;
            }
        }

        return res;
    }

    public static void printArr(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};

        Solution807_保持城市天际线 solution = new Solution807_保持城市天际线();
        System.out.println(solution.maxIncreaseKeepingSkyline(grid));
    }
}
