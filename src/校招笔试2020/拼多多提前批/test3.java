package 校招笔试2020.拼多多提前批;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @Author: pyh
 * @Date: 2019/7/28 15:37
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 带权重的拓扑排序题
 */
public class test3 {

    static int n,m;
    static int[] in;
    static ArrayList<Integer> G[];

    static class E{
        int to;
        int w;
        E(int to, int w){
            this.to = to;
            this.w = w;
        }
    }

    static void sortedTopology(Map<Integer, Integer> map){
        Queue<E> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.w == o2.w){
                //此处保证字典序最小
                return o1.to-o2.to;
            }
            return o1.w-o2.w;
        });
        for(int i = 1; i <= n; i++){
            if(in[i] == 0){
                queue.add(new E(i, map.get(i)));
            }
        }
        boolean flag = true;
        while(!queue.isEmpty()){
            int cur = queue.poll().to;
            if(flag){
                System.out.print(cur);
                flag = false;
            } else{
                System.out.print(" " + cur);
            }

            for(int i = 0; i < G[cur].size(); i++){
                int to = G[cur].get(i);
                if(--in[to] == 0 && to != 0){
                    queue.add(new E(to, map.get(to)));
                }
            }
        }
    }

    //输出字典序最小
    public static void main(String[] args){
        Scanner cin = new Scanner(new BufferedInputStream(System.in));

        String line = cin.nextLine();
        String[] str = line.split(" ");
        n = Integer.valueOf(str[0]);
        m = Integer.valueOf(str[1]);
        if (n == 0 && m == 0)
            return;

        String time = cin.nextLine();
        String[] weight = time.split(" ");
        Map<Integer, Integer> wMap = new HashMap<>();
        for (int i = 0; i < weight.length; i++) {
            wMap.put(i + 1, Integer.valueOf(weight[i]));
        }

        in = new int[n + 1];
        G = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            G[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int from = cin.nextInt();
            int to = cin.nextInt();
            G[from].add(to);
            in[to]++;
        }
        sortedTopology(wMap);
    }

}
