package LeetCode;

import java.util.HashMap;

/**
 * @Author: pyh
 * @Date: 2019/2/27 15:13
 * @Version 1.0
 * @Function:   677、键值映射
 *
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 * 示例 1:
 *
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 *
 * 思想：前缀树
 */
public class Solution677_键值映射 {

    /**
     * 方法一：前缀树
     * */
    //前缀树的方法
    class MapSum {

        //前缀树节点
        public class Node{
            public int val = 0;
            public HashMap<Character, Node> next = new HashMap<>();
            public Node(int val){
                this.val = val;
            }
            public Node(){

            }
        }

        private Node root;
        /** Initialize your data structure here. */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node cur = root;
            for(int i = 0; i < key.length(); i++){
                char c = key.charAt(i);
                if(cur.next.get(c) == null){
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            //更新val值
            cur.val = val;
        }

        public int sum(String prefix) {
            Node cur = root;
            //先遍历到以prefix开头的串
            for(int i = 0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if (cur.next.get(c) == null){
                    return 0;
                }
                cur = cur.next.get(c);
            }
            //对接下来的数值相加,递归
            return sum(cur);
        }

        //递归相加
        private int sum(Node node){
            int val = node.val;
            for(char c : node.next.keySet()){
                val += sum(node.next.get(c));
            }
            return val;
        }
    }

    /**
     * 方法二：直接使用HashMap及 String 的库方法
     * */
    //直接HashMap
    class MapSum1{
        public HashMap<String, Integer> map = new HashMap<>();

        public MapSum1() {

        }

        public void insert(String key, int val) {
            map.put(key,val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for(String str : map.keySet()){
                if(str.startsWith(prefix)){
                    sum += map.get(str);
                }
            }
            return sum;
        }

    }

}
