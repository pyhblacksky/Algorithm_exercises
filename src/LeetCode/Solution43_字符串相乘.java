package LeetCode;

/**
 * @Author: pyh
 * @Date: 2019/4/20 9:47
 * @Version: 1.0
 * @Function:
 * @Description:
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Solution43_字符串相乘 {
    //模拟竖式相乘
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if(n1 <= 0 || n2 <= 0){
            return "";
        }
        int[] res = new int[n1 + n2];

        for(int i = n1-1; i >= 0; i--){
            for(int j = n2-1; j>= 0; j--){
                int bitNum = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');

                bitNum += res[i+j+1];//加上进位

                res[i+j] += bitNum / 10;
                res[i+j+1] = bitNum % 10;
            }
        }

        //去除前缀0
        int index = 0;
        while(res[index] == 0 && index < res.length-1){// "0" * "0" 的情况
            index++;
        }

        //转换为字符串
        StringBuilder sb = new StringBuilder();
        for(int i = index; i < res.length; i++){
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution43_字符串相乘 solution = new Solution43_字符串相乘();
        String num1 = "0";
        String num2 = "0";
        System.out.println(solution.multiply(num1, num2));
    }
}
