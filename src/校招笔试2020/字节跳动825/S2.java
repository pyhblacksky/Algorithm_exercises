package 校招笔试2020.字节跳动825;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/25 19:49
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 卡塔兰数
 * 100%
 */
public class S2 {


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        N = N/2;

        int i;
        BigInteger x, y;
        BigInteger[] a = new BigInteger[110];
        a[0] = BigInteger.valueOf(1);
        a[1] = BigInteger.valueOf(1);

        for(i = 2; i < 101; i++){
            x = a[i-1];
            x = x.multiply(BigInteger.valueOf(4*i-2));
            y = x.divide(BigInteger.valueOf(i+1));
            a[i] = y;
        }

        System.out.println(a[N].mod(BigInteger.valueOf(mod)));
    }


    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        N = N/2;

        int i;
        int x, y;
        int[] a = new int[110];
        a[0] = 1;
        a[1] = 1;

        for(i = 2; i < 101; i++){
            x = a[i-1];
            x = x * (4*i-2) % mod;
            y = x / (i+1);
            a[i] = y % mod;
        }

        System.out.println(a[N]);
    }

    static int mod = 1000000007;
    static long[] longs = new long[1000010];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N % 2 == 1)
            return;
        N = N/2 + 1;
        init(N);
        long last = 1;
        long now = 1;
        for(int i = 2; i <= N; i++){
            last = now;
            now = last * (4 * i - 2) % mod * longs[i+1] % mod;
        }
        System.out.println(last);
    }
    static void init(int n){
        longs[1] = 1;
        for(int i = 2; i <= n+1; i++){
            longs[i] = (mod-mod/i)*longs[mod%i]%mod;
        }
    }



}
