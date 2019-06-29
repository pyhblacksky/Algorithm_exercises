package LeetCodeRace.ContestTwo3;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: pyh
 * @Date: 2019/6/29 22:36
 * @Description:
 * 给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "havefunonleetcode", K = 5
 * 输出：6
 * 解释：
 * 这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
 * 示例 2：
 *
 * 输入：S = "home", K = 5
 * 输出：0
 * 解释：
 * 注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 10^4
 * S 中的所有字符均为小写英文字母
 * 1 <= K <= 10^4
 */

public class 长度为K的无重复字符子串 {

    //依然暴力
    static class Solution {
        public int numKLenSubstrNoRepeats(String S, int K) {
            if(S == null || S.length() == 0 || K > S.length()){
                return 0;
            }

            int count = 0;
            for(int i = 0; i < S.length(); i++){
                Set<Character> set = new HashSet<>();
                set.add(S.charAt(i));
                if(set.size() == K){
                    count++;
                    continue;
                }
                for(int j = i+1; j < S.length(); j++){
                    if(!set.contains(S.charAt(j))){
                        set.add(S.charAt(j));
                    } else{
                        break;
                    }

                    if(set.size() == K){
                        count++;
                        break;
                    }
                }
            }

            return count;
        }
    }

}
