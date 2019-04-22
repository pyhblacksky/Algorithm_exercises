package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/22 11:28
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 */
public class Solution367_有效的完全平方数 {
    //一般方法，从头遍历到中间
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        if(num == 0){
            return false;
        }
        for(int i = 0; i <= num/2; i++){
            if(i*i == num){
                return true;
            }
        }
        return false;
    }


    //完全平方数肯定是前n个连续奇数的和
    public boolean isPerfectSquare1(int num) {
        if(num == 1){
            return true;
        }
        if(num == 0){
            return false;
        }

        long sum = 0;
        long thread = (long)(num)*2 - 1;
        for(long i = 1; i <= thread; i = i + 2){
            sum += i;
            if(sum == num){
                return true;
            } else if(sum > num){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Solution367_有效的完全平方数 solution = new Solution367_有效的完全平方数();
        System.out.println(solution.isPerfectSquare1(2147395600));
    }
}
