package Java刷题模板.面试笔试模板;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/4/29 21:57
 * @Version: 1.0
 * @Function:
 * @Description:
 * 质数（prime number）又称素数，有无限个。
 *  质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数。
 */
public class 素数筛法 {

    /**
     * 普通筛素数法
     * 这个也是普通的素数判定的方法，这个方法判定素数时间复杂度为O (sqrt(n))。
     *  只要检查2 —— n-1 所有整数是否整除 n 就能判定  n是不是素数
     *
     *  可能会超时
     * */
    static ArrayList<Integer> sieveClassic(boolean[] is_prime, int MAX){
        ArrayList<Integer> prime = new ArrayList<>();
        is_prime[0] = is_prime[1] = false;//0 1 不是素数
        boolean flag;
        for(int i = 2; i <= MAX; i++){
            flag = true;
            for(int j = 2; j * j <= i; j++){ //根号i 的时间复杂度
                if(i % j == 0){
                    is_prime[i] = false;
                    flag = false;
                    break;
                }
            }

            if(flag){
                prime.add(i);
                is_prime[i] = true;
            }
        }
        return prime;
    }

    //经典埃式筛法
    /**
     * 首先，将2 - n 范围内的所有整数写下来。其中最小的数字2 是素数。 将表中所有2 的倍数都划去
     * 表中剩余的最小数字是 3， 它不能被更小的数整除，所以是素数。
     * 再将表中所有3 的倍数全部划去。
     * 以此类推，如果表中剩余的最小数字是m时，m就是素数。
     * 然后将表中所有m 的倍数全都划去，像这样反复操作，就能依次枚举出 n 以内的素数
     * */
    static ArrayList<Integer> sieve(boolean[] is_prime, int MAX){
        ArrayList<Integer> prime = new ArrayList<>();
        Arrays.fill(is_prime, true);
        for(int i = 2; i <= MAX; i++){
            if(is_prime[i]){
                prime.add(i);

                for(int j = i*2; j <= MAX; j += i){
                    is_prime[j] = false;
                }
            }
        }
        return prime;
    }

    //优化筛法
    static ArrayList<Integer> sieve2(boolean[] is_prime, int MAX){
        ArrayList<Integer> prime = new ArrayList<>();
        Arrays.fill(is_prime, true);
        is_prime[0] = is_prime[1] = false;
        for(int i = 2; i <= MAX; i++){
            if(is_prime[i]){
                prime.add(i);
            }

            for(int j = 0; j < prime.size() && prime.get(j) <= MAX/i; j++){
                is_prime[prime.get(j) * i] = false;
                if(i % prime.get(j) == 0){
                    break;
                }
            }
        }
        return prime;
    }

    //测试方法
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        int MAX = 100000000;
        MAX = 200000000;
        ArrayList<Integer>  res = sieve(new boolean[MAX+1], MAX);
        //sieve  3303 ms    5761455     埃式筛法
        //sieveClassic 108998ms   5761455   超时
        //sieve 2167ms  5761455     优化筛法
        System.out.println(res.size());
        long end = System.currentTimeMillis();
        System.out.println("程序花费时间为:" + (end - start) + " ms");
        //printList(res);
    }

    static void printList(ArrayList<Integer> list){
        for(int x : list){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
