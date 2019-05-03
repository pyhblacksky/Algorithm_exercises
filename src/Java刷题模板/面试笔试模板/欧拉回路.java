package Java刷题模板.面试笔试模板;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/29 17:05
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 欧拉回路：
 *
 * 1)、图G是连通的，不能有孤立点存在。
 *      对于无向图来说度数为奇数的点个数为0，对于有向图来说每个点的入度必须等于出度。
 *
 * 欧拉路径：
 * 1)、图G是连通的，无孤立点存在。
 *
 * 分情况:
 *      对于无向图来说:度数为奇数的的点可以有2个或者0个，并且这两个奇点其中一个为起点另外一个为终点。
 *
 *      对于有向图来说:可以存在两个点，其入度不等于出度，其中一个入度比出度大1，为路径的起点；
 *      另外一个出度比入度大1，为路径的终点。
 *
 *
 * 判断连通可以用DFS或者并查集。
 */
public class 欧拉回路 {

    //dfs判断连通
    //cur - 表示当前点 vis - 表示是否已经访问的数组    G - 对应的图
    public static void dfs(int cur, boolean[] vis, ArrayList<Integer>[] G){
        if(vis[cur]){
            return;//已经访问
        }
        vis[cur] = true;
        for(int to : G[cur]){
            if(!vis[to]){
                dfs(to, vis, G);
            }
        }
    }

    //测试Dfs判断欧拉回路的方法
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int n = cin.nextInt();
            if(n == 0){
                break;
            }
            int m = cin.nextInt();
            int[] in = new int[n+1];//计算入度
            boolean[] vis = new boolean[n+1];
            ArrayList<Integer>[] G = new ArrayList[n+1];
            //初始化
            for(int i = 0; i <= n; i++){
                G[i] = new ArrayList<>();
            }
            for(int i = 0; i < m; i++){
                int from = cin.nextInt();
                int to  = cin.nextInt();
                G[from].add(to);
                G[to].add(from);
                in[from]++;
                in[to]++;
            }
            dfs(1, vis, G);//起点
            boolean ok = true;
            for(int i = 1; i <= n; i++){
                if(in[i] % 2 != 0 || !vis[i]){
                    ok = false;
                    break;
                }
            }
            System.out.println(ok ? "Yes" : "No");
        }
    }

    /********************************************************************************************************/

    //使用并查集判断连通
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

        public int find(int a){
            while(a != parent[a]){
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }

        public void union(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if(aRoot == bRoot){
                return;
            }

            if(rank[aRoot] < rank[aRoot]){
                parent[aRoot] = bRoot;
            } else if(rank[bRoot] < rank[aRoot]){
                parent[bRoot] = aRoot;
            } else{
                parent[aRoot] = bRoot;
                rank[bRoot]++;
            }
        }

        public boolean isSameSet(int a, int b){
            return find(a) == find(b);
        }
    }

    //测试并查集判断欧拉回路的方法
    public static void main1(String[] args){
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while(cin.hasNext()){
            int n = cin.nextInt();
            if(n == 0)
                break;
            int m = cin.nextInt();
            int[] in = new int[n+1];
            UnionSet uset = new UnionSet(n+1);

            //构图
            for(int i = 0; i < m; i++){
                int from = cin.nextInt();
                int to = cin.nextInt();
                uset.union(from, to);
                in[from]++;
                in[to]++;
            }

            int oneRoot = uset.find(1);
            boolean ok = in[1] % 2 == 0;
            for(int i = 2; i <= n; i++){
                if(in[i] % 2 != 0 || uset.find(i) != oneRoot){
                    ok = false;
                    break;
                }
            }
            System.out.println(ok ? "Yes" : "No");
        }
    }
}
