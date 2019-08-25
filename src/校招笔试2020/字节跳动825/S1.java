package 校招笔试2020.字节跳动825;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/25 19:05
 * @Version: 1.0
 * @Function:
 * @Description:
 * 豆油瓶  90%
 */
public class S1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        UnionSet set = new UnionSet(N);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] > 3 && arr[j][i] > 3){
                    set.union(i, j);
                }
            }
        }

        //统计个数
        int res = set.getRootSize();
        System.out.println(res);

    }

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

        public int size(){
            return parent.length;
        }

        private int find(int p){
            if(p < 0 || p > size()){
                throw new IllegalArgumentException("p is out of bound!");
            }
            while(p != parent[p]){
                p = parent[p];
            }
            return p;
        }

        public void union(int a, int b){
            int aRoot = find(a);
            int bRoot = find(b);
            if(aRoot == bRoot){
                return;
            }

            if(rank[aRoot] < rank[bRoot]){
                parent[aRoot] = bRoot;
            } else if(rank[bRoot] < rank[aRoot]){
                parent[bRoot] = aRoot;
            } else{
                parent[aRoot] = bRoot;
                rank[bRoot]++;
            }
        }

        public int getRootSize(){
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
