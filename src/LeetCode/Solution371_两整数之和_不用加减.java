package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/28 9:04
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 */
public class Solution371_两整数之和_不用加减 {

    public int getSum(int a, int b) {
        int p = a ^ b;
        int q = (a&b) << 1;
        while(q != 0){
            int temp = p;
            p = p ^ q;
            q = (temp & q) << 1;
        }
        return p;
    }

}
