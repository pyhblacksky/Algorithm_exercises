package 程序员面试金典;

/**
 * @Author: pyh
 * @Date: 2019/7/7 16:12
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 *
 * 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
 *
 * 测试样例：
 * "aeiou"
 * 返回：True
 * "BarackObama"
 * 返回：False
 */
public class 确定字符互异 {

    //暴力方法，允许使用额外空间则用HashSet O(N）即可完成
    public class Different {
        public boolean checkDifferent(String iniString) {
            // write code here
            if(iniString == null || iniString.length() <= 1)
                return true;

            for(int i = 0; i < iniString.length(); i++){
                char c1 = iniString.charAt(i);
                for(int j = i+1; j < iniString.length(); j++){
                    char c2 = iniString.charAt(j);
                    if(c1 == c2)
                        return false;
                }
            }
            return true;
        }
    }

}
