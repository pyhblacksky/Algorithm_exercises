package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/27 10:52
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */
public class Solution34_在排序数组中查找元素的第一个和最后一个位置 {

    //二分
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        //查找第一个等于key的
        int i = 0;
        int j = nums.length - 1;
        while(i <= j){
            int mid = i + (j-i) / 2;
            if(nums[mid] >= target){
                j = mid-1;
            } else{
                i = mid+1;
            }
        }
        int start = i;

        //查找最后一个等于key的
        i = 0;
        j = nums.length - 1;
        while(i <= j){
            int mid = i + (j-i)/2;
            if(nums[mid] <= target){
                i = mid+1;
            } else{
                j = mid-1;
            }
        }
        int end = j;
        //System.out.println(start + "  " + end);
        if(start >= 0 && start < nums.length && end >= 0 && end < nums.length
                && end >= start && nums[start] == target && nums[end] == target){
            return new int[]{start, end};
        }
        return  new int[]{-1,-1};
    }

}
