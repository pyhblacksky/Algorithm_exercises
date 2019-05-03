package Java刷题模板.面试笔试模板;

import java.util.HashMap;

/**
 * @Author: pyh
 * @Date: 2019/4/26 21:59
 * @Version: 1.0
 * @Function:
 * @Description:
 * leetCode 208
 *
 */
public class 字典树 {

    //方法一，速度较慢
    class Trie1 {

        public class Node{
            boolean isWord;
            HashMap<Character, Node> next = new HashMap<>();
            public Node(){
                this.isWord = false;
            }
        }

        private int size;
        private Node root;
        /** Initialize your data structure here. */
        public Trie1() {
            root = new Node();
            size = 0;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(cur.next.get(ch) == null){
                    cur.next.put(ch, new Node());
                }
                cur = cur.next.get(ch);
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
                char ch = word.charAt(i);
                if(cur.next.get(ch) == null){
                    return false;
                }
                cur = cur.next.get(ch);
            }
            return cur.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node cur = root;
            for(int i = 0; i < prefix.length(); i++){
                char ch = prefix.charAt(i);
                if(cur.next.get(ch) == null){
                    return false;
                }
                cur = cur.next.get(ch);
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

    //方法二
    static class Trie{

        //字典树节点结构
        private class Node{
            int path;
            int end;
            Node[] next;//使用整数表示字符 c - 'a'

            public Node(){
                path = 0;
                end = 0;
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
                int index = word.charAt(i) - 'a';
                if(cur.next[index] == null){
                    //没有则新建一个
                    cur.next[index] = new Node();
                }
                cur = cur.next[index];
                cur.path++;//经过
            }
            cur.end++;//以当前为终点
        }

        //统计某个字符串的数量
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

        public boolean search(String word){
            return count(word) > 0;
        }

        //求前缀是prefix的数量
        public int prefixNum(String prefix){
            if(prefix == null || prefix.length() == 0){
                return 0;
            }
            Node cur = root;
            for(int i = 0; i < prefix.length(); i++){
                int index = prefix.charAt(i) - 'a';
                if(cur.next[index] == null){
                    return 0;
                }
                cur = cur.next[index];
            }
            return cur.path;//经过此，即以此为前驱
        }

        public boolean startsWith(String prefix){
            return prefixNum(prefix) > 0;
        }

        //在trie中删除word
        public void remove(String word){
            if(word == null || word.length() == 0){
                return;
            }
            if(!search(word)){//没有这个字符串
                return;
            }
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';
                if(--cur.next[index].path == 0){
                    //释放下面的树
                    cur.next[index] = null;
                    return;
                }
                cur = cur.next[index];
            }
            cur.end--;//单词数减一
        }

    }

    //测试函数
    public static void main(String[] args){
        Trie trie = new Trie();

        trie.insert("abc");
        trie.insert("ab");
        trie.insert("ab");
        trie.insert("abd");
        trie.insert("bc");
        trie.insert("bd");
        trie.insert("cd");
        trie.insert("cde");
        trie.insert("ce");

        System.out.println(trie.count("ab"));
        trie.remove("ab");
        System.out.println(trie.count("ab"));

        System.out.println(trie.count("abd"));
        trie.remove("ab");
        System.out.println(trie.count("ab"));
        System.out.println(trie.count("abd"));

        trie.remove("abd");
        System.out.println(trie.count("abd"));

    }

}
