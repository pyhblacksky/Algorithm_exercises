package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: pyh
 * @Date: 2019/4/29 14:27
 * @Version: 1.0
 * @Function:
 * @Description:
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，
 * 我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，
 *      你还应先完成课程 1。这是不可能的。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，
 *  因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 */
public class Solution207_课程表 {


    //方法一：BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0
                || prerequisites[0] == null || prerequisites[0].length == 0){
            return true;
        }

        int n = numCourses;
        ArrayList<Integer> G[] = new ArrayList[n];//构建图
        int[] in  = new int[n];//计算每个点的入度
        boolean[] vis = new boolean[n];//记录某个点是否已经访问过
        //构图
        for(int i = 0; i < n; i++){
            G[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            G[from].add(to);
            in[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(in[i] == 0){
                queue.add(i);//入度为0，直接入队并标记
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            vis[cur] = true;

            for(int i = 0; i < G[cur].size(); i++){
                int to = G[cur].get(i);
                if(--in[to] == 0){//入度每个减一，等于0则入队
                    queue.add(to);
                }
            }
        }

        //查看是否有没有被访问到的节点
        for(int i = 0; i < vis.length; i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }

    //方法二，DFS
    private ArrayList<Integer> G[];
    private int[] vis;//0: not visited, 1 : visited, 2 : visiting

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        G = new ArrayList[n];
        vis = new int[n];
        for(int i = 0; i < n; i++){
            G[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            G[from].add(to);
        }

        //dfs
        for(int i = 0; i < n; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int cur){
        vis[cur] = 2;//visiting，正在访问
        for(int to : G[cur]){
            if((vis[to] == 2 || (vis[to] == 0 && !dfs(to)))){
                return false;
            }
        }
        vis[cur] = 1;//访问完毕
        return true;
    }
    //dfs改写
    private boolean dfs1(int cur){
        if(vis[cur] == 1){
            return true;
        }
        if(vis[cur] == 2){
            return false;
        }
        vis[cur] = 2;//正在访问
        for(int to : G[cur]){
            if(!dfs1(to)){
                return false;
            }
        }
        vis[cur] = 1;//已经访问
        return true;
    }


    //测试方法
    public static void main(String[] args){
        int numCourses = 2;
        int[][] prerequisites = {
                {1, 0},
                {0, 1}
        };
        System.out.println(new Solution207_课程表().
                canFinish(numCourses, prerequisites)
        );
    }
}
