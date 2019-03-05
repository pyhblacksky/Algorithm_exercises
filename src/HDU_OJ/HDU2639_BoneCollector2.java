package HDU_OJ;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/3/4 16:42
 * @Version 1.0
 * @Function:
 *
 * 今天我们不希望骨头的最大值，但是K的最大值bones.NOTICE，我们考虑两种获得相同骨骼值的方法是相同的。
 * 这意味着，它将是从第1个最大值，第2个最大值到第K个最大值的严格递减序列。
 *
 * 如果不同值的总数小于K，则输出0。
 *
 * 输入
 * 第一行包含整数T，个案数。
 * 接下来是T个案例，每个案例有三行，第一行包含两个整数N，V，K（N <= 100，V <= 1000，K <= 30），
 * 表示骨头的数量和他的包的体积和我们需要K. 第二行包含表示每个骨骼值的N个整数。第三行包含表示每个骨骼体积的N个整数。
 *
 *
 * 输出
 * 每行一个整数，表示总值的第K个最大值（该数字将小于2 31）。
 *
 *
 * 样本输入
 * 3
 * 5 10 2
 * 1 2 3 4 5
 * 5 4 3 2 1
 * 5 10 12
 * 1 2 3 4 5
 * 5 4 3 2 1
 * 5 10 16
 * 1 2 3 4 5
 * 5 4 3 2 1
 *
 *
 * 样本输出
 * 12
 * 2
 * 0
 *
 */
public class HDU2639_BoneCollector2 {

    /**
     * 没有编写完成
     * */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int T = scan.nextInt();
            while(T > 0){
                T--;
                int N = scan.nextInt();//个数
                int V = scan.nextInt();//体积
                int K = scan.nextInt();//第K个
                int[] val = new int[N];//价值
                for(int i = 0; i < N; i++){
                    val[i] = scan.nextInt();
                }
                int[] volume = new int[N];
                for(int i = 0; i < N; i++){
                    volume[i] = scan.nextInt();
                }
                /*********************************************/
                //数据读取完毕

                int[][] dp = new int[N+1][V+1];
                for(int i = 1; i <= N; i++){
                    for(int j = V; j >= volume[i-1]; j--){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - volume[i-1]] + val[i-1]);
                    }
                }

                //s????
            }
        }
    }

}
