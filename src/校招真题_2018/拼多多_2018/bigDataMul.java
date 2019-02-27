package 校招真题_2018.拼多多_2018;

/**
 * @Author: pyh
 * @Date: 2019/2/15 11:02
 * @Version 1.0
 * @Function:
 *      2018拼多多第二题，大数相乘
 */
import java.util.Scanner;

public class bigDataMul {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String a = scan.next();
            String b = scan.next();
            int[] r1 = new int[a.length()];
            for(int  i = 0; i < a.length(); i++){
                r1[i] = a.charAt(i) - '0';
            }
            int[] r2 = new int[b.length()];
            for(int i = 0; i < b.length(); i++){
                r2[i] = b.charAt(i) - '0';
            }
            String res = multiply(r1, r2);
            System.out.println(res);
        }
        scan.close();
    }

    //竖式相乘
    public static String multiply(int[] a, int[] b){
        int[] c = new int[a.length + b.length];

        //相乘
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                c[i+j] += a[i]*b[j];
            }
        }

        //进位
        c = reverse(c);
        normalize(c);

        c = reverse(c);

        //去除前缀0
        StringBuffer bf = new StringBuffer();

        for(int i = 0; i < c.length-1; i++){
            bf.append(c[i]);
        }
        return bf.toString();
    }

    //进位操作
    public static void normalize(int[] res){
        for(int i = 0; i < res.length - 1; i++){
            res[i+1] += res[i] / 10;
            res[i] = res[i] % 10;
        }
    }

    //翻转
    public static int[] reverse(int[] list){
        int[] res = new int[list.length];
        int index = 0;
        for(int i = list.length-1; i >= 0; i--){
            res[index++] = list[i];
        }
        return res;
    }

}