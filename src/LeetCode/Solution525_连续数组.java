package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/7/2 14:52
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *  
 *
 * 注意: 给定的二进制数组的长度不会超过50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution525_连续数组 {

    //最长连续子数组       原问题可转化为求最长子数组和为0(0看为-1)
    static class Solution {
        public int findMaxLength(int[] nums) {
            if(nums == null || nums.length < 2)
                return 0;

            int sum = 0;
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 1){
                    sum += 1;
                } else if(nums[i] == 0){
                    sum -=1;
                }

                if(sum == 0 && i > res){
                    res = i+1;
                }
                if(map.containsKey(sum)){
                    res = Math.max(i-map.get(sum), res);
                } else{
                    map.put(sum, i);
                }
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = {0,0,0,0,0,0,1,0,1,1,1};
        solution.findMaxLength(arr);
    }

}
