package Java刷题模板.面试笔试模板;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: pyh
 * @Date: 2019/4/30 8:43
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 *  解决的问题: 任何一个大于1的自然数 N，如果N不为质数，那么N可以唯一分解成有限个质数的乘积。
 *  题目链接
 *  https://acm.sdut.edu.cn/onlinejudge2/index.php/Home/Index/problemdetail/pid/1634.html
 */
public class 唯一分解定理 {

    //唯一分解定理,输出分解后的质数
    static ArrayList<Integer> sieve(int MAX){
        ArrayList<Integer> prime = new ArrayList<>();
        boolean[] is_prime = new boolean[MAX+1];

        //求出质数
        Arrays.fill(is_prime, true);
        for(int i = 2; i <= MAX; i++){
            if(is_prime[i]){
                prime.add(i);

                for(int j = 2*i; j <= MAX; j += i){
                    is_prime[j] = false;
                }
            }
        }

        //分解筛选
        int n = MAX;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < prime.size(); i++){
            int p = prime.get(i);
            while(n % p == 0){
                res.add(p);
                n /= p;
            }
        }

        return res;
    }

    //约数(因数)枚举  得到某个数的约数，所有约数
    static ArrayList<Integer> divisor(int n){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0){
                res.add(i);
            }
            if(i != n/i){//去重, 比如 5 * 5，已经含有因子5
                res.add(n/i);
            }
        }
        return res;
    }

    //整数分解  将一个正整数写成几个约数的乘积
    static HashMap<Integer, Integer> prime_factor(int n){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 2; i * i <= n; i++){
            while(n % i == 0){
                if(map.containsKey(i)){
                    map.put(i, map.get(i) + 1);
                } else{
                    map.put(i, 1);
                }
                n /= i;
            }
        }

        if(n != 1)
            map.put(n,1);

        return map;
    }

    //测试方法
    public static void main(String[] args){

        ArrayList<Integer> res = sieve(2451);

        printList(res);

        HashMap<Integer, Integer> map = prime_factor(45);
        printMap(map);

    }
    static void printList(ArrayList<Integer> list){
        for(int x : list){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void printMap(Map<Integer, Integer> map){
        for(Map.Entry temp : map.entrySet()){
            System.out.println(temp.getKey() + " * " + temp.getValue());
        }
        System.out.println();
    }
}
