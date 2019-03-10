package HDU_OJ;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/3/4 15:59
 * @Version 1.0
 * @Function:   动态规划相关题目
 *
 * 问题描述
 * 许多年前，在泰迪的家乡，有一个人被称为“骨头收藏家”。
 * 这个男人喜欢收集各种各样的骨头，比如狗狗，牛，还有他去了坟墓......
 * 骨头收集器有一个大容量V的袋子，沿着他的收集之旅有很多骨头，显然，不同的骨骼具有不同的值和不同的体积，
 * 现在根据他的行程给出每个骨骼的值，你能计算出骨骼采集器可以得到的总值的最大值吗？
 *
 * 输入
 * 第一行包含整数T，个案数。
 * 接下来是T个案例，每个案例有三行，
 * 第一行包含两个整数N，V，（N <= 1000，V <= 1000）表示骨骼的数量和他的包的体积。
 * 第二行包含表示每个骨骼值的N个整数。
 * 第三行包含表示每个骨骼体积的N个整数。
 *
 * 输出
 * 每行一个整数，表示总值的最大值（此数字将小于2 31）。
 *
 * 样本输入
 * 1
 * 5 10
 * 1 2 3 4 5
 * 5 4 3 2 1
 *
 * 样本输出
 * 14
 */
public class HDU2602_BoneCollector {

    //标准01背包问题
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int T = scan.nextInt();
            while(T > 0){
                T--;
                int N = scan.nextInt();//表示骨头数
                int V = scan.nextInt();//表示包的容量
                int[] val = new int[N];
                for(int i = 0; i < N; i++){//价值
                    val[i] = scan.nextInt();
                }
                int[] volume = new int[N];
                for(int i = 0; i < N; i++){//每个骨头的容量
                    volume[i] = scan.nextInt();
                }
                /************************************************/
                //数据录入结束

                int[] dp = new int[V+1];
                for(int i = 0; i < N; i++){
                    for(int j = V; j >= volume[i]; j--){
                        dp[j] = Math.max(dp[j], dp[j-volume[i]] + val[i]);
                    }
                }

                System.out.println(dp[V]);
            }
        }
    }

}
