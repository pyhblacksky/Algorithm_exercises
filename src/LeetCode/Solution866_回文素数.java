package LeetCode;

import java.util.ArrayList;

/**
 * @Author: pyh
 * @Date: 2019/4/30 9:17
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 求出大于或等于 N 的最小回文素数。
 *
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 *
 * 例如，2，3，5，7，11 以及 13 是素数。
 *
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 *
 * 例如，12321 是回文数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：6
 * 输出：7
 * 示例 2：
 *
 * 输入：8
 * 输出：11
 * 示例 3：
 *
 * 输入：13
 * 输出：101
 *
 *
 * 提示：
 *
 * 1 <= N <= 10^8
 * 答案肯定存在，且小于 2 * 10^8。
 */
public class Solution866_回文素数 {

    //方法一，打表法
    public int primePalindrome1(int N) {
        if(N <= 2){
            return 2;
        }

        ArrayList<Integer> prime = getPrimeList();
        for(int num : prime){
            if(num >= N){
                return num;
            }
        }
        return -1;
    }

    static boolean isReverse(int num){
        int oldNum = num;
        int newNum = 0;
        while(num > 0){
            newNum = newNum * 10 + num % 10;
            num /= 10;
        }

        return oldNum == newNum;
    }

    //求出所有素数    100000000以内
    static ArrayList<Integer> getPrimeList(){
        int max = 200000000;
        boolean[] is_prime = new boolean[max];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i < max; i++){
            if(!is_prime[i]){
                if(isReverse(i)){
                    list.add(i);
                }

                for(int j = i*2; j < max; j += i){
                    is_prime[j] = true;
                }
            }
        }
        return list;
    }

    //测试
    public static void main(String[] args){
        ArrayList<Integer> res = getPrimeList();
        System.out.println(res.size());

        printList(res);
    }


    static void printList(ArrayList<Integer> list){
        for(int x : list){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    /******************************************************************************/
    //方法二
    public int primePalindrome(int N) {
        if (N > 7 && N <= 11) {
            return 11;
        }
        Rev rev = Rev.from(N);
        while (true) {
            int k = rev.get();
            if (k >= N && isPrime(k)) {
                return k;
            }
            rev.base++;
        }
    }

    boolean isPalindrom(int n) {
        char[] nc = Integer.toString(n).toCharArray();
        for (int i = 0; i < nc.length / 2; i++) {
            if (nc[i] != nc[nc.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    boolean isPrime(int n) {
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
