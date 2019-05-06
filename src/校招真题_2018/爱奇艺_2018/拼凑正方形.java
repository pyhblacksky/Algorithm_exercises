package 校招真题_2018.爱奇艺_2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/6 20:33
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 牛牛有4根木棍,长度分别为a,b,c,d。羊羊家提供改变木棍长度的服务,
 * 如果牛牛支付一个硬币就可以让一根木棍的长度加一或者减一。
 * 牛牛需要用这四根木棍拼凑一个正方形出来,牛牛最少需要支付多少硬币才能让这四根木棍拼凑出正方形。
 *
 * 输入描述:
 * 输入包括一行,四个整数a,b,c,d(1 ≤ a,b,c,d ≤ 10^6), 以空格分割
 *
 * 输出描述:
 * 输出一个整数,表示牛牛最少需要支付的硬币
 * 示例1
 *
 * 输入
 * 4 1 5 4
 *
 * 输出
 * 4
 */
public class 拼凑正方形 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);

        int[] arr = new int[4];
        for(int i = 0; i < 4; i++){
            arr[i] = cin.nextInt();
        }

        System.out.println(getMinCoins(arr));

    }

    public static int getMinCoins(int[] arr){

        //查看4个数中的相等数的数量
        Arrays.sort(arr);
        int equalNum = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i-1]){
                equalNum = arr[i];
            }
        }

        int count = 0;
        if(equalNum != 0){
            //以equalNum为准
            for(int i = 0; i < arr.length; i++){
                count += Math.abs(equalNum-arr[i]);
            }
        } else{
            //以中间数为准
            int midNum = arr[1];
            for(int i = 0; i < arr.length; i++){
                count += Math.abs(midNum-arr[i]);
            }
        }

        return count;
    }
}
