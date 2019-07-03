package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/3 15:50
 * @Version: 1.0
 * @Function:
 * @Description:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution9_回文数 {

    //转换为字符串比较
    class Solution {
        public boolean isPalindrome(int x) {
            if(x < 10 && x >= 0)
                return true;
            if(x < 0)
                return false;

            String str = String.valueOf(x);
            StringBuilder sb = new StringBuilder(str);
            String rev = sb.reverse().toString();

            return str.equals(rev);
        }
    }

    //不转换为为字符串
    static class Solution1 {
        public boolean isPalindrome(int x) {
            if(x < 0 || (x % 10 == 0 && x != 0))
                return false;

            int revertNum = 0;
            int temp = x;
            while(x != 0){
                revertNum = revertNum * 10 + x % 10;
                x = x/10;
            }

            return temp == revertNum;
        }
    }

    //不转换为字符串且复杂度log(N)
    static class Solution2 {
        public boolean isPalindrome(int x) {
            if(x < 0 || (x % 10 == 0 && x != 0))
                return false;

            int revertNum = 0;
            while(x > revertNum){
                revertNum = revertNum * 10 + x % 10;
                x = x/10;
            }

            return x == revertNum || x == revertNum/10;
        }
    }

    public static void main(String[] args){
        Solution2 solution = new Solution2();
        solution.isPalindrome(123321);
    }
}
