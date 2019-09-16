package LeetCodeRace.Contest154;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: pyh
 * @Date: 2019/9/15 11:30
 * @Version: 1.0
 * @Function:
 * @Description:
 * 查找集群内关键连接
 * 力扣数据中心有 n 台服务器，分别按从 0 到 n-1 的方式进行了编号。
 *
 * 它们之间以「服务器到服务器」点对点的形式相互连接组成了一个内部集群，其中连接 connections 是无向的。
 *
 * 从形式上讲，connections[i] = [a, b] 表示服务器 a 和 b 之间形成连接。任何服务器都可以直接或者间接地通过网络到达任何其他服务器。
 *
 * 「关键连接」是在该集群中的重要连接，也就是说，假如我们将它移除，便会导致某些服务器无法访问其他服务器。
 *
 * 请你以任意顺序返回该集群内的所有 「关键连接」。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * 输出：[[1,3]]
 * 解释：[[3,1]] 也是正确的。
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * 不存在重复的连接
 */
public class Main4 {

    //图中寻找最小生成树
    static class Solution {
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

            List<Edge>[] G = new LinkedList[n + 1];
            for(int i = 0; i <= n; i++){
                G[i] = new LinkedList<>();
            }

            int m = connections.size();
            for(int i = 0; i < m; i++){
                List<Integer> tmp = connections.get(i);
                int from = tmp.get(0);
                int to = tmp.get(1);
                G[from].add(new Edge(from,to));
                G[to].add(new Edge(to,from));
            }

            //寻找出度只有1的，超时，估计是因为申请的数据空间太大 10^6
            List<List<Integer>> res = new LinkedList<>();
            for(int i = 0; i < G.length; i++){
                if(G[i].size() == 1){
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(i);
                    tmp.add(G[i].get(0).to);
                    res.add(tmp);
                }
            }
            return res;


            //获得最小生成树的所有边集
//            List<List<Integer>> res = prim(1, G, vis, n);
//
//            //遍历List
//            return res;
        }

        //边的类
        class Edge implements Comparable<Edge>{
            int now;
            public int to;
            public int w = 0;
            public Edge(int now, int to){
                this.now = now;
                this.to = to;
            }

            public int compareTo(Edge o){
                return w - o.w;
            }
        }

        //prim核心方法
        //start-起点，vis-是否访问过的数组，n-顶点数，G-图集
        List<List<Integer>> prim(int start, ArrayList<Edge>[] G, boolean[] vis, int n){
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for(int i = 0; i < G[start].size(); i++){
                pq.add(G[start].get(i));
            }
            int count = 0;
            int res = 0;

            List<List<Integer>> resOfEdg = new LinkedList<>();
            vis[start] = true;//起始节点已经在集合中
            while(!pq.isEmpty()){
                Edge curEdge = pq.poll();
                int to = curEdge.to;
                if(!vis[to]){
                    vis[to] = true;
                    count++;
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(curEdge.to);
                    tmp.add(curEdge.now);
                    resOfEdg.add(new LinkedList<>(tmp));
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
                return null;
            }
            return resOfEdg;
        }

        //删边寻路，若无则是关键边

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
