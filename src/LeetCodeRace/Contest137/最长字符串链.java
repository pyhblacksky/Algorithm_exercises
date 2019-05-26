package LeetCodeRace.Contest137;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: pyh
 * @Date: 2019/5/19 11:14
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给出一个单词列表，其中每个单词都由小写英文字母组成。
 *
 * 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是 "abac" 的前身。
 *
 * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2 的前身，word_2 是 word_3 的前身，依此类推。
 *
 * 从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。
 *
 *
 * 示例：
 *
 * 输入：["a","b","ba","bca","bda","bdca"]
 * 输出：4
 * 解释：最长单词链之一为 "a","ba","bda","bdca"。
 */
public class 最长字符串链 {

    public int longestStrChain(String[] words) {
        Set<String> dict = new HashSet<>();
        for (String word : words) {
            dict.add(word);
        }
        int ans = 0;
        Map<String, Integer> memo = new HashMap<>();
        for (String s : dict) {
            ans = Math.max(ans, func(s, dict, memo));
        }
        return ans;
    }

    int func(String latter, Set<String> dict, Map<String, Integer> memo) {
        if (memo.containsKey(latter)) {
            return memo.get(latter);
        }
        int ans = 1;
        for (int i = 0; i < latter.length(); i++) {
            String former = latter.substring(0, i) + latter.substring(i + 1, latter.length());
            if (dict.contains(former)) {
                ans = Math.max(ans, 1 + func(former, dict, memo));
            }
        }

        memo.put(latter, ans);
        return ans;
    }


    public static void main(String[] args) {
//        Solution sol = new Solution();
//        System.out.println(sol.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }

}
