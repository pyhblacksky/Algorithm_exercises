package LeetCodeRace.Contest144;

import java.util.Arrays;

/**
 * @Author: pyh
 * @Date: 2019/7/7 11:11
 * @Version: 1.0
 * @Function:
 * @Description:
 * 有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：
 *
 * 空字符串
 * 连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 * 嵌套，可以记作 (A)，其中 A 是有效括号字符串
 * 类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 *
 * s 为空时，depth("") = 0
 * s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 * s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 * 例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 都不是有效括号字符串。
 *
 *
 *
 * 给你一个有效括号字符串 seq，将其分成两个不相交的子序列 A 和 B，且 A 和 B 满足有效括号字符串的定义（注意：A.length + B.length = seq.length）。
 *
 * 现在，你需要从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。
 *
 * 返回长度为 seq.length 答案数组 answer ，选择 A 还是 B 的编码规则是：如果 seq[i] 是 A 的一部分，那么 answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。
 *
 *
 *
 * 示例 1：
 *
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * 示例 2：
 *
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 *
 *
 * 提示：
 *
 * 1 <= text.size <= 10000
 *
 */
public class 有效括号的嵌套深度 {

    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            char[] cs = seq.toCharArray();
            int len = cs.length;
            int lo = 0;
            int hi = len;

            int[] res = null;

            while(lo < hi){
                int mid = lo + ((hi-lo) >> 1);
                if(isOk(cs, mid)){
                    hi = mid;
                    res = Arrays.copyOf(tp, len);
                }else{
                    lo += 1;
                }
            }
            return res;
        }

        int[] tp;
        boolean isOk(char[] cs, int limit){
            tp = new int[cs.length];
            int p = 0;
            int ma = 0;
            int p1 = 0;
            int x = 0;
            for(char c : cs){
                if(c == '('){
                    if(p + 1 > limit){
                        p1++;
                        tp[x] = 1;
                    }else{
                        p++;
                    }
                    ma = Math.max(p1, ma);
                    ma = Math.max(p, ma);
                }else{
                    if(p > 0){
                        --p;
                    }else{
                        --p1;
                        tp[x] = 1;
                    }
                    if(p < 0 || p1 < 0){
                        return false;
                    }
                }
                x++;
            }
            return p == 0 && p1 == 0 && ma <= limit;
        }
    }

}
