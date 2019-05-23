package 牛客模拟笔试._2019_5;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/15 19:30
 * @Version: 1.0
 * @Function:
 * @Description:
 *  一闪一闪亮晶晶
 */
public class test2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] res = new int[1001][1001];
        while(sc.hasNext()){
            int n = sc.nextInt();
            for(int i = 0; i < n; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                res[a][b] = 1;
            }
            int len = res.length;
            for(int i = 1; i < len; i++){
                for(int j = 1; j < len; j++){
                    res[i][j] = res[i][j] + res[i-1][j] + res[i][j-1] - res[i-1][j-1];
                }
            }

            int m = sc.nextInt();
            int count = 0;
            for(int i = 0; i < m; i++){
                int c = sc.nextInt();
                int d = sc.nextInt();
                int e = sc.nextInt();
                int f = sc.nextInt();
                count = res[e][f] - res[c-1][f] - res[e][d-1] + res[c-1][d-1];//边界上的点，向外扩一个单位
                System.out.println(count);
            }
        }
        sc.close();
    }

}
