package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/4/24 17:25
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Solution78_子集 {
    //二进制法 枚举的方式
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        for(int mask = 0; mask < (1 << n); mask++){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(((mask >> i) & 1) == 1){
                    temp.add(nums[i]);
                }
            }
            list.add(temp);
        }

        return list;
    }

    //测试方法
    public static void main(String[] args){
        int[] nums = {1,2,8,12,7};
        Solution78_子集 solution = new Solution78_子集();
        List<List<Integer>> list = solution.subsets(nums);
        printList(list);
    }

    public static void printList(List<List<Integer>> list){
        for(List<Integer> temp : list){
            for(Integer x : temp){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
