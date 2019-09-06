package 校招笔试2020.顺丰829;

import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/8/29 18:43
 * @Version: 1.0
 * @Function:
 * @Description:
 * 题目描述：
 * 某学术会议上，一共有n个人参加，现在已知每个人会的语言（一个人可能不会任何语言）。现在有一种学习机，每一个学习机可以在会议期间使一个人暂时掌握一种自己不会的语言，问要使得任意两人都要能直接或者间接的交流至少准备多少个学习机？
 *
 * 间接交流的意思是：可以通过其他参加会议的人翻译（可能或出现很多人一起帮忙翻译的情况）进行交流。如：第一个人和第二个人会第一种语言，第二个人和第三个人会第二种语言，那么第一个人可以和第三个人进行交流（通过第二个人的翻译）
 *
 * 输入
 * 第一行3个数n,m,k代表人数，语言数，已知的信息数 接下来k行，每行两个数u,v，代表u第个人会第v种语言
 *
 * 输出
 * 输出需要准备的学习机的个数
 *
 *
 * 样例输入
 * 3 3 2
 * 2 3
 * 3 1
 * 样例输出
 * 2
 *
 * 提示
 * 数据范围
 * 1≤n≤100000 , 1≤m≤100000 , 0≤k≤100000 , 1≤u≤n , 1≤v≤m
 */
public class Main1 {

    //36%
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        byte[][] arr = new byte[n][m];
        Set<Integer> speakSet = new HashSet<>();
        while(k != 0){
            k--;
            int man = sc.nextInt();
            int speak = sc.nextInt();
            speakSet.add(speak-1);
            arr[man-1][speak-1] = (byte)1;
        }

        //遍历矩阵
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            boolean flag = true;
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] != 0){
                    flag = false;
                }
            }
            if(flag)
                count++;
        }

        int res = count + (m-speakSet.size());
        System.out.println(res);

    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        Set<Integer> speakSet = new HashSet<>();
        Set<Integer> manSet = new HashSet<>();
        while(k != 0){
            k--;
            int man = sc.nextInt();
            int speak = sc.nextInt();
            speakSet.add(speak);
            manSet.add(man);
        }

        int res = (n-manSet.size()) + (m-speakSet.size());
        System.out.println(res);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        UnionSet set = new UnionSet(n);
        Map<Integer, Set<Integer>> map = new LinkedHashMap<>();
        while(k != 0){
            k--;
            int man = sc.nextInt();
            int speak = sc.nextInt();
            if(map.get(man) == null){
                map.put(man, new LinkedHashSet<>());
                map.get(man).add(speak);
            } else{
                map.get(man).add(speak);
            }
        }

        //list有交集，合并
        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            for(Map.Entry<Integer, Set<Integer>> inner : map.entrySet()){
                if(!entry.getKey().equals(inner.getKey())){
                    //集合有交集，合并
                    Set<Integer> s1 = entry.getValue();
                    Set<Integer> s2 = entry.getValue();
                    if(s1.retainAll(s2)){
                        set.union(entry.getKey()-1, inner.getKey()-1);
                    }
                }
            }
        }

        int res = n-map.size();
        res += m-set.getNumOfRoot();
        System.out.println(res);
    }


    //并查集
    static class UnionSet{
        private int[] parent;
        private int[] rank;

        public UnionSet(int size){
            parent = new int[size];
            rank = new int[size];

            for(int i = 0; i < size; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int size(){
            return parent.length;
        }

        private int find(int p){
            if(p < 0 || p > size()){
                throw new IllegalArgumentException("p is out f bound");
            }

            while(p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if(aRoot == bRoot){
                return;
            }

            if(rank[aRoot] < rank[bRoot]){
                parent[aRoot] = bRoot;
            } else if(rank[bRoot] < rank[aRoot]){
                parent[bRoot] = aRoot;
            } else{
                parent[aRoot] = bRoot;
                rank[bRoot]++;
            }
        }

        public int getNumOfRoot(){
            int count = 0;
            for(int i = 0; i < parent.length; i++){
                if(parent[i] == i){
                    count++;
                }
            }

            return count;
        }
    }

}
