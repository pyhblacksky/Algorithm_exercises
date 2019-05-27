package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/27 10:45
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 */
public class Solution240_搜索二维矩阵2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        //从右上角开始搜索
        int i = 0;
        int j = matrix[i].length-1;
        while(i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length){
            if(matrix[i][j] == target){
                return true;
            } else if(matrix[i][j] < target){
                i++;
            } else{
                j--;
            }
        }

        return false;
    }

}
