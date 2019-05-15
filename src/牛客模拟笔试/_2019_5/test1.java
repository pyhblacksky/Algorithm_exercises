package 牛客模拟笔试._2019_5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/15 21:09
 * @Version: 1.0
 * @Function:
 * @Description:
 *  扑克牌问题
 */
public class test1 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int[] num = new int[14];
        int[] accum = new int[14];
        int sum = 0, dif = 0, temp = 0;

        Arrays.fill(num, 1, 14, 4);//13个数字，每个数字4张
        for(int i = 0; i < 6; ++i){
            temp = sc.nextInt();
            num[temp]--;
            dif += (i < 3 ? temp : -temp);//计算已知6张后，两边的数字和之差
        }

        for(int i = 1; i < 14; ++i){
            accum[i] = accum[i-1] + num[i];//accum[i] : 6张外小于等于i的牌的张数
        }

        if(dif > 0){
            //dif大于0，减去牛牛拿的最后一张
            for(int i = 1; i < 14; ++i){
                sum += (accum[Math.min(13,i+dif-1)] - 1) * num[i];
            }
        } else{
            //dif小于等于0，不考虑最后一张
            for(int i = 1; i < 14; ++i){
                sum += accum[Math.max(0, i+dif -1)] * num[i];
            }
        }

        double res = (double) sum / (45*46);
        System.out.println(convert(res));
    }

    //保留4位小数
    private static String convert(double num){
        StringBuilder sb = new StringBuilder("0.");
        String str = String.valueOf(num);
        sb.append(str.charAt(2));
        sb.append(str.charAt(3));
        sb.append(str.charAt(4));
        sb.append(str.charAt(5));

        return sb.toString();
    }
}
