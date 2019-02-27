package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/2/25 8:40
 * @Version 1.0
 * @Function:   15、三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Solution15_三数之和 {

    //利用两数之和变形
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int opposite = -nums[i];
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = len - 1;
                while (left < right) {
                    int twoSum = nums[left] + nums[right];
                    if (twoSum == opposite) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        res.add(ans);
                        left = moveLeft(nums, left, right);
                        right = moveRight(nums, left, right);
                    } else if (twoSum < opposite) {
                        left = moveLeft(nums, left, right);
                    } else {
                        right = moveRight(nums, left, right);
                    }
                }
            }
        }
        return res;
    }

    //存在重复数字，移动
    private int moveLeft(int[] nums, int left, int right) {
        int num = nums[left++];
        while (left <= right) {
            if (nums[left] != num)
                break;
            left++;
        }
        return left;
    }

    private int moveRight(int[] nums, int left, int right) {
        int num = nums[right--];
        while (left <= right) {
            if (nums[right] != num)
                break;
            right--;
        }
        return right;
    }

}
