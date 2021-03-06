package LeetCode;

import java.util.HashMap;

/**
 * @Author: pyh
 * @Date: 2019/2/27 19:19
 * @Version 1.0
 * @Function:   211. 添加与搜索单词 - 数据结构设计
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 */
public class Solution211_添加与搜索单词_数据结构设计 {

    /**
     * 前缀树
     * */
    class WordDictionary {

        class Node{
            public boolean isWord;
            public HashMap<Character, Node> next = new HashMap<>();
            public Node(){
                this.isWord = false;
            }
            public Node(boolean isWord){
                this.isWord = isWord;
            }
        }

        private Node root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.next.get(c) == null){
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            if(!cur.isWord){
                cur.isWord = true;
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return match(root, word, 0);
        }
        //节点、单词、序号（走到哪一部分）
        private boolean match(Node node, String word, int index){
            if(index == word.length()){
                return node.isWord;
            }

            char c = word.charAt(index);
            //关键,如果是字符'.'
            if(c == '.'){
                for(char nextChar : node.next.keySet()){
                    //如果下一个返回true，则返回true
                    if(match(node.next.get(nextChar), word, index + 1)){
                        return true;
                    }
                }
                return false;
            } else{
                if(node.next.get(c) == null){
                    return false;
                }
                return match(node.next.get(c), word, index + 1);
            }
        }

    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

}
