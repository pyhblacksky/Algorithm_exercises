package Java刷题模板.面试笔试模板;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/30 14:42
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 *  题目：
 *      给定一个N阶矩阵A，输出A的M次幂（M是非负整数）
 *
 *  输入：
 *  第一行是一个正整数N、M(1 <= N <= 30, 0 <= M <= 5)  表示矩阵的阶数和要求幂数
 *  接下来N行，每行N个绝对值不超过10的非负整数，描述矩阵A的值
 *
 *  输出
 *  输出共N行，每行N个整数，表示A的M次幂 所对应的 矩阵，相邻的数只见那用一个空格隔开
 *
 *  样例输入
 *  2 2
 *  1 2
 *  3 4
 *
 *  样例输出
 *  7 10
 *  15 22
 */
public class 矩阵快速幂 {

    /**
     * 矩阵的乘法必须满足第一个矩阵的列 = 第二个矩阵的行；
     * 矩阵的求幂必须满足矩阵是一个方阵；
     * */

    static class Matrix{
        public int row;
        public int col;
        public int[][] m;

        public Matrix(int row, int col){
            this.row = row;
            this.col = col;

            m = new int[row][col];
        }
    }

    //两个矩阵相加，a，b必须为同型矩阵
    static Matrix add(Matrix a, Matrix b){
        if(a.col != b.col || a.row != b.row){
            throw new IllegalArgumentException("a， b 必须为同型矩阵");
        }

        Matrix c = new Matrix(a.row, a.col);
        for(int i = 0; i < a.row; i++){
            for(int j = 0; j < a.col; j++){
                c.m[i][j] = a.m[i][j] + b.m[i][j];
            }
        }
        return c;
    }

    //矩阵相乘， 必须满足 a.col = b.row 才能相乘
    static Matrix mul(Matrix a, Matrix b){
        if(a.col != b.row){
            throw new IllegalArgumentException("col != row !");
        }

        Matrix c = new Matrix(a.row, b.col);
        for(int i = 0; i < a.row; i++){
            for(int j = 0; j < b.col; j++){
                for(int k = 0; k < a.col; k++){
                    c.m[i][j] = c.m[i][j] + a.m[i][k] * b.m[k][j];
                }
            }
        }
        return c;
    }

    //必须为方阵才能求幂
    static Matrix pow(Matrix a, int n){ //矩阵a 的k次幂
        if(a.col != a.row){
            throw new IllegalArgumentException("矩阵不是方阵，无法求幂");
        }

        Matrix res = new Matrix(a.row, a.col);
        //矩阵初始化
        for(int i = 0; i < a.row; i++){
            res.m[i][i] = 1;//对角线为1， 为单位阵，即  I
        }

        //真正的快速幂
        while(n > 0){
            if((n & 1) != 0){
                res = mul(res, a);
            }
            a = mul(a, a);
            n >>= 1;
        }
        return res;
    }

    //测试方法
    public static void main(String[] args){
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        int n = cin.nextInt();
        int m = cin.nextInt();

        Matrix a = new Matrix(n,n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a.m[i][j] = cin.nextInt();
            }
        }

        Matrix res = pow(a, m);
        printMatrix(res);
    }

    static void printMatrix(Matrix a){
        for(int i = 0; i < a.row; i++){
            for(int j = 0; j < a.col; j++){
                System.out.print(a.m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
