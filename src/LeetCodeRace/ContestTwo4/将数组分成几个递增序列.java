package LeetCodeRace.ContestTwo4;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/7/13 22:42
 * @Description:
 *
 * 给你一个 非递减 的正整数数组 nums 和整数 K，判断该数组是否可以被分成一个或几个 长度至少 为 K 的 不相交的递增子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,3,3,4,4], K = 3
 * 输出：true
 * 解释：
 * 该数组可以分成两个子序列 [1,2,3,4] 和 [2,3,4]，每个子序列的长度都至少是 3。
 * 示例 2：
 *
 * 输入：nums = [5,6,6,7,8], K = 3
 * 输出：false
 * 解释：
 * 没有办法根据条件来划分数组。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= K <= nums.length
 * 1 <= nums[i] <= 10^5
 */

public class 将数组分成几个递增序列 {

    static class Solution {
        public boolean canDivideIntoSubsequences(int[] nums, int K) {
            if(nums == null || nums.length == 0 || K == 0){
                return false;
            }

            int[] dp = new int[nums.length];
            int max = 0;
            for(int i = 0; i < nums.length; i++){
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(nums[j] < nums[i]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }

            if(max == nums.length)
                return true;



            return true;
        }

        int[] getLIS(int[] arr, int[] dp, Map<Integer, Integer> map){
            int maxLen = 0;
            int end = 0;
            for(int i = 0; i < dp.length; i++){
                if(dp[i] > maxLen){
                    maxLen = dp[i];
                    end = i;
                }
            }

            //递减还原数列
            int[] lis = new int[maxLen];
            lis[--maxLen] = arr[end];
            for(int i = end - 1; i >= 0; i--){
                if(dp[i] == dp[end] - 1 && arr[i] < arr[end] && map.get(arr[i]) != 0){
                    lis[--maxLen] = arr[i];
                    end = i;
                    map.put(arr[i], map.get(arr[i]) - 1);
                }
            }
            return lis;
        }
    }

    //1. 遍历数组，得到数组中所有元素的出现次数；
    //2. 再次遍历数组，并且对于每个元素，要么查看它是否可以附加到先前构建的连续序列，
    //  要么是否可以是新的连续序列的开始。 如果两个都不是真的，那我们就返回假。
    static class Solution1 {
        public boolean canDivideIntoSubsequences(int[] nums, int K) {
            Map<Integer,Integer> frequenceMap = new HashMap<>();
            Map<Integer,Integer> appendMap = new HashMap<>();
            for (int n : nums){
                frequenceMap.put(n,frequenceMap.getOrDefault(n,0) + 1);
            }
            for (int n : nums){
                boolean flag = true;
                if (frequenceMap.get(n) == 0) continue;
                else if (appendMap.getOrDefault(n,0) > 0){
                    appendMap.put(n,appendMap.get(n) - 1);
                    appendMap.put(n + 1,appendMap.getOrDefault(n + 1,0) + 1);
                } else{
                    int index = 1;
                    boolean judge = true;
                    while(index < K){
                        judge = frequenceMap.getOrDefault(n + index,0) > 0;
                        if(!judge) {
                            flag = false;
                            break;
                        }
                        index++;
                    }
                    if(flag){
                        int count = 0;
                        for(int i = 1; i < K; i++){
                            if(frequenceMap.get(n+i) > 1){
                                frequenceMap.put(n+i, frequenceMap.get(n+i)-1);
                                count++;
                            }
                            if(count == K)
                                break;
                        }
                        appendMap.put(n + K,appendMap.getOrDefault(n + K,0) + 1);
                    } else{
                        return false;
                    }
                }
                frequenceMap.put(n,frequenceMap.get(n) - 1);
            }
            return true;
        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,2,3,3,4,4};
        int[] arr1 = {5,6,6,7,8};
        int[] arr2 = {1,1,2,3,4,4};
        int[] arr3 = {1,2,3,3,4,5};
        Solution1 solution = new Solution1();
        boolean res = solution.canDivideIntoSubsequences(arr2, 3);
        System.out.println(res);
    }


}
