package 校招真题_2018.滴滴出行;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/2/24 13:52
 * @Version 1.0
 * @Function:
 */
public class 寻找丑数 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int res = UnglyNum(n);
            System.out.println(res);
        }
        scan.close();
    }
    private static int UnglyNum(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        list.add(1);
        for(int i = 1; i < n; i++){
            int min = Math.min(list.get(p2)*2, Math.min(list.get(p3)*3, list.get(p5)*5));
            if(min == list.get(p2)*2){
                p2++;
            }
            if(min == list.get(p3)*3){
                p3++;
            }
            if(min == list.get(p5)*5){
                p5++;
            }
            list.add(min);
        }
        return list.get(list.size()-1);
    }


}
