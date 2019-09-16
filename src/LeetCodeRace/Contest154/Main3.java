package LeetCodeRace.Contest154;

/**
 * @Author: pyh
 * @Date: 2019/9/15 10:06
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给你一个整数数组 arr 和一个整数 k。
 *
 * 首先，我们要对该数组进行修改，即把原数组 arr 重复 k 次。
 *
 * 举个例子，如果 arr = [1, 2] 且 k = 3，那么修改后的数组就是 [1, 2, 1, 2, 1, 2]。
 *
 * 然后，请你返回修改后的数组中的最大的子数组之和。
 *
 * 注意，子数组长度可以是 0，在这种情况下它的总和也是 0。
 *
 * 由于 结果可能会很大，所以需要 模（mod） 10^9 + 7 后再返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2], k = 3
 * 输出：9
 * 示例 2：
 *
 * 输入：arr = [1,-2,1], k = 5
 * 输出：2
 * 示例 3：
 *
 * 输入：arr = [-1,-2], k = 7
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * 1 <= k <= 10^5
 * -10^4 <= arr[i] <= 10^4
 */
public class Main3 {

    //逻辑没有考虑完全
    static class Solution {
        int mod = 100000007;
        public int kConcatenationMaxSum(int[] arr, int k) {
            if(arr == null || arr.length == 0)
                return 0;

            int sum = 0;
            boolean flag = true;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] < 0)
                    flag = false;
                sum += arr[i];
            }

            int maxSubArray = maxSubArray(arr);
            int maxLeftRight = maxLeftAndRight(arr);

            //说明此时全为正
            if(flag){
                return (sum % mod) * (k % mod) % mod;
            }

            long res = Math.max(0,Math.max(Math.max((sum % mod) * (k % mod) % mod, maxSubArray), maxLeftRight)) % mod;
            return (int)res;
        }

        //最长子序列
        int maxSubArray(int[] nums){
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

        int maxLeftAndRight(int[] nums){
            if(nums == null || nums.length <= 1){
                return 0;
            }

            int left = 0;
            int right = nums.length-1;
            int sum = 0;
            int max = Math.max(nums[left], nums[right]);
            while(left < right){
                sum += nums[left] + nums[right];
                max = Math.max(sum, max);
                left++;
                right--;
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-5,-2,0,0,3,9,-2,-5,4};
        int res = solution.kConcatenationMaxSum(arr, 3);
        System.out.println(res);
    }

}
