package LeetCodeRace.ContestTwo4;

/**
 * @Author: pyh
 * @Date: 2019/7/13 22:42
 * @Description:
 *
 * 给你一个 非递减 的正整数数组 nums 和整数 K，判断该数组是否可以被分成一个或几个 长度至少 为 K 的 不相交的递增子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,3,3,4,4], K = 3
 * 输出：true
 * 解释：
 * 该数组可以分成两个子序列 [1,2,3,4] 和 [2,3,4]，每个子序列的长度都至少是 3。
 * 示例 2：
 *
 * 输入：nums = [5,6,6,7,8], K = 3
 * 输出：false
 * 解释：
 * 没有办法根据条件来划分数组。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= K <= nums.length
 * 1 <= nums[i] <= 10^5
 */

public class 将数组分成几个递增序列 {

    static class Solution {
        public boolean canDivideIntoSubsequences(int[] nums, int K) {
            for(int i = 0; i < nums.length; i++) {
                int j = i;
                while(j+1 < nums.length && nums[i] == nums[j+1])
                    j++;

                int len = j - i + 1;
                if (len*K > nums.length)
                    return false;
                i = j;
            }
            return true;
        }

    }


    public static void main(String[] args){
        int[] arr = {1,2,2,3,3,4,4};
        int[] arr1 = {5,6,6,7,8};
        int[] arr2 = {1,1,2,3,4,4};
        int[] arr3 = {1,2,3,3,4,5};
        Solution solution = new Solution();
        boolean res = solution.canDivideIntoSubsequences(arr2, 3);
        System.out.println(res);
    }


}
