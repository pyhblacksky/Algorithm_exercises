package 校招笔试2020.华为8_21;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/21 19:05
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class S1 {

    //AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] str = line.split("\\s+");

        if(str.length == 0)
            return;

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 1; i < str.length; i++){
            char c = str[i].charAt(0);
            if(c == 'A'){
                count += 2;
                sb.append("12 34 ");
            } else if(c == 'B'){
                count += 2;
                sb.append("AB CD ");
            } else{
                count++;
                sb.append(c + " ");
            }
        }

        String len = intToHex(count+1);

        System.out.println(len + " " + sb.toString().trim());
    }

    static String intToHex(int n) {
        StringBuilder sb = new StringBuilder();
        char[] chs = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            sb.append(chs[n % 16]);
            n = n/16;
        }
       return sb.reverse().toString();
    }

}
