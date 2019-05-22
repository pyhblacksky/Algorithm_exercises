package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/21 15:53
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class Solution238_除自身以外数组的乘积 {

    //暴力求解 O(N^2)，超时
    public static int[] productExceptSelf1(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        if(nums.length == 1){
            return new int[]{0};
        }

        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int temp = 1;
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    temp *= nums[j];
                }
            }
            res[i] = temp;
        }

        return res;
    }

    //O(N)解法，分为两个部分，从数n划分，左边部分和右边部分,最后两部分相乘即可
    public static int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        if(nums.length == 1){
            return new int[]{0};
        }

        //左边
        int[] left = new int[nums.length];
        left[0] = 1;
        int temp = 1;
        for(int i = 1; i < nums.length; i++){
            temp *= nums[i-1];
            left[i] = temp;
        }

        //右边
        int[] right = new int[nums.length];
        right[nums.length-1] = 1;
        temp = 1;
        for(int i = nums.length-1; i > 0; i--){
            temp *= nums[i];
            right[i-1] = temp;
        }

        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = left[i]*right[i];
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        int[] res = productExceptSelf(arr);
        int a = 0;
    }

}
