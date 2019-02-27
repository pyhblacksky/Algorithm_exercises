package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/2/25 14:31
 * @Version 1.0
 * @Function:   69、x的平方根
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Solution69_x的平方根 {

    //不使用库函数
    //牛顿迭代法求平方根   x - f(x)/f'(x)   求平方根中 f(x) = x^2 - a  就是求这个方程的解   就是求a的立方根
    public int mySqrt(int x) {
        if(x == 1){
            return 1;
        }
        long res = x;//指定起始点
        //确定收敛条件  注意考虑一些限定条件：如输入为0， Integer.MAX_VALUE。溢出
        while(res != 0 && res > x/res){
            res = (res + x/ res)/2;//为了防止溢出
        }
        return (int)res;
    }

    public static void main(String[] args){
        Solution69_x的平方根 solution69 = new Solution69_x的平方根();
        int a = solution69.mySqrt(2147395600);
        System.out.println(a);
    }
}
