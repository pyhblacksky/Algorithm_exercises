package 校招真题_2018.爱奇艺_2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/6 19:58
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 牛牛举办了一场数字游戏,有n个玩家参加这个游戏,游戏开始每个玩家选定一个数,然后将这个数写在纸上(十进制数,无前缀零),然后接下来对于每一个数字将其数位按照非递减顺序排列,得到新的数,新数的前缀零将被忽略。得到最大数字的玩家赢得这个游戏。
 * 输入描述:
 * 输入包括两行,第一行包括一个整数n(1 ≤ n ≤ 50),即玩家的人数
 * 第二行n个整数x[i](0 ≤ x[i] ≤ 100000),即每个玩家写下的整数。
 * 输出描述:
 * 输出一个整数,表示赢得游戏的那个玩家获得的最大数字是多少。
 * 示例1
 *
 * 输入
 * 3
 * 9638 8210 331
 *
 * 输出
 * 3689
 */
public class 数字游戏 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = cin.nextInt();
        }
        System.out.println(getMax(nums));

    }

    public static int getMax(int[] arr){

        for(int i = 0; i < arr.length; i++){
            arr[i] = convert(arr[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int x : arr){
            max = Math.max(max, x);
        }

        return max;
    }

    public static int convert(int num){
        String str = String.valueOf(num);
        char[] ch = str.toCharArray();

        Arrays.sort(ch);
        int bit = 1;
        int res = 0;
        for(int i = ch.length-1; i >= 0; i--){
            res += bit*(ch[i]-'0');
            bit *= 10;
        }
        return res;
    }

}
