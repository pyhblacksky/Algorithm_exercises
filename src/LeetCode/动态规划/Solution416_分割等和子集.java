package LeetCode.动态规划;

/**
 * @Author: pyh
 * @Date: 2019/3/2 9:30
 * @Version 1.0
 * @Function:   416、分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class Solution416_分割等和子集 {

    //方法一：深搜
    public boolean canPartition(int[] nums){
        if(nums == null || nums.length <= 1){
            return false;
        }

        //计算数组和，为奇数必然不行，偶数，后序验证
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1){return false;}

        //数组中的部分和是否等于此
        sum = sum/2;

        return subsetSum(nums, sum);
    }
    private boolean subsetSum(int[] nums, int s){
        boolean[] dp = new boolean[s+1];
        dp[0] = true;
        for(int n : nums){
            for(int i = s; i >= n; i--){
                dp[i] = dp[i] || dp[i-n];
            }
            if(dp[s]){
                return true;
            }
        }
        return dp[s];
    }

    //方法二：01背包问题，动态规划
    public boolean canPartition1(int[] nums){
        if(nums == null || nums.length <= 1){
            return false;
        }

        //计算数组和，为奇数必然不行，偶数，后序验证
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1){return false;}

        //数组中的部分和是否等于此
        sum = sum/2;

        //dp
        int[] dp = new int[sum+1];
        for(int i = 0; i < nums.length; i++){
            for(int j = sum; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        if(dp[sum] == sum){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        int[] arr = {7,6,5,4,3,2,1};
    }
}
