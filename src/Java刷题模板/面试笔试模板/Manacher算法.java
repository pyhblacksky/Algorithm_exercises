package Java刷题模板.面试笔试模板;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/4/28 22:09
 * @Version: 1.0
 * @Function:
 * @Description:
 *  解决的是求最长回文子串的问题
 *
 *  leetcode 5 最长回文子串问题
 */
public class Manacher算法 {

    //解决O(N)求最长回文串问题

    //生成指定格式的字符串
    /**
     * 获取指定格式的字符串(中间和两边都带有#) 这样可以处理偶回文
     * 例如 : 如果是abc -->#a#b#c#
     * 如果是abcd -->#a#b#c#d#
     */
    public static char[] manacherString(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        char[] res = new char[str.length()*2+1];
        int index = 0;
        for(int i = 0; i < res.length; i++){
            res[i] = i % 2 == 0 ? '#' : str.charAt(index++);
        }
        return res;
    }

    //manacher方法
    public static int manacher(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] chs = manacherString(s);
        int[] r = new int[chs.length];//记录每个位置的最长回文半径，大小是chs的长度
        int pR = -1;//最长回文右边界;
        int C = -1;//最长回文中心
        int max = Integer.MIN_VALUE; // 记录结果
        for(int i = 0; i < chs.length; i++){
            //此时包含三种情况
            //  1、i不在回文右边界里(i >pR)，暴力扩
            //  2、i在回文右边界里，i关于C对称的位置i'在L，R内（L是pR关于C的对称点）；则r[i] = r[i'] = r[2*C-i]
            //  3、i在回文右边界里，i关于C对称的位置i'在L，R外；r[i] = R - i
            r[i] = pR > i ? Math.min(r[2*C - i], pR - i) : 1;//为1是暴力扩
            while(i + r[i] < chs.length && i - r[i] >= 0){//保证不越界
                if(chs[i+r[i]] == chs[i-r[i]]){
                    r[i]++;
                } else{
                    break;//扩不动了
                }
            }

            if(i + r[i] > pR){
                pR = i + r[i];//更新右边界
                C = i;//更新中心
            }
            max = Math.max(max, r[i]);//取最大的r[i]（r[i]记录的是每个位置的最大回文半径）
        }
        return max - 1;//求出的是加了'#'的，所以需要-1
    }

    //manacher还原最长回文串
    public static String getStringFromManacher(String s){
        if(s == null || s.length() == 0){
            return null;
        }
        char[] chs = manacherString(s);
        int[] r = new int[chs.length];
        int C = -1;
        int pR = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i < chs.length; i++){
            r[i] = pR > i ? Math.min(r[2*C - i], pR - i) : 1;
            while(i + r[i] < chs.length && i - r[i] >= 0){//暴力扩
                if(chs[i + r[i]] == chs[i - r[i]]){
                    r[i]++;
                } else{
                    break;
                }
            }

            if(i + r[i] > pR){
                pR = i + r[i];
                C = i;
            }
            if(r[i] > max){
                max = r[i];
                maxIndex = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = maxIndex - (max-1); i <= maxIndex + (max - 1); i++){
            if(chs[i] != '#'){
                sb.append(chs[i]);
            }
        }
        return sb.toString();
    }

    //测试方法
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            String s = in.next();// bcbca    abFeFbatttzxFeFs
            System.out.println(manacher(s));
            System.out.println(getStringFromManacher(s));
        }
    }
}
