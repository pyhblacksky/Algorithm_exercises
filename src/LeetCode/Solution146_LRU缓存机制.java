package LeetCode;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/4/21 20:18
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 );// 缓存容量
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
public class Solution146_LRU缓存机制 {

    //利用继承LinkedHashMap实现
    public class LRUCache1 extends LinkedHashMap{

        private final int CACHE_SIZE;

        public LRUCache1(int capacity) {
            super(capacity, 0.75f, true);
            CACHE_SIZE = capacity;
        }

        protected boolean removeEldestEntry(Map.Entry eldest){
            return size() > CACHE_SIZE;
        }

        public int get(int key) {
            if(super.get(key) == null){
                return -1;
            }
            return (int) super.get(key);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }
    }


    //不使用继承LinkedHashMap实现，使用LinkedList的特性
    class LRUCache2 {

        LinkedHashMap<Integer, Integer> saveMap;

        int size;


        public LRUCache2(int capacity) {
            this.size = capacity;
            saveMap = new LinkedHashMap<>();
        }

        public int get(int key) {
            if(saveMap.isEmpty() || saveMap.get(key) == null){
                return -1;
            }

            int num = saveMap.get(key);
            saveMap.remove(key);
            saveMap.put(key, num);

            return num;
        }

        public void put(int key, int value) {
            if(get(key) != -1){
                saveMap.remove(key);
                saveMap.put(key, value);
                return;
            }
            if(saveMap.size() == size){
                for(Map.Entry<Integer, Integer> entry : saveMap.entrySet()){
                    saveMap.remove(entry.getKey());
                    break;
                }
            }

            saveMap.put(key,value);
        }
    }

    //组合  哈希表 + 双向链表
    class LRUCache {

        //自定义节点
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }

        private void addNode(DLinkedNode node) {
            /**
             * Always add the new node right after head.
             */
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node){
            /**
             * Remove an existing node from the linked list.
             */
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DLinkedNode node){
            /**
             * Move certain node in between to the head.
             */
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail() {
            /**
             * Pop the current tail.
             */
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private Hashtable<Integer, DLinkedNode> cache =
                new Hashtable<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            // head.prev = null;

            tail = new DLinkedNode();
            // tail.next = null;

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) return -1;

            // move the accessed node to the head;
            moveToHead(node);

            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if(node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                cache.put(key, newNode);
                addNode(newNode);

                ++size;

                if(size > capacity) {
                    // pop the tail
                    DLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // update the value.
                node.value = value;
                moveToHead(node);
            }
        }

    }

}
