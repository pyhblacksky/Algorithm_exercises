package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/27 14:47
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 */
public class Solution171_Excel表列序号 {

    public int titleToNumber(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int res = 0;
        int index = 0;
        for(int i = s.length()-1; i >= 0; i--){
            int mul = (int)Math.pow(26, index);
            res += (s.charAt(i) - 'A'+1) * mul;
            index++;
        }
        return res;
    }

}
