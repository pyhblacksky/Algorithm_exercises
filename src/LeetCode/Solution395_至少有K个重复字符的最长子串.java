package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/6/5 8:24
 * @Version: 1.0
 * @Function:
 * @Description:
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */
public class Solution395_至少有K个重复字符的最长子串 {

    /**
     * 核心思想：如果某个字符 x 在整个字符串中出现的次数 <k，那么 x 不可能出现在最终要求的子串中。
     *  因此，可以将原字符串截断为：
     *      x 左侧字符子串 + x + x 右侧字符子串
     * */
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0 || k > s.length()){
            return 0;
        }
        if(k < 2){
            return s.length();
        }

        return help(s, k, 0, s.length() - 1);
    }
    //换了个数据结构存储
    static int help(String s, int k, int left, int right){
        if(right - left + 1 < k){
            return 0;
        }
        int[] cnt = new int[26];//只有小写字符,计数数组
        for(int i = left; i <= right; i++){
            cnt[s.charAt(i) - 'a']++;
        }

        //加速
        while(right - left + 1 >= k && cnt[s.charAt(left) - 'a'] < k)
            left++;
        while(right - left + 1 >= k && cnt[s.charAt(right) - 'a'] < k)
            right--;

        if(right - left + 1 < k)
            return 0;

        for(int i = left; i <= right; i++){
            if(cnt[s.charAt(i) - 'a'] < k)
                return Math.max(help(s, k, left, i-1), help(s, k, i+1, right));
        }
        return right - left + 1;
    }



    /*****************************************************************************/
    //以下方法超时 ，  暂时放弃...
    public static int longestSubstring1(String s, int k) {
        if(s == null || s.length() == 0 || k > s.length()){
            return 0;
        }

        return find(s, k, 0, s.length() - 1);
    }
    //遗憾超时..
    public static int find(String s, int k, int left, int right){
        if(left > right){
            return 0;
        }

        // 用字典存储所有字符出现的情况
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> index = new HashMap<>();
        for(int i = left; i <= right; i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
                index.put(c, i);
            } else{
                map.put(c, map.get(c)+1);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            int count = entry.getValue();//字符出现次数
            if(count > 0 && count < k){
                int pos = index.get(entry.getKey()) ;//该字符首次出现的位置
                return Math.max(find(s, k, left, pos - 1), find(s, k, pos+1, right));
            }
        }
        return right - left + 1;
    }

}
