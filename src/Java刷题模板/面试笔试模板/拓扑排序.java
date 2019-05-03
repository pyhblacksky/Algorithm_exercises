package Java刷题模板.面试笔试模板;

import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/29 11:00
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 *  拓扑排序 采用DFS和BFS进行拓扑排序
 *
 *  leetCode 207
 */
public class 拓扑排序 {

    /**
     * 给你n、m，n代表点的个数，m代表边的条数，然后下面给出m条边，都是有向的(有向图)，
     * 要你建出一个图，并且找出一种序列，这种序列即拓扑序列 。
     *
     * 拓扑排序: 是对有向无环图（DAG)进行的一种操作，这种操作是将DAG中的所有顶点排成一个线性序列，
     *      使得图中的任意一对顶点u,v满足如下条件：若边(u,v) ∈ E(G)，则u在最终的线性序列中出现在v的前面;
     *      拓扑排序的应用常常和AOV网相联系，在一个大型的工程中，某些项目不是独立于其他项目的，
     *      这意味着这种非独立的项目的完成必须依赖与其它项目的完成而完成，
     *      不妨记为u,v，则若边(u,v)∈E(G)，代表着必须在项目u完成后，v才能完成。
     *
     * 所以如果存在有向环，则不存在拓扑排序，反之则存在。
     * */

    /**
     * BFS拓扑排序
     * 拓扑排序使用BFS解题的过程:
     *
     * 1、找出入度为0 的结点并加入队列；
     * 2、在队列中弹出一个结点，并访问，并把它的相邻结点的入度-1，如果减一之后入度为0，则也进队列；
     * 3、直到队列为空，访问完毕 ；
     *
     * 通过上述过程即可以得到图的拓扑序列。
     */
    static PrintStream out;
    static int n,m;
    static int[] in;
    static ArrayList<Integer> G[];

    static void sortedTopology(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(in[i] == 0){
                queue.add(i);
            }
        }
        boolean flag = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(flag){
                out.print(cur);
                flag = false;
            } else{
                out.print(" " + cur);
            }

            for(int i = 0; i < G[cur].size(); i++){
                int to = G[cur].get(i);
                if(--in[to] == 0){
                    queue.add(to);
                }
            }
        }

        /**
         * 如果要判断是否有环，加入一个vis数组
         * 如果退出上一个while循环后还有点没有被访问到 vis[i] = false，说明有环
         * */

    }


    //测试方法,测试bfs
    /**
     * 测试例子：
     * 给你n、m。   n代表点的个数，m代表边的条数，然后下面给出m条边，
     *  都是有向的(有向图)，要你建出一个图，并且找出一种序列，这种序列即拓扑序列 。
     * input:
     * 5 4
     * 1 2
     * 2 3
     * 1 3
     * 1 5
     * 0 0
     *
     * output:
     * 1 4 2 5 3
     * */
    public static void main(String[] args){
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        out = System.out;
        while(cin.hasNext()){
            n = cin.nextInt();
            m = cin.nextInt();
            if(n == 0 && m == 0)
                break;
            in = new int[n + 1];
            G = new ArrayList[n + 1];
            for(int i = 0; i <= n; i++)
                G[i] = new ArrayList<>();
            for(int i = 0; i < m; i++){
                int from = cin.nextInt();
                int to = cin.nextInt();
                G[from].add(to);
                in[to]++;
            }
            sortedTopology();
        }
    }
}
