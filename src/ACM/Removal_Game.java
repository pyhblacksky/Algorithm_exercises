package ACM;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/17 9:39
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class Removal_Game {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String str = sc.nextLine();
            if(str.charAt(0) == '0'){
                break;
            }

            String[] split = str.split(" ");
            int res = getRes(split);
            System.out.println(res);
        }
        sc.close();
    }

    static int getRes(String[] split){
        int n = Integer.valueOf(split[0]);
        int len = n;
        n = n << 1;
        int[] arr = new int[n];
        for(int i = 0; i < split.length-1; i++){
            arr[i] = Integer.valueOf(split[i+1]);
            arr[len+i] = Integer.valueOf(split[i+1]);
        }

        int[][] g = new int[n][n];//gcd矩阵
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                g[i][j] = gcd(arr[i], arr[j]);
            }
        }

        int res = Integer.MAX_VALUE;
        int[][] r = new int[n][n];
        //初始化
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == i+1){
                    r[i][j] = 0;
                } else{
                    r[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j + i + 1 < n; ++j) {
                int k = i + j + 1;
                for (int l = j + 1; l < k; ++l)
                    r[j][k] = Math.min(r[j][l] + r[l][k] + g[j][l] + g[l][k], r[j][k]);
            }
        }

        for (int i = 0; i < n / 2; ++i) {
            int j = i + n / 2;
            for (int k = i; k <= j; ++k)
                if(r[i][k] + r[k][j] + g[i][k] + g[k][j] + g[k][j] >= 0) {
                    res = Math.min(res, r[i][k] + r[k][j] + g[i][k] + g[k][j] + g[k][j]);
                }
        }
        for (int i = 0; i < n / 2; ++i)
            res -= g[i][i + 1];

        return res;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
