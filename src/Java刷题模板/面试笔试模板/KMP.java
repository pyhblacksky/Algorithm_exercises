package Java刷题模板.面试笔试模板;

/**
 * @Author: pyh
 * @Date: 2019/4/28 20:54
 * @Version: 1.0
 * @Function:
 * @Description:
 *  字符串匹配问题
 *      KMP要解决的问题在字符串中的模式定位问题，即关键词搜索
 *
 */
public class KMP {

    //定位,m匹配s中的
    //失配时，模式串向右移动的位数为：已匹配字符数 - 失配字符的上一位字符所对应的最大长度值
    public static int getIndex(String s, String m){
        if(s == null || m == null || s.length() == 0 || m.length() == 0 || s.length() < m.length()){
            return -1;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int[] next = getNext(str2);
        int i1 = 0;
        int i2 = 0;
        while(i1 < str1.length && i2 < str2.length){
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            } else if(next[i2] == -1){
                i1++;
            } else{
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    /**
     * next数组含义:
     * next[i]的含义是在str[i]之前的字符串也就是: str[0...i)中，
     * 必须以str[i-1]结尾的后缀子串(不能包含str[0]) 和
     * 必须以str[0]开头的前缀子串(不能包含str[i-1])的最大匹配长度
     */
    public static int[] getNext(char[] str){
        if(str.length == 1){
            return new int[]{-1};
        }

        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while(i < str.length){
            if(str[i-1] == str[cn]){
                next[i++] = ++cn;
            } else if(cn > 0){
                cn = next[cn];
            } else{
                next[i++] = 0;
            }
        }
        return next;
    }

    //测试方法
    public static void main(String[] args){
        String a = "abcabcabec";
        String b ="cab";
        System.out.println(getIndex(a, b));
    }
}
