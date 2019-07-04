package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/4 11:06
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Solution7_整数反转 {

    static class Solution {
        public int reverse(int x) {

            boolean flag = false;
            if(x < 0){
                x = -x;
                flag = true;
            }

            long num = 0;
            while(x != 0){
                num = num*10 + x % 10;
                if(num < 0)
                    return 0;
                x /= 10;
            }

            //溢出，返回0
            if(num > Integer.MAX_VALUE)
                return 0;

            return flag ? (int)-num : (int)num;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int num = solution.reverse(
                -2147483648);

        System.out.println(num);
        System.out.println(Integer.MIN_VALUE);
    }

}
