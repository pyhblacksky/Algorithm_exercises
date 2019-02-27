package 剑指offer.水题;

/**
 * @Author: pyh
 * @Date: 2019/2/16 11:22
 * @Version 1.0
 * @Function:
 *      替换空格
 *      请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *      例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格 {

    //不使用replaceAll
    public static String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                sb.append("%20");
                continue;
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /***************************************************************************************************************/

    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("We  Are Happy");
        String res = replaceSpace(sb);
        System.out.println(res);
    }

}
