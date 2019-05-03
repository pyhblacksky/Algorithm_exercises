package Java刷题模板.面试笔试模板;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/29 21:32
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 *  GCD 和 LCM
 */
public class 最大公约数和最小公倍数 {

    //非递归gcd  最大公约数  a > b
    static int gcdIter(int a, int b){
        int r;
        while(b != 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    //递归版
    static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    //最小公倍数 LCM
    static int lcm(int a, int b){
        return a / gcd(a,b) * b;
    }

    //
    static int ngcd(int[] arr, int n){
        if(n == 1){return arr[0];}
        return gcd(arr[n-1], ngcd(arr, n - 1));
    }

    //
    static int nlcm(int[] arr, int n){
        if(n == 1){
            return arr[0];
        }
        return lcm(arr[n-1], nlcm(arr, n - 1));
    }


    //测试方法
    public static void main(String[] args){
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        int T = cin.nextInt();
        for(int t = 0; t < T; t++){
            int n = cin.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = cin.nextInt();
            System.out.println(nlcm(a, n));
        }
    }

}
