package 校招真题_2018.爱奇艺_2018;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/6 15:47
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 如果一个整数只能被1和自己整除,就称这个数是素数。
 * 如果一个数正着反着都是一样,就称为这个数是回文数。例如:6, 66, 606, 6666
 * 如果一个数字既是素数也是回文数,就称这个数是回文素数
 * 牛牛现在给定一个区间[L, R],希望你能求出在这个区间内有多少个回文素数。
 * 输入描述:
 * 输入包括一行,一行中有两个整数(1 ≤ L ≤ R ≤ 1000)
 * 输出描述:
 * 输出一个整数,表示区间内回文素数个数。
 * 示例1
 * 输入
 * 100 150
 * 输出
 * 2
 */
public class 回文素数 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int L = cin.nextInt();
        int R = cin.nextInt();

        //System.out.println(primePalindrome(L, R));
        System.out.println(sieve(L, R));
    }

    public static int sieve(int MIN, int MAX){
        //寻找所有素数
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] is_prime = new boolean[MAX+1];
        for(int i = 2; i <= MAX; i++){
            if(!is_prime[i]){

                list.add(i);

                for(int j = i*2; j <= MAX; j = j + i){
                    is_prime[j] = true;
                }
            }
        }

        //判断
        int res = 0;
        for(int x : list){
            if(x >= MIN && isReverse(x)){
                res++;
            }
        }

        return res;
    }

    //判断是否是回文
    public static boolean isReverse(int num){
        if(num < 0){
            return false;
        }
        if(num < 10){
            return true;
        }

        int oldNum = num;
        int reverse = 0;
        while(num > 0){
            reverse = reverse * 10 + num % 10;
            num = num / 10;
        }

        return oldNum == reverse;
    }



    /******************************************************************************/
    //方法二
    public static int primePalindrome(int MIN, int MAX) {
        if(MAX < MIN || MIN < 0 || MAX > Integer.MAX_VALUE){
            return 0;
        }
        Rev rev = Rev.from(MIN);
        int res = 0;
        if(MAX >= 11 && MIN <= 11){
            res = 1;
        }
        int k = rev.get();
        while (k <= MAX) {
            if (k >= MIN && isPrime(k)) {
                res++;
                System.out.println(k);
            }
            rev.base++;
            k = rev.get();
        }

        return res;
    }

    static boolean isPalindrom(int n) {
        char[] nc = Integer.toString(n).toCharArray();
        for (int i = 0; i < nc.length / 2; i++) {
            if (nc[i] != nc[nc.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n != 2 && n % 2 == 0) {
            return false;
        }
        int max = (int) Math.sqrt(n) + 1;
        for (int i = 3; i < max; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static class Rev {
        int base;

        static Rev from(int n) {
            String nx = Integer.toString(n);
            Rev r = new Rev();

            if (nx.length() % 2 == 0) {
                r.base = (int) Math.pow(10, nx.length() / 2);
            } else {
                r.base = Integer.valueOf(nx.substring(0, nx.length() / 2 + 1));
            }
            return r;
        }

        Rev f(int d) {
            Rev r = new Rev();
            r.base = base + d;
            return r;
        }

        int get() {
            char[] bc = Integer.toString(base).toCharArray();
            int n = 0;
            for (int i = 0; i < bc.length; i++) {
                n = n * 10 + (bc[i] - '0');
            }
            int pos = bc.length - 1;
            for (int i = pos - 1; i >= 0; i--) {
                n = n * 10 + (bc[i] - '0');
            }
            return n;
        }
    }
}
