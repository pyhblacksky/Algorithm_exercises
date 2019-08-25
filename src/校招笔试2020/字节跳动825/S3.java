package 校招笔试2020.字节跳动825;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/25 19:20
 * @Version: 1.0
 * @Function:
 * @Description:
 * 2048小游戏，忽略随机生成的数
 * 100%
 */
public class S3 {

    //0224 4400
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int direction = sc.nextInt();
        int[][] arr = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        if(direction == 1){
            //上
            for(int j = 0; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    int k = i + 1;
                    while (k < 4 && arr[k][j] == 0) {
                        k++;
                    }
                    if (k >= 4)
                        break;
                    if (arr[i][j] == 0) {
                        arr[i][j] = arr[k][j];
                        arr[k][j] = 0;
                        i = i - 1;
                    } else if (arr[i][j] == arr[k][j]) {
                        arr[i][j] *= 2;
                        arr[k][j] = 0;
                    } else if(i+1 < arr.length && arr[i+1][j] == 0 && arr[k][j] != 0){
                        arr[i+1][j] = arr[k][j];
                        arr[k][j] = 0;
                    }
                }
            }

        } else if(direction == 2){
            //下
            for(int j = 0; j < 4; j++) {
                for (int i = 3; i >= 0; i--) {
                    int k = i - 1;
                    while (k >= 0 && arr[k][j] == 0) {
                        k--;
                    }
                    if (k < 0)
                        break;
                    if (arr[i][j] == 0) {
                        arr[i][j] = arr[k][j];
                        arr[k][j] = 0;
                        i = i + 1;
                    } else if (arr[i][j] == arr[k][j]) {
                        arr[i][j] *= 2;
                        arr[k][j] = 0;
                    } else if(i-1 >= 0 && arr[i-1][j] == 0 && arr[k][j] != 0){
                        arr[i-1][j] = arr[k][j];
                        arr[k][j] = 0;
                    }
                }
            }

        } else if(direction == 3){
            //左
            for(int j = 0; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    int k = i + 1;
                    while (k < 4 && arr[j][k] == 0) {
                        k++;
                    }
                    if (k >= 4)
                        break;
                    if (arr[j][i] == 0) {
                        arr[j][i] = arr[j][k];
                        arr[j][k] = 0;
                        i = i - 1;
                    } else if (arr[j][i] == arr[j][k]) {
                        arr[j][i] *= 2;
                        arr[j][k] = 0;
                    } else if(i+1 < arr.length && arr[j][i+1] == 0 && arr[j][k] != 0){
                        arr[j][i+1] = arr[j][k];
                        arr[j][k] = 0;
                    }
                }
            }

        } else if(direction == 4){
            //右
            for(int j = 0; j < 4; j++) {
                for (int i = 3; i >= 0; i--) {
                    int k = i - 1;
                    while (k >= 0 && arr[j][k] == 0) {
                        k--;
                    }
                    if (k < 0)
                        break;
                    if (arr[j][i] == 0) {
                        arr[j][i] = arr[j][k];
                        arr[j][k] = 0;
                        i = i + 1;
                    } else if (arr[j][i] == arr[j][k]) {
                        arr[j][i] *= 2;
                        arr[j][k] = 0;
                    } else if(i-1 >= 0 && arr[j][i-1] == 0 && arr[j][k] != 0){
                        arr[j][i-1] = arr[j][k];
                        arr[j][k] = 0;
                    }
                }
            }
        }

        printArr(arr);
    }
    static void printArr(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(j == arr.length-1){
                    System.out.print(arr[i][j]);
                } else
                    System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }




    public static void main1(String[] args) {
        int[] a = {8,8,2,2};
        for(int i = 0; i < 4; i++){
            int k = i+1;
            while(k < 4 && a[k] == 0){
                k++;
            }
            if(k >= 4)
                break;
            if(a[i] == 0){
                a[i] = a[k];
                a[k] = 0;
                i = i-1;
            } else if(a[i] == a[k]){
                a[i] *= 2;
                a[k] = 0;
            } else if(i+1 < a.length && a[i+1] == 0 && a[k] != 0){
                a[i+1] = a[k];
                a[k] = 0;
            } else
                break;
        }

        System.out.println(a);
    }
}
