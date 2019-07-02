package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/2 17:03
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution415_字符串相加 {

    static class Solution {
        public String addStrings(String num1, String num2) {
            if(num1 == null || num1.length() == 0)
                return num2;
            if(num2 == null || num2.length() == 0)
                return num1;

            //先对齐
            if(num1.length() > num2.length()){
                int sub = num1.length() - num2.length();
                StringBuilder temp = new StringBuilder();
                for(int i = 0; i < sub; i++){
                    temp.append('0');
                }
                temp.append(num2);
                num2 = temp.toString();
            } else if(num1.length() < num2.length()){
                int sub = num2.length() - num1.length();
                StringBuilder temp = new StringBuilder();
                for(int i = 0; i < sub; i++){
                    temp.append('0');
                }
                temp.append(num1);
                num1 = temp.toString();
            }

            int len = num1.length();
            StringBuilder sb = new StringBuilder();
            int cin = 0;
            for(int i = len -1; i >= 0; i--){
                int n1 = num1.charAt(i)-'0';
                int n2 = num2.charAt(i)-'0';
                int num = n1+n2+cin;
                if(num >= 10){
                    num = num % 10;
                    cin = 1;
                } else{
                    cin = 0;
                }
                sb.append(num);
            }

            if(cin == 1){
                sb.append(1);
                return sb.reverse().toString();
            }
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String str = solution.addStrings("9999", "9999");
        System.out.println(str);
    }

}
