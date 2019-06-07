package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/5 8:32
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
 *  本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class Solution29_两数相除 {
    public int divide(int dividend, int divisor) {
        //记录符号位
        int sign = 0;
        //处理掉特殊情况
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if(divisor == 1)
            return dividend;
        //确定符号位
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        //所有数据转换为 负数 处理  ----- 因为正数转换为负数不会出现溢出
        dividend = dividend < 0 ? dividend : 0 - dividend;
        divisor = divisor < 0 ? divisor : 0 - divisor;
        //递归算数
        int res = rec(dividend,divisor);
        return sign < 0 ? res : 0 - res;

    }
    public int rec(int dividend, int divisor){
        //记录本次算得的 商 值
        int quo = 0;
        //递归终止条件,因为是负数, 所以采用 <=
        if(dividend <= divisor){
            quo --;
            dividend -= divisor;
            //每一次 除数 变为之前的二倍,变化之前需要考虑是否会越界
            if(Integer.MIN_VALUE - divisor < divisor){
                //记录当前的除数
                int temp = divisor + divisor;
                //记录当前的除数与原始的除数的倍数  -- 即 每次 商 的增加值
                int it = -2;
                while(dividend <= temp){
                    quo += it;
                    dividend -= temp;
                    //每一次 除数 变为之前的二倍,变化之前需要考虑是否会越界,如果越界,则跳出循环
                    if(Integer.MIN_VALUE - temp > temp)
                        break;
                    temp = temp + temp;
                    it = it + it;
                }
            }
            //递归算值, 除数变为初始值,重新计算
            quo += rec(dividend,divisor);
        }
        return quo;
    }
}
