package 校招笔试2020.快手825;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: pyh
 * @Date: 2019/8/25 17:13
 * @Version: 1.0
 * @Function:
 * @Description:
 * 100% AC
 */
public class S2 {

    //32位正整数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N != 0) {
            N--;
            int number = sc.nextInt();

            boolean flag = true;
            Set<Integer> set = new LinkedHashSet<>();
            while (number != 1) {
                int pre = number;
                number = func(number);
                if (pre == number || set.contains(number)) {
                    System.out.println("false");
                    flag = false;
                    break;
                }
                set.add(number);
            }

            if(flag) {
                System.out.println("true");
            }
        }
    }

    static int func(int num){
        int result = 0;
        while(num != 0) {
            int temp = num%10;
            result += temp*temp;
            num = num/10;
        }

        return result;
    }

}
