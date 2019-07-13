package 公司题.字节跳动;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/7/12 10:21
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。
 * 现在小Y使用1024元的纸币购买了一件价值为的商品，请问最少他会收到多少硬币？
 *
 * 输入描述:
 * 一行，包含一个数N。
 *
 * 输出描述:
 * 一行，包含一个数，表示最少收到的硬币数。
 *
 * 输入例子1:
 * 200
 *
 * 输出例子1:
 * 17
 *
 * 例子说明1:
 * 花200，需要找零824块，找12个64元硬币，3个16元硬币，2个4元硬币即可。
 */
public class 零钱 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = getRes(n);
        System.out.println(res);
    }

    static int getRes(int amount){
        amount = amount % 1024;
        if(amount == 0){
            return 0;
        }
        int[] coins = {1,4,16,64};
        amount = 1024 - amount;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 0; i <= amount; i++){
            for(int coin : coins){
                if(i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        return dp[amount] >= amount+1 ? -1 : dp[amount];
    }

}
