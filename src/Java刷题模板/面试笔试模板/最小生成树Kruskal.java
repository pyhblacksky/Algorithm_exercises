package Java刷题模板.面试笔试模板;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/29 15:16
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * Kruskal算法思想及流程
 *
 * 1、首先各个顶点看成一个集合，每个顶点的根就是自己；
 * 2、从整个图中边的集合中取出最小的一条(一开始对边的集合排序)，判断该边的两个定点是不是同一个集合，
 *      如果不是，合并两个集合；
 * 3、如果是同一个集合，舍弃，继续取下一条边；
 * 4、直到集合中有n - 1条边为止；
 *
 * 时间复杂度为为O(e2), 使用并查集优化后复杂度为 O（eloge），与网中的边数有关，适用于求边稀疏的网的最小生成树
 *
 */
public class 最小生成树Kruskal {

    /**********************************************************/
    //并查集
    static class UnionSet{
        public int[] parent;
        public int[] rank;

        public UnionSet(int size){
            parent = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int a){
            if(a < 0 || a > parent.length){
                throw new IllegalArgumentException("Out of bound!");
            }
            while(a != parent[a]){
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
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
    /**********************************************************/
    //边的类
    static class Edge implements Comparable<Edge>{
        public int from;
        public int to;
        public int w;

        public Edge(int from, int to, int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }
        public int compareTo(Edge o){
            return w - o.w;
        }
    }

    //Kruskal算法核心, edges是边集合，n是顶点数
    //求出最小生成树的权值
    static int kruskal(ArrayList<Edge> edges, int n){
        Collections.sort(edges);
        UnionSet uset = new UnionSet(n);
        int res = 0;    //记录权值
        int count = 0;  //记录最小生成树的顶点数
        for(int i = 0; i < edges.size(); i++){
            int from = edges.get(i).from;
            int to = edges.get(i).to;
            int w = edges.get(i).w;
            if(!uset.isSameSet(from, to)){
                //两个顶带你不属于同一个集合
                res += w;
                count++;
                if(count == n - 1){
                    break;
                }
                uset.union(from, to);//连接
            }
        }
        return count == n - 1 ? res : -1;//最后判断是否有最小生成树
    }

    //测试方法
    public static void main(String[] args){
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while(cin.hasNext()){
            int m = cin.nextInt();//输入边的数目
            int n = cin.nextInt();//输入顶点数。
            if(m == 0){
                break;
            }
            ArrayList<Edge> edges = new ArrayList<>();
            for(int i = 0; i < m; i++){
                int from = cin.nextInt();
                int to = cin.nextInt();
                int w = cin.nextInt();
                edges.add(new Edge(from, to, w));
                edges.add(new Edge(to, from, w));
            }
            int res = kruskal(edges, n);
            System.out.println(res);
        }
    }

}
