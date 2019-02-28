package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/2/27 20:22
 * @Version 1.0
 * @Function:   421、数组中两个数的最大异或值
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 *
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *
 * 你能在O(n)的时间解决这个问题吗？
 *
 * 示例:
 *
 * 输入: [3, 10, 5, 25, 2, 8]
 *
 * 输出: 28
 *
 * 解释: 最大的结果是 5 ^ 25 = 28.
 */
public class Solution421_数组中两个数的最大异或值 {

    //O(N^2)的解法
    public int findMaximumXOR1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    //使用前缀树的解法，没有完全了解
    public int findMaximumXOR(int[] nums){
        if(nums == null || nums.length <= 1){
            return 0;
        }
        Trie root = new Trie();
        int result = 0;
        for (int num : nums) {
            int xor = 0;
            Trie insert = root, search = root;
            for (int i = 30; i >= 0; i--) {
                int bit = (num >>> i) & 1;//判断是否存在1
                int rbit = bit ^ 1;     //是否存在异或值
                if (insert.next[bit] == null) {
                    insert.next[bit] = new Trie();
                }
                insert = insert.next[bit];
                if (search != null) {
                    if (search.next[rbit] != null) {
                        xor += (1 << i);
                        search = search.next[rbit];
                    } else {
                        search = search.next[bit];
                    }
                }
            }
            result = Math.max(result, xor);
        }
        return result;
    }
    class Trie{
        Trie[] next;
        public Trie(){
            next = new Trie[2];//设定大小为2
        }
    }
}
