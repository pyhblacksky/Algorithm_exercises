package Java刷题模板.面试笔试模板;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/29 16:49
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Dijstra最短路 {

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

    //Dijstra
    //start - 起点    n - 顶点数  vis - 是否访问过的节点  G - 对应图的邻接表表示
    public static int[] dijstra(int start, int n, boolean[] vis, ArrayList<Edge>[] G){
        PriorityQueue<Edge> pq = new PriorityQueue<>();//优先队列，小的在前
        int[] dis = new int[n];
        for(int i = 0; i < n; i++){
            dis[i] = Integer.MAX_VALUE;//初始化标记，一开始距离均为最大值
        }
        dis[start] = 0;
        pq.add(new Edge(start, 0));//将第一条边加入pq，自环边
        while(!pq.isEmpty()){
            Edge curEdge = pq.poll();
            int to = curEdge.to;
            if(vis[to]){//已经访问，跳过本次循环
                continue;
            }
            vis[to] = true;
            for(int i = 0; i < G[to].size(); i++){
                int nextNode = G[to].get(i).to;
                int nextW = G[to].get(i).w;
                if(!vis[nextNode] && dis[nextNode] > dis[to] + nextW){
                    dis[nextNode] = dis[to] + nextW;
                    pq.add(new Edge(nextNode, dis[nextNode]));//将新的dis加入优先队列
                }
            }
        }

        return dis;
    }

    //测试方法
    public static void main(String[] args){
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while(cin.hasNext()){
            int m = cin.nextInt();
            int n = cin.nextInt();
            ArrayList<Edge>[] G = new ArrayList[n];//0 ~ n-1
            boolean[] vis = new boolean[n];
            //初始化
            for(int i = 0; i < n; i++){
                G[i] = new ArrayList<>();
                vis[i] = false;
            }

            for(int i = 0; i < m; i++){
                int from = cin.nextInt();
                int to = cin.nextInt();
                int w = cin.nextInt();
                G[from].add(new Edge(to, w));
                G[to].add(new Edge(from, w));
            }

            int start = cin.nextInt();//起点
            int end = cin.nextInt();//终点
            int[] dis = dijstra(start, n, vis, G);//d的数组
            System.out.println(dis[end] == Integer.MAX_VALUE ? -1 : dis[end]);
        }
    }
}
