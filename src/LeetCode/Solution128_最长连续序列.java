package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: pyh
 * @Date: 2019/5/25 8:53
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Solution128_最长连续序列 {

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longMax = 0;
        for(int num : nums){
            if(set.remove(num)){
                int currentNum = num;
                int currentLong = 1;
                //向左搜索
                while(set.remove(currentNum-1)) currentNum--;
                currentLong += num - currentNum;

                //向右搜索
                currentNum = num;
                while(set.remove(currentNum+1)) currentNum++;
                currentLong += currentNum - num;

                //更新值
                longMax = Math.max(currentLong, longMax);
            }
        }

        return longMax;
    }

}
