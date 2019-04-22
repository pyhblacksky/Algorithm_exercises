package LeetCode;

import java.util.HashSet;

/**
 * @Author: pyh
 * @Date: 2019/4/22 17:07
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution3_无重复字符的最长子串 {
    //贪心
    public int lengthOfLongestSubstring(String s) {
        //贪心
        HashSet<Character> set = new HashSet<>();
        int count = 1;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
            for(int j = i+1; j < s.length() && s.charAt(i) != s.charAt(j) && !set.contains(s.charAt(j)); j++){
                set.add(s.charAt(j));
                count++;
            }
            System.out.println(count);
            max = Math.max(count, max);
            count = 1;
            set = new HashSet<>();
        }
        return max;
    }

    //使用滑动窗口
    /**
     * 建立一个256位大小的整型数组freg，用来建立字符和其出现位置之间的映射
     *
     * 维护一个滑动窗口，窗口内的都是没有重复的字符，尽可能的扩大窗口的大小，窗口不停的向右滑动
     *  （1）如果当前遍历到的字符从未出现过，那么直接扩大有边界
     *  （2）如果当前遍历到的字符出现过，则缩小窗口（左边索引向右移动），继续观察当前遍历到的字符
     *  （3）重复（1）（2）直到左边索引无法再移动
     *  （4）维护一个结果res，每次用出现过的窗口大小来更新结果res，最后返回res获取结果
     * */
    public int lengthOfLongestSubstring1(String s) {
        int size = s.length();
        int i = 0;
        int max = 0;
        for(int j = 0;j < size; j++){
            for(int k = i; k < j; k++)
                if(s.charAt(k) == s.charAt(j)){
                    i = k + 1;
                    break;
                }
            if(j - i + 1 > max)
                max = j - i + 1;
        }
        return max;
    }
}
