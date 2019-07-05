package LeetCode;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/7/5 15:09
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution85_最大矩形 {

    //动态规划 找最大高度，然后横向扩展
    //不断向上方遍历，直到遇到“0”，以此找到矩形的最大高度。
    //向左右两边扩展，直到无法容纳矩形最大高度。
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
                return 0;

            int m = matrix.length;
            int n = matrix[0].length;

            int[] height = new int[n];
            int[] left = new int[n];
            int[] right = new int[n];

            Arrays.fill(right, n);//填充右边界

            int maxArea = 0;

            for(int i = 0; i < m; i++){
                int cur_left = 0;//当前的左边界
                int cur_right = n;//当前的右边界

                //更新高
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] == '1')
                        height[j]++;
                    else
                        height[j] = 0;
                }

                //更新左边界
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] == '1')
                        left[j] = Math.max(left[j], cur_left);
                    else{
                        left[j] = 0;
                        cur_left = j+1;
                    }
                }

                //更新右边界
                for(int j = n-1; j >= 0; j--){
                    if(matrix[i][j] == '1')
                        right[j] = Math.min(right[j], cur_right);
                    else{
                        right[j] = n;
                        cur_right = j;
                    }
                }

                //更新面积
                for(int j = 0; j < n; j++){
                    maxArea = Math.max(maxArea, height[j] * (right[j]-left[j]));
                }
            }

            return maxArea;
        }
    }

}
