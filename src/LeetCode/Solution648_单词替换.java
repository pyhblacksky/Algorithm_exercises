package LeetCode;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/2/27 16:15
 * @Version 1.0
 * @Function:   648、单词替换
 *
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 * 示例 1:
 *
 * 输入: dict(词典) = ["cat", "bat", "rat"]
 * sentence(句子) = "the cattle was rattled by the battery"
 * 输出: "the cat was rat by the bat"
 * 注:
 *
 * 输入只包含小写字母。
 * 1 <= 字典单词数 <=1000
 * 1 <=  句中词语数 <= 1000
 * 1 <= 词根长度 <= 100
 * 1 <= 句中词语长度 <= 1000
 */
public class Solution648_单词替换 {

    /**
     * 方法一：前缀树      存在问题！
     * */
    public String replaceWords1(List<String> dict, String sentence) {
        Trie trie = new Trie();
        String[] strArr = sentence.split("\\s+");
        for(int i = 0; i < strArr.length; i++){
            trie.insert(strArr[i]);
        }

        String res = new String();
        boolean jump = false;
        for(int i = 0; i < strArr.length; i++){
            jump = false;
            for(int j = 0; j < dict.size(); j++){
                if(trie.startWiths(dict.get(j))){
                    res += dict.get(j) + " ";
                    jump = true;
                    break;
                }
            }
            if(jump) continue;
            res += strArr[i] + " ";
        }

        return res;
    }
    class Trie{
        public class Node{
            int num = 0;//计数存在问题
            HashMap<Character, Node> next;
            Node(){
                next = new HashMap<>();
            }
        }

        private Node root;
        public Trie(){
            root = new Node();
        }

        public void insert(String word){
            Node cur = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(cur.next.get(c) == null){//或者!contains()
                    cur.next.put(c, new Node());
                }
                cur.num++;
                cur = cur.next.get(c);
            }

        }

        public boolean startWiths(String prefix){
            Node cur = root;
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if(cur.next.get(c) == null){
                    return false;
                }
                cur = cur.next.get(c);
            }
            if(cur.num == 0){
                return false;
            }
            cur.num--;
            return true;
        }
    }

    /**
     * 方法二：String方法
     * */
    public String replaceWords(List<String> dict, String sentence) {
        String[] strArr = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        boolean jump = false;
        for(int i = 0; i < strArr.length; i++){
            jump = false;
            for(int j = 0; j < dict.size(); j++){
                if(strArr[i].startsWith(dict.get(j))){
                    sb.append(dict.get(j));
                    sb.append(" ");
                    jump = true;
                    break;
                }
            }
            if(jump) continue;
            sb.append(strArr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
