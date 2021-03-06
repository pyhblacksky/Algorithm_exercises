package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/23 19:11
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 数学表达式如下:
 *
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 *
 * 输入: [5,4,3,2,1]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution334_递增三元子序列 {

    /**
     * 思路：
     * 首先找到一个相对较小的值，然后找到一个中间值，最后如果出现比中间值大的，直接返回true
     * */
    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            if(nums == null || nums.length < 3){
                return false;
            }

            //双指针
            int min = Integer.MAX_VALUE;
            int max = Integer.MAX_VALUE;
            int i = 0;
            while(i < nums.length){
                if(nums[i] < min){
                    min = nums[i];
                } else if(nums[i] > min && nums[i] < max){
                    max = nums[i];
                } else if(nums[i] > max){
                    return true;
                }
                i++;
            }

            return false;
        }
    }

    public static void main(String[] args) {

    }
}
