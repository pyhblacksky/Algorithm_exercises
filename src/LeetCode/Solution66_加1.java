package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/8/17 21:42
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution66_加1 {

    class Solution {
        public int[] plusOne(int[] digits) {
            if(digits == null || digits.length == 0)
                return digits;

            int cin = 1;
            int p1 = digits.length-1;
            while(p1 >= 0){
                digits[p1] += cin;
                if(digits[p1] == 10){
                    digits[p1] = 0;
                } else{
                    cin = 0;
                    break;
                }
                p1--;
            }

            if(cin == 1){
                int[] arr = new int[digits.length+1];
                System.arraycopy(digits, 0, arr, 1, digits.length);
                arr[0] = cin;
                return arr;
            }
            return digits;
        }
    }

}
