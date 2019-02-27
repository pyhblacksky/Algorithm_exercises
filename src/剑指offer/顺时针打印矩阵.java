package 剑指offer;

import java.util.ArrayList;

import static 剑指offer.Tools.printArrList;

/**
 * @Author: pyh
 * @Date: 2019/2/17 20:05
 * @Version 1.0
 * @Function:
 *      输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *      例如，如果输入如下4 X 4矩阵：
 *      1 2 3 4
 *      5 6 7 8
 *      9 10 11 12
 *      13 14 15 16
 *      则依次打印出数字
 *      1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 *      思想：定位两个角的坐标进行打印，注意只有单行和单列的情况
 */
public class 顺时针打印矩阵 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }

        int uL = 0;
        int uR = 0;
        int dL = matrix.length-1;
        int dR = matrix[0].length-1;
        while(uL <= dL && uR <= dR){
            help(matrix, uL++, uR++, dL--, dR--, res);
        }
        return res;
    }

    private static void help(int[][] matrix, int upLeft, int upRight, int downLeft, int downRight, ArrayList<Integer> res){

        //只有一行
        if(upLeft == downLeft){
            for(int i = upRight; i <= downRight; i++){
                res.add(matrix[upLeft][i]);
            }
            return;
        }

        //只有一列
        if(upRight == downRight){
            for(int i = upLeft; i <= downLeft; i++){
                res.add(matrix[i][downRight]);
            }
            return;
        }

        int uL = upLeft;
        int uR = upRight;
        while(upRight < downRight){
            res.add(matrix[upLeft][upRight++]);
        }

        while(upLeft < downLeft){
            res.add(matrix[upLeft++][upRight]);
        }
        while(downRight > uR){
            res.add(matrix[downLeft][downRight--]);
        }
        while(downLeft > uL){
            res.add(matrix[downLeft--][downRight]);
        }

    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4,5},
                {2,4,6,8,10},
                {3,6,9,12,15},
                {4,8,12,16,20},
                {5,10,15,20,25},
                {6,12,18,24,30}};

        int[][] matrix1 = {{1},{2},{3}};

        int[][] matrix2 = {{1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};

        int[][] matrix3 = {{1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}};

        ArrayList<Integer> res = printMatrix(matrix);
        printArrList(res);

        res = printMatrix(matrix1);
        printArrList(res);

        res = printMatrix(matrix2);
        printArrList(res);

        res = printMatrix(matrix3);
        printArrList(res);
    }

}
