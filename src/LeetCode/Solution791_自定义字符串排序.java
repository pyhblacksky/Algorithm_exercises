package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/2/27 21:08
 * @Version 1.0
 * @Function:   791、自定义字符串排序
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 *
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 *
 * 返回任意一种符合条件的字符串T。
 *
 * 示例:
 * 输入:
 * S = "cba"
 * T = "abcd"
 * 输出: "cbad"
 * 解释:
 * S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 * 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 */
public class Solution791_自定义字符串排序 {

    //使用计数排序的思想
    public String customSortString(String S, String T) {
        int[] countArr = new int[26];
        for(char c : T.toCharArray()){
            countArr[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            if(countArr[c-'a'] != 0){
                for(int i = 0; i < countArr[c-'a']; i++){
                    sb.append(c);
                }
                countArr[c-'a'] = 0;
            }
        }

        for(int i = 0; i < 26; i++){
            if(countArr[i] != 0){
                char c = (char)(i+'a');
                for(int j = 0; j < countArr[i]; j++){
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

}
