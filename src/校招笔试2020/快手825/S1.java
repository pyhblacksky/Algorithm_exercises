package 校招笔试2020.快手825;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/25 17:49
 * @Version: 1.0
 * @Function:
 * @Description:
 * 版本号更新问题
 * 100%AC
 *
 */
public class S1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        while(N != 0){
            N--;
            String line = sc.nextLine();
            String[] str = line.split(" ");
            String[] demo1 = str[0].split("\\.");
            String[] demo2 = str[1].split("\\.");
            int p1 = 0;
            int p2 = 0;
            boolean flag = true;
            while(p1 < demo1.length && p2 < demo2.length){
                int n1 = Integer.valueOf(demo1[p1]);
                int n2 = Integer.valueOf(demo2[p2]);
                if(n1 < n2){
                    System.out.println("true");
                    flag = false;
                    break;
                } else if(n1 > n2){
                    System.out.println("false");
                    flag = false;
                    break;
                }
                p1++;
                p2++;
            }

            if(flag) {
                boolean mark = true;
                while (p1 < demo1.length) {
                    int n = Integer.valueOf(demo1[p1]);
                    if (n > 0) {
                        System.out.println("false");
                        mark = false;
                        break;
                    }
                    p1++;
                }
                while (p2 < demo2.length) {
                    int n = Integer.valueOf(demo2[p2]);
                    if (n > 0) {
                        System.out.println("true");
                        mark = false;
                        break;
                    }
                    p2++;
                }
                if(mark)
                    System.out.println("false");
            }
        }
    }

}
