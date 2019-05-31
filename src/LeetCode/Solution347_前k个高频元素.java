package LeetCode;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/5/31 9:35
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class Solution347_前k个高频元素 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0 || k <= 0){
            return list;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });//自定义优先队列

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.add(entry);
        }

        while(k != 0 && !queue.isEmpty()){
            k--;
            int val = queue.poll().getKey();
            list.add(val);
        }

        return list;
    }

}
