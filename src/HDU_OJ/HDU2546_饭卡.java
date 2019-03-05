package HDU_OJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/3/4 11:11
 * @Version 1.0
 * @Function:       HDU2546
 *
 * Problem Description
 * 电子科大本部食堂的饭卡有一种很诡异的设计，即在购买之前判断余额。如果购买一个商品之前，卡上的剩余金额大于或等于5元，就一定可以购买成功（即使购买后卡上余额为负），否则无法购买（即使金额足够）。所以大家都希望尽量使卡上的余额最少。
 * 某天，食堂中有n种菜出售，每种菜可购买一次。已知每种菜的价格以及卡上的余额，问最少可使卡上的余额为多少。
 *
 *
 * Input
 * 多组数据。对于每组数据：
 * 第一行为正整数n，表示菜的数量。n<=1000。
 * 第二行包括n个正整数，表示每种菜的价格。价格不超过50。
 * 第三行包括一个正整数m，表示卡上的余额。m<=1000。
 *
 * n=0表示数据结束。
 *
 *
 * Output
 * 对于每组输入,输出一行,包含一个整数，表示卡上可能的最小余额。
 *
 *
 * Sample Input
 * 1
 * 50
 * 5
 * 10
 * 1 2 3 2 1 1 2 3 2 1
 * 50
 * 0
 *
 *
 * Sample Output
 * -45
 * 32
 *
 */
public class HDU2546_饭卡 {
/**
 * 很经典的一道01背包题，要注意的是这里只要剩余的钱不低于5元，就可以购买任何一件物品，
 * 所以5在这道题中是很特许的，再使用01背包之前，我们首先要在现在所拥有的余额中保留5元，
 * 用这五元去购买最贵的物品，而剩下的钱就是背包的总容量，可以随意使用，因此可得代码
 * */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt(); //菜的数量
            if(n == 0){ //输入0表示数据结束
                break;
            }
            //每个菜的价格
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scan.nextInt();
            }
            int m = scan.nextInt();//m表示卡上的余额
            //卡上余额大于等于5，即可购买
            if(m >= 5){
                m = m - 5;//减5
                int[] dp = new int[m+1];
                //找出arr最大值
                Arrays.sort(arr);
                int max = arr[arr.length-1];
                //取出最贵的东西
                for(int i = 0; i < n-1; i++){
                    for(int j = m; j >= arr[i]; j--){
                        dp[j] = Math.max(dp[j], dp[j-arr[i]] + arr[i]);
                    }
                }

                //余额最少
                System.out.println(m + 5 - dp[m] - max);
            } else{
                //否则，输出卡余额
                System.out.println(m);
            }
        }
        scan.close();
    }

}
