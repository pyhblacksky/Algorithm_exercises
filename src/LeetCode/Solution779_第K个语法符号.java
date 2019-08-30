package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/8/29 10:56
 * @Version: 1.0
 * @Function:
 * @Description:
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 *
 *
 * 例子:
 *
 * 输入: N = 1, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 2
 * 输出: 1
 *
 * 输入: N = 4, K = 5
 * 输出: 1
 *
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 *
 * 注意：
 *
 * N 的范围 [1, 30].
 * K 的范围 [1, 2^(N-1)].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution779_第K个语法符号 {

    //模拟题意，超时
    class Solution {
        public int kthGrammar(int N, int K) {
            String[] strs = new String[N];
            strs[0] = "0";
            for(int i = 1; i < N; i++){
                StringBuilder sb = new StringBuilder(strs[i-1].length()*2);
                for(int j = 0; j < strs[i-1].length(); j++){
                    char c = strs[i-1].charAt(j);
                    if(c == '0'){
                        sb.append("01");
                    } else if(c == '1'){
                        sb.append("10");
                    }
                }
                strs[i] = sb.toString();
            }

            if(K > strs[N-1].length()){
                return 0;
            }
            return strs[N-1].charAt(K-1) - '0';
        }
    }

    //尾递归
    /**
     * 第 N 行的第 K 个数字，是通过 N - 1 行的第 (K - 1) / 2 + 1) 个数字产生的。（因为K是从 1 开始的需要 -1）
     * (K - 1) / 2 + 1) == (k + 1) / 2 ← 这俩是一样的
     *
     * 然后，通过递归调用，肯定能够计算出这个数字。
     * 如果 N - 1 行的数字是 0 ，那么产生 01 ，否则产生 10 。
     * 第 1 行，只有 0 一个数字。
     *
     * 最后，具体产生的是前面的数字还是后面的数字？
     * 这就要看原来的K，通过求余数操作计算，即 (K - 1) % 2。
     *
     * 另外：
     * 第 N 行的数字长度为 2 的 N - 1 次方个。（调试的时候能用到 :P）
     *
     * 作者：ikaruga
     * 链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar/solution/di-kge-yu-fa-fu-hao-by-ikaruga-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */
    class Solution1{
        public int kthGrammar(int N, int K){
            if(N == 1)
                return 0;
            return kthGrammar(N-1, (K-1)/2+1) == 0 ? (K-1) % 2 : 1 - (K-1)%2;
        }
    }

}
