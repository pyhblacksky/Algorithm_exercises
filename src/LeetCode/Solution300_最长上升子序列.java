package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/25 9:03
 * @Version: 1.0
 * @Function:
 * @Description:
 * 实际就是求最长递增子序列
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Solution300_最长上升子序列 {

    //O(N^2)的方法
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int res = 1;
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    //O(n logN) 的算法
    public int lengthOfLIS1(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int[] ends = new int[n+1];
        dp[0] = 1;
        nums[1] = nums[0];
        int right = 1;
        int L, mid, R;
        for(int i = 0; i < n; i++){
            L = 1;
            R = right;
            while(L <= R){
                mid = L + (R - L)/2;
                if(ends[mid] > nums[i]){
                    R = mid-1;
                } else{
                    L = mid+1;
                }
            }

            if(L > right){
                dp[i] = right+1;
                ends[right+1] = nums[i];
                right++;
            } else{
                dp[i] = right;
                ends[L] = nums[i];
            }
        }

        return right;
    }

    //测试方法
    public static void main(String[] args){
        Solution300_最长上升子序列 solution = new Solution300_最长上升子序列();
        int[] arr = {10,9,2,5,3,7,101,18};
        solution.lengthOfLIS1(arr);
    }

}
