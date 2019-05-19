package ACM.邀请赛;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/19 8:11
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class AlNumber {

    public static void main(String[] args){
        double  r = circle(3);
        System.out.println(r);
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            double res = count(n);
            System.out.println(String.format("%.9f", res));
        }

    }

    static double count(int n){
        double max = 0;
        int recordI = 0;
        int recordJ = 0;
        int recordK = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                int k = n - i - j;
                if(i+j+k == n && i >= 1 && j >= 1 && k >= 1){
                    double res = Math.sin(i)+Math.sin(j) + Math.sin(k);
                    if(res >= max){
                        max = res;
                        recordI = i;
                        recordJ = j;
                        recordK = k;
                        System.out.println("i : " + recordI + " j : " + recordJ + " k : " + recordK + " res : " + res);
                    }
                    //System.out.println(i+ " " + j + " " + k);
                }
            }
        }

        System.out.println("i : " + recordI + " j : " + recordJ + " k : " + recordK);
        return max;
    }

    static double circle(int n){
        double max = 0;
        for(int i = 1; i <= n; i++){
            int y = n - 2*i;
            if(i >= 1 && y >= 1 && y+i+i == n){
                max = Math.max(max, 2*Math.sin(i)+Math.sin(y));
            }
        }
        return max;
    }

}
