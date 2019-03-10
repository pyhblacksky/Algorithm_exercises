package HDU_OJ;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/3/4 21:02
 * @Version 1.0
 * @Function:       动态规划相关题目
 *
 * 问题描述
 * 最近，iSea去了一个古老的国家。在这么长的时间里，它是世界上最富裕，最强大的王国。
 * 结果，这个国家的人民仍然非常自豪，即使他们的国家不再那么富裕。
 * 商家是最典型的，每个商品只出售一件商品，价格是Pi，
 * 但如果你的钱少于Qi，他们会拒绝与你交易，而iSea评估每件商品的价值为Vi。
 * 如果他有M单位的钱，那么iSea可以获得的最大价值是多少？
 *
 *
 * 输入
 * 输入中有几个测试用例。
 *
 * 每个测试用例以两个整数N，M（1≤N≤500,1≤M≤5000）开始，表示项目的编号和初始资金。
 * 然后是N行，每行包含三个数字Pi，Qi和Vi（1≤Pi≤Qi≤100,1≤Vi≤1000），它们的含义在描述中。
 *
 * 输入终止于文件结束标记。
 *
 *
 * 输出
 * 对于每个测试用例，输出一个整数，表示iSea可以得到的最大值。
 *
 * 样本输入
 * 2 10
 * 10 15 10
 * 5 10 5
 * 3 10
 * 5 10 5
 * 3 5 6
 * 2 7 3
 *
 *
 * 样本输出
 * 5
 * 11
 */
public class HDU3466_ProudMerchants {

    //01背包问题扩展
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()){
            int N = scan.nextInt();//项目数量
            int M = scan.nextInt();//初始资金
            int[] p = new int[N];
            int[] q = new int[N];
            int[] v = new int[N];
            for(int i = 0; i < N; i++){
                p[i] = scan.nextInt();
                q[i] = scan.nextInt();
                v[i] = scan.nextInt();
            }
            /*****************************************/
            //数据输入完毕
           //排序
            for(int i = 1; i < N; i++){
                for(int j = i; j > 0; j--){
                    if(q[j] - p[j] < q[j-1] - p[j-1]){
                        exch(q, j, j-1);
                        exch(p, j , j-1);
                        exch(v, j , j-1);
                    }
                }
            }

            int[][] dp = new int[N+1][M+1];
            for(int i = 1; i <= N; i++){
                for(int j = M; j >= q[i-1]; j--){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - p[i - 1]] + v[i - 1]);
                }
            }
            System.out.println(dp[N][M]);
        }
        scan.close();
    }

    public static void exch(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
