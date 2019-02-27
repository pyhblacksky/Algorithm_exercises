package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/2/25 10:24
 * @Version 1.0
 * @Function: 50、Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 */
public class Solution50_Pow_x_n {

    /*
    * 特殊情况 : -1, -2147483648  1, -2147483648,  -2, -2147483648
    * 相应的返回值： 1， 1， 0
    * */

    //快速幂算法
    public double myPow(double x, int n) {
        //考虑特殊情况
        int exp = 0;
        if(x == 1){
            return 1;
        }
        if(n < 0){
            if(x == -1 && n == Integer.MIN_VALUE){
                return 1;
            }
            if(n == Integer.MIN_VALUE){
                return 0;
            }
            exp = -n;
            if(x == 0){
                throw new IllegalArgumentException("x == 0!");
            }
        } else if(n == 0){
            return 1;
        } else{
            exp = n;
        }

        double res = 1;
        double cur = x;
        while(exp != 0){
            if((exp & 1) == 1){
                res *= cur;
            }
            cur *= cur;
            exp >>= 1;
        }
        return n < 0 ? 1/res : res;
    }

}
