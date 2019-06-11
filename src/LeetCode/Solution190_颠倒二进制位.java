package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/6/11 9:36
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Solution190_颠倒二进制位 {

    /**
     * 将给定的二进制数,由低到高位逐个取出
     * 然后通过位运算将其放置到反转后的位置.
     * 将上述结果再次通过运算结合到一起
     * */
    public static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            if(n == 0)
                return 0;

            int res = 0;
            for(int i = 0; i <= 32; i++){
                int temp = n >> i;//右移 i 位
                temp = temp & 1;//有效位
                temp = temp << (31 - i);
                res = res | temp;
            }
            return res;
        }

        public static void main(String[] args){
            Solution solution = new Solution();
            solution.reverseBits(43261596);
        }
    }

}
