package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/22 10:34
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution80_删除排序数组中的重复项2 {

    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length <= 2){
            return nums.length;
        }

        int i = 0;
        for(int num : nums){
            //和i-2比较，可依次类推.保留n个数就减n
            if(i < 2 || num > nums[i-2]){
                nums[i++] = num;
            }
        }

        return i;
    }


}
