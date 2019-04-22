package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/4/22 19:45
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class Solution219_存在重复元素2 {
    //普通方法
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k <= 0){
            return false;
        }

        for(int i = 0; i < nums.length; i++){
            if(help(nums, i, k)){
                return true;
            }
        }

        return false;
    }

    public boolean help(int[] nums, int start, int end){
        for(int i = start+1; i <= start + end && i < nums.length; i++){
            if(nums[start] == nums[i]){
                return true;
            }
        }
        return false;
    }

    //先判断有无相等，再判断是否在一定的区间范围内
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k <= 0){
            return false;
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    if(Math.abs(i-j) <= k){
                        return true;
                    } else{
                        break;
                    }
                }
            }
        }
        return false;
    }

    //使用HashMap
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k <= 0){
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();//存放 值-下标
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            } else{
                //此时，存在
                int index = map.get(nums[i]);
                if(i - index <= k){
                    return true;
                } else{
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }

}
