package 牛客竞赛OJ.快速幂;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/20 20:58
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 链接：https://ac.nowcoder.com/acm/problem/15187
 * 来源：牛客网
 *
 * 题目描述
 * 毕竟是元宵节，晚上还是要吃几个元宵。 Etéreo 家可是个大家庭，元宵的数量，甚至是餐具的数量，都多的惊人。现在，爱数学的 Etéreo 又来问你有趣的数学题了，快来秒掉它！   Etéreo 家里有
 * ς
 * ς 种元宵馅，
 * ϑ
 * ϑ 种元宵皮，每个元宵可以选择任意一种元宵馅和任意一种元宵皮。同时有
 * ϖ
 * ϖ 张桌子，每张桌子上放了
 * ϱ
 * ϱ 只碗，每只碗能放一只元宵。每只碗都要装一只元宵。Etéreo 会告诉你
 * ς
 * ,
 * ϑ
 * ,
 * ϖ
 * ,
 * ϱ
 * ς,ϑ,ϖ,ϱ 的值，想请问你有多少种装元宵的方式。答案对
 * Λ
 * Λ 取模。
 * 两种方式被认为是不同的当且仅当至少有一只碗存在于两种方式的同一个位置但是里面有至少一个元宵不同。
 * 两个元宵被认为是不同的当且仅当元宵馅不同或者元宵皮不同。
 * 碗和桌子都是有编号的，但是你不能改变碗或桌子的编号。
 * 你可以认为碗和桌子都是固定的，你只能改变元宵的种类和位置。
 *
 * 输入描述:
 * 输入共一行，五个整数
 * ς
 * ,
 * ϑ
 * ,
 * ϖ
 * ,
 * ϱ
 * ,
 * Λ
 * ς,ϑ,ϖ,ϱ,Λ ，意义同题目描述。
 * 输出描述:
 * 每行一个整数，表示答案。
 * 示例1
 * 输入
 * 复制
 * 1 2 1 3 998244353
 * 输出
 * 复制
 * 8
 */
public class 分元宵 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long d = sc.nextLong();
        long mod = sc.nextLong();

        long res = getAns(a, b, c, d, mod);
        System.out.println(res);
    }

    //实际是(a+b) ^ (c*d)
    static long getAns(long a, long b, long c, long d, long mod){
        long n = a*b;
        long m = c*d;

        long res = 1;
        while(m > 0){
            if((m & 1) != 0){
                res = res * n % mod;
            }
            n = n*n % mod;
            m = m >> 1;
        }

        return res;
    }
}
