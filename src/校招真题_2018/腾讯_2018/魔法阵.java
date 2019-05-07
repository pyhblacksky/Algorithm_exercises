package 校招真题_2018.腾讯_2018;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/5/7 10:43
 * @Version: 1.0
 * @Function:
 * @Description:
 *
 * 题目描述
 * 小Q搜寻了整个魔法世界找到了四块魔法石所在地，当4块魔法石正好能构成一个正方形的时候将启动魔法阵，
 * 小Q就可以借此实现一个愿望。
 *
 * 现在给出四块魔法石所在的坐标，小Q想知道他是否能启动魔法阵
 *
 * 输入描述:
 * 输入的第一行包括一个整数（1≤T≤5）表示一共有T组数据
 *
 * 每组数据的第一行包括四个整数x[i](0≤x[i]≤10000)，即每块魔法石所在的横坐标
 *
 * 每组数据的第二行包括四个整数y[i](0≤y[i]≤10000),即每块魔法石所在的纵坐标
 * 输出描述:
 * 对于每组数据，如果能启动魔法阵输出“Yes”否则输出“No”。
 * 示例1
 *
 * 输入
 * 3
 * 0022
 * 0202
 * 0156
 * 1605
 * 0077
 * 0303
 *
 * 输出
 * Yes
 * Yes
 * No
 */
public class 魔法阵 {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);

        int T = Integer.valueOf(cin.nextLine());
        while(T != 0){
            String str1 = cin.nextLine();
            String str2 = cin.nextLine();

            if(canStart(str1, str2)){
                System.out.println("Yes");
            } else{
                System.out.println("No");
            }

            T--;
        }
    }

    static boolean canStart(String line1, String line2){
        if(line1 == null || line1.length() == 0 || line2 == null || line2.length() == 0){
            return false;
        }

        int x1 = line1.charAt(0)-'0';
        int y1 = line2.charAt(0)-'0';

        int x2 = line1.charAt(1)-'0';
        int y2 = line2.charAt(1)-'0';

        int x3 = line1.charAt(2)-'0';
        int y3 = line2.charAt(2)-'0';

        int x4 = line1.charAt(3)-'0';
        int y4 = line2.charAt(3)-'0';

        double[] temp = new double[3];
        temp[0] = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        temp[1] = Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
        temp[2] = Math.sqrt((x1-x4)*(x1-x4)+(y1-y4)*(y1-y4));
        if(temp[0] == temp[1] && temp[1] == temp[2]){
            return false;//三个相等，不能构成正方形
        }

        if(!equalTwo(temp)){
            return false;
        }
        /**********************************/
        temp[0] = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        temp[1] = Math.sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));
        temp[2] = Math.sqrt((x2-x4)*(x2-x4)+(y2-y4)*(y2-y4));
        if(!equalTwo(temp)){
            return false;
        }

        temp[0] = Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
        temp[1] = Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
        temp[2] = Math.sqrt((x3-x4)*(x3-x4)+(y3-y4)*(y3-y4));
        if(!equalTwo(temp)){
            return false;
        }

        return true;
    }

    //三个数中有两个相等，返回true，否则返回false
    static boolean equalTwo(double[] arr){
        if(arr == null || arr.length == 0){
            return false;
        }

        if(arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]){
            return true;
        }
        return false;
    }

}
