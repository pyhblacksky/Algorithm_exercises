package 公司题.字节跳动;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/7/12 10:22
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 *
 * 输入描述:
 * 第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。
 *
 * 后面跟随N行，每行为一个待校验的字符串。
 *
 * 输出描述:
 * N行，每行包括一个被修复后的字符串。
 *
 * 输入例子1:
 * 2
 * helloo
 * wooooooow
 *
 * 输出例子1:
 * hello
 * woow
 */
public class 聪明的编辑 {

    //
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            String res = getRes(str);
            System.out.println(res);
        }
    }

    static String getRes(String str){
        if(str == null || str.length() <= 2){
            return str;
        }

        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();
        for(int i = 0; i < chs.length; i++){
            if(sb.length() < 2){
                sb.append(chs[i]);
                continue;
            }
            if(chs[i] == sb.charAt(sb.length()-1) && chs[i] == sb.charAt(sb.length()-2)){
                continue;
            }
            if(sb.length() - 3 >= 0 && sb.charAt(sb.length()-3) == sb.charAt(sb.length()-2) && sb.charAt(sb.length()-1) == chs[i]){
                continue;
            }
            sb.append(chs[i]);
        }

        return sb.toString();
    }

}
