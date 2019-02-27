package LeetCode;

import java.util.HashMap;

/**
 * @Author: pyh
 * @Date: 2019/2/25 8:47
 * @Version 1.0
 * @Function:   1、两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution1_两数之和 {
    //暴力求解
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }

        throw new IllegalArgumentException("No Results");
    }

    //使用HashMap,两次遍历Hash
    public int[] twoSum1(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int sub = target - nums[i];
            if(map.containsKey(sub) && map.get(sub) != i){
                return new int[]{i, map.get(sub)};
            }
        }
        throw new IllegalArgumentException("No result");
    }

    //一遍Hash
    public int[] twoSum2(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int sub = target - nums[i];
            if(map.containsKey(sub)){
                return new int[]{i, map.get(sub)};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No result");
    }
}
