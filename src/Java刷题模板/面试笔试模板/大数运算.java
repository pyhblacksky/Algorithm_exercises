package Java刷题模板.面试笔试模板;

/**
 * @Author: pyh
 * @Date: 2019/4/24 10:05
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class 大数运算 {
    /**
     * 大数加法
     * 两个大数我们可以用数组来保存，然后在数组中逐位进行相加，再判断该位相加后是否需要进位，
     * 为了方便计算，我们将数字的低位放在数组的前面，高位放在后面。
     * */
    public static String bigAdd(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n1 = s1.length;
        int n2 = s2.length;
        int maxL = Math.max(n1, n2);
        int[] a = new int[maxL+1];//注意其数组大小必须是maxL+1 ，因为存在溢位
        int[] b = new int[maxL+1];
        for(int i = 0; i < n1; i++){
            a[i] = s1[n1 - i - 1] - '0';
        }
        for(int i = 0; i < n2; i++){
            b[i] = s2[n2 - i -1] - '0';
        }
        for(int i = 0; i < maxL; i++){
            if(a[i] + b[i] >= 10){
                //处理进位
                int temp = a[i] + b[i];
                a[i] = temp % 10;
                a[i+1] += temp / 10;
            } else{
                a[i] += b[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        if(a[maxL] != 0)
            sb.append((char)(a[maxL] + '0'));
        for(int i = maxL - 1; i >= 0; i--){
            sb.append((char)(a[i] + '0'));
        }
        return sb.toString();
    }

    /**
     * 大数乘法
     * */
    public static String bigMul(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n1 = s1.length;
        int n2 = s2.length;
        int[] a = new int[n1];
        int[] b = new int[n2];
        int[] c = new int[n1+n2];
        for(int i = 0; i < n1; i++){
            a[i] = s1[n1-1+i] - '0';
        }
        for(int i = 0; i < n2; i++){
            b[i] = s2[n2-1+i] - '0';
        }
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                c[i+j] += a[i] * b[j];
            }
        }
        for(int i = 0; i < n1 + n2 - 1; i++){
            if(c[i] >= 10){
                c[i+1] += c[i]/10;
                c[i] %= 10;
            }
        }

        int i;
        for(i = n1+n2-1; i >= 0; i--){
            if(c[i] != 0){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(;i >= 0; i--){
            sb.append((char)(c[i] + '0'));
        }
        return sb.toString();
    }

    /**
     * 大数阶乘
     * 比如算50的阶乘:
     *
     * 我们要先从1开始乘：1*2=2，将2存到a[0]中；
     * 接下来是用a[0]*3；2*3=6，将6储存在a[0]中；
     * 接下来是用a[0]*4；6*4=24，是两位数，那么24%10==4存到a[0]中，24/10==2存到a[1]中；
     * 接下来是用a[0]*5；a[1]*5+num(如果前一位相乘结果位数是两位数，那么num就等于十位上的那个数字；
     *      如果是一位数，num==0)；24*5=120，是三位数，那么120%10==0存到a[0]中，120/10%10==2存到a[1]中，
     *      120/100==1存到a[2]中；
     * 接下来是用a[0]*6、a[1]*6+num、a[2]*6+num、120*6=720，那么720%10==0存到a[0]中，
     *      720/10%10==2存到a[1]中，720/100==7存到a[2]中。。。
     * */
    public static String bigFactorial(int n){
        int[] res = new int[100001];
        int digit = 1;
        res[0] = 1;
        for(int i = 2; i <= n; i++){
            int carry = 0;
            for(int j = 0; j < digit; j++){
                int temp = res[j] * i + carry;//每一位的运算结果
                res[j] = temp % 10; //将最低位保留在原位置
                carry = temp/10;    //计算进位，等下这个进位会累加到j+1
            }
            while(carry != 0){
                res[digit] = carry % 10;
                carry /= 10;
                digit++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = digit - 1; i >= 0; i--){
            sb.append((char)(res[i] + '0'));
        }
        return sb.toString();
    }
    //计算大数阶乘位数
    //lg(N!)=[lg(N*(N-1)*(N-2)*......*3*2*1)]+1 = [lgN+lg(N-1)+lg(N-2)+......+lg3+lg2+lg1]+1;
    static int factorialDiagit(int n){
        double sum = 0;
        for(int i = 1; i <= n; i++){
            sum += Math.log10(i);
        }
        return (int) sum + 1;
    }


    //测试方法
    public static void main(String[] args){

        String res = bigAdd("99999999999999999999999", "546546132899999999999999999999999944");

        System.out.println(res);
        String fac = bigFactorial(5000);
        System.out.println(fac);
        System.out.println(fac.length());

    }
}
