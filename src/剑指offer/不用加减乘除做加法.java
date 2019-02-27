package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/19 16:22
 * @Version 1.0
 * @Function:
 *      写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class 不用加减乘除做加法 {

    //用 ^ 运算，再考虑进位采用&
    public static int Add(int num1,int num2) {
        int a = num1 ^ num2;
        int b = (num1&num2) << 1;
        while(b != 0){
            int temp = a;
            a = a ^ b;
            b = (temp & b) << 1;
        }
        return a;
    }


    public static void main(String[] args){
        System.out.println(Add(10,20));
    }

}
