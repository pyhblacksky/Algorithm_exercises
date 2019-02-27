package 校招真题_2018.网易_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/15 20:01
 * @Version 1.0
 * @Function:
 *      独立的小易
 *      小易手中已经有
 *      f个水果   d元钱
 *      每天必须吃一个水果 且需要每天支付x元
 *      商店每个水果售卖p元
 *
 *      输入包括一行,四个整数x, f, d, p(1 ≤ x,f,d,p ≤ 2 * 10^9),以空格分割
 *
 *      思考：
 *      只有两种情况,已有水果个数比现有的钱除以房钱的次数多，此时以开房天数来算，
 *      否则，就把水果卖了换钱，再用钱除以水果单价加房钱总和
 */
public class self_help_Yi {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            long x = scan.nextInt();
            long f = scan.nextInt();
            long d = scan.nextInt();
            long p = scan.nextInt();

            long day = 0;
            if(f >= d/x){
                day = d/x;
            } else{
                d += p*f;
                day = d/(x+p);
            }
            System.out.println(day);
        }
        scan.close();
    }

}
