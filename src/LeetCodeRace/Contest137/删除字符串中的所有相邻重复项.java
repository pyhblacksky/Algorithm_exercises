package LeetCodeRace.Contest137;

/**
 * @Author: pyh
 * @Date: 2019/5/19 10:46
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class 删除字符串中的所有相邻重复项 {

    //超时
    public static String removeDuplicates(String S) {
        if(S == null || S.length() < 1){
            return S;
        }

        for (int i = 0; i < S.length() - 1; i++) {
            boolean flag = false;
            for (int j = i+1; j < S.length(); j++) {
                char c1 = S.charAt(i);
                char c2 = S.charAt(j);
                if (c1 == c2) {
                    S = S.substring(0, j-1) + S.substring(j+1);
                    j--;
                    flag = true;
                } else {
                    break;
                }
            }
            if(flag){
                i = 0;
            }
        }

        if(S.length() >= 2){
            if(S.charAt(0) == S.charAt(1)){
                S = S.substring(2);
            }
        }

        return S;
    }

    public static void main(String[] args){
        String s = removeDuplicates("abbaca");
        String s1 = removeDuplicates("azxxzy");

        String s4 = removeDuplicates(s1);
        System.out.println(s4);
    }
}
