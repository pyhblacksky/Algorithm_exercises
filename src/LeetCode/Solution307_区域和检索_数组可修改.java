package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/26 20:37
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 *
 * 示例:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 说明:
 *
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 */
public class Solution307_区域和检索_数组可修改 {

    //方法一，直接求解，效率低下
    class NumArray1 {

        private int[] arr;
        private int sum;

        public NumArray1(int[] nums) {
            arr = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                arr[i] = nums[i];
            }
        }

        public void update(int i, int val) {
            arr[i] = val;
        }

        public int sumRange(int i, int j) {
            if(i < 0 || j >= arr.length){
                throw new IllegalArgumentException("Out of Range!");
            }
            int res = 0;
            for(int k = i; k <= j; k++){
                res += arr[k];
            }
            return res;
        }

    }

    //方法二，使用树状数组,提高效率
    class NumArray {

        private int[] sums;//树状数组中求和的数组
        private int[] data;//真实存放数据的数组
        private int n;

        //取出x的最低位 二进制位
        private int lowbit(int x){
            return x & (-x);//二进制最低位
        }

        //查询
        private int query(int i){
            int s = 0;
            while(i > 0){
                s += sums[i];
                i -= lowbit(i);
            }
            return s;
        }

        //delta是增量
        private void renewal(int i, int delta){
            while(i <= n){
                //树状数组中索引是1~n
                sums[i] += delta;
                i += lowbit(i);
            }
        }

        /***********************************************/
        public NumArray(int[] nums) {
            n = nums.length;
            sums = new int[n+1];
            data = new int[n];
            for(int i = 0; i < n; i++){
                data[i] = nums[i];
                renewal(i+1, nums[i]);
            }
        }

        public void update(int i, int val) {
            renewal(i+1, val - data[i]);
            data[i] = val;
        }

        public int sumRange(int i, int j) {
            return query(j+1) - query(i);
        }
    }

    public static void main(String[] args){

    }

}
