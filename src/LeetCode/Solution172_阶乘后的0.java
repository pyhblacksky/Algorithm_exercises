package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/24 11:18
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class Solution172_阶乘后的0 {

    //方法一，计算出阶乘后的值，来计算尾部0的数量，超时
    public int trailingZeroes(int n) {
        String res = bigFac(n);

        int count = 0;
        for(int i = res.length() - 1; i >= 0; i--){
            if(res.charAt(i) == '0'){
                count++;
            } else{
                break;
            }
        }

        return count;
    }

    //方法二，计算乘法因子 中5的个数
    public int trailingZeros1(int n){
        if(n < 5){
            return 0;
        }
        int count = 0;
        while(n >= 5){
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    //计算大数阶乘
    public static String bigFac(int n){
        int[] res = new int[10001];
        int digit = 1;
        res[0] = 1;
        for(int i = 2; i <= n; i++){
            int carry = 0;
            for(int j = 0; j < digit; j++){
                int temp = res[j] * i + carry;
                res[j] = temp % 10;
                carry = temp / 10;
            }
            while(carry != 0){
                res[digit] = carry % 10;
                carry /= 10;
                digit++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = digit -1; i >= 0; i--){
            sb.append((char)(res[i] + '0'));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(bigFac(6));
    }
}
