package 数据结构;

import java.util.HashMap;

/**
 * @Author: pyh
 * @Date: 2019/2/27 11:15
 * @Version 1.0
 * @Function:
 *  实现前缀树的数据结构，
 *      实现前缀树 插入，查找，起始操作
 *
 */
public class 前缀树 {

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    class Trie {
        private class Node{
            public boolean isWord;
            public HashMap<Character, Node> next = new HashMap<>();
            public Node(boolean isWord){
                this.isWord = isWord;
            }
            public Node(){
                this.isWord = false;
            }
        }

        private Node root;
        private int size = 0;
        /** Initialize your data structure here. */
        public Trie() {
            size = 0;
            root = new Node();
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

}
