package HDU_OJ;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/29 17:12
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * Problem Description
 * 欧拉回路是指不令笔离开纸面，可画过图中每条边仅一次，且可以回到起点的一条回路。现给定一个图，问是否存在欧拉回路？
 *
 *
 * Input
 * 测试输入包含若干测试用例。每个测试用例的第1行给出两个正整数，分别是节点数N ( 1 < N < 1000 )和边数M；随后的M行对应M条边，每行给出一对正整数，分别是该条边直接连通的两个节点的编号（节点从1到N编号）。当N为0时输入结
 * 束。
 *
 *
 * Output
 * 每个测试用例的输出占一行，若欧拉回路存在则输出1，否则输出0。
 *
 *
 * Sample Input
 * 3 3
 * 1 2
 * 1 3
 * 2 3
 * 3 2
 * 1 2
 * 2 3
 * 0
 *
 *
 * Sample Output
 * 1
 * 0
 *
 */
public class HDU1878_欧拉回路 {

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
