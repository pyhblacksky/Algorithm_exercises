package LeetCodeRace.ContestTwo3;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/6/29 22:51
 * @Description:
 * 在一个社交圈子当中，有 N 个人。每个人都有一个从 0 到 N-1 唯一的 id 编号。
 *
 * 我们有一份日志列表 logs，其中每条记录都包含一个非负整数的时间戳，以及分属两个人的不同 id，logs[i] = [timestamp, id_A, id_B]。
 *
 * 每条日志标识出两个人成为好友的时间，友谊是相互的：如果 A 和 B 是好友，那么 B 和 A 也是好友。
 *
 * 如果 A 是 B 的好友，或者 A 是 B 的好友的好友，那么就可以认为 A 也与 B 熟识。
 *
 * 返回圈子里所有人之间都熟识的最早时间。如果找不到最早时间，就返回 -1 。
 *
 *
 *
 * 示例：
 *
 * 输入：logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
 * 输出：20190301
 * 解释：
 * 第一次结交发生在 timestamp = 20190101，0 和 1 成为好友，社交朋友圈如下 [0,1], [2], [3], [4], [5]。
 * 第二次结交发生在 timestamp = 20190104，3 和 4 成为好友，社交朋友圈如下 [0,1], [2], [3,4], [5].
 * 第三次结交发生在 timestamp = 20190107，2 和 3 成为好友，社交朋友圈如下 [0,1], [2,3,4], [5].
 * 第四次结交发生在 timestamp = 20190211，1 和 5 成为好友，社交朋友圈如下 [0,1,5], [2,3,4].
 * 第五次结交发生在 timestamp = 20190224，2 和 4 已经是好友了。
 * 第六次结交发生在 timestamp = 20190301，0 和 3 成为好友，大家都互相熟识了。
 *
 *
 * 提示：
 *
 * 1 <= N <= 100
 * 1 <= logs.length <= 10^4
 * 0 <= logs[i][0] <= 10^9
 * 0 <= logs[i][1], logs[i][2] <= N - 1
 * 保证 logs[i][0] 中的所有时间戳都不同
 * Logs 不一定按某一标准排序
 * logs[i][1] != logs[i][2]
 */

public class 彼此熟识的最早时间 {

    //并查集
    static class Solution {
        public int earliestAcq(int[][] logs, int N) {
            if(N == 0 || logs == null || logs.length == 0 || logs[0] == null || logs[0].length == 0){
                return -1;
            }

            UnionFind unionFind = new UnionFind(N);
            Arrays.sort(logs, (o1, o2) -> o1[0]-o2[0]);

            for(int i = 0; i < logs.length; i++){
                unionFind.union(logs[i][1],logs[i][2]);
                if(unionFind.size() == 1){
                    return logs[i][0];
                }
            }

            return -1;
        }


        //并查集
        private class UnionFind{
            int[] parent;
            UnionFind(int size){
                parent = new int[size];
                for(int i = 0; i < size; i++){
                    parent[i] = i;
                }
            }

            public int find(int p){
                while(p != parent[p]){
                    p = parent[p];
                }
                return p;
            }

            public void union(int p, int q){
                int pRoot = find(p);
                int qRoot = find(q);

                if(pRoot == qRoot){
                    return;
                }

                parent[pRoot] = qRoot;
            }

            public int size(){
                int count = 0;
                for(int i = 0; i < parent.length; i++){
                    if(parent[i] == i){
                        count++;
                    }
                }
                return count;
            }

        }
    }

    public static void main(String[] args) {
        int[][] arr = {{3,0,3},{4,1,2},{0,2,0},{2,0,2},{8,0,3},{1,0,1},{5,1,2},{7,3,1},{6,1,0},{9,3,0}};
        Solution solution = new Solution();
        int date = solution.earliestAcq(arr, 4);
        System.out.println(date);
    }

}
