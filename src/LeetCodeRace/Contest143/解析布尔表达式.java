package LeetCodeRace.Contest143;

/**
 * @Author: pyh
 * @Date: 2019/6/30 11:29
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 *
 * 有效的表达式需遵循以下约定：
 *
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *
 *
 * 示例 1：
 *
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 *
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 *
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 *
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 */
public class 解析布尔表达式 {

    /**
     * 布尔表达式有5个规则。
     *     1.t 真
     *     2.f 假
     *     3.!(expr)取反
     *     4.&(expr1,expr2,...) 取与
     *     5.|(expr1, expr2,...) 取或
     *
     *     增加另外一个规则，就可以形成递归闭环。
     *     6. `(expr,expr,...)` 获得布尔表达式集合。
     *     只需要统计是否有true和是否有false即可
     */
    class Solution {
        int start = 0;
        public boolean parseBoolExpr(String expression) {
            return passExpr(expression.toCharArray());
        }

        private boolean passExpr(char[] expression){
            char c = expression[start];
            start++;//跳过括号

            if(c == 't')
                return true;
            if(c == 'f')
                return false;

            if(c == '!')
                return !passMore(expression,1);
            if(c == '|')
                return passMore(expression,1);
            if(c == '&')
                return passMore(expression, 0);

            return true;
        }

        private boolean passMore(char[] expression, int flag){
            start++;//跳过括号
            boolean ret = passExpr(expression);
            while(expression[start] == ','){
                start++;//跳过逗号
                boolean temp = passExpr(expression);
                if(flag == 1){
                    ret = ret || temp;
                } else{
                    ret = ret && temp;
                }
            }
            start++;//跳过括号
            return ret;
        }
    }
}
