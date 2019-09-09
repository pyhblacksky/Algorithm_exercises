package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: pyh
 * @Date: 2019/9/9 14:19
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。
 *
 * 示例:
 * 输入: [[1,2], [3], [3], []]
 * 输出: [[0,1,3],[0,2,3]]
 * 解释: 图是这样的:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * 这有两条路: 0 -> 1 -> 3 和 0 -> 2 -> 3.
 * 提示:
 *
 * 结点的数量会在范围 [2, 15] 内。
 * 你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution797_所有可能的路径 {

    //dfs
    static class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new LinkedList<>();
            if(graph == null || graph.length == 0 || graph[0].length == 0)
                return res;


            for(int i = 0; i < graph.length; i++){
                if(graph[i].length > 0) {
                    List<Integer> tmp = new LinkedList<>();
                    dfs(tmp, res, i, graph, 0, graph.length-1);
                }
            }

            return res;
        }

        void dfs(List<Integer> list, List<List<Integer>> res, int pos, int[][] graph, int start, int end){
            list.add(pos);

            if(graph[pos] == null || graph[pos].length == 0){
                if(list.get(0) == start && list.get(list.size()-1) == end)
                    res.add(new LinkedList<>(list));
                return;
            }

            for(int i = 0; i < graph[pos].length; i++){
                List<Integer> tmp = new LinkedList<>(list);
                dfs(tmp, res, graph[pos][i], graph, start, end);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {{1,2}, {3}, {3}, {}};
        int[][] graph1 = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> res = solution.allPathsSourceTarget(graph1);
        printArr(res);
    }

    static void printArr(List<List<Integer>> res){
        for(List<Integer> tmp : res){
            for(int num : tmp){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
