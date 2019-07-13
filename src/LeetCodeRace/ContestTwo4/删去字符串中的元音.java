package LeetCodeRace.ContestTwo4;

/**
 * @Author: pyh
 * @Date: 2019/7/13 22:34
 * @Description:
 * 给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："leetcodeisacommunityforcoders"
 * 输出："ltcdscmmntyfrcdrs"
 * 示例 2：
 *
 * 输入："aeiou"
 * 输出：""
 *
 *
 * 提示：
 *
 * S 仅由小写英文字母组成。
 * 1 <= S.length <= 1000
 */

public class 删去字符串中的元音 {

    class Solution {
        public String removeVowels(String S) {
            if(S == null || S.length() == 0)
                return S;

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < S.length(); i++){
                char c = S.charAt(i);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    continue;
                }
                sb.append(c);
            }

            return sb.toString();
        }
    }

}
