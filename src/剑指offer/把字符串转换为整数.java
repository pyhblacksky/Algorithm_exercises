package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/19 16:39
 * @Version 1.0
 * @Function:
 *      将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 *      要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 *      输入描述:
 *      输入一个字符串,包括数字字母符号,可以为空
 *      输出描述:
 *      如果是合法的数值表达则返回该数字，否则返回0
 */
public class 把字符串转换为整数 {

    //正负号也要考虑
    public static int StrToInt(String str) {
        if(str == null || str.length() == 0 || str.trim().equals("")){
            return 0;
        }

        boolean positive = true;
        int index = 0;
        //正负号
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '+' && i+1 < str.length() && str.charAt(i+1) != '+'){
                positive = true;
                index = i+1;
                break;
            } else if(str.charAt(i) == '-' && i+1 < str.length() && str.charAt(i+1) != '-'){
                positive = false;
                index = i+1;
                break;
            }
        }

        int carry = 1;
        int res = 0;
        for(int i = str.length() - 1; i >= index; i--){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                return 0;
            } else{
                //判断溢出
                if(carry * (str.charAt(i) - '0') > Integer.MAX_VALUE){
                    return 0;
                } else{
                    res += carry * (str.charAt(i) - '0');
                    carry = carry*10;
                }
            }
        }
        if (positive){
            return res;
        } else {
            return -res;
        }
    }

    public static void main(String[] args){
        String str = "16541";
        System.out.println(StrToInt(str));
    }
}
