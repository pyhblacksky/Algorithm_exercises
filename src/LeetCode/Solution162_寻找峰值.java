package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/3 17:03
 * @Version: 1.0
 * @Function:
 * @Description:
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 */
public class Solution162_寻找峰值 {

    /**
     * 首先要注意题目条件，在题目描述中出现了nums[-1] = nums[n] = -∞，
     *      这就代表着只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
     * 根据上述结论，我们就可以使用二分查找找到峰值
     * 查找时，左指针l，右指针r，以其保持左右顺序为循环条件
     * 根据左右指针计算中间位置m，并比较m与m+1的值，如果m较大，
     *      则左侧存在峰值，r=m，如果m+1较大，则右侧存在峰值，l=m+1
     * */
    public int findPeakElement(int[] nums) {
        //二分
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid+1]){
                right = mid;//左侧存在峰值
            } else{
                left = mid + 1;//右侧存在峰值
            }
        }
        return left;

    }

}
