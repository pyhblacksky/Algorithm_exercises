package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: pyh
 * @Date: 2019/7/4 9:33
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution41_缺失的第一个正数 {

    //先上通用解法    时间复杂度O(N)   空间复杂度O(N)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            if(nums == null || nums.length == 0)
                return 1;

            Set<Integer> set = new HashSet<>();
            int max = 0;
            for(int i = 0; i < nums.length; i++){
                set.add(nums[i]);
                max = Math.max(nums[i], max);
            }

            for(int i = 1; i <= max; i++){
                if(!set.contains(i))
                    return i;
            }
            return max+1;
        }
    }

    //空间复杂度1的解法
    //索引作为哈希表....
    class Solution1{
        // 关键字：桶排序，什么数字就要放在对应的索引上，其它空着就空着
        // 最好的例子：[3,4,-1,1]
        // 整理好应该是这样：[1,-1,3,4]，
        // 这里 1，3，4 都在正确的位置上，
        // -1 不在正确的位置上，索引是 1 ，所以返回 2
        // [4,3,2,1] 要变成 [1,2,3,4]，*** Offer 上有类似的问题。
        // 这里负数和大于数组长度的数都是"捣乱项"。
        public int firstMissingPositive(int[] nums) {
            if(nums == null || nums.length == 0)
                return 1;

            int len = nums.length;

            for(int i = 0; i < len; i++){
                // 前两个是在判断是否成为索引
                // 后一个是在判断，例如 3 在不在索引 2 上
                // 即 nums[i] ?= nums[nums[i]-1] 这里要特别小心
                while(nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                    // 第 3 个条件不成立的索引的部分是 i 和 nums[i]-1
                    swap(nums, nums[i]-1, i);
                }
            }

            for (int i = 0; i < len; i++) {
                // [1,-2,3,4]
                // 除了 -2 其它都满足： i+1 = num[i]
                if (nums[i] - 1 != i) {
                    return i + 1;
                }
            }

            return len + 1;
        }

        public void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
