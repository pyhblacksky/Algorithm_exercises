package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/16 21:24
 * @Version 1.0
 * @Function:
 *      给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 *      二分快速幂是一种利用b的二进制特征来快速求a^b的算法。
 *      例如：
 *      a = 2, b = 35
 *      则b的二进制表示形式为100011
 *      则 a^b = (2^32) * (2^2) * (2^1)
 *      有了这样的思路之后，就不用循环b次了。
 */
public class 数值的整数次方 {

    //正确解法：利用快速幂
    public double Power(double base, int exponent) {
        double res = 1.0;
        double cur = base;
        int n = 0;
        if(exponent > 0){
            n = exponent;
        } else if(exponent < 0){
            if(base == 0){
                throw new ArithmeticException("分母不能为0");
            }
            n = -exponent;
        } else{
            return res;
        }

        while(n != 0){
            if((n&1) == 1){
                res *= cur;
            }
            cur *= cur;//翻倍
            n >>= 1;
        }
        return exponent > 0 ? res : 1/res;
    }


    //利用现有函数
    public double Power1(double base, int exponent) {
        return Math.pow(base, exponent);
    }

}
