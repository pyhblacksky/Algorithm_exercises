package Java刷题模板.面试笔试模板;

import java.io.PrintStream;

/**
 * @Author: pyh
 * @Date: 2019/4/24 20:28
 * @Version: 1.0
 * @Function:
 * @Description:
 *  leetcode 51  N皇后问题
 *
 *  作为经典回溯来学习
 */
public class N皇后问题 {

    static PrintStream out = System.out;

    static int count;

    //第一种方法
    static void dfs(int r, int n, int[] cols){
        //当前是r行
        if(r == n){
            count++;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(cols[i] == j){
                        out.print("0 ");
                    } else{
                        out.print(". ");
                    }
                }
                out.println();
            }
            out.println("------------------------");
            return;
        }

        for(int c = 0; c < n; c++){
            //考察的是每一列
            cols[r] = c;//尝试将r行的皇后放在第c列
            boolean ok = true;
            for(int i = 0; i < r; i++){
                //检查列，“副对角线”，“主对角线”
                if(cols[r] == cols[i] || r-i == cols[r] - cols[i] || r-i == cols[i] - cols[r]){
                    ok = false;
                    break;
                }
            }
            if(ok){
                dfs(r+1, n, cols);
            }
        }
    }

    //第二种解法：使用cs三个数组记录，此处只统计数目，没有保留解
    static void dfs(int r, boolean[] cs, boolean[] d1, boolean[] d2, int n){
        if(r == n){//当前是r行
            count++;
            return;
        }

        for(int c = 0; c < n; c++){
            int id1 = r + c;//主对角线
            int id2 = r - c + n - 1;
            if(cs[c] || d1[id1] || d2[id2]){
                continue;
            }

            cs[c] = d1[id1] = d2[id2] = true;

            dfs(r+1, cs, d1, d2, n);

            cs[c] = d1[id1] = d2[id2] = false;
        }
    }

    //第二种解法的改进：使用cols数组保留解
    static void dfs(int r, boolean[][] vis, int[] cols, int n){
        //逐行放置皇后
        if(r == n){
            count++;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(cols[i] == j){
                        out.print("0 ");
                    } else{
                        out.print(". ");
                    }
                }
                out.println();
            }
            out.println("------------------------");
            return;
        }

        for(int c = 0; c < n; c++){
            //尝试在cur行的各列放置皇后
            if(vis[0][c] || vis[1][r+c] || vis[2][r - c + n - 1]){
                continue;//判断当前尝试的皇后的列主对角线
            }
            vis[0][c] = vis[1][r+c] = vis[2][r-c + n - 1] = true;
            cols[r] = c;    //r行的列是c
            dfs(r+1, vis, cols, n);
            vis[0][c] = vis[1][r+c] = vis[2][r-c + n - 1] = false;//一定要改回
        }
    }

    //测试方法
    public static void main(String[] args){
        int n = 8;//8皇后

        count = 0;
        dfs(0, n, new int[n]);
        out.println(count);
        out.println("=======================");

        count = 0;
        dfs(0, new boolean[n], new boolean[2*n - 1], new boolean[2 * n - 1], n);
        out.println(count);
        out.println("=======================");


    }

}
