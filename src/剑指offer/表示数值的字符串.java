package 剑指offer;

/**
 * @Author: pyh
 * @Date: 2019/2/19 19:55
 * @Version 1.0
 * @Function:
 *      请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *      例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *      但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class 表示数值的字符串 {
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0){
            return false;
        }

        int index = 0;
        if (str[0] == '+' || str[0] == '-'){
            index++;
        }

        boolean hasE = false;
        boolean hasPoint = false;
        for(int i = index; i < str.length; i++){
            if(!hasE && (str[i] == 'e' || str[i] == 'E')){
                hasE = true;
                hasPoint = true; //e 后不能有小数点
                if(i+1 >= str.length){
                    return false;
                }
                if(i+1 < str.length && (str[i+1] == '+' || str[i+1] == '-')){
                    i++;
                    if(i+1 < str.length && (str[i+1] < '0' || str[i+1] > '9')){
                        return false;
                    }
                }
                continue;
            }

            if(!hasPoint && (str[i] == '.')){
                hasPoint = true;
                if(i+1 >= str.length){
                    return false;
                }
                continue;
            }

            if(str[i] > '9' || str[i] < '0'){
                return false;
            }
        }
        return true;
    }
}
