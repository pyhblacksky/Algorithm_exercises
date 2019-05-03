package Java刷题模板.面试笔试模板;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/29 15:20
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * Prim算法思想及流程:
 * 1、一开始也有一个集合，和Kruskal算法不同的是，这个不是慢慢的合并(通过并查集)变大，而是一个一个的添加结点；
 * 2、一开始选择一个起点，有一个优先队列存放边的集合，把这个结点相连的边加入优先队列；
 * 3、然后选择一条相连的且权值最小的边，并判断这条边的终点是否已经加入过点的集合
 *      (准确的来说是看这两个点相连的边是否已经加入过集合(但是这里是用两个端点都是否进过vis数组替代))，
 *      如果没有，就加入，并且把这条边加入到结果集，并且解锁和它相连的边(解锁就是把边加入到优先队列)
 * 4、如果出现过，继续从优先队列中拿出最小的边判断；
 * 5、直到结果集达到n-1条边，或者图不连通；
 */
public class 最小生成树Prim {

    //边的类
    static class Edge implements Comparable<Edge>{
        public int to;
        public int w;
        public Edge(int to, int w){
            this.to = to;
            this.w = w;
        }

        public int compareTo(Edge o){
            return w - o.w;
        }
    }

    //prim核心方法
    //start-起点，vis-是否访问过的数组，n-顶点数，G-图集
    private static int prim(int start, ArrayList<Edge>[] G, boolean[] vis, int n){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < G[start].size(); i++){
            pq.add(G[start].get(i));
        }
        int count = 0;
        int res = 0;
        vis[start] = true;//起始节点已经在集合中
        while(!pq.isEmpty()){
            Edge curEdge = pq.poll();
            int to = curEdge.to;
            if(!vis[to]){
                vis[to] = true;
                count++;
                res += curEdge.w;
                if(count == n -1){
                    break;
                }
                for (int i = 0; i < G[to].size(); i++){
                    int nextNode = G[to].get(i).to;
                    if(!vis[nextNode]){
                        //to -> nextNode 没有加入过
                        pq.add(G[to].get(i));   //将 to -> nextNode的边加入优先队列
                    }
                }
            }
        }

        if(count != n - 1){
            return -1;
        }
        return res;
    }

    //测试方法
    public static void main(String[] args){
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while(cin.hasNext()){
            int m = cin.nextInt();
            int n = cin.nextInt();
            if(m == 0){
                break;
            }

            ArrayList<Edge>[] G = new ArrayList[n + 1];
            boolean[] vis = new boolean[n + 1];
            for(int i = 0; i <= n; i++){
                G[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++){
                int from = cin.nextInt();
                int to = cin.nextInt();
                int w = cin.nextInt();
                G[from].add(new Edge(to, w));
                G[to].add(new Edge(from, w));
            }
            int res = prim(1, G, vis, n);
            System.out.println(res);
        }
    }

}
