package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/5/27 14:26
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Solution54_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return list;
        }

        //从两个角开始
        int upLeft = 0;
        int upRight = 0;
        int downLeft = matrix.length-1;
        int downRight = matrix[downLeft].length-1;

        while(upLeft <= downLeft && upRight <= downRight){
            help(matrix,upLeft++,upRight++, downLeft--, downRight--, list);
        }
        return list;
    }

    static void help(int[][] matrix, int upLeft, int upRight, int downLeft, int downRight, List<Integer> res){
        //单行
        if(upLeft == downLeft){
            while(upRight <= downRight){
                res.add(matrix[upLeft][upRight++]);
            }
            return;
        }
        //单列
        if(upRight == downRight){
            while(upLeft <= downLeft){
                res.add(matrix[upLeft++][downRight]);
            }
            return;
        }

        //方框旋转
        int tempRight = upRight;
        while(upRight < downRight){
            res.add(matrix[upLeft][upRight++]);
        }

        int tempLeft = upLeft;
        while(upLeft < downLeft){
            res.add(matrix[upLeft++][upRight]);
        }

        while(downRight > tempRight){
            res.add(matrix[downLeft][downRight--]);
        }

        while(downLeft > tempLeft){
            res.add(matrix[downLeft--][downRight]);
        }

    }

}
