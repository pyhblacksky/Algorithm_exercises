package LeetCodeRace.Contest153;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author: pyh
 * @Date: 2019/9/8 10:31
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class main1 {

    static class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int n = distance.length;
            ArrayList<Edge>[] G = new ArrayList[n];//0 ~ n-1
            boolean[] vis = new boolean[n];
            //初始化
            for(int i = 0; i < n; i++){
                G[i] = new ArrayList<>();
                vis[i] = false;
            }
            for(int i = 0; i < distance.length; i++){
                int from = i;
                int to = i+1 == distance.length ? 0 : i+1;
                int w = distance[i];
                G[from].add(new Edge(to, w));
                G[to].add(new Edge(from, w));
            }

            int[] res = dijstra(start, n, vis, G);
            return res[destination];
        }

        public int[] dijstra(int start, int n, boolean[] vis, ArrayList<Edge>[] G){
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

        class Edge implements Comparable<Edge>{
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
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] distance = {1,2,3,4};
        int res = solution.distanceBetweenBusStops(distance, 0, 3);
        System.out.println(res);
    }

}
