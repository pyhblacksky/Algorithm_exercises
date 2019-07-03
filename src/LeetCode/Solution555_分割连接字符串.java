package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/7/3 10:04
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一个字符串列表，你可以将这些字符串连接成一个循环字符串，对于每个字符串，你可以选择是否翻转它。在所有可能的循环字符串中，你需要分割循环字符串（这将使循环字符串变成一个常规的字符串），然后找到字典序最大的字符串。
 *
 * 具体来说，要找到字典序最大的字符串，你需要经历两个阶段：
 *
 * 将所有字符串连接成一个循环字符串，你可以选择是否翻转某些字符串，并按照给定的顺序连接它们。
 * 在循环字符串的某个位置分割它，这将使循环字符串从分割点变成一个常规的字符串。
 * 你的工作是在所有可能的常规字符串中找到字典序最大的一个。
 *
 * 示例:
 *
 * 输入: "abc", "xyz"
 * 输出: "zyxcba"
 * 解释: 你可以得到循环字符串 "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-"，
 * 其中 '-' 代表循环状态。
 * 答案字符串来自第四个循环字符串，
 * 你可以从中间字符 'a' 分割开然后得到 "zyxcba"。
 *  
 *
 * 注意:
 *
 * 输入字符串只包含小写字母。
 * 所有字符串的总长度不会超过 1,000。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-concatenated-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution555_分割连接字符串 {

    /**
     * 1、将所有字符串连接成一个循环字符串，你可以选择是否翻转某些字符串，并按照给定的顺序连接它们。
     * 2、在循环字符串的某个位置分割它，这将使循环字符串从分割点变成一个常规的字符串。
     *
     * */
    static class Solution {
        public String splitLoopedString(String[] strs) {
            if(strs == null || strs.length == 0)
                return "";

            //构建逆序字符串数组
            String[] revers = new String[strs.length];
            StringBuilder sb = new StringBuilder();//最大的常规字符串
            for(int i = 0; i < revers.length; i++){
                String temp = reverseString(strs[i]);
                revers[i] = temp;

                sb.append(maxDic(temp, strs[i]));
            }


            int k = 0;
            String res = "a";
            for(int i = 0; i < strs.length; i++){
                String rev = revers[i];
                String str = strs[i];
                String mid = sb.substring(k+str.length()) + sb.substring(0,k);

                for(int j = 0; j < str.length(); j++){
                    if(str.charAt(j) >= res.charAt(0)){
                        res = maxDic(res, str.substring(j)+mid+str.substring(0,j));
                    }
                    if(rev.charAt(j) >= res.charAt(0)){
                        res = maxDic(res, rev.substring(j)+mid+rev.substring(0,j));
                    }
                }

                k += str.length();
            }
            return res;
        }

        //反转字符串
        private String reverseString(String str){
            StringBuilder sb = new StringBuilder(str);
            return sb.reverse().toString();
        }

        //返回最大字典序字符串
        private String maxDic(String a, String b){
            if(a.equals(b))
                return a;
            int aLen = a.length();
            int bLen = b.length();
            if(aLen > bLen){
                for(int i = 0; i < bLen; i++){
                    if(b.charAt(i) > a.charAt(i))
                        return b;
                    else if(a.charAt(i) > b.charAt(i))
                        return a;
                }
                return a;//长的优先?如果不这样，不通过？
            } else{
                for(int i = 0; i < aLen; i++){
                    if(b.charAt(i) > a.charAt(i))
                        return b;
                    else if(a.charAt(i) > b.charAt(i))
                        return a;
                }
                return b;
            }
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] str = {"abca","xeyz"};

        String res = solution.splitLoopedString(str);
        System.out.println(res);
    }

}
