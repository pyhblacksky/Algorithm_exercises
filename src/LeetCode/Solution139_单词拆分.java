package LeetCode;

import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/5/25 10:52
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Solution139_单词拆分 {

    //动态规划...
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean[] memo = new boolean[n+1];//表示以i结尾的字符是否在字典中
        memo[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(memo[j] && wordDict.contains(s.substring(j, i))){
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }

    /********************************************************/
    //使用字典树
    class Trie{

        public class Node{
            int end;
            int path;
            Node[] next;

            public Node(){
                end = 0;
                path = 0;
                next = new Node[26];
            }
        }

        private Node root;

        public Trie(){
            root = new Node();
        }

        public void insert(String word){
            if(word == null || word.length() == 0){
                return;
            }

            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                int pos = word.charAt(i) - 'a';
                if(cur.next[pos] == null){
                    cur.next[pos] = new Node();
                }
                cur = cur.next[pos];
                cur.path++;
            }
            cur.end++;
        }

        public int count(String word){
            if(word == null || word.length() == 0){
                return 0;
            }

            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(cur.next[index] == null){
                    return 0;
                }
                cur = cur.next[index];
            }
            return cur.end;
        }

        public boolean isWord(String word){
            return count(word) > 0;
        }
    }

}
