package 校招真题_2018.拼多多_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/7 15:38
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 *  有n只小熊，他们有着各不相同的战斗力。每次他们吃糖时，会按照战斗力来排，战斗力高的小熊拥有优先选择权。
 *  前面的小熊吃饱了，后面的小熊才能吃。每只小熊有一个饥饿值，每次进食的时候，
 *  小熊们会选择最大的能填饱自己当前饥饿值的那颗糖来吃，可能吃完没饱会重复上述过程，但不会选择吃撑。
 *  现在给出n只小熊的战斗力和饥饿值，并且给出m颗糖能填饱的饥饿值。
 *  求所有小熊进食完之后，每只小熊剩余的饥饿值。
 *
 *
 * 输入描述:
 *  第一行两个正整数n和m，分别表示小熊数量和糖的数量。（n <= 10, m <= 100）
 *  第二行m个正整数，每个表示着颗糖能填充的饥饿值。
 *  接下来的n行，每行2个正整数，分别代表每只小熊的战斗力和当前饥饿值。
 *  题目中所有输入的数值小于等于100。
 *
 * 输出描述:
 *  输出n行，每行一个整数，代表每只小熊剩余的饥饿值
 *
 * 示例1
 *
 * 输入
 * 2 5
 * 5 6 10 20 30
 * 4 34
 * 3 35
 *
 * 输出
 * 4
 * 0
 *
 * 说明
 * 第一只小熊吃了第5颗糖
 * 第二只小熊吃了第4颗糖
 * 第二只小熊吃了第3颗糖
 * 第二只小熊吃了第1颗糖
 */
public class 小熊吃糖 {

    //类似01背包问题
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[] bag = new int[m];
        for(int i = 0; i < m; i++){
            bag[i] = cin.nextInt();
        }

        int[][] bear = new int[n][2];
        for(int i = 0; i < n; i++){
            bear[i][0] = cin.nextInt();
            bear[i][1] = cin.nextInt();
        }

        int[] res = eatCanny(bag, bear);
        printArr(res);
    }

    static int[] eatCannyOne(int[] volume, int[][] bear){
        //排序,熊的优先级排序
        Arrays.sort(bear, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];//战斗力降序
            }
        });

        int[] res = new int[bear.length];

        return null;
    }
    
    //01背包，理解错误
    static int[] eatCanny(int[] volume, int[][] bear){
        //排序,熊的优先级排序
        Arrays.sort(bear, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];//战斗力降序
            }
        });

        int[] res = new int[bear.length];
        //5 6 10 20 30  价值
        //bear[][1]表示背包容量
        for(int i = 0; i < bear.length; i++){
            int V = bear[i][1];
            int N = volume.length;
            int[] dp = new int[V+1];
            for(int j = 0; j < N; j++){
                for(int k = V; k >= volume[j]; k--){
                    dp[k] = Math.max(dp[k], dp[k-volume[j]]+volume[j]);
                }
            }
            res[i] = V - dp[V];//容量减去最大可吃
            //吃过的把它容量赋值为0
            int[] arr = findDpArr(dp);
            changeVol(volume, arr);
        }

        return res;
    }

    static int[] findDpArr(int[] dp){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1; i < dp.length; i++){
            int sub = dp[i] - dp[i-1];
            if(sub > 0){
                temp.add(sub);
            }
        }

        int[] res = new int[temp.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = temp.get(i);
        }

        return res;
    }

    static void changeVol(int[] vol, int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < vol.length ;j++){
                if(arr[i]  == vol[j]){
                    vol[j] = 0;
                    break;
                }
            }
        }
    }

    static void printArr(int[] arr){
        for(int num : arr){
            System.out.println(num);
        }
    }
}
