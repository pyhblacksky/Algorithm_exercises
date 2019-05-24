package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/5/23 15:59
 * @Version: 1.0
 * @Function:
 * @Description:
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 *
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 */
public class Solution547_朋友圈 {

    //典型的并查集问题
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0] == null || M[0].length == 0){
            return 0;
        }

        int size = M.length;
        Union union = new Union(size);
        for(int i = 0; i < size; i++){
            for(int j= 0; j < size; j++){
                if(i != j && M[i][j] == 1){
                    union.union(i, j);
                }
            }
        }

        return union.countNumOfGroup();
    }

    class Union{
        private int[] parent;
        private int[] rank;

        public Union(int size){
            parent = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++){
                parent[i] = i;
                rank[i] = 1;
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
            int qRoot= find(q);

            if(pRoot == qRoot){
                return;
            }

            if(rank[pRoot] < rank[qRoot]){
                parent[pRoot] = qRoot;
            } else if(rank[qRoot] < rank[pRoot]){
                parent[qRoot] = pRoot;
            } else{
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }
        }

        public boolean isSameUnion(int p, int q){
            return find(p) == find(q);
        }

        //统计群的数量
        public int countNumOfGroup(){
            int count = 0;
            for(int i = 0; i < parent.length; i++){
                if(parent[i] == i){
                    count++;
                }
            }
            return count;
        }
    }


    public static void main(String[] args){
        Solution547_朋友圈 solution = new Solution547_朋友圈();
        int[][] M = {
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };
        System.out.println(solution.findCircleNum(M));
    }
}
