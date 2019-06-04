package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/6/3 10:12
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质：
 * counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class Solution315_计算右侧小于当前元素的个数 {

    //暴力解法，超时，用二分查找+插排的思想
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        Integer[] record = new Integer[nums.length];
        int len = nums.length;
        for(int i = len - 1; i >= 0; i--){
            //二分,找到第一个小于此元素的
            int idx = binarySearch(list, nums[i]);
            record[i] = idx;
            list.add(idx, nums[i]);
        }

        return Arrays.asList(record);
    }

    private static int binarySearch(List<Integer> list, int key) {
        int l = 0;
        int r = list.size();
        for (; l < r;) {
            int m = l + (r - l) / 2;
            // 不能判断list.get(m) > key
            if (list.get(m) < key) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }


    public static void main(String[] args){
        Solution315_计算右侧小于当前元素的个数 solution = new Solution315_计算右侧小于当前元素的个数();
        solution.countSmaller(new int[]{5,2,6,1});
    }

}
