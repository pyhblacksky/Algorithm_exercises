package LeetCodeRace.ContestTwo3;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author: pyh
 * @Date: 2019/6/29 23:09
 * @Description:
 *
 * 给你一个 R 行 C 列的整数矩阵 A。矩阵上的路径从 [0,0] 开始，在 [R-1,C-1] 结束。
 *
 * 路径沿四个基本方向（上、下、左、右）展开，从一个已访问单元格移动到任一相邻的未访问单元格。
 *
 * 路径的得分是该路径上的 最小 值。例如，路径 8 →  4 →  5 →  9 的值为 4 。
 *
 * 找出所有路径中得分 最高 的那条路径，返回其 得分。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[5,4,5],[1,2,6],[7,4,6]]
 * 输出：4
 * 解释：
 * 得分最高的路径用黄色突出显示。
 * 示例 2：
 *
 *
 *
 * 输入：[[2,2,1,2,2,2],[1,2,2,2,1,2]]
 * 输出：2
 * 示例 3：
 *
 *
 *
 * 输入：[[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= R, C <= 100
 * 0 <= A[i][j] <= 10^9
 */

public class 得分最高的路径 {
    //一直超时。。。。。
    static class Solution {
        public int maximumMinimumPath(int[][] A) {
            if(A == null || A.length == 0 || A[0] == null || A[0].length == 0){
                return 0;
            }

            boolean[][] visted = new boolean[A.length][A[0].length];
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();

            judge(A, visted, 0, 0, new ArrayList<>(), res);

            if(res.size() == 0){
                return 0;
            }

            res.sort(new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int min1 = Integer.MAX_VALUE;
                    int min2 = Integer.MAX_VALUE;
                    for(int num : o1){
                        min1 = Math.min(min1, num);
                    }
                    for(int num : o2){
                        min2 = Math.min(min2, num);
                    }

                    return min2-min1;
                }
            });

            res.get(0).sort(((o1, o2) -> o1-o2));
            return res.get(0).get(0);
        }

        private void judge(int[][] A, boolean[][] visited, int i, int j, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res){
            if(i < 0 || i >= A.length || j < 0 || j >= A[i].length || visited[i][j]){
                return;
            }
            visited[i][j] = true;
            list.add(A[i][j]);
            judge(A, visited, i-1, j, list, res);
            judge(A, visited, i+1, j, list, res);
            judge(A, visited, i, j-1, list, res);
            judge(A, visited, i, j+1, list, res);
            if(i == A.length-1 && j == A[0].length-1){
                ArrayList<Integer> temp = new ArrayList<>(list);
                res.add(temp);
            }
            list.remove(list.size()-1);
            visited[i][j] = false;

        }

    }

    public static void main(String[] args) {
        int[][] arr = {{5,4,5},{1,2,6},{7,4,6}};
        int[][] A = {{1,0,1,1,1,0,0},{0,1,1,1,1,1,0},{1,0,1,1,1,1,0},{1,1,1,0,1,1,0},{1,0,1,1,0,1,0}};
        Solution solution = new Solution();
        solution.maximumMinimumPath(A);
    }
}
