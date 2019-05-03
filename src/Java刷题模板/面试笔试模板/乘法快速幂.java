package Java刷题模板.面试笔试模板;

/**
 * @Author: pyh
 * @Date: 2019/4/30 11:14
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 递归计算 (a^n) % mod
 * 非递归计算 (a^n) % mod
 * 计算 ( a * b ) % mod
 * 配合 ( a * b ) % mod和乘法快速幂
 * XYNUOJ - 1872. 次方求模题解
 * LeetCode - 50. Pow(x, n)题解
 *
 */
public class 乘法快速幂 {

    /**
     * 递归计算 (a^n) % mod
     * */
    static long pow_mod(long a, long n, long mod){
        if(n == 0)
            return 1;

        //先求一半
        long halfRes = pow_mod(a, n >> 1, mod);

        long res = halfRes * halfRes % mod;

        if((n & 1) != 0)    //奇数时的情景
            res = res * a % mod;

        return res;
    }

    /**
     * 非递归计算 (a^n) % mod
     * */
    static long pow_mod2(long a, long n, long mod){
        long res = 1;
        while(n > 0){
            if((n & 1) != 0){   //二进制最低位是1
                res = res * a % mod;
            }
            a = a * a % mod; // a = a^2
            n = n >> 1;   // n/2 向右移动一位
        }
        return res;
    }

    /**
     * 计算 (a * b) % mod
     * */
    static long mul_mod(long a, long b, long mod){
        long res = 0;

        while(b > 0){
            if((b & 1) != 0){
                res = (res + a) % mod;
            }
            a = (a << 1) % mod;
            b >>= 1;
        }

        return res;
    }


    static long pow(long a, long n){
        long res = 1;
        while(n > 0){
            if((n & 1) != 0){
                res = res * a;
            }
            a = a * a;
            n >>= 1;
        }
        return res;
    }

    //测试方法
    public static void main(String[] args){
        System.out.println(pow_mod2(2,10, 5));
    }
}
