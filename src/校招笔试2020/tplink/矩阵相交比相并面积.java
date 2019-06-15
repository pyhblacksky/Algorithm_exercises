package 校招笔试2020.tplink;

import java.util.Scanner;

/**
 * @Author: pyh
 * @Date: 2019/6/15 10:42
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class 矩阵相交比相并面积 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //A矩形的对角
        int ax1 = scanner.nextInt();
        int ay1 = scanner.nextInt();
        int ax2 = scanner.nextInt();
        int ay2 = scanner.nextInt();

        //B矩形的对角
        int bx1 = scanner.nextInt();
        int by1 = scanner.nextInt();
        int bx2 = scanner.nextInt();
        int by2 = scanner.nextInt();

        int temp = 0;
        int crossArea = 0;//相交面积
        //相交比相并
        if(ax1 > ax2){
            temp = ax1;
            ax1 = ax2;
            ax2 = temp;
        }
        if(ay1 > ay2){
            temp = ay1;
            ay1 = ay2;
            ay2 = temp;
        }
        if(bx1 > bx2){
            temp = bx1;
            bx1 = bx2;
            bx2 = temp;
        }
        if(by1 > by2){
            temp = by1;
            by1 = by2;
            by2 = temp;
        }
        if(ax2>=bx1 && ax1<=bx2 && ay2>=by1 && ay1<=by2)
            crossArea = (ax2-bx1)*(ay2-by1);

        if(crossArea == 0){
            System.out.println(0);
            return;
        }


        int SA = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
        int SB = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        int unionArea = SA + SB - crossArea;//相并面积

        double res = (double) crossArea / (double)unionArea;

        System.out.println(res);
    }

}
