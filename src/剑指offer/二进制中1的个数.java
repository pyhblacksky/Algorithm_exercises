package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/16 21:00
 * @Version 1.0
 * @Function:
 *      输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 *      思路： 用 n & (n-1)计算个数
 */
public class 二进制中1的个数 {

    public static int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            n = (n-1) & n;
            count++;
        }
        return count;
    }

    //错解：如果为负数，则陷入无限循环中,改为无符号右移
    public static int NumberOf1_w1(int n) {
        int res = 0;
        while(n>>>1 != 0){
            if((n & 1) == 1){
                res++;
            }
            n = n>>>1;
        }
        if((n & 1) == 1){
            res++;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(NumberOf1(-7));
    }

}
