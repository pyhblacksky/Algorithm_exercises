package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/5/21 19:26
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。
 *
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 *
 * 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
 *
 * 当可以用这种方法将每个人分进两组时，返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 *
 * 输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 *
 * 输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * 对于 dislikes[i] == dislikes[j] 不存在 i != j
 */
public class Solution886_可能的二分法 {

    ArrayList<Integer>[] graph;//图的邻接表
    Map<Integer, Integer> color;

    //深度优先搜索，着色算法,二分着色
    //考虑由给定的 “不喜欢”边缘形成的N人的图表，检查这个图的每个连通分支是否是二分的
    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : dislikes){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        color = new HashMap<>();
        for(int node = 1; node <= N; node++){
            if(!color.containsKey(node) && !dfs(node, 0)){
                return false;
            }
        }

        return true;
    }
    boolean dfs(int node, int c){
        if(color.containsKey(node)){
            return color.get(node) == c;
        }
        color.put(node, c);

        for(int neiber : graph[node]){
            if(!dfs(neiber, c^1)){  //表示c异或1
                return false;
            }
        }
        return true;
    }



    //可以尝试并查集

    public static void main(String[] args){
        //possibleBipartition(4, null);
    }

}
