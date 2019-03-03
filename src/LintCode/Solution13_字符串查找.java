package LintCode;

/**
 * @Author: pyh
 * @Date: 2019/3/2 11:18
 * @Version 1.0
 * @Function:       字符串查找
 * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 *
 * 样例
 * 样例  1:
 * 	输入: source = "source" ， target = "target"
 * 	输出:-1
 *
 * 	样例解释:
 * 	如果source里没有包含target的内容，返回-1
 *
 * 样例 2:
 * 	输入: source = "abcdabcdefg" ，target = "bcd"
 * 	输出: 1
 *
 * 	样例解释:
 * 	如果source里包含target的内容，返回target在source里第一次出现的位置
 *
 * 挑战
 * O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。（提示：KMP）
 */
public class Solution13_字符串查找 {

    public static int strStr(String source, String target) {
        // Write your code here
        if(source == null || target == null){
            return -1;
        }
        if(source.equals(target)){
            return 0;
        }

        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int j = 0;
        for(int i = 0; i < s.length; i++){
            j = 0;
            int temp = i;
            for(; j < t.length; j++){
                if(i < source.length() && s[i] == t[j]){
                    i++;
                } else{
                    i = temp;
                    break;
                }
            }
            if(j == t.length){
                return i - j;
            }
        }
        if(j == t.length){
            return s.length - j;
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(strStr("abcdabcdefg", "bcd"));
    }

}
