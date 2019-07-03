package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/3 8:06
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution673_最长递增子序列的个数 {

    static class Solution {
        public int findNumberOfLIS(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;

            int[] dp = new int[nums.length];
            int[] save = new int[nums.length];//记录找到的组合数
            int max = 1;
            for(int i = 0; i < nums.length; i++){
                dp[i] = 1;
                save[i] = 1;
                for(int j = 0; j < i; j++){
                    if(nums[j] < nums[i]){
                        if(dp[j] + 1 > dp[i]){//长度增加，组合数不变
                            dp[i] = dp[j] + 1;
                            save[i] = save[j];
                        } else if(dp[j] + 1 == dp[i]){//如果相等，则说明出现了新组合
                            save[i] += save[j];
                        }
                    }
                }
                max = Math.max(max, dp[i]);
            }

            int res = 0;
            for(int i = 0; i < dp.length; i++)
                if(dp[i] == max)
                    res += save[i];

            return res;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {1,3,5,4,7};
        int[] arr1 = {2,2,2,2,2};
        int[] arr2= {1,2,4,3,5,4,7,2};
        int res = solution.findNumberOfLIS(arr2);
        System.out.println(res);
    }
}
