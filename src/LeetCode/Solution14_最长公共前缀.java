package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/4 8:26
 * @Version: 1.0
 * @Function:
 * @Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution14_最长公共前缀 {

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs == null || strs.length == 0)
                return "";

            if(strs.length == 1)
                return strs[0];

            StringBuilder sb = new StringBuilder();
            int p1 = 0;
            int p2 = 0;
            while (p1 < strs[0].length() && p2 < strs[1].length() && strs[0].charAt(p1) == strs[1].charAt(p2)) {
                sb.append(strs[0].charAt(p1));
                p1++;
                p2++;
            }
            if(sb.length() == 0)
                return "";
            for(int i = 2; i < strs.length; i++) {
                String temp = judge(strs[i], strs[i - 1], sb.toString());
                if (temp.equals(""))
                    return "";
                sb = new StringBuilder(temp);
            }

            return sb.toString();
        }

        public String judge(String a, String b, String prev){
            if(a.startsWith(prev) && b.startsWith(prev))
                return prev;

            StringBuilder sb = new StringBuilder(prev);
            while (!a.startsWith(sb.toString()) || !b.startsWith(sb.toString())) {
                sb.deleteCharAt(sb.length()-1);
                if(sb.length() == 0)
                    return "";
            }
            return sb.toString();
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] arr = {"flower", "flow","flight"};
        solution.longestCommonPrefix(arr);

        String a = "a";
        a = "b";
        a = "c";
        System.out.println(a);
    }
}
