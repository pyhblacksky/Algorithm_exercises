package 校招真题_2018.网易_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/15 16:50
 * @Version 1.0
 * @Function:
 *      交错01串
 *      如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。
 *      例如: "1","10101","0101010"都是交错01串。
 */
public class diff0_1 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()){
            String str = scan.nextLine();
            int res = detect(str);
            System.out.println(res);
        }
        scan.close();
    }

    private static int detect(String str){
        int res = 1;
        for(int i = 0; i < str.length(); i++){
            int temp = 1;
            int save = i;
            for(int j = save + 1; j < str.length(); j++){
                if(str.charAt(save) != str.charAt(j)){
                    temp++;
                    save++;
                } else{
                    break;
                }
            }
            res = Math.max(res, temp);
        }

        return res;
    }


}
