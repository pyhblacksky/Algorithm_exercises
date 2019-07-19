package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/2/23 16:03
 * @Version 1.0
 * @Function:   53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution53_最大子序和 {

    public int maxSubArray(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int res = nums[0];
        int sum = 0;
        for(int num : nums){
            if(sum > 0){
                sum += num;
            } else{
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    //动态规划
    public int maxSubArray1(int[] nums) {
        //保存两个值，一个局部最大值，一个全局最大值
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int maxLocal = Integer.MIN_VALUE;
        int maxGlobal = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            for(int j = i+1; j < nums.length; j++){
                maxLocal = Math.max(maxLocal, temp);
                temp += nums[j];
            }
            maxGlobal = Math.max(temp, Math.max(maxGlobal, maxLocal));
        }
        return maxGlobal;
    }

    //dp动态规划
    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;

            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            int max = dp[0];
            for(int i = 1; i < n; i++){
                dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
                max = Math.max(dp[i], max);
            }

            return max;
        }
    }

}
