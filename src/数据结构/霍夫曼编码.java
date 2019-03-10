package 数据结构;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: pyh
 * @Date: 2019/3/5 16:54
 * @Version 1.0
 * @Function:   实现霍夫曼编码，字符
 */
public class 霍夫曼编码 {

    public class Huffman{
        private class Node implements Comparable<Node>{
            char ch;//字符
            int freq;//出现频率
            boolean isLeaf;//是否是叶子节点
            Node left, right;

            public Node(char ch, int freq){
                this.ch = ch;
                this.freq = freq;
                isLeaf = true;
            }

            public Node(Node left, Node right, int freq){
                this.left = left;
                this.right = right;
                this.freq = freq;
                isLeaf = false;
            }

            @Override
            public int compareTo(Node o) {
                return this.freq - o.freq;
            }
        }

        //生成霍夫曼树
        public Map<Character, String> encode(Map<Character, Integer> frequencyForChar){
            //建立优先队列，根据出现频率建立堆
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
            for(Character c : frequencyForChar.keySet()){
                priorityQueue.add(new Node(c, frequencyForChar.get(c)));
            }

            while(priorityQueue.size() != 1){
                Node node1 = priorityQueue.poll();
                Node node2 = priorityQueue.poll();
                priorityQueue.add(new Node(node1, node2, node1.freq + node2.freq));//重新入队
            }

            //返回根节点
            return encode(priorityQueue.poll());
        }

        //返回对应编码
        private Map<Character, String> encode(Node root){
            Map<Character, String> encodingForChar = new HashMap<>();
            encode(root, "", encodingForChar);// 转换编码
            return encodingForChar;
        }
        //生成编码
        private void encode(Node node, String encoding, Map<Character, String> encodingForChar){
            if(node.isLeaf){
                encodingForChar.put(node.ch, encoding);
                return;
            }
            encode(node.left, encoding + '0', encodingForChar);
            encode(node.right, encoding + '1', encodingForChar);
        }
    }

}
