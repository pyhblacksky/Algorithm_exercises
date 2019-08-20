package 校招笔试2020.bilibili;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/20 18:46
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class S2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] str = line.split(",");

        Arrays.sort(str, (o1, o2)->{
            String s1 = o1+o2;
            String s2 = o2+o1;
            if(s1.equals(s2))
                return 0;
            return Integer.valueOf(s1) > Integer.valueOf(s2) ? 1 : -1;
        });

        StringBuilder sb = new StringBuilder();
        for(String s : str){
            sb.append(s);
        }

        System.out.println(sb.toString());
    }
}
