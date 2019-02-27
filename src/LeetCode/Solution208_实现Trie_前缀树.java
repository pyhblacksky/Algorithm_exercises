package LeetCode;

import java.util.HashMap;

/**
 * @Author: pyh
 * @Date: 2019/2/27 14:42
 * @Version 1.0
 * @Function:   208、实现Trie(前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Solution208_实现Trie_前缀树 {

    class Trie {

        //前缀树节点的结构
        public class Node{
            public boolean isWord;
            public HashMap<Character, Node> next = new HashMap<>();
            public Node(boolean isWord){
                this.isWord = isWord;
            }
            public Node(){
                this.isWord = false;
            }
        }

        //前缀树根节点
        private Node root;
        private int size;
        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
            size = 0;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.next.get(c) == null){
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }

            //插入完毕，为单词，改变isWord
            if(!cur.isWord){
                cur.isWord = true;
                size++;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.next.get(c) == null){
                    return false;
                }
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node cur = root;
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if(cur.next.get(c) == null){
                    return false;
                }
                cur = cur.next.get(c);
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

}
