package 校招笔试2020.阿里830;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/30 18:54
 * @Version: 1.0
 * @Function:
 * @Description:
 * 一只兔子要通过一个n * n （6<= n <= 30)的方格机关区域，兔子每踩一个方格就会触发与之邻边的方格机关,机关触发后会散发迷雾，
 * 机关所在方格的数字对应迷雾散发的时间，数字越小，迷雾散发的时间越短，迷雾散去之后才能继续前进。
 * 由于被触发机关的方格是不能行走的，兔子只能跳着通过该区域。假如兔子每次只能跳过与当前所在方格相邻的一个方格，
 * 请为兔子计算出从该正方形区域的最上边中的任意一点出发，最快时间通过该区域到达最下边所需要的时间。
 * 要求： 兔子只能从左向右或者从上向下走；方格中的数字大于0，小于100；只有机关被触发的方格才能被跳过
 *
 * 输入：
 * 1. 第一行输入一个数字n，表示方格机关的区域大小
 * 2. 随后输入n行，每行有n个使用逗号分隔的数字，分别代表方格机关每一行对应的方格中的数字
 * 输出：
 * 1. 从最上边开始，最快时间通过区域到达对边，所需要的时间
 *
 *
 * 示例：
 * 输入：
6
1,2,3,5,7,6
2,1,4,5,7,4
3,4,5,6,3,6
2,3,1,4,6,8
5,6,1,4,6,2
4,2,4,1,1,6
 *
 * 输出：
 * 6
 *
 * 说明：
 * 兔子有两种方式以最短时间通过该区域（假设方格区域为二维数组 a ）
 * 1. 兔子所踩方格的坐标依次为： a[0][1] -> a[2][1] -> a[4][1] ；
 *     期间跳过机关格子依次为： a[1][1] -> a[3][1] -> a[5][1] ；
 *     对应的通过时间为： 1 + 3 + 2 = 6
 *
 * 2. 兔子所踩方格的坐标依次为； a[0][1] -> a[2][1] -> a[4][1] -> a[4][3] ;
 *     期间跳过的机关格子依次为： a[1][1] -> a[3][1] ->a[4][2] -> a[5][3] ;
 *     对应的通过时间为： 1 + 3 +1 +1 = 6
 *
 * 输入范例:
8
35,92,98,68,35,65,26,72
29,78,83,16,5,89,92,28
48,51,37,79,65,74,50,71
98,78,99,57,1,30,22,16
72,88,55,33,56,58,28,49
4,28,29,20,18,61,11,73
61,19,47,34,85,32,77,89
29,49,10,81,52,5,63,25
 * 输出范例:
 * 76
 */
public class Main1 {

    //0%通过率
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < area[0].length; i++){
            min = Math.min(func(area, 0, i, area[0][i]), min);
        }
        for(int i = 0; i < area[0].length; i++){
            min = Math.min(func(area, 1, i, area[0][i]), min);
        }

        return min;
    }

    static int func(int[][] area, int x, int y, int count){
        if(x == area.length-1)
            return area[x][y];

        if(x < 0 || x >= area.length || y < 0 || y >= area.length)
            return Integer.MAX_VALUE/2;

//        if(count - area[x][y] <= 0){
//            //可以踩
//            int down2 = func(area, x+2, y, count);
//            int right1 = func(area, x, y+2, count);
//
//            return Math.min(right1, down2);
//        } else{
            int now = area[x][y];
            int down1 = func(area, x+2, y, area[x][y]);
            int down2 = func(area, x+1, y, area[x][y]);
            int right1 = func(area, x, y+1, area[x][y]);
            int right2 = func(area, x, y+2, area[x][y]);

            return Math.min(right2, Math.min(right1,Math.min(down1, down2))) + now;

    }


    /*******************************************/
    static class Edge implements Comparable<Edge>{
        public int to;
        public int w;
        public Edge(int to, int w){
            this.to = to;
            this.w = w;
        }

        public int compareTo(Edge o){
            return w - o.w;
        }
    }

    //Dijstra
    //start - 起点    n - 顶点数  vis - 是否访问过的节点  G - 对应图的邻接表表示
    public static int[] dijstra(int start, int n, boolean[] vis, ArrayList<Edge>[] G){
        PriorityQueue<Edge> pq = new PriorityQueue<>();//优先队列，小的在前
        int[] dis = new int[n];
        for(int i = 0; i < n; i++){
            dis[i] = Integer.MAX_VALUE;//初始化标记，一开始距离均为最大值
        }
        dis[start] = 0;
        pq.add(new Edge(start, 0));//将第一条边加入pq，自环边
        while(!pq.isEmpty()){
            Edge curEdge = pq.poll();
            int to = curEdge.to;
            if(vis[to]){//已经访问，跳过本次循环
                continue;
            }
            vis[to] = true;
            for(int i = 0; i < G[to].size(); i++){
                int nextNode = G[to].get(i).to;
                int nextW = G[to].get(i).w;
                if(!vis[nextNode] && dis[nextNode] > dis[to] + nextW){
                    dis[nextNode] = dis[to] + nextW;
                    pq.add(new Edge(nextNode, dis[nextNode]));//将新的dis加入优先队列
                }
            }
        }

        return dis;
    }

    public static void main2(String[] args){
        Scanner cin = new Scanner(System.in);

        String line = cin.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = cin.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        ArrayList<Edge>[] G = new ArrayList[n];//0 ~ n-1
        boolean[] vis = new boolean[n];
        //初始化
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList<>();
            vis[i] = false;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int from = i;
                int to = j;
                int w = area[i][j];
                G[from].add(new Edge(to, w));
                G[to].add(new Edge(from, w));
            }
        }

        int min = 0;
        for(int i = 0; i < n; i++){
            int start = i;//起点
            int end = n-1;//终点
            int[] dis = dijstra(start, n, vis, G);//d的数组
            min = Math.min(min, dis[end]);
        }
        System.out.println(min);

    }

}
