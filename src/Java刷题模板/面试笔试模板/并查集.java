package Java刷题模板.面试笔试模板;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/24 22:20
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 例题 ： POJ - 1611. The Suspects        http://poj.org/problem?id=1611
 *
 * 100 4
 * 2 1 2
 * 5 10 13 11 12 14
 * 2 0 1
 * 2 99 2
 * 200 2
 * 1 5
 * 5 1 2 3 4 5
 * 1 0
 * 0 0
 * Sample Output
 *
 * 4
 * 1
 * 1
 *
 *  讲解：https://github.com/ZXZxin/ZXBlog/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%AE%97%E6%B3%95/Data%20Structure/UnionFind/POJ%20-%201611.%20The%20Suspects%E4%BB%A5%E5%8F%8A%E5%B9%B6%E6%9F%A5%E9%9B%86%E6%80%BB%E7%BB%93.md
 *
 * 题意
 *      就是告诉你0号同学被感染了，他还参加了一些社团，给出一些社团以及里面的人，问总共多少人感染。
 *      输入给出n表示人数(标号为0~n-1)，m表示社团数目，接下来m行每行第一个数k ，表示该社团有k人，
 *      然后是k个人的编号。要你输出有多少个人感染了病毒。
 *
 * 解析
 * 题目本身并不难:
 *      把每个社团加入到各自的集合中，然后不断的合并相同的集合，最后看哪些和0号同学在同一个集合中，
 *      使用一个变量记录和0号同学在同一个集合中的人数即可；
 *      这里主要是总结并查集几种优化的方式；
 *
 * 基本并查集
 *      基本并查集，记录一个每个结点p的父亲结点是parent[p]，然后是一个不断从孩子找父亲的过程:
 *
 *      find()操作， while(p != parent[p])p = parent[p]，一直往上找根的过程；
 *      union()操作，就是找到两个结点的根节点，然后将其中一个结点的根节点挂到另一个结点的根节点即可；
 *      例如: union()操作合并6和3所在的集合:
 */
public class 并查集 {

    //并查集数据结构
    static class UnionSet{
        private int[] parent;

        public UnionSet(int size){
            parent = new int[size];

            //初始化，每个parent[i]都指向自己，表示每一个元素自成一个集合
            for(int i = 0; i < size; i++){
                parent[i] = i;
            }
        }

        public int size(){
            return parent.length;
        }

        //查找, 查找元素p所对应的集合编号
        private int find(int p){
            if(p < 0 || p >= parent.length){
                throw new IllegalArgumentException("p is out of bound!");
            }
            while(p != parent[p]){
                p = parent[p];
            }
            return p;
        }

        //合并元素p和元素q所属的集合
        public void union(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if(aRoot == bRoot){
                return;
            }
            parent[aRoot] = bRoot;// aRoot 指向 bRoot
        }

        //是否是同一个集合
        public boolean isSameSet(int a, int b){
            return find(a) == find(b);
        }
        
    }

    //Size优化并查集
    /**
     * 每一个集合记录一个size，在union()操作的时候，
     * 我们将size小的挂到size大的下面，这样会使得深度稍微小一点；
     * 操作完之后记得维护被挂的那个集合的size()；
     * */
    class UnionSet1{
        private int[] parent;
        private int[] sz;   //sz[i]表示 以i为根的集合中元素个数

        public UnionSet1(int size){
            parent = new int[size];
            sz = new int[size];
            /*初始化， 每一个parent[i]指向子集，表示每一个元素自成一个集合*/
            for(int i = 0; i < size; i++){
                parent[i] = i;
                sz[i] = 1;
            }
        }

        public int size(){
            return parent.length;
        }

        private int find(int p){
            if(p < 0 || p > size()){
                throw new IllegalArgumentException("p is out of bound！");
            }
            while(p != parent[p]){
                p = parent[p];
            }
            return p;
        }

        public boolean isSameSet(int a, int b){
            return find(a) == find(b);
        }

        public void union(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if(aRoot == bRoot){
                return;
            }

            /**
             * 根据两个元素所在树的元素铬铜合并方向
             * 将元素个数少的集合合并到元素个数多的集合上
             * */
            if(sz[aRoot] < sz[bRoot]){
                parent[aRoot] = bRoot;
                sz[bRoot] += sz[aRoot];
            } else{
                parent[bRoot] = aRoot;
                sz[aRoot] += sz[bRoot];
            }
        }
    }

    /**
     * Rank优化并查集
     * 基于rank的优化，其中rank[i]表示的是根节点为i的树的高度；
     * 高度小的挂在高度大的下面，这样使得深度更低；
     * */
    class UnionSet2{
        private int[] parent;
        private int[] rank;

        public UnionSet2(int size){
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
                throw new IllegalArgumentException("p is out of bound!");
            }
            while(p != parent[p]){
                p = parent[p];
            }
            return p;
        }

        public boolean isSameSet(int a, int b){
            return find(a) == find(b);
        }

        public void union(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if(aRoot == bRoot){
                return;
            }

            /**
             * 根据两个元素所在树的rnak不同判断合并方向
             * 将rank低的集合合并到rank高的集合上
             * */
            if(rank[aRoot] < rank[bRoot]){
                parent[aRoot] = bRoot;
            } else if(rank[bRoot] < rank[aRoot]){
                parent[bRoot] = aRoot;
            } else{
                parent[aRoot] = bRoot;
                //此时维护rank的值
                rank[bRoot]++;
            }
        }
    }

    /**
     * 路径压缩优化，最好
     * 在find()的时候，沿途将查找的孩子结点改变他们的父亲parent达到路径压缩的目的
     * */
    class UnionSet3{
        private int[] parent;
        private int[] rank;

        public UnionSet3(int size){
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
                /*只加入这一行，改变结构   p这个结点的父亲设置为它父亲的父亲*/
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean isSameSet(int a, int b){
            return find(a) == find(b);
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
    }

    //测试方法
    public static void main(String[] args){
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while(cin.hasNext()){
            //已知0号被感染
            int n = cin.nextInt();//总共有n个同学
            int m = cin.nextInt();//总共有m个社团
            if(n == 0 && m == 0){
                break;
            }

            UnionSet unionSet = new UnionSet(n);

            for(int i = 0; i < m; i++){
                int k = cin.nextInt();//表示这个社团中有k个人
                int root = cin.nextInt();//默认以第一个同学作为并查集的根
                for(int j = 0; j < k - 1; j++){
                    //此时剩余k-1个人
                    int x = cin.nextInt();
                    unionSet.union(root, x);
                }
            }

            int sum = 1;//0号感染，感染人数为1
            for(int i = 1; i < n; i++){
                //从1号开始计算
                if(unionSet.isSameSet(0, i)){
                    //是同一个集合，说明也被感染，+1
                    sum++;
                }
            }

            System.out.println(sum);
        }
    }

}
