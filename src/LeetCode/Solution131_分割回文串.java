package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/6/19 15:26
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution131_分割回文串 {

    //回溯的方法
    static class Solution {
        List<List<String>> res = new ArrayList<>();
        public List<List<String>> partition(String s) {
            if(s.length() == 0){
                return res;
            }

            dfs(0, s, new ArrayList<>());
            return res;
        }

        void dfs(int index, String s, List<String> save){
            if(index == s.length()){
                res.add(new ArrayList<>(save));
                return;
            }

            for(int i = index; i < s.length(); i++){
                if(isPar(index, i, s)){
                    save.add(s.substring(index, i+1));
                    dfs(i+1, s, save);
                    save.remove(save.size()-1);
                }
            }
        }

        //判断是否是回文串
        boolean isPar(int start, int end, String str){
            while(start <= end){
                if(str.charAt(start) != str.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }

        boolean isPar(String str){
            StringBuilder sb = new StringBuilder();
            for(int i = str.length()-1; i >= 0; i--){
                sb.append(str.charAt(i));
            }
            return str.equals(sb.toString());
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.partition("aab");
    }

}
