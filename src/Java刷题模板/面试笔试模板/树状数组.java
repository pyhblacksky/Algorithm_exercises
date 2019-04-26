package Java刷题模板.面试笔试模板;

/**
 * @Author: pyh
 * @Date: 2019/4/26 20:30
 * @Version: 1.0
 * @Function:
 * @Description:
 * 参考leetcode上 307 区域和检索 - 数组可修改
 *
 */
public class 树状数组 {

    class NumArray{
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

}
