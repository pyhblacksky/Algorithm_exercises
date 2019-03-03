package LeetCode.动态规划;

/**
 * @Author: pyh
 * @Date: 2019/3/2 17:04
 * @Version 1.0
 * @Function:   303_区域和检索_数组不可变
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 */
public class Solution303_区域和检索_数组不可变 {

    //方法一：动态规划  利用一个数组存储前n个和
    class NumArray {

        int[] arr;

        public NumArray(int[] nums) {
            if(nums == null){
                return;
            }
            arr = new int[nums.length];
            arr[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                arr[i] += arr[i-1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if(i < 0 || j> arr.length){
                return 0;
            }
            if(i == j){
                return arr[i];
            } else{
                return arr[j] - arr[i];
            }
        }
    }

    //方法二：暴力直接求解
    class NumArray1 {
        int[] arr;
        public NumArray1(int[] nums) {
            arr = new int[nums.length];
            for(int i = 0; i < arr.length; i++){
                arr[i] = nums[i];
            }
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            if(j > arr.length || i < 0){
                return 0;
            }
            for(int k = i; k <= j; k++){
                sum += arr[k];
            }
            return sum;
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
}
