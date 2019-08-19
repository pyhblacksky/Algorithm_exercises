package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/20 14:22
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 *
 * 示例 1:
 *
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明:  n 的范围为 [1, 10,000]。
 *
 * 输入:
 * [3,4,2,3]
 * 预期结果
 * false
 *
 * [3,3,2,2]
 * false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution665_非递减数列 {

    //双指针法
    static class Solution {
        public boolean checkPossibility(int[] nums) {
            if(nums == null || nums.length <= 1)
                return true;

            int i = 0;
            int j = nums.length - 1;

            while(i < j && nums[i] <= nums[i+1])
                i++;

            while(i < j && nums[j] >= nums[j-1])
                j--;

            //必须满足以下四个条件中的一个
            if(j-i <= 1 && (i == 0 || j == nums.length - 1 || nums[i] <= nums[j+1] || nums[i-1] <= nums[j]))
                return true;
            return false;
        }
    }

    public static void main(String[] args){
        int[] arr = {3,3,2,2};
        Solution solution = new Solution();
        boolean res = solution.checkPossibility(arr);
        System.out.println(res);
    }

}
