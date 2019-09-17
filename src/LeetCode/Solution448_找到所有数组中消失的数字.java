package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/9/16 19:57
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Solution448_找到所有数组中消失的数字 {

    static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> res = new LinkedList<>();
            if(nums == null || nums.length == 0)
                return res;

            for(int i = 0; i < nums.length; i++){
                if(nums[i] != i+1 && nums[nums[i]-1] != nums[i]) {
                    swap(nums, nums[i]-1, i);
                    i--;
                }
            }

            for(int i = 0; i < nums.length; i++){
                if(nums[i] != i+1){
                    res.add(i+1);
                }
            }

            return res;
        }
        void swap(int[] arr, int i, int j){
            if(arr == null)
                return;
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4,3,2,7,8,2,3,1};
        solution.findDisappearedNumbers(arr);
    }
}
