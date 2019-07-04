package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/4 17:32
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution55_跳跃游戏 {

    //暴力递归，超时。。。
    class Solution {
        public boolean canJump(int[] nums) {
            if(nums == null || nums.length == 0)
                return false;

            if(nums.length == 1)
                return true;

            return judge(nums, 0);
        }

        private boolean judge(int[] nums, int pos){
            if(pos >= nums.length-1)
                return true;
            if(nums[pos] == 0)
                return false;

            for(int i = nums[pos]; i >= 1; i--){
                boolean res = judge(nums, pos + i);
                if(res)
                    return true;
            }
            return false;
        }
    }

    //记忆化方法,  1075ms....
    class Solution1{
        public boolean canJump(int[] nums) {
            if(nums == null || nums.length == 0)
                return false;

            if(nums.length == 1)
                return true;

            int[] dp = new int[nums.length+1];
            return judge(nums, 0, dp);
        }

        private boolean judge(int[] nums, int pos, int[] dp){
            if(pos >= nums.length-1)
                return true;
            if(nums[pos] == 0)
                return false;
            if(dp[pos] != 0)
                return dp[pos] == 1;

            for(int i = nums[pos]; i >= 1; i--){
                boolean res = judge(nums, pos + i, dp);
                if(res) {
                    dp[pos] = 1;
                    return true;
                }
            }
            dp[pos] = -1;
            return false;
        }
    }

    //dp            317ms
    class Solution2{
        public boolean canJump(int[] nums) {
            if(nums == null || nums.length == 0)
                return false;

            if(nums.length == 1)
                return true;

            int[] dp = new int[nums.length];
            dp[nums.length-1] = 1;

            for(int i = nums.length - 2; i >= 0; i--){
                int jump = Math.min(i+nums[i], nums.length-1);
                for(int j = i+1; j <= jump; j++){
                    if(dp[j] == 1){
                        dp[i] = 1;
                        break;
                    }
                }
            }

            return dp[0] == 1;
        }
    }

    //贪心
    class Solution3{
        public boolean canJump(int[] nums) {
            int lastPos = nums.length - 1;
            for(int i = nums.length - 1; i >= 0; i--){
                if(i+ nums[i] >= lastPos){
                    lastPos = i;
                }
            }

            return lastPos == 0;
        }
    }

    //之前的解法
    class Solution4{
        public boolean canJump(int[] nums){
            int[] dp = new int[nums.length];

            //每个点可以跳的最大位置
            for(int i = 0; i < nums.length; i++)
                dp[i] = nums[i]+i;

            int jump = 0;
            int maxIndex = dp[0];
            while(jump < dp.length){
                if(jump > maxIndex){
                    break;
                }
                if(dp[jump] > maxIndex){
                    maxIndex = dp[jump];
                }
                jump++;
            }

            return jump == nums.length;
        }
    }


}
