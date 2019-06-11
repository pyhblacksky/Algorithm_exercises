package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/11 11:00
 * @Version: 1.0
 * @Function:
 * @Description:
 * 题目是乘积最大子序列，但是根据题意来看应该是子数组
 */
public class Solution152_乘积最大子数组 {
    //直接上暴力
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int mul = nums[i];
            max = Math.max(max, mul);
            for(int j = i+1; j < nums.length; j++){
                mul *= nums[j];
                max = Math.max(max, mul);
            }
        }

        return max;
    }

    //优化一下
    public int maxProduct1(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        int iMax = 1;
        int iMin = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }

            iMax = Math.max(nums[i], nums[i] * iMax);
            iMin = Math.min(nums[i], nums[i] * iMin);

            max = Math.max(max, iMax);
        }
        return max;
    }
}
