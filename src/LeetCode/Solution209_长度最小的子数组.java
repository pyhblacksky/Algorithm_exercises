package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/22 20:31
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Solution209_长度最小的子数组 {
    //滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        int k = 0;
        int sum = 0;
        int min = nums.length+1;  // set a maximum value
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                // try to reduce difference between i and k
                while((sum-nums[k]) >= s) {
                    sum -= nums[k];
                    k++;
                }
                if ((i-k+1) < min) {
                    min = (i-k+1);  // update minimum value
                }
            }
        }
        return (min == nums.length+1)? 0: min;
    }

    public static void main(String[] args){
        Solution209_长度最小的子数组 solution = new Solution209_长度最小的子数组();
        int[] arr = new int[]{1,2,3,4,5};
        solution.minSubArrayLen(11, arr);
    }
}
