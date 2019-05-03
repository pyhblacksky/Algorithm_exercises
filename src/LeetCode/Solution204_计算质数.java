package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/30 8:51
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 */
public class Solution204_计算质数 {

    //埃式筛法
    public int countPrimes(int n) {
        int count = 0;
        boolean[] is_prime = new boolean[n];
        for(int i = 2; i < n; i++){
            if(!is_prime[i]){
                count++;

                for(int j = i * 2; j < n; j += i){
                    is_prime[j] = true;
                }
            }
        }
        return count;
    }

}
