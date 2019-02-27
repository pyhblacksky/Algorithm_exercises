package 剑指offer.水题;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/16 9:57
 * @Version 1.0
 * @Function:
 *      二维数组中的查找
 *      在一个二维数组中（每个一维数组的长度相同），
 *      每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *      请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *      解决思路：
 *      从右上角,或者任意一角开始查找
 */
public class 二维数组中的查找 {

    //最优方法
    public static boolean Find(int target, int[][] array){

        if(array == null || array.length == 0 || array[0].length == 0){
            return false;
        }

        int row = 0;
        int col = array[0].length-1;
        while(row < array.length && col >= 0){
            if(target == array[row][col]){
                return true;
            } else if(array[row][col] > target){
                col--;
            } else{
                row++;
            }
        }
        return false;
    }

    //以下均为测试

    /******************************************************************************************************************/

    //方法1，递归
    public static boolean Find1(int target, int [][] array) {
        if(array == null || array.length == 0 || array[0].length == 0){
            return false;
        }

        return Find1(target, array, array.length-1, array[0].length-1);
    }
    private static boolean Find1(int target, int[][] array, int i, int j){
        if(i >= 0 && i < array.length && j >= 0 && j < array[i].length){
            if(array[i][j] == target){
                return true;
            } else if(array[i][j] > target && i-1 >= 0 && j-1 >= 0){
                boolean r1 = Find1(target, array, i, j-1);
                return r1;
            } else if(array[i][j] < target && i+1 < array.length && j+1 < array[0].length){
                boolean r2 = Find1(target, array, i+1, j);
                return r2;
            } else{
                return false;
            }
        } else{
            return false;
        }
    }

    public static void main2(String[] args){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    matrix[i][j] = scan.nextInt();
                }
            }
            int target = scan.nextInt();
            System.out.println(Find(target, matrix));
        }
        scan.close();
    }

    //测试专用
    public static void main(String[] args){
        int target = 7;

        int[][] matrix = {{1,2,3,4,5},
                {2,4,6,8,10},
                {3,6,9,12,15},
                {4,8,12,16,20},
                {5,10,15,20,25},
                {6,12,18,24,30}};
        System.out.println(Find(target, matrix));

        for(int i = 0; i < 10; i++){
            int[][] temp = randomArr();
            printArr(temp);
            System.out.println(Find(target, temp));
        }

    }

    static void printArr(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //产生随机矩阵
    public static int[][] randomArr(){
        Random random = new Random();
        int n = Math.abs(random.nextInt(10));
        int m = Math.abs(random.nextInt(10));
        int[][] res = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                res[i][j] = (i+1)*(j+1);
            }
        }
        return res;
    }
}
