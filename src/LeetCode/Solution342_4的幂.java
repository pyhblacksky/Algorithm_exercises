package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/22 11:06
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 */
public class Solution342_4的幂 {
    public boolean isPowerOfFour(int num) {
        //二进制对应位上不为0，4的幂次说明二进制位有且只有一个1。
        return (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
