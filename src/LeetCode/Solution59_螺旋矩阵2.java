package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/19 16:59
 * @Version 1.0
 * @Function:
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Solution59_螺旋矩阵2 {
    public int[][] generateMatrix(int n) {
        if(n <= 0){
            return null;
        }
        int[][] res = new int[n][n];

        //从两个角开始
        int upLeft = 0;
        int upRight = 0;
        int downLeft = res.length-1;
        int downRight = res[downLeft].length - 1;
        int count = 1;
        while(upLeft <= downLeft && upRight <= downRight){
            count = help(res, upLeft++, upRight++, downLeft--, downRight--, count);
        }

        //printArr(res);
        return res;
    }

    //按照顺时针打印矩阵的思路
    //矩阵左上角的坐标(upLeft, upRight)， 右下角的坐标(downLeft, downRight)
    public static int help(int[][] matrix, int upLeft, int upRight, int downLeft, int downRight, int count){
        //此时只有一行
        if(upLeft == downLeft){
            matrix[upLeft][upRight++] = count++;
            return count;
        }

        //此时只有一列
        if(upRight == downRight){
            matrix[upLeft++][upRight] = count++;
            return count;
        }

        int uL = upLeft;
        int uR = upRight;

        //左到右
        while(upRight < downRight){
            matrix[upLeft][upRight++] = count++;
        }

        //上到下
        while(upLeft < downLeft){
            matrix[upLeft++][upRight] = count++;
        }

        //右到左
        while(downRight > uR){
            matrix[downLeft][downRight--] = count++;
        }

        //下到上
        while(downLeft > uL){
            matrix[downLeft--][downRight] = count++;
        }

        return count;
    }

    public static void printArr(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        Solution59_螺旋矩阵2 solution = new Solution59_螺旋矩阵2();
        solution.generateMatrix(4);
    }
}
