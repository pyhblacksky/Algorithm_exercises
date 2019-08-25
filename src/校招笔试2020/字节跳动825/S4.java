package 校招笔试2020.字节跳动825;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/25 19:31
 * @Version: 1.0
 * @Function:
 * @Description:
 * 糖果连线
 * 20%
 */
public class S4 {

    //最大公约数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        List<int[]> list = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            int[] tmp = new int[N];
            tmp[i] = 1;//自己为1
            for(int j = 0; j < arr.length; j++){
                if(i != j){
                    tmp[j] = gcd(arr[i], arr[j]);
                }
            }
            list.add(tmp);
        }

        //并查集
        UnionSet set = new UnionSet(N);
        for(int i = 0; i < list.size(); i++){
            int[] tmp = list.get(i);
            for(int j = 0; j < tmp.length; j++){
                if(tmp[j] > 1){
                    //此处修改，公约数相等的连线
                    set.union(i, j);
                }
            }
        }
        int res = set.getMaxRoot();
        System.out.println(res);

    }

    //非递归gcd  最大公约数  a > b
    static int gcd(int a, int b){
        int r;
        while(b != 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
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

        public int getMaxRoot(){
            int max = 0;
            for(int i = 0; i < parent.length; i++){
                int count = 0;
                for(int j = 0; j < parent.length; j++){
                    if(i == parent[j]){
                        count++;
                    }
                }
                max = Math.max(count, max);
            }
            return max;
        }
    }

}
