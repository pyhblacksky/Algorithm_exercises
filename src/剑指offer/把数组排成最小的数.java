package 剑指offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: pyh
 * @Date: 2019/2/18 19:16
 * @Version 1.0
 * @Function:
 *      输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *      例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class 把数组排成最小的数 {

    public String PrintMinNumber(int [] numbers) {
        String[] strArr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                if(s1.compareTo(s2) < 0){
                    return -1;
                } else{
                    return 1;
                }
            }
        });

        String res = new String();
        for(int i = 0; i < strArr.length; i++){
            res += strArr[i];
        }
        return res;
    }

}
