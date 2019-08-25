package 校招笔试2020.快手825;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/8/25 17:09
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 内容插入问题
 * 100% AC
 */
public class S3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        String[] str1 = line1.split(" ");
        String[] str2 = line2.split(" ");

        int count = 0;
        StringBuilder sb = new StringBuilder(str1.length*2 + str2.length*2);
        int index = 0;
        for(int i = 0; i < str1.length; i++){
            count++;
            sb.append(str1[i] + " ");
            if(count % 4 == 0 && index < str2.length){
                sb.append(str2[index++] + " ");
            }
        }

        while(index < str2.length){
            sb.append(str2[index++] + " ");
        }

        System.out.println(sb.toString().trim());
    }

}
