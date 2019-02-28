package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/2/28 10:05
 * @Version 1.0
 * @Function:   704、二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
public class Solution704_二分查找 {

    /**
     * 二分查找一般由三个部分组成
     * 1、预处理 —— 如果集合未排序，则进行排序。
     * 2、二分查找 —— 使用循环或递归在每次比较后将查找空间划分为两半。
     * 3、后处理 —— 在剩余空间中确定可行的候选者。
     * */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        return search(nums, 0, nums.length-1, target);
    }
    private int search(int[] arr, int min, int max, int target){
        if(min > max){
            return -1;
        }
        int mid = min + (max-min)/2;
        if(arr[mid] == target){
            return mid;
        } else if(arr[mid] > target){
            max = mid - 1;
            return search(arr, min, max, target);
        } else{
            min = mid + 1;
            return search(arr, min, max, target);
        }
    }

    /**
     * 二分查找模板1
     * */
    public int binarySearch1(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找模板2
     * 用于查找需要访问数组中当前索引及其直接右邻居索引的元素或条件
     *
     * 使用元素的右邻居来确定是否满足条件，并决定是向左还是向右
     * 保证查找空间在每一步中至少有 2 个元素
     * 需要进行后处理。 当你剩下 1 个元素时，循环 / 递归结束。 需要评估剩余元素是否符合条件
     * */
    public int binarySearch2(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){return mid;}
            if(nums[mid] < target){left = mid + 1;}
            else{right = mid;}
        }

        //此时left = right
        if(left != nums.length && nums[left] == target){return left;}
        return -1;
    }

    /**
     * 二分查找模板3
     * 搜索条件需要访问元素的直接左右邻居。
     * 保证查找空间在每个步骤中至少有 3 个元素。
     * 需要进行后处理。 当剩下 2 个元素时，循环 / 递归结束。 需要评估其余元素是否符合条件。
     *  用于搜索需要访问当前索引及其在数组中的直接左右邻居索引的元素或条件。
     * */
    public int binarySearch3(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){return mid;}
            else if(nums[mid] > target){end = mid;}
            else{start = mid;}
        }

        //最后剩下两个元素   start + 1 = end
        if(nums[start] == target){return start;}
        if(nums[end] == target){return end;}
        return -1;
    }

}
