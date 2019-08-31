package Java刷题模板.面试笔试模板;

/**
 * @Author: pyh
 * @Date: 2019/8/27 14:20
 * @Version: 1.0
 * @Function:
 * @Description:
 * 十进制的数，含小数转换为n进制的数
 */
public class 进制转换 {

    static int HEX = 2;
    public static void main(String[] args) {

        String str = TenToHexAll(10.25);
        System.out.println(str);

        double res = HexToTen("1010.01", 2);
        System.out.println(res);
    }

    //进制转换整数部分
    public static String TenToHEX(int n){
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append(n % HEX);
            n = n /HEX;
        }

        return sb.reverse().toString();
    }

    //进制转换小数部分,保留十位小数
    public static String TenToHEXPoint(double n){
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append((int)(n*HEX));
            n = n*HEX - (int)(n*HEX);
            if(sb.length() >= 10)
                break;
        }
        //return "0." + sb.toString();
        return sb.toString();
    }

    //输入任意double类型的数，将输出对应进制的变化
    public static String TenToHexAll(double n){
        if(n - (int)n == 0){
            //只有整数部分
            return TenToHEX((int)n);
        } else{
            int num = (int)n;
            double decimal = n - (int)n;
            return TenToHEX(num) + "." + TenToHEXPoint(decimal);
        }
    }

    /**
     * n进制转为10进制
     * str 是n禁止的数
     * n是多少进制
     * */
    public static double HexToTen(String str, int n){
        //如果有小数的话
        String[] sp = str.split("\\.");

        int pow = 0;
        int resInt = 0;
        for(int i = sp[0].length()-1; i >= 0; i--){
            char c = sp[0].charAt(i);
            int num = (c-'0') * (int)Math.pow(n, pow);
            pow++;
            resInt += num;
        }

        double point = 0;
        pow = -1;
        for(int i = 0; i < sp[1].length(); i++){
            char c = sp[1].charAt(i);
            double num = (c-'0') * Math.pow(n, pow);
            pow--;
            point += num;
        }

        return resInt + point;
    }

}
