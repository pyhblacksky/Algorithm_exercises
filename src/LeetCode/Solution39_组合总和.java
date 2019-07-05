package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/7/5 9:05
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution39_组合总和 {

    //递归求解，复杂度较高
    static class Solution {
        List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if(candidates == null || candidates.length == 0)
                return list;

            help(candidates, 0, target, new ArrayList<>());
            return list;
        }

        public void help(int[] nums, int index, int target, List<Integer> cord){
            if(target < 0)
                return;
            if(target == 0 && !list.contains(cord)){
                list.add(new ArrayList<>(cord));
                return;
            }
            if(index >= nums.length){
                return;
            }

            cord.add(nums[index]);
            help(nums, index + 1, target - nums[index], cord);
            help(nums, index, target - nums[index], cord);
            cord.remove(cord.size()-1);
            help(nums, index + 1, target, cord);
        }
    }

    //递归改进
    static class Solution1 {
        List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if(candidates == null || candidates.length == 0)
                return list;

            Arrays.sort(candidates);
            help(candidates, 0, target, new ArrayList<>());
            return list;
        }

        public void help(int[] nums, int index, int target, List<Integer> cord){
            if(target < 0)
                return;
            if(target == 0 && !list.contains(cord)){
                list.add(new ArrayList<>(cord));
                return;
            }
            if(index >= nums.length){
                return;
            }

            //用一个for循环
            for(int i = index; i < nums.length; i++){
                if(target < nums[i])
                    break;
                cord.add(nums[i]);
                help(nums, i, target - nums[i], cord);
                cord.remove(cord.size()-1);
            }
        }
    }


    public static void main(String[] args){
        int[] arr = {2,3,6,7};
        Solution1 solution = new Solution1();
        solution.combinationSum(arr, 7);
    }
}
