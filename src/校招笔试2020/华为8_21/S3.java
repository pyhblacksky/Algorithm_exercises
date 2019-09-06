package 校招笔试2020.华为8_21;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/21 19:19
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 实际是个并查集问题
 */
public class S3 {

    //AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int M = Integer.valueOf(sc.nextLine());
        String[] group = new String[M];

        Map<String, Integer> map = new LinkedHashMap<>();
        int index = 0;
        for(int i = 0; i < M; i++){
            group[i] = sc.nextLine();
            String[] tmp = group[i].split(",");
            for(String people : tmp){
                if(map.get(people) == null)
                    map.put(people, index++);
            }
        }

        if(map.get(name) == null){
            System.out.println(1);
            return;
        }

        UnionFind unionFind = new UnionFind(index);
        //process
        for(int i = 0; i < M; i++){
            String[] names = group[i].split(",");
            int len = names.length;
            int groupLeader = map.get(names[0]);
            for(int j = 1; j < len; j++){
                unionFind.union(groupLeader, map.get(names[j]));
            }
        }

        int first = map.get(name);
        int root = unionFind.find(first);
        int res = unionFind.getUnionSize(root);
        System.out.println(res);
    }

    static class UnionFind{
        private int[] parent;
        private int[] weight;

        UnionFind(int num){
            parent = new int[num];
            weight = new int[num];
            for(int i = 0; i < parent.length; i++){
                parent[i] = i;
                weight[i] = 1;
            }
        }

        int find(int p){
            while(p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }

            return p;
        }

        void union(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);
            if(pRoot == qRoot)
                return;
            if(weight[qRoot] < weight[pRoot]){
                parent[qRoot] = pRoot;
            } else if(weight[pRoot] < weight[qRoot]){
                parent[pRoot] = pRoot;
            } else{
                parent[qRoot] = pRoot;
                weight[pRoot]++;
            }
        }

        int getUnionSize(int root){
            int count = 0;
            for(int num : parent){
                if(num == root)
                    count++;
            }

            return count;
        }
    }

}
